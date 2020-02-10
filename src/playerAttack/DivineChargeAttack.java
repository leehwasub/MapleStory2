package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import buff.BuffFactory;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttackImage.DivineChargeHitImage;
import playerAttackImage.DivineChargeUse1Image;
import playerAttackImage.DivineChargeUse2Image;
import skill.ActiveSkill;
import skill.AdvancedChargeSkill;
import skill.DivineChargeSkill;
import utils.CalUtils;

public class DivineChargeAttack extends PlayerAttack {
	
	private int canMoreHit = 0; 
	
	public DivineChargeAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
		getAdvancedChargeEffect();
	}
	
	private void getAdvancedChargeEffect() {
		AdvancedChargeSkill advancedChargeSkill = (AdvancedChargeSkill)((Adventurer)attacker.getCharacter()).getSkillWithName("어드밴스드차지");
		if(advancedChargeSkill != null && advancedChargeSkill.getPoint() >= 1) {
			canMoreHit = advancedChargeSkill.getEffect(advancedChargeSkill.getPoint());
		}
	}
	
	public void run() {
		attacker.attackForwardMotion();
		addNoDelaySkillImageThread(new DivineChargeUse1Image(hunt, attacker, opponent, null));
		addSkillImageThread(new DivineChargeUse2Image(hunt, attacker, opponent, makeAttackInfor()),
				new DivineChargeHitImage(hunt, opponent, opponent, null), true);
		makeSlienceBuff();
		afterAttack();
	}
	
	private void makeSlienceBuff() {
		int slienceRate = ((DivineChargeSkill)activeSkill).getSilenceRate(activeSkill.getPoint());
		int slienceLast = ((DivineChargeSkill)activeSkill).getLast(activeSkill.getPoint());
		if(CalUtils.calPercent(slienceRate)) {
			opponent.getCharacter().addBuff(BuffFactory.makeSpecialBuff("침묵", slienceLast));
		}
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 3; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		if(opponent.getCharacter().isAlreadyBuffed("스턴")) {
			double extraDamageRate = (double)((DivineChargeSkill)activeSkill).getExtraEffect(activeSkill.getPoint()) / 100.0;
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(extraDamageRate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		for(int i = 0; i < canMoreHit; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}

package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.LightningChargeHitImage;
import attackImage.LightningChargeUseImage;
import buff.BuffFactory;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.ActiveSkill;
import skill.AdvancedChargeSkill;
import skill.ElementalForceSkill;
import skill.LightningChargeSkill;

public class LightningChargeAttack extends PlayerAttack {
	
	private int canMoreHit = 0; 
	
	public LightningChargeAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
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

		addSkillImageThread(new LightningChargeUseImage(hunt, attacker, opponent, makeAttackInfor()),
				new LightningChargeHitImage(hunt, opponent, opponent, null), true);
		makeStunBuff();
		afterAttack();
	}
	
	private double elementalForceEffect() {
		double extraRate = 0.0;
		ElementalForceSkill elementalForceSkill = (ElementalForceSkill)((Adventurer)attacker.getCharacter()).getSkillWithName("엘리멘탈포스");
		if(elementalForceSkill != null && elementalForceSkill.getPoint() >= 1) {
			extraRate = elementalForceSkill.getEffect(elementalForceSkill.getPoint()) / 100.0;
		}
		return extraRate;
	}
	
	
	private void makeStunBuff() {
		double stunRate = ((LightningChargeSkill)activeSkill).stunRate(activeSkill.getPoint());
		int stunLast = ((LightningChargeSkill)activeSkill).getLast(activeSkill.getPoint());
		int stun100Rate = (int)(Math.random() *  99) + 1;
		if(stun100Rate <= stunRate) {
			opponent.getCharacter().addBuff(BuffFactory.makeSpecialBuff("스턴", stunLast));
		}
	}
	

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		rate += elementalForceEffect();
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 3; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		if(opponent.getCharacter().isAlreadyBuffed("동상")) {
			double extraDamageRate = (double)((LightningChargeSkill)activeSkill).extraEffect(activeSkill.getPoint()) / 100.0;
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

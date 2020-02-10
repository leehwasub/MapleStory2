package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.ShoutHitImage;
import attackImage.ShoutUseImage;
import buff.BuffFactory;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.ActiveSkill;
import skill.IncisingSkill;
import skill.ShoutSkill;
import utils.CalUtils;

public class ShoutAttack extends PlayerAttack {
	
	public ShoutAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();

		addSkillImageThread(new ShoutUseImage(hunt, attacker, opponent, makeAttackInfor()), 
				new ShoutHitImage(hunt, opponent, opponent, null), true);
		makeStunBuff();
		afterAttack();
	}
	
	private void makeStunBuff() {
		int stunRate = ((ShoutSkill)activeSkill).deBuffRate(activeSkill.getPoint());
		int stunLast = ((ShoutSkill)activeSkill).deBuffTurn(activeSkill.getPoint());
		if(CalUtils.calPercent(stunRate)) {
			opponent.getCharacter().addBuff(BuffFactory.makeSpecialBuff("스턴", stunLast));
		}
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		rate += incisingEffect();
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 6; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}
	
	private double incisingEffect() {
		IncisingSkill incisingSkill = (IncisingSkill)((Adventurer)attacker.getCharacter()).getSkillWithName("인사이징");
		if(incisingSkill != null && incisingSkill.getPoint() >= 1) {
			return incisingSkill.getShoutEffect(incisingSkill.getPoint()) / 100.0;
		}
		return 0.0;
	}

	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}

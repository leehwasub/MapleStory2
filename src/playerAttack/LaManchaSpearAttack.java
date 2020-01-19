package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.LaManchaSpearHit1Image;
import attackImage.LaManchaSpearHit2Image;
import attackImage.LaManchaSpearUse1Image;
import attackImage.LaManchaSpearUse2Image;
import attackImage.LaManchaSpearUse3Image;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.ActiveSkill;
import skill.BlizzardChargeSkill;
import skill.LaManchaSpearSkill;

public class LaManchaSpearAttack extends PlayerAttack {
	
	public LaManchaSpearAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();

		addSkillImageThread(new LaManchaSpearUse1Image(hunt, attacker, opponent, null), true);
		addSkillImageThread(new LaManchaSpearUse2Image(hunt, attacker, opponent, makePreAttackInfor()),
				new LaManchaSpearHit1Image(hunt, opponent, opponent, null), true);
		addSkillImageThread(new LaManchaSpearUse3Image(hunt, attacker, opponent, makeAttackInfor()),
				new LaManchaSpearHit2Image(hunt, opponent, opponent, null), true);
		afterAttack();
	}
	
	protected ArrayList<AttackInfor> makePreAttackInfor() {
		double rate = (double)((LaManchaSpearSkill)activeSkill).getPreEffect(activeSkill.getPoint()) / 100.0;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}

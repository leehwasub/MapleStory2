package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.BlizzardChargeUseAttackImage;
import attackImage.BrandishHitAttackImage;
import attackImage.BrandishUseAttackImage;
import attackImage.FlameChargeUseAttackImage;
import attackImage.PowerStrikeHitImage;
import attackImage.PowerStrikeUseImage;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import skill.BlizzardChargeSkill;

public class BlizzardChargeAttack extends PlayerAttack {
	
	public BlizzardChargeAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();

		addSkillImageThread(new BlizzardChargeUseAttackImage(hunt, attacker, opponent, makeAttackInfor()));
		
		afterAttack();
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 3; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		if(opponent.getCharacter().isAlreadyBuffed("화상")) {
			double extraDamageRate = (double)((BlizzardChargeSkill)activeSkill).extraEffect(activeSkill.getPoint()) / 100.0;
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(extraDamageRate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}

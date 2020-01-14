package playerAttack;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.PowerStrikeHitImage;
import attackImage.PowerStrikeUseImage;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;

public class PowerStrikeAttack extends PlayerAttack {
	
	public PowerStrikeAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new PowerStrikeUseImage(hunt, attacker, opponent, null));
		addSkillImageThread(new PowerStrikeHitImage(hunt, opponent, opponent, makeAttackInfor()));
		afterAttack();
	}

	@Override
	protected AttackInfor makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		return new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE);
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}

package monsterAttack;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.DoubleSlashAttackImage;
import attackImage.FlashAttackImage;
import component.StateBox;
import hunt.Hunt;
import skill.MonsterSkill;

public class DoubleSlashAttack extends MonsterAttack {
	public DoubleSlashAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new DoubleSlashAttackImage(hunt, attacker, opponent, makeAttackInfor()));
		afterAttack();
	}
	
	@Override
	protected AttackInfor makeAttackInfor() {
		double rate = 1.1f + (double)monsterSkill.getSkillPoint() * 0.1f;
		return new AttackInfor(this.attacker.getCharacter(), Property.PROPERTY_NOTHING,
				0, this.attacker.getCharacter().calMagicDamge(rate), DamageType.DAMAGE_HP_TYPE);
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 20 + (monsterSkill.getSkillPoint() / 4) * 5;
	}
	
}

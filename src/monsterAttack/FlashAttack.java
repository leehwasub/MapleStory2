package monsterAttack;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.FlashAttackImage;
import component.StateBox;
import hunt.Hunt;
import skill.MonsterSkill;

public class FlashAttack extends MonsterAttack {
	public FlashAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new FlashAttackImage(hunt, attacker, opponent, makeAttackInfor()));
		afterAttack();
	}
	
	@Override
	protected AttackInfor makeAttackInfor() {
		double percent = 0.9f + (double)monsterSkill.getSkillPoint() * 0.1f;
		return new AttackInfor(this.attacker.getCharacter(), Property.PROPERTY_NOTHING,
				0, this.attacker.getCharacter().calNormalDamge(percent), DamageType.DAMAGE_HP_TYPE);
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return monsterSkill.getSkillPoint()*10;
	}
	
}

package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.DoubleSlashAttackImage;
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
	protected ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		double rate = 1.1f + (double)monsterSkill.getSkillPoint() * 0.1f;
		for(int i = 0; i < 2; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), Property.PROPERTY_NOTHING, 0, this.attacker.getCharacter().calMagicDamge(rate), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 20 + (monsterSkill.getSkillPoint() / 4) * 5;
	}
	
}

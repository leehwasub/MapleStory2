package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.flameShootBallMovableImage;
import attackImage.flameShootHitImage;
import attackImage.flameShootUseImage;
import component.StateBox;
import hunt.Hunt;
import skill.MonsterSkill;

public class FlameShootAttack extends MonsterAttack {
	public FlameShootAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new flameShootUseImage(hunt, attacker, opponent, null));
		addSkillImageThread(new flameShootBallMovableImage(hunt, attacker, opponent, null));
		addSkillImageThread(new flameShootHitImage(hunt, opponent, opponent, makeAttackInfor()));
		afterAttack();
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		double percent = 0.9f + (double)monsterSkill.getSkillPoint() * 0.1f;
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), Property.PROPERTY_NOTHING, 0, this.attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return monsterSkill.getSkillPoint()*10;
	}
	
}

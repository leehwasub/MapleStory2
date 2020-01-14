package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.SwordHitImage;
import attackImage.SwordUseImage;
import character.Character;
import component.StateBox;
import hunt.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class SwordAttack extends MonsterAttack {
	
	public SwordAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new SwordUseImage(hunt, attacker, opponent, null));
		addSkillImageThread(new SwordHitImage(hunt, opponent, opponent, makeAttackInfor()));
		afterAttack();
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), Property.PROPERTY_NOTHING, this.attacker.getCharacter().calNormalDamge(1.2d), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 5;
	}

}

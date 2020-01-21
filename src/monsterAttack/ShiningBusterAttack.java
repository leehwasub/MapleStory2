package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.FlashBallMovableImage;
import attackImage.FlashHitImage;
import attackImage.FlashUseImage;
import attackImage.ShiningBusterHitImage;
import attackImage.ShiningBusterUseImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;

public class ShiningBusterAttack extends MonsterAttack {
	public ShiningBusterAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new ShiningBusterUseImage(hunt, attacker, opponent, makeAttackInfor()), new ShiningBusterHitImage(hunt, opponent, opponent, null), true);
		afterAttack();
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.8f + (double)monsterSkill.getSkillPoint() * 0.1f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 3; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), Property.PROPERTY_NOTHING, attacker.getCharacter().calNormalDamge(percent), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 17 + monsterSkill.getSkillPoint() * 4;
	}
	
}

package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.DoublePiercingHitImage;
import attackImage.DoublePiercingUseImage;
import attackImage.ManaBurstHitImage;
import attackImage.ManaBurstUseImage;
import attackImage.SwordHitImage;
import attackImage.SwordUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.CalUtils;

public class ManaBurstAttack extends MonsterAttack {
	
	public ManaBurstAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new ManaBurstUseImage(hunt, attacker, opponent, makeAttackInfor()), new ManaBurstHitImage(hunt, opponent, opponent, null), true);
		afterAttack();
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.4f + (double)monsterSkill.getSkillPoint() * 0.1f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 3; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), Property.PROPERTY_NOTHING, 0, attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 14 + monsterSkill.getSkillPoint() * 2;
	}

}

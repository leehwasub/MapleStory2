package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.ArmageddonHitImage;
import attackImage.ArmageddonUse1Image;
import attackImage.ArmageddonUse2Image;
import attackImage.ChainLightningHitImage;
import attackImage.ChainLightningUseImage;
import attackImage.CombatSwitchingUseImage;
import attackImage.SwordHitImage;
import attackImage.SwordUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import skill.ShoutSkill;
import utils.CalUtils;

public class ArmageddonAttack extends MonsterAttack {
	
	public ArmageddonAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addNoDelaySkillImageThread(new ArmageddonUse1Image(hunt, attacker, opponent, null));
		addSkillImageThread(new ArmageddonUse2Image(hunt, opponent, opponent, makeAttackInfor()), new ArmageddonHitImage(hunt, opponent, opponent, null), false);
		afterAttack();
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 2.2f + (double)monsterSkill.getSkillPoint() * 0.1f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 3; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), monsterSkill.getProperty(), attacker.getCharacter().calNormalDamge(percent), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 150 + monsterSkill.getSkillPoint() * 30;
	}

}

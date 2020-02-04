package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.FlameBarrierUse1Image;
import attackImage.FlameBarrierUse2Image;
import attackImage.InfinityUse1Image;
import attackImage.InfinityUse2Image;
import attackImage.PowerTransferUseImage;
import attackImage.SkillLockUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import lastingImage.FlameBarrierLastingImage;
import skill.MonsterSkill;
import utils.MusicUtils;

public class FlameBarrierAttack extends MonsterAttack {
	
	public FlameBarrierAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addNoDelaySkillImageThread(new FlameBarrierUse1Image(hunt, attacker, opponent, null));
		addSkillImageThread(new FlameBarrierUse2Image(hunt, attacker, opponent, null), true);
		attacker.getCharacter().addBuff(BuffFactory.makeMonsterBuff("플레임배리어", monsterSkill.getSkillPoint()));
		hunt.addSkillImage(new FlameBarrierLastingImage(hunt, attacker, opponent, makeAttackInfor()));
		afterAttack();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. 자신에게 물리마법방어력, 불속성 저항을 증가시키고 화상 상태 면역이 되는 버프를 걸었다.";
	}

	public int calNeedMp() {
		return 50 + monsterSkill.getSkillPoint() * 5;
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.05f + (double)monsterSkill.getSkillPoint() * 0.01f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		ret.add(new AttackInfor(attacker.getCharacter(), monsterSkill.getProperty(), 0, attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		return ret;
	}
	
}

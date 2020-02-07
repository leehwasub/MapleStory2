package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.InfinityUse1Image;
import attackImage.InfinityUse2Image;
import attackImage.PowerTransferUseImage;
import attackImage.SkillLockUseImage;
import attackImage.SoulEndureUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class SoulEndureAttack extends MonsterAttack {
	
	public SoulEndureAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new SoulEndureUseImage(hunt, attacker, opponent, null), true);
		attacker.getCharacter().addBuff(BuffFactory.makeMonsterBuff("소울인듀어", monsterSkill.getSkillPoint()));
		afterAttack();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. 자신에게 모든 속성저항증가, 물리방어력, 마법방어력을 증가시키는 버프를 걸었다.";
	}

	public int calNeedMp() {
		return 50 + monsterSkill.getSkillPoint() * 7;
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
}

package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.EtherealFormUseImage;
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

public class EtherealFormAttack extends MonsterAttack {
	
	public EtherealFormAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new EtherealFormUseImage(hunt, attacker, opponent, null), true);
		attacker.getCharacter().addBuff(BuffFactory.makeSpecialBuff("에테리얼폼", 12 + monsterSkill.getSkillPoint()));
		afterAttack();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. 자신에게 모든 상태이상에대해 면역상태가 되는 버프를 걸었다.";
	}

	public int calNeedMp() {
		return 60 + monsterSkill.getSkillPoint() * 5;
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
}

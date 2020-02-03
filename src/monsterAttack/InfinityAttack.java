package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.InfinityUse1Image;
import attackImage.InfinityUse2Image;
import attackImage.PowerTransferUseImage;
import attackImage.SkillLockUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class InfinityAttack extends MonsterAttack {
	
	public InfinityAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addNoDelaySkillImageThread(new InfinityUse1Image(hunt, attacker, opponent, null));
		addSkillImageThread(new InfinityUse2Image(hunt, attacker, opponent, null), true);
		attacker.getCharacter().removeAllAbnormalBuff();
		attacker.getCharacter().addBuff(BuffFactory.makeMonsterBuff("인피니티", monsterSkill.getSkillPoint()));
		afterAttack();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. 자신에게 걸린 모든 상태이상을 일시적으로 회복하고 물리마법방어력을 증가, 체력을 회복시키는 버프를 걸었다.";
	}

	public int calNeedMp() {
		return 45 + monsterSkill.getSkillPoint() * 6;
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
}

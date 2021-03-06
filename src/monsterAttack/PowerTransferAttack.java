package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.PowerTransferUseImage;
import attackImage.SkillLockUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import lastingImage.PowerTransferLastingImage;
import skill.MonsterSkill;
import utils.MusicUtils;

public class PowerTransferAttack extends MonsterAttack {
	
	public PowerTransferAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new PowerTransferUseImage(hunt, attacker, opponent, null), true);
		attacker.getCharacter().addBuff(BuffFactory.makeSpecialBuff("파워트랜스퍼", 6 + monsterSkill.getSkillPoint() / 3));
		hunt.addSkillImage(new PowerTransferLastingImage(hunt, attacker, opponent, null));
		afterAttack();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. 자신에게 일정확률로 적의 공격을 방어하는 버프를 걸었다.";
	}

	public int calNeedMp() {
		return 40 + monsterSkill.getSkillPoint() * 5;
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
}

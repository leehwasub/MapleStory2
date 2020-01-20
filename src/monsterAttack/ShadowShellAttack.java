package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.ShadowShellUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class ShadowShellAttack extends MonsterAttack {
	
	public ShadowShellAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new ShadowShellUseImage(hunt, attacker, opponent, null), true);
		attacker.getCharacter().addBuff(BuffFactory.makeMonsterBuff("안티매직쉘", monsterSkill.getSkillPoint()));
		attacker.updateStateBox(); 
		afterAttack();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. 자신에게 모든 속성저항을 강화하는 버프를 걸었다.";
	}

	public int calNeedMp() {
		return 20 + monsterSkill.getSkillPoint() * 5;
	}

	@Override
	public ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
}

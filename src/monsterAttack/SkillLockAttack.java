package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.SkillLockUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class SkillLockAttack extends MonsterAttack {
	
	public SkillLockAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new SkillLockUseImage(hunt, attacker, opponent, null), true);
		opponent.getCharacter().addBuff(BuffFactory.makeSpecialBuff("스킬잠금", 3 + monsterSkill.getSkillPoint()));
		opponent.updateStateBox(); 
		afterAttack();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 적중률을 약화하는 버프를 걸었다.";
	}

	public int calNeedMp() {
		return 100 + monsterSkill.getSkillPoint() * 10;
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
}

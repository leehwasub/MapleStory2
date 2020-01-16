package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.RageUseImage;
import attackImage.ironWallUseImage;
import buff.BuffFactory;
import character.Adventurer;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import skill.HyperBodySkill;
import utils.MusicUtils;

public class IronWillAttack extends PlayerAttack {
	
	public IronWillAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		
		attacker.getCharacter().addBuff(BuffFactory.makeAdventurerBuff(activeSkill));
		addSkillImageThread(new ironWallUseImage(hunt, attacker, opponent, null));
		
		afterAttack();
	}
	
	@Override
	public ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " +activeSkill.getName() + "를 사용. 자신에게 물리방어력과 마법방어력을 증가시키는 버프를 걸었다.";
	}

}

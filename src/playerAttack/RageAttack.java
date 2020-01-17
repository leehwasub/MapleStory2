package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.RageUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import utils.MusicUtils;

public class RageAttack extends PlayerAttack {
	
	public RageAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		
		attacker.getCharacter().addBuff(BuffFactory.makeAdventurerBuff(activeSkill));
		addSkillImageThread(new RageUseImage(hunt, attacker, opponent, null), false);
		
		afterAttack();
	}

	@Override
	public ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " +activeSkill.getName() + "를 사용. 자신에게 물리방어력을 강화시키는 버프를 걸었다.";
	}

}

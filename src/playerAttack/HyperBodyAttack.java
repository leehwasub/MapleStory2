package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.RageUseImage;
import attackImage.hyperBodyUseImage;
import buff.BuffFactory;
import character.Adventurer;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import skill.HyperBodySkill;
import utils.MusicUtils;

public class HyperBodyAttack extends PlayerAttack {
	
	public HyperBodyAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		
		setIncre();
		attacker.getCharacter().addBuff(BuffFactory.makeAdventurerBuff(activeSkill));
		addSkillImageThread(new hyperBodyUseImage(hunt, attacker, opponent, null));
		
		afterAttack();
	}
	
	private void setIncre() {
		((HyperBodySkill)activeSkill).setHpIncre((Adventurer)attacker.getCharacter());
		((HyperBodySkill)activeSkill).setMpIncre((Adventurer)attacker.getCharacter());
	}

	@Override
	public ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " +activeSkill.getName() + "를 사용. 자신에게 최대 HP와 최대 MP을 증가시키는 버프를 걸었다.";
	}

}

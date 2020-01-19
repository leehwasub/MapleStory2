package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.CrossSurgeUseImage;
import attackImage.RageUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.ActiveSkill;

public class CrossSurgeAttack extends PlayerAttack {
	
	public CrossSurgeAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		
		addSkillImageThread(new CrossSurgeUseImage(hunt, attacker, opponent, null), true);
		attacker.getCharacter().addBuff(BuffFactory.makeSpecialBuff("크로스오버체인", activeSkill.getLast(activeSkill.getPoint())));
		
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

package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.CombatOrdersUseImage;
import buff.BuffFactory;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.ActiveSkill;
import skill.CombatOrdersSkill;

public class CombatOrdersAttack extends PlayerAttack {
	
	public CombatOrdersAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		
		attacker.getCharacter().addBuff(BuffFactory.makeSpecialBuff("컴뱃오더스", activeSkill.getLast(activeSkill.getPoint())));
		addSkillImageThread(new CombatOrdersUseImage(hunt, attacker, opponent, null), false);
		((CombatOrdersSkill)activeSkill).upSkillPointForCombatOrders((Adventurer)attacker.getCharacter());
		afterAttack();
	}

	@Override
	public ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " +activeSkill.getName() + "를 사용. 자신에게 스킬 포인트를 증가 시키는 버프를 걸었다.";
	}

}

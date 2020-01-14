package playerAttack;

import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import skill.NormalSkill;
import utils.MusicUtils;
import attack.Attack;
import attack.AttackType;
import attack.AttackInfor;
import attack.Property;
import buff.BuffFactory;
import character.Character;

public class IronBodyAttack extends PlayerAttack {
	
	public IronBodyAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		attackMoveDelay();
		
		MusicUtils.startEffectSound("ironBody");
		attacker.getCharacter().addBuff(BuffFactory.makeAdventurerBuff(activeSkill));
		attacker.updateStateBox();
		
		this.attacker.attackBackMotion();
		afterAttackDelay();
		
		wakeUpThread();
	}

	@Override
	public AttackInfor makeAttackInfor() {
		return null;
	}
	
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " +activeSkill.getName() + "를 사용. 자신에게 물리방어력을 강화시키는 버프를 걸었다.";
	}

}

package playerAttack;

import attack.Attack;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;

public abstract class PlayerAttack extends Attack {
	
	protected ActiveSkill activeSkill;

	public PlayerAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent);
		this.activeSkill = activeSkill;
	}

	public ActiveSkill getActiveSkill() {
		return activeSkill;
	}

	public void setActiveSkill(ActiveSkill activeSkill) {
		this.activeSkill = activeSkill;
	}

	
}

package monsterAttack;

import attack.Attack;
import component.StateBox;
import hunt.Hunt;
import skill.MonsterSkill;

public abstract class MonsterAttack extends Attack {
	
	protected MonsterSkill monsterSkill;

	public MonsterAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent);
		this.monsterSkill = monsterSkill;
	}

	public MonsterSkill getMonsterSkill() {
		return monsterSkill;
	}

	public void setMonsterSkill(MonsterSkill monsterSkill) {
		this.monsterSkill = monsterSkill;
	}
	
	public abstract int calNeedMp();
	
}

package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public final class Pig extends Monster {
	
	private static final long serialVersionUID = 1L;

	public Pig() {
		super("돼지", "pig", new Strength(new Resistance(100, 100, 100, 100, 100, 100), 5, 60, 10, 0, 0, 3, 0, 2, 2, 0),
				23, 26, 0, 0, 8, 18, false);
		initSkillList();
	}

	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp()));
	}
}
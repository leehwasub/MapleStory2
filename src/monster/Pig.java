package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Pig extends Monster {
	
	private static final long serialVersionUID = 1L;

	public Pig() {
		super("돼지", "pig", new Strength(new Resistance(100, 100, 100, 100, 100, 100), 5, 60, 10, 10, 10, 2, 2),
				23, 26, 0, 0, 8 * Main.EXP_BONUS, 18 * Main.MONEY_BONUS, false);
		initSkillList();
	}

	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}
}
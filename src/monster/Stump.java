package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Stump extends Monster {

	private static final long serialVersionUID = 1L;

	public Stump() {
		super("스텀프", "stump",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 10, 200, 20, 0, 0, 5, 0, 5, 5, 0), 40, 43, 0, 0,
				20 * Main.EXP_BONUS, 30 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 1000, "공격력강화", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
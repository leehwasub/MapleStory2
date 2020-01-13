package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class AxeStump extends Monster {

	private static final long serialVersionUID = 1L;

	public AxeStump() {
		super("엑스텀프", "axeStump",
				new Strength(new Resistance(50, 100, 100, 100, 100, 100), 12, 320, 20, 0, 0, 10, 0, 5, 5, 0), 70, 76, 0, 0,
				28 * Main.EXP_BONUS, 35 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
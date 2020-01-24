package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class DarkYeti extends Monster {

	private static final long serialVersionUID = 1L;

	public DarkYeti() {
		super("다크예티", "darkYeti",
				new Strength(new Resistance(50, 150, 100, 100, 150, 50), 36, 6400, 200, 0, 0, 250, 250, 25, 25, 0), 370, 392, 0, 0,
				182 * Main.EXP_BONUS, 370 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "방어력강화", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(800, 1000, "맹수의일격", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
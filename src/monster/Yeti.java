package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Yeti extends Monster {

	private static final long serialVersionUID = 1L;

	public Yeti() {
		super("예티", "yeti",
				new Strength(new Resistance(50, 150, 100, 100, 100, 100), 35, 6000, 200, 0, 0, 200, 200, 25, 25, 0), 364, 386, 0, 0,
				170 * Main.EXP_BONUS, 340 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "방어력강화", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(800, 1000, "맹수의일격", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
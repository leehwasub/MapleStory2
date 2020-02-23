package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Saitie extends Monster {

	private static final long serialVersionUID = 1L;

	public Saitie() {
		super("샤이티", "saitie",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 58, 75000, 2400, 10, 10, 40, 40), 693, 705, 712, 723,
				820 * Main.EXP_BONUS, 2340 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "회피율강화", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(500, 900, "윈드서클", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
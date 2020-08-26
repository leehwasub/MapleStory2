package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class BlueDragonTurtle extends Monster {

	private static final long serialVersionUID = 1L;

	public BlueDragonTurtle() {
		super("블루드래곤터틀", "blueDragonTurtle",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 73, 160000, 5000, 10, 10, 40, 40), 850, 880, 861, 874,
				2600 * Main.EXP_BONUS, 7200 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "방어력강화", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(100, 250, "파워트랜스퍼", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(150, 300, "인피니티", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(400, 700, "윈드서클", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(750, 1000, "맹수의일격", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
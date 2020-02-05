package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class DualBirk extends Monster {

	private static final long serialVersionUID = 1L;

	public DualBirk() {
		super("듀얼버크", "dualBirk",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 71, 114000, 3000, 10, 10, 40, 40), 850, 873, 861, 882,
				1950 * Main.EXP_BONUS, 4700 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "방어력강화", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(100, 250, "파워트랜스퍼", strength.getMaxHp(), 4));
		skillList.add(new MonsterSkillInfor(150, 300, "인피니티", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(600, 1000, "윈드서클", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
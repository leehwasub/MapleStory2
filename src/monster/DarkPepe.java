package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class DarkPepe extends Monster {

	private static final long serialVersionUID = 1L;

	public DarkPepe() {
		super("다크페페", "darkPepe",
				new Strength(new Resistance(50, 150, 100, 100, 150, 50), 33, 4200, 400, 10, 10, 35, 35), 320, 334, 325, 347,
				154 * Main.EXP_BONUS, 272 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "공격력강화", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(800, 1000, "콜드빔", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(700, 800, "안티매직쉘", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
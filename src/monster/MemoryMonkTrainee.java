package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class MemoryMonkTrainee extends Monster {

	private static final long serialVersionUID = 1L;

	public MemoryMonkTrainee() {
		super("추억의신관", "memoryMonkTrainee",
				new Strength(new Resistance(100, 100, 150, 50, 100, 100), 81, 230000, 12000, 10, 10, 40, 40), 1231, 1254, 1275, 1302,
				4400 * Main.EXP_BONUS, 11000 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 11));
		skillList.add(new MonsterSkillInfor(100, 250, "인피니티", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(200, 350, "안티매직쉘", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(300, 600, "포이즌브레스", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(600, 800, "포이즌미스트", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(800, 1000, "서클오브마나", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
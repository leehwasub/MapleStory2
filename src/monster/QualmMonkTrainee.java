package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class QualmMonkTrainee extends Monster {

	private static final long serialVersionUID = 1L;

	public QualmMonkTrainee() {
		super("후회의신관", "qualmMonkTrainee",
				new Strength(new Resistance(50, 150, 100, 100, 100, 100), 84, 312000, 14000, 10, 10, 40, 40), 1185, 1200, 1220, 1242,
				4800 * Main.EXP_BONUS, 13000 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 11));
		skillList.add(new MonsterSkillInfor(100, 250, "인피니티", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(200, 350, "안티매직쉘", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(300, 600, "콜드빔", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(600, 800, "아이스스트라이크", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(800, 1000, "서클오브마나", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
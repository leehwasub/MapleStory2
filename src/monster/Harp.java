package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Harp extends Monster {

	private static final long serialVersionUID = 1L;

	public Harp() {
		super("하프", "harp",
				new Strength(new Resistance(50, 150, 100, 100, 100, 100), 67, 124000, 4000, 10, 10, 40, 40), 806, 820, 853, 875,
				1320 * Main.EXP_BONUS, 3700 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "회피율강화", strength.getMaxHp(), 9));
		skillList.add(new MonsterSkillInfor(100, 250, "안티매직쉘", strength.getMaxHp(), 9));
		skillList.add(new MonsterSkillInfor(150, 300, "인피니티", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(300, 600, "콜드빔", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(600, 1000, "플래쉬", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
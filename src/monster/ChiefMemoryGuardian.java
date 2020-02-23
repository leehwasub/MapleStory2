package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class ChiefMemoryGuardian extends Monster {

	private static final long serialVersionUID = 1L;

	public ChiefMemoryGuardian() {
		super("추억의수호대장", "chiefMemoryGuardian",
				new Strength(new Resistance(100, 100, 150, 50, 100, 100), 82, 365000, 12000, 10, 10, 40, 40), 1275, 1312, 1295, 1322,
				4620 * Main.EXP_BONUS, 12000 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "방어력강화", strength.getMaxHp(), 11));
		skillList.add(new MonsterSkillInfor(100, 250, "소울인듀어", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(200, 350, "파워트랜스퍼", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(0, 300, "플레인차지드라이브", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(300, 600, "포이즌브레스", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(600, 800, "포이즌미스트", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(800, 1000, "잊혀지지않는악몽", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
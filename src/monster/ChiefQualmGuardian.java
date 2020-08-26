package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class ChiefQualmGuardian extends Monster {

	private static final long serialVersionUID = 1L;

	public ChiefQualmGuardian() {
		super("후회의수호대장", "chiefQualmGuardian",
				new Strength(new Resistance(50, 150, 100, 100, 100, 100), 85, 332000, 14000, 10, 10, 40, 40), 1204, 1230, 1270, 1282,
				5000 * Main.EXP_BONUS, 14000 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "방어력강화", strength.getMaxHp(), 11));
		skillList.add(new MonsterSkillInfor(100, 250, "소울인듀어", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(200, 350, "파워트랜스퍼", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(0, 300, "플레인차지드라이브", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(300, 600, "콜드빔", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(600, 800, "아이스스트라이크", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(800, 1000, "잊혀지지않는악몽", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
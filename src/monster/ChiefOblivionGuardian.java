package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class ChiefOblivionGuardian extends Monster {

	private static final long serialVersionUID = 1L;

	public ChiefOblivionGuardian() {
		super("망각의수호대장", "chiefOblivionGuardian",
				new Strength(new Resistance(50, 150, 100, 100, 100, 100), 88, 305000, 16000, 10, 10, 40, 40), 1374, 1400, 1410, 1447,
				5400 * Main.EXP_BONUS, 15000 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "방어력강화", strength.getMaxHp(), 11));
		skillList.add(new MonsterSkillInfor(100, 250, "소울인듀어", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(200, 350, "파워트랜스퍼", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(0, 300, "플레인차지드라이브", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(300, 600, "강화된플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(600, 800, "플레임바이트", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(800, 1000, "잊혀지지않는악몽", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
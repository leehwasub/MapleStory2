package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Cornian extends Monster {

	private static final long serialVersionUID = 1L;

	public Cornian() {
		super("코니언", "cornian",
				new Strength(new Resistance(100, 100, 150, 100, 100, 100), 77, 277000, 7000, 10, 10, 40, 40), 1010, 1030, 1033, 1060,
				3700 * Main.EXP_BONUS, 8700 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(100, 250, "안티매직쉘", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(150, 300, "인피니티", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(300, 700, "플레인차지드라이브", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(700, 1000, "강화된플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class BloodHarp extends Monster {

	private static final long serialVersionUID = 1L;

	public BloodHarp() {
		super("블러드하프", "bloodHarp",
				new Strength(new Resistance(150, 50, 100, 100, 100, 100), 68, 130000, 4000, 10, 10, 40, 40), 813, 825, 861, 882,
				1440 * Main.EXP_BONUS, 4000 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "회피율강화", strength.getMaxHp(), 9));
		skillList.add(new MonsterSkillInfor(100, 250, "안티매직쉘", strength.getMaxHp(), 9));
		skillList.add(new MonsterSkillInfor(150, 300, "인피니티", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(300, 500, "잊혀지지않는악몽", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(500, 800, "강화된플레임샷", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(800, 1000, "플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
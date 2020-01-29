package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Kiyo extends Monster {

	private static final long serialVersionUID = 1L;

	public Kiyo() {
		super("키요", "kiyo",
				new Strength(new Resistance(150, 50, 100, 100, 100, 100), 46, 14000, 420, 0, 0, 580, 580, 37, 37, 0), 535, 550, 550, 570,
				371 * Main.EXP_BONUS, 800 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 200, "공격력약화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(100, 300, "회피율약화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(300, 500, "안티매직쉘", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(600, 700, "버프해제", strength.getMaxHp(), 1, true));
		skillList.add(new MonsterSkillInfor(700, 1000, "플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
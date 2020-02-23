package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Cactus extends Monster {

	private static final long serialVersionUID = 1L;

	public Cactus() {
		super("카투스", "cactus",
				new Strength(new Resistance(150, 50, 100, 100, 100, 100), 42, 16700, 350, 10, 10, 37, 37), 480, 494, 480, 500,
				262 * Main.EXP_BONUS, 563 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "방어력강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(550, 700, "체력회복", strength.getMaxHp() - 4500, 3));
		skillList.add(new MonsterSkillInfor(700, 1000, "플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
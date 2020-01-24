package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class LoyalCactus extends Monster {

	private static final long serialVersionUID = 1L;

	public LoyalCactus() {
		super("로얄카투스", "royalCactus",
				new Strength(new Resistance(150, 50, 150, 100, 100, 100), 43, 10500, 400, 0, 0, 450, 450, 37, 37, 0), 501, 523, 523, 528,
				262 * Main.EXP_BONUS, 563 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "방어력강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(650, 800, "체력회복", strength.getMaxHp() - 5000, 3));
		skillList.add(new MonsterSkillInfor(800, 1000, "플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
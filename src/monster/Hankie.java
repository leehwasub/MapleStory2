package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Hankie extends Monster {

	private static final long serialVersionUID = 1L;

	public Hankie() {
		super("헹키", "hankie",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 66, 120000, 2700, 0, 0, 800, 800, 40, 40, 0), 797, 813, 805, 820,
				1250 * Main.EXP_BONUS, 3500 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "방어력약화", strength.getMaxHp(), 9));
		skillList.add(new MonsterSkillInfor(100, 250, "안티매직쉘", strength.getMaxHp(), 9));
		skillList.add(new MonsterSkillInfor(150, 300, "인피니티", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(600, 900, "데빌사이더", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(900, 1000, "버프해제", strength.getMaxHp(), 1, true));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
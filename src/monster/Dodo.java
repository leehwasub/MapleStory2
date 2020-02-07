package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Dodo extends Monster {

	private static final long serialVersionUID = 1L;

	public Dodo() {
		super("도도", "dodo",
				new Strength(new Resistance(120, 120, 170, 70, 120, 120), 83, 2800000, 250000, 20, 20, 40, 40), 1351, 1374, 1398, 1442,
				120000 * Main.EXP_BONUS, 240000 * Main.MONEY_BONUS, true);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 11));
		skillList.add(new MonsterSkillInfor(100, 250, "인피니티", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(200, 350, "안티매직쉘", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(400, 500, "에테리얼폼", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 400, "포이즌브레스", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(500, 800, "포이즌미스트", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(800, 850, "체력회복", strength.getMaxHp() - 1000000, 100));
		skillList.add(new MonsterSkillInfor(850, 1000, "포이즌노바", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
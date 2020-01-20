package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Eliza extends Monster {

	private static final long serialVersionUID = 1L;

	public Eliza() {
		super("엘리자", "eliza",
				new Strength(new Resistance(100, 100, 100, 100, 150, 50), 30, 27000, 6000, 0, 0, 150, 400, 37, 37, 0), 270, 295, 301, 317,
				3000 * Main.EXP_BONUS, 5000 * Main.MONEY_BONUS, true);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(150, 300, "회피율강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(900, 1000, "안티매직쉘", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(600, 900, "데빌사이더", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(500, 600, "스킬잠금", strength.getMaxHp() - 10000, 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
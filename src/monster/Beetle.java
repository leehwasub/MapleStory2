package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Beetle extends Monster {

	private static final long serialVersionUID = 1L;

	public Beetle() {
		super("비틀", "beetle",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 63, 95000, 2600, 0, 0, 800, 800, 40, 40, 0), 781, 793, 795, 804,
				1030 * Main.EXP_BONUS, 2750 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(100, 250, "파워트랜스퍼", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(150, 300, "인피니티", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(500, 1000, "플래쉬", strength.getMaxHp(), 4));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class DualBeetle extends Monster {

	private static final long serialVersionUID = 1L;

	public DualBeetle() {
		super("듀얼비틀", "dualBeetle",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 64, 102000, 2600, 10, 10, 40, 40), 781, 793, 795, 804,
				1100 * Main.EXP_BONUS, 3000 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "방어력강화", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(100, 250, "파워트랜스퍼", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(150, 300, "인피니티", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(500, 1000, "플래쉬", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Kentaurus extends Monster {

	private static final long serialVersionUID = 1L;

	public Kentaurus() {
		super("켄타우로스", "kentaurus",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 69, 108000, 2800, 10, 10, 40, 40), 734, 750, 751, 772,
				1600 * Main.EXP_BONUS, 4300 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 9));
		skillList.add(new MonsterSkillInfor(100, 250, "안티매직쉘", strength.getMaxHp(), 9));
		skillList.add(new MonsterSkillInfor(150, 300, "인피니티", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(500, 1000, "플레인차지드라이브", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
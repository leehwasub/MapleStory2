package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class WoodenMask extends Monster {

	private static final long serialVersionUID = 1L;

	public WoodenMask() {
		super("우드마스크", "woodenMask",
				new Strength(new Resistance(50, 100, 100, 100, 100, 100), 18, 900, 60, 0, 0, 40, 40, 12, 12, 0), 164, 171, 0, 0,
				50 * Main.EXP_BONUS, 90 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
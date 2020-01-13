package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class IronHog extends Monster {

	private static final long serialVersionUID = 1L;

	public IronHog() {
		super("아이언호그", "ironHog",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 16, 700, 30, 0, 0, 100, 20, 7, 7, 0), 120, 123, 0, 0,
				42 * Main.EXP_BONUS, 70 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "방어력강화", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class StarPixie extends Monster {

	private static final long serialVersionUID = 1L;

	public StarPixie() {
		super("스타픽시", "starPixie",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 25, 2000, 400, 10, 10, 25, 25), 202, 210, 253, 265,
				90 * Main.EXP_BONUS, 145 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(400, 1000, "플래쉬", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
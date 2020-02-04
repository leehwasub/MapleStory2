package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Mummydog extends Monster {

	private static final long serialVersionUID = 1L;

	public Mummydog() {
		super("머미독", "mummydog",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 21, 1210, 100, 10, 10, 12, 12), 184, 195, 0, 0,
				62 * Main.EXP_BONUS, 115 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
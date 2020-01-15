package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class BlueSnail extends Monster {

	private static final long serialVersionUID = 1L;

	public BlueSnail() {
		super("파란달팽이", "blueSnail",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 1, 15, 2, 8, 0, 0, 0, 0, 0, 0), 7, 10, 0, 0, 3 * Main.EXP_BONUS,
				10 * Main.MONEY_BONUS, false);
		initSkillList();
	}

	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}

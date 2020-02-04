package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class GreenMushroom extends Monster {

	private static final long serialVersionUID = 1L;

	public GreenMushroom() {
		super("초록버섯", "greenMushroom",
				new Strength(new Resistance(100, 100, 150, 100, 100, 100), 9, 125, 10, 10, 10, 2, 2), 34, 37, 0, 0,
				15 * Main.EXP_BONUS, 24 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
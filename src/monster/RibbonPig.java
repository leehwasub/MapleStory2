package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class RibbonPig extends Monster {

	private static final long serialVersionUID = 1L;

	public RibbonPig() {
		super("리본돼지", "ribbonPig",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 6, 75, 10, 10, 10, 2, 2), 26, 29, 0, 0,
				10 * Main.EXP_BONUS, 20 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}
	
}

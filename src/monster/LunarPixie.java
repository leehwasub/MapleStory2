package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class LunarPixie extends Monster {

	private static final long serialVersionUID = 1L;

	public LunarPixie() {
		super("루나픽시", "lunarPixie",
				new Strength(new Resistance(100, 100, 100, 100, 150, 50), 26, 2240, 450, 0, 0, 70, 200, 25, 25, 0), 215, 220, 260, 272,
				95 * Main.EXP_BONUS, 160 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력약화", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(400, 1000, "플래쉬", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
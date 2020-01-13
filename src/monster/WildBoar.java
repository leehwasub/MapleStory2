package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class WildBoar extends Monster {

	private static final long serialVersionUID = 1L;

	public WildBoar() {
		super("와일드보어", "wildBoar",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 14, 520, 20, 0, 0, 20, 20, 7, 7, 0), 100, 105, 0, 0,
				35 * Main.EXP_BONUS, 54 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
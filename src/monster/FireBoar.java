package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class FireBoar extends Monster {

	private static final long serialVersionUID = 1L;

	public FireBoar() {
		super("파이어보어", "fireBoar",
				new Strength(new Resistance(150, 100, 100, 100, 100, 100), 15, 610, 20, 10, 10, 7, 7), 131, 134, 0, 0,
				38 * Main.EXP_BONUS, 60 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
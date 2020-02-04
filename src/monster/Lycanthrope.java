package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Lycanthrope extends Monster {

	private static final long serialVersionUID = 1L;

	public Lycanthrope() {
		super("라이칸스로프", "lycanthrope",
				new Strength(new Resistance(50, 150, 100, 100, 100, 100), 37, 7420, 250, 10, 10, 29, 29), 430, 449, 0, 0,
				204 * Main.EXP_BONUS, 430 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(800, 1000, "맹수의일격", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
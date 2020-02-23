package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Werewolf extends Monster {

	private static final long serialVersionUID = 1L;

	public Werewolf() {
		super("웨어울프", "werewolf",
				new Strength(new Resistance(50, 150, 100, 100, 100, 100), 37, 10100, 250, 10, 10, 29, 29), 392, 406, 0, 0,
				190 * Main.EXP_BONUS, 400 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(800, 1000, "맹수의일격", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
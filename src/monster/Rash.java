package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Rash extends Monster {

	private static final long serialVersionUID = 1L;

	public Rash() {
		super("레쉬", "rash",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 61, 80000, 1500, 0, 0, 700, 700, 40, 40, 0), 737, 750, 755, 774,
				900 * Main.EXP_BONUS, 2400 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 200, "공격력강화", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(200, 400, "인피니티", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(700, 1000, "맹수의일격", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
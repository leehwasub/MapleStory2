package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class DarkRash extends Monster {

	private static final long serialVersionUID = 1L;

	public DarkRash() {
		super("다크레쉬", "darkRash",
				new Strength(new Resistance(100, 100, 100, 100, 150, 50), 62, 87000, 2500, 0, 0, 750, 750, 40, 40, 0), 745, 760, 765, 784,
				950 * Main.EXP_BONUS, 2500 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 200, "공격력약화", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(200, 400, "인피니티", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(700, 1000, "맹수의일격", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
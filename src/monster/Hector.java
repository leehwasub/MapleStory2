package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Hector extends Monster {

	private static final long serialVersionUID = 1L;

	public Hector() {
		super("헥터", "hector",
				new Strength(new Resistance(50, 150, 100, 100, 100, 100), 32, 4750, 200, 10, 10, 35, 35), 284, 290, 0, 0,
				145 * Main.EXP_BONUS, 224 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(850, 1000, "체력회복", strength.getMaxHp() / 2, 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
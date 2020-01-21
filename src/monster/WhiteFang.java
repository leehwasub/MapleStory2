package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class WhiteFang extends Monster {

	private static final long serialVersionUID = 1L;

	public WhiteFang() {
		super("화이트팽", "whiteFang",
				new Strength(new Resistance(50, 150, 100, 100, 100, 100), 31, 3400, 200, 0, 0, 100, 150, 35, 35, 0), 284, 290, 0, 0,
				134 * Main.EXP_BONUS, 215 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(850, 1000, "체력회복", strength.getMaxHp() / 2, 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
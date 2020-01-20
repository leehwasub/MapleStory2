package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Lucida extends Monster {

	private static final long serialVersionUID = 1L;

	public Lucida() {
		super("루이넬", "lucida",
				new Strength(new Resistance(100, 100, 100, 100, 150, 50), 29, 2800, 800, 0, 0, 120, 300, 35, 35, 0), 254, 265, 270, 287,
				118 * Main.EXP_BONUS, 194 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 4));
		skillList.add(new MonsterSkillInfor(150, 300, "회피율강화", strength.getMaxHp(), 4));
		skillList.add(new MonsterSkillInfor(900, 1000, "안티매직쉘", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(600, 900, "데빌사이더", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
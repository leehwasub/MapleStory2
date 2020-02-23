package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class IronMutae extends Monster {

	private static final long serialVersionUID = 1L;

	public IronMutae() {
		super("아이언뮤테", "ironMutae",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 52, 42000, 2400, 10, 10, 40, 40), 610, 621, 612, 623,
				671 * Main.EXP_BONUS, 1240 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 200, "공격력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(200, 400, "파워트랜스퍼", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(100, 300, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(500, 900, "더블샷", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
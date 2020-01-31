package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class MithrilMutae extends Monster {

	private static final long serialVersionUID = 1L;

	public MithrilMutae() {
		super("미스릴뮤테", "mithrilMutae",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 54, 35000, 2600, 0, 0, 550, 550, 40, 40, 0), 626, 635, 632, 643,
				685 * Main.EXP_BONUS, 1630 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 200, "공격력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(100, 300, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(300, 500, "샤이닝버스터", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(600, 1000, "더블샷", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
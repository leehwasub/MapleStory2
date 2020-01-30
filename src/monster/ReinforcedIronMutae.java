package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class ReinforcedIronMutae extends Monster {

	private static final long serialVersionUID = 1L;

	public ReinforcedIronMutae() {
		super("강화된아이언뮤테", "reinforcedIronMutae",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 52, 32000, 2500, 0, 0, 700, 700, 40, 40, 0), 621, 630, 622, 633,
				671 * Main.EXP_BONUS, 1240 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "방어력강화", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(300, 500, "샤이닝버스터", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(500, 900, "더블샷", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
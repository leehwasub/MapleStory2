package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Sentinel extends Monster {

	private static final long serialVersionUID = 1L;

	public Sentinel() {
		super("스톤볼", "sentinel",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 30, 4000, 250, 10, 10, 24, 24), 292, 305, 290, 300,
				125 * Main.EXP_BONUS, 201 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "방어력강화", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(800, 1000, "샤이닝버스터", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
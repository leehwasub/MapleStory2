package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Skeledog extends Monster {

	private static final long serialVersionUID = 1L;

	public Skeledog() {
		super("스켈독", "rockyMask",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 20, 1120, 80, 0, 0, 80, 80, 12, 12, 0), 180, 190, 0, 0,
				60 * Main.EXP_BONUS, 110 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
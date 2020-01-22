package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Cerebes extends Monster {

	private static final long serialVersionUID = 1L;

	public Cerebes() {
		super("불독", "cerebes",
				new Strength(new Resistance(150, 50, 100, 100, 100, 100), 39, 7600, 200, 0, 0, 250, 200, 25, 25, 0), 441, 461, 460, 482,
				212 * Main.EXP_BONUS, 450 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "방어력강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(800, 1000, "플레임샷", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
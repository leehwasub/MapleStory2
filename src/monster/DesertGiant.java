package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class DesertGiant extends Monster {

	private static final long serialVersionUID = 1L;

	public DesertGiant() {
		super("모래거인", "desertGiant",
				new Strength(new Resistance(160, 40, 100, 100, 100, 100), 48, 25000, 600, 0, 0, 600, 600, 37, 37, 0), 601, 654, 615, 660,
				500 * Main.EXP_BONUS, 1050 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "방어력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(300, 500, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(500, 600, "여의선인", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(700, 1000, "강화된플레임샷", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
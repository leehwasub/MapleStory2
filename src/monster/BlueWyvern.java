package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class BlueWyvern extends Monster {

	private static final long serialVersionUID = 1L;

	public BlueWyvern() {
		super("블루와이번", "blueWyvern",
				new Strength(new Resistance(150, 50, 100, 100, 100, 100), 75, 189000, 5000, 10, 10, 40, 40), 873, 883, 923, 950,
				3100 * Main.EXP_BONUS, 8000 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(100, 250, "안티매직쉘", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(150, 300, "인피니티", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(400, 700, "플레임바이트", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(700, 1000, "강화된플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
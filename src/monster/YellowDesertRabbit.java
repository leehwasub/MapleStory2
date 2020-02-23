package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class YellowDesertRabbit extends Monster {

	private static final long serialVersionUID = 1L;

	public YellowDesertRabbit() {
		super("노란모래토끼", "yellowDesertRabbit",
				new Strength(new Resistance(150, 50, 100, 100, 100, 100), 41, 15000, 350, 10, 10, 37, 37), 450, 464, 450, 470,
				235 * Main.EXP_BONUS, 520 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "회피율강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(800, 1000, "플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
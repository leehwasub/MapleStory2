package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class EarPlugPlead extends Monster {

	private static final long serialVersionUID = 1L;

	public EarPlugPlead() {
		super("귀마개프릴드", "earPlugPlead",
				new Strength(new Resistance(150, 50, 100, 100, 100, 100), 45, 21500, 400, 10, 10, 37, 37), 523, 540, 540, 560,
				337 * Main.EXP_BONUS, 724 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 200, "공격력강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(100, 300, "회피율강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(300, 500, "안티매직쉘", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(600, 700, "버프해제", strength.getMaxHp(), 1, true));
		skillList.add(new MonsterSkillInfor(700, 1000, "플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
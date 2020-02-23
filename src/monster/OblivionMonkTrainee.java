package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class OblivionMonkTrainee extends Monster {

	private static final long serialVersionUID = 1L;

	public OblivionMonkTrainee() {
		super("망각의신관", "OblivionMonkTrainee",
				new Strength(new Resistance(150, 50, 100, 100, 100, 100), 87, 430000, 16000, 10, 10, 40, 40), 1330, 1370, 1380, 1412,
				5240 * Main.EXP_BONUS, 15000 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 11));
		skillList.add(new MonsterSkillInfor(100, 250, "인피니티", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(200, 350, "안티매직쉘", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(300, 600, "강화된플레임샷", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(600, 800, "플레임바이트", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(800, 1000, "서클오브마나", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Scorpion extends Monster {

	private static final long serialVersionUID = 1L;

	public Scorpion() {
		super("스콜피온", "scorpion",
				new Strength(new Resistance(150, 50, 100, 100, 100, 100), 47, 15100, 450, 0, 0, 600, 600, 37, 37, 0), 552, 557, 561, 570,
				396 * Main.EXP_BONUS, 836 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "공격력강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(300, 700, "더블피어싱", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(700, 1000, "플레임샷", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
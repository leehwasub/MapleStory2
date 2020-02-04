package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Roid extends Monster {

	private static final long serialVersionUID = 1L;

	public Roid() {
		super("로이드", "roid",
				new Strength(new Resistance(100, 100, 100, 150, 50, 100), 56, 43000, 1600, 10, 10, 40, 40), 653, 665, 672, 673,
				717 * Main.EXP_BONUS, 1925 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 200, "공격력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(100, 300, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(300, 600, "컴뱃스위칭", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(600, 1000, "체인라이트닝", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
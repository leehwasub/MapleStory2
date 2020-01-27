package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Deo extends Monster {

	private static final long serialVersionUID = 1L;

	public Deo() {
		super("데우", "deo",
				new Strength(new Resistance(170, 30, 100, 100, 100, 100), 45, 170000, 3000, 0, 0, 600, 600, 37, 37, 0), 564, 583, 583, 600,
				9600 * Main.EXP_BONUS, 20000 * Main.MONEY_BONUS, true);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(75, 225, "방어력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(150, 300, "안티매직쉘", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(800, 1000, "강화된플레임샷", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(600, 800, "플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(500, 600, "여의선인", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
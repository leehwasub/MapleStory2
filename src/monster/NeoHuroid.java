package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class NeoHuroid extends Monster {

	private static final long serialVersionUID = 1L;

	public NeoHuroid() {
		super("네오휴로이드", "neoHuroid",
				new Strength(new Resistance(100, 100, 100, 150, 50, 100), 57, 71000, 2200, 10, 10, 40, 40), 683, 695, 702, 703,
				753 * Main.EXP_BONUS, 2130 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 200, "공격력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(100, 300, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(300, 600, "매시브파이어", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(600, 1000, "체인라이트닝", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
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
				new Strength(new Resistance(100, 100, 100, 150, 50, 100), 57, 48600, 2200, 0, 0, 700, 700, 40, 40, 0), 683, 695, 702, 703,
				753 * Main.EXP_BONUS, 2130 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "공격력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(300, 500, "매시브파이어", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(500, 900, "체인라이트닝", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
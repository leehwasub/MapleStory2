package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class CubeSlime extends Monster {

	private static final long serialVersionUID = 1L;

	public CubeSlime() {
		super("큐브슬라임", "cubeSlime",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 49, 19000, 1500, 0, 0, 400, 400, 37, 37, 0), 583, 590, 583, 590,
				396 * Main.EXP_BONUS, 836 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "공격력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(800, 1000, "체력회복", strength.getMaxHp() - 5000, 5));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
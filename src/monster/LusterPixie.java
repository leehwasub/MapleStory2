package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class LusterPixie extends Monster {

	private static final long serialVersionUID = 1L;

	public LusterPixie() {
		super("러스터픽시", "lusterPixie",
				new Strength(new Resistance(100, 100, 100, 100, 50, 150), 27, 3090, 600, 10, 10, 30, 30), 220, 224, 270, 285,
				102 * Main.EXP_BONUS, 175 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(200, 600, "방어력강화", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(400, 1000, "플래쉬", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class SkeletonSoldier extends Monster {

	private static final long serialVersionUID = 1L;

	public SkeletonSoldier() {
		super("스켈레톤사병", "skeletonSoldier",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 22, 1350, 120, 0, 0, 100, 100, 12, 12, 0), 192, 204, 0, 0,
				65 * Main.EXP_BONUS, 124 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(400, 800, "베기", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
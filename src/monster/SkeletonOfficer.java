package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class SkeletonOfficer extends Monster {

	private static final long serialVersionUID = 1L;

	public SkeletonOfficer() {
		super("스켈레톤장교", "skeletonOfficer",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 23, 2300, 120, 10, 10, 12, 12), 200, 210, 0, 0,
				70 * Main.EXP_BONUS, 135 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력약화", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(400, 800, "베기", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
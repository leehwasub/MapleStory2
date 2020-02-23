package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class SkeletonCommander extends Monster {

	private static final long serialVersionUID = 1L;

	public SkeletonCommander() {
		super("스켈레톤지휘관", "skeletonCommander",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 24, 3000, 300, 10, 10, 12, 12), 202, 205, 234, 237,
				85 * Main.EXP_BONUS, 200 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "공격력강화", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(150, 450, "방어력강화", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(600, 1000, "베기", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
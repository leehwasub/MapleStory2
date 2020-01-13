package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class RockyMask extends Monster {

	private static final long serialVersionUID = 1L;

	public RockyMask() {
		super("스톤마스크", "rockyMask",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 19, 1000, 60, 0, 0, 70, 70, 12, 12, 0), 171, 179, 0, 0,
				55 * Main.EXP_BONUS, 90 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "공격력강화", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
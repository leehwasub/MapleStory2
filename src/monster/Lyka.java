package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Lyka extends Monster {

	private static final long serialVersionUID = 1L;

	public Lyka() {
		super("라이카", "lyka",
				new Strength(new Resistance(170, 70, 120, 120, 120, 120), 89, 4500000, 160000, 20, 20, 40, 40), 1354, 1400, 1380, 1427,
				180000 * Main.EXP_BONUS, 360000 * Main.MONEY_BONUS, true);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 11));
		skillList.add(new MonsterSkillInfor(100, 250, "소울인듀어", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(200, 400, "맹수의일격", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(300, 600, "강화된플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(600, 800, "플레임바이트", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(800, 1000, "잊혀지지않는악몽", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Homunculus extends Monster {

	private static final long serialVersionUID = 1L;

	public Homunculus() {
		super("호문쿨루", "homunculus",
				new Strength(new Resistance(100, 100, 150, 100, 100, 100), 59, 82000, 2500, 10, 10, 40, 40), 713, 733, 745, 774,
				820 * Main.EXP_BONUS, 2340 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "공격력약화", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(200, 500, "서클오브마나", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(500, 750, "포이즌미스트", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(750, 900, "체력회복", strength.getMaxHp() - 30000, 20));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
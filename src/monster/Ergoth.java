package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Ergoth extends Monster {

	private static final long serialVersionUID = 1L;

	public Ergoth() {
		super("에레고스", "ergoth",
				new Strength(new Resistance(110, 110, 110, 110, 160, 110), 25, 40000, 40000, 20, 20, 20, 20), 202, 205, 271, 301,
				3000 * Main.EXP_BONUS, 10000 * Main.MONEY_BONUS, true);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 250, "공격력강화", 23000, 2));
		skillList.add(new MonsterSkillInfor(250, 500, "방어력강화", 21000, 2));
		skillList.add(new MonsterSkillInfor(500, 750, "적중률강화", 19000, 2));
		skillList.add(new MonsterSkillInfor(750, 1000, "회피율강화", 17000, 2));
		skillList.add(new MonsterSkillInfor(0, 200, "더블슬래쉬", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(600, 1000, "플레임샷", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
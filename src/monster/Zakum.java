package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Zakum extends Monster {

	private static final long serialVersionUID = 1L;

	public Zakum() {
		super("자쿰", "zakum",
				new Strength(new Resistance(170, 30, 100, 100, 100, 100), 40, 100000, 60000, 0, 0, 300, 300, 30, 25, 0), 502, 536, 632, 688,
				25000 * Main.EXP_BONUS, 100000 * Main.MONEY_BONUS, true);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 120, "공격력강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(60, 180, "공격력약화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(120, 240, "방어력강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(180, 300, "방어력약화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(400, 700, "베츠스웜", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(800, 1000, "강화된플레임샷", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(700, 800, "녹스피어", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Frankenroid extends Monster {

	private static final long serialVersionUID = 1L;

	public Frankenroid() {
		super("프랑켄로이드", "frankenroid",
				new Strength(new Resistance(100, 100, 150, 100, 100, 100), 60, 800000, 60000, 0, 0, 900, 900, 40, 40, 0), 793, 812, 815, 830,
				37000 * Main.EXP_BONUS, 100000 * Main.MONEY_BONUS, true);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(100, 250, "방어력강화", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(200, 350, "안티매직쉘", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(200, 450, "더블샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(450, 600, "로켓펀치", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(600, 750, "매시브파이어", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(750, 900, "샤이닝버스터", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(900, 1000, "매시브스플래쉬", strength.getMaxHp() - 200000, 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
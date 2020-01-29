package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Rumo extends Monster {

	private static final long serialVersionUID = 1L;

	public Rumo() {
		super("루모", "rumo",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 50, 21000, 1500, 0, 0, 550, 550, 40, 40, 0), 584, 595, 595, 600,
				483 * Main.EXP_BONUS, 1035 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "공격력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(700, 1000, "서클오브마나", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
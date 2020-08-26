package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Lilynouch extends Monster {

	private static final long serialVersionUID = 1L;

	public Lilynouch() {
		super("릴리노흐", "lilynouch",
				new Strength(new Resistance(70, 170, 120, 120, 120, 120), 85, 3700000, 14000, 20, 20, 40, 40), 1354, 1380, 1400, 1432,
				160000 * Main.EXP_BONUS, 320000 * Main.MONEY_BONUS, true);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "방어력강화", strength.getMaxHp(), 11));
		skillList.add(new MonsterSkillInfor(100, 250, "소울인듀어", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(200, 350, "파워트랜스퍼", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(300, 600, "콜드빔", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(600, 800, "아이스스트라이크", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(900, 1000, "블리자드", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class TripleRumo extends Monster {

	private static final long serialVersionUID = 1L;

	public TripleRumo() {
		super("트리플루모", "tripleRumo",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 51, 39000, 1700, 10, 10, 40, 40), 591, 607, 601, 617,
				483 * Main.EXP_BONUS, 1035 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "공격력강화", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 7));
		skillList.add(new MonsterSkillInfor(700, 1000, "서클오브마나", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}
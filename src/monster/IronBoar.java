package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class IronBoar extends Monster {

	private static final long serialVersionUID = 1L;

	public IronBoar() {
		super("아이언보어", "ironBoar",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 17, 750, 30, 10, 10, 7, 7), 126, 131, 0, 0,
				46 * Main.EXP_BONUS, 75 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "방어력강화", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
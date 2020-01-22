package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Bain extends Monster {

	private static final long serialVersionUID = 1L;

	public Bain() {
		super("파이어독", "bain",
				new Strength(new Resistance(170, 30, 100, 100, 100, 100), 39, 8000, 300, 0, 0, 250, 200, 25, 25, 0), 450, 472, 470, 492,
				227 * Main.EXP_BONUS, 500 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "방어력강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(800, 1000, "플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}
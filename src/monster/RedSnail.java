package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;
import maplestory.Main;

public final class RedSnail extends Monster {

	private static final long serialVersionUID = 1L;

	public RedSnail() {
		super("빨간달팽이", "redSnail", new Strength(new Resistance(100, 100, 100, 100, 100, 100), 3, 30, 10, 0, 0, 1, 0, 0, 0, 0), 10, 13, 0, 0,
				6 * Main.EXP_BONUS, 15 * Main.MONEY_BONUS, false);
		initSkillList();
	}


	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}
}

package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public final class BlueSnail extends Monster {

	private static final long serialVersionUID = 1L;

	public BlueSnail() {
		super("빨간달팽이", "blueSnail",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 1, 15, 2, 8, 0, 0, 0, 0, 0, 0), 7, 10, 0, 0, 3,
				10, false);
		initSkillList();
	}

	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp()));
	}

}

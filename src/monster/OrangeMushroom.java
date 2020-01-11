package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public final class OrangeMushroom extends Monster {

	private static final long serialVersionUID = 1L;

	public OrangeMushroom() {
		super("주황버섯", "orangeMushroom",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 7, 90, 10, 0, 0, 3, 0, 2, 2, 0), 30, 33, 0, 0,
				12, 21, false);
		initSkillList();
	}

	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}

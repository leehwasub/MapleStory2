package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
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
		
	}

}

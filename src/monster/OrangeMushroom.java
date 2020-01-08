package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public class OrangeMushroom extends Monster {
	public OrangeMushroom() {
		super("주황버섯", "orangeMushroom",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 7, 90, 10, 0, 0, 3, 0, 2, 2, 0), 30, 33, 0, 0,
				12, 21, false);
	}

	public Attack attack(Hunt hunt, StateBox attacker, StateBox opponents) {
		return AttackFactory.makeAttack(hunt, attacker, opponents, "몸통박치기", 0);
	}
}

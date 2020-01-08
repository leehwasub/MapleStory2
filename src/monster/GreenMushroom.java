package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public class GreenMushroom extends Monster {
	public GreenMushroom() {
		super("초록버섯", "greenMushroom",
				new Strength(new Resistance(100, 100, 150, 100, 100, 100), 9, 125, 10, 0, 0, 3, 0, 2, 2, 0), 34, 37, 0, 0,
				15, 24, false);
	}

	public Attack attack(Hunt hunt, StateBox attacker, StateBox opponents) {
		return AttackFactory.makeAttack(hunt, attacker, opponents, "몸통박치기", 0);
	}
}
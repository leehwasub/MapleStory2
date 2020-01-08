package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public class BlueSnail extends Monster {
	public BlueSnail() {
		super("빨간달팽이", "blueSnail",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 1, 15, 2, 8, 0, 0, 0, 0, 0, 0), 7, 10, 0, 0, 3,
				10, false);
	}

	public Attack attack(Hunt hunt, StateBox attacker, StateBox opponents) {
		return AttackFactory.makeAttack(hunt, attacker, opponents, "몸통박치기", 0);
	}
}

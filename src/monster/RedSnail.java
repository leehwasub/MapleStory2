package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public class RedSnail extends Monster {
	public RedSnail() {
		super("빨간달팽이", "redSnail", new Strength(new Resistance(100, 100, 100, 100, 100, 100), 3, 30, 10, 0, 0, 1, 0, 0, 0, 0), 10, 13, 0, 0,
				6, 15, false);
	}

	public Attack attack(Hunt hunt, StateBox attacker, StateBox opponents) {
		return AttackFactory.makeAttack(hunt, attacker, opponents, "몸통박치기", 0);
	}
}

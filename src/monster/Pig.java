package monster;

import java.util.ArrayList;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public class Pig extends Monster {
	public Pig() {
		super("돼지", "pig", new Strength(new Resistance(100, 100, 100, 100, 100, 100), 5, 60, 10, 0, 0, 3, 0, 2, 2, 0),
				23, 26, 0, 0, 8, 18, false);
	}

	public Attack attack(Hunt hunt, StateBox attacker, StateBox opponents) {
		return AttackFactory.makeAttack(hunt, attacker, opponents, "몸통박치기", 0);
	}
}
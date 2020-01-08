package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public class Mano extends Monster {
	public Mano() {
		super("마노", "mano",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 5, 400, 100, 0, 0, 2, 2, 10, 0, 0), 20, 23, 30,
				33, 100, 300, true);
	}

	public Attack attack(Hunt hunt, StateBox attacker, StateBox opponents) {
		int percent = (int) (Math.random() * 100.0D);
		Attack attack = null;
		if ((percent >= 0) && (percent <= 70)) {
			attack = AttackFactory.makeAttack(hunt, attacker, opponents, "몸통박치기", 0);
		} else {
			attack = AttackFactory.makeAttack(hunt, attacker, opponents, "플래쉬", 0);
		}
		return attack;
	}
}

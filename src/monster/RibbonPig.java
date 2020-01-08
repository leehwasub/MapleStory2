package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public class RibbonPig extends Monster {
	public RibbonPig() {
		super("리본돼지", "ribbonPig",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 6, 75, 10, 0, 0, 3, 0, 2, 2, 0), 26, 29, 0, 0,
				10, 20, false);
	}

	public Attack attack(Hunt hunt, StateBox attacker, StateBox opponents) {
		return AttackFactory.makeAttack(hunt, attacker, opponents, "몸통박치기", 0);
	}
}

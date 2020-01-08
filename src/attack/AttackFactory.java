package attack;

import java.util.ArrayList;

import component.StateBox;
import hunt.Hunt;

public class AttackFactory {
	public static Attack makeAttack(Hunt hunt, StateBox attacker, StateBox opponents, String attackName,
			int skillPoint) {
		switch (attackName) {
		case "몸통박치기":
			return new TackleAttack(hunt, attacker, opponents, 0);
		case "플래쉬":
			//return new FlashAttack(hunt, attacker, opponents, 0);
		case "일반공격":
			return new NormalAttack(hunt, attacker, opponents, 0);
		}
		return null;
	}
}

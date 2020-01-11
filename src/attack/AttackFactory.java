package attack;

import javax.swing.JOptionPane;

import component.StateBox;
import hunt.Hunt;
import utils.DialogUtils;

public class AttackFactory {
	public static Attack makeMonsterAttack(Hunt hunt, StateBox attacker, StateBox opponents, String attackName,
			int skillPoint) {
		switch (attackName) {
		case "몸통박치기":
			return new TackleAttack(hunt, attacker, opponents, 0);
		case "플래쉬":
			return new FlashAttack(hunt, attacker, opponents, skillPoint);
		}
		DialogUtils.showErrorDialog("AttackFactory.makeMonsterAttack(...) 몬스터 공격 실패!");
		return null;
	}
	
	public static Attack makeAdventurerAttack(Hunt hunt, StateBox attacker, StateBox opponents, String attackName,
			int skillPoint) {
		switch (attackName) {
		case "일반공격":
			return new NormalAttack(hunt, attacker, opponents, 0);
		}
		DialogUtils.showErrorDialog("AttackFactory.makeAdventurerAttack(...) 플레이어 공격 실패!");
		return null;
	}
	
}

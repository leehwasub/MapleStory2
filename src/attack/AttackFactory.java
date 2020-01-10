package attack;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import component.StateBox;
import hunt.Hunt;

public class AttackFactory {
	public static Attack makeMonsterAttack(Hunt hunt, StateBox attacker, StateBox opponents, String attackName,
			int skillPoint) {
		switch (attackName) {
		case "몸통박치기":
			return new TackleAttack(hunt, attacker, opponents, 0);
		case "플래쉬":
			return new FlashAttack(hunt, attacker, opponents, skillPoint);
		}
		JOptionPane.showMessageDialog(null, "AttackFactory class 몬스터 스킬 생성 실패!!", "오류", JOptionPane.ERROR_MESSAGE);
		return null;
	}
	
	public static Attack makeAdventurerAttack(Hunt hunt, StateBox attacker, StateBox opponents, String attackName,
			int skillPoint) {
		switch (attackName) {
		case "일반공격":
			return new NormalAttack(hunt, attacker, opponents, 0);
		}
		JOptionPane.showMessageDialog(null, "AttackFactory class 플레이어 스킬 생성 실패!!", "오류", JOptionPane.ERROR_MESSAGE);
		return null;
	}
	
}

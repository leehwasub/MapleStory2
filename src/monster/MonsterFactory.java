package monster;

import java.util.ArrayList;

import character.Monster;
import maplestory.Main;

public class MonsterFactory {
	public static boolean isRange(int mid, int low, int high) {
		return (low <= mid) && (mid < high);
	}

	public static Monster makeMonster(String monsterName) {
		switch (monsterName) {
		case "파란달팽이":
			return new BlueSnail();
		case "빨간달팽이":
			return new RedSnail();
		case "마노":
			return new Mano();
		case "돼지":
			return new Pig();
		case "리본돼지":
			return new RibbonPig();
		case "주황버섯":
			return new OrangeMushroom();
		case "초록버섯":
			return new GreenMushroom();
		}
		return null;
	}

	public static Monster readyMonster(String mapName) {
		Monster ret = null;
		int percent = (int) (Math.random() * 200.0D);
		if(Main.MONSTER_TEST_MODE) percent *= 1000000;
		switch (mapName) {
		case "초보자의숲2":
			if (isRange(percent, 0, 10)) {
				ret = makeMonster("파란달팽이");
			}
			break;
		case "달팽이의숲":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("파란달팽이");
			} else if (isRange(percent, 5, 10)) {
				ret = makeMonster("빨간달팽이");
			}
			break;
		case "위험한숲":
			ret = makeMonster("마노");
			break;
		case "리스항구외각":
			break;
		}
		return ret;
	}
}

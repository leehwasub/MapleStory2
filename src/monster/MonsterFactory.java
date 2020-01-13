package monster;

import character.Monster;
import maplestory.Main;
import utils.DialogUtils;

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
		case "스텀프":
			return new Stump();
		case "엑스텀프":
			return new AxeStump();
		case "와일드보어":
			return new WildBoar();
		case "파이어보어":
			return new FireBoar();
		case "아이언호그":
			return new IronHog();
		case "아이언보어":
			return new IronBoar();
		}
		DialogUtils.showErrorDialog("Monsterfactory.makeMonster(monsterName) 몬스터 생성 실패!");
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
			if (isRange(percent, 0, 4)) {
				ret = makeMonster("파란달팽이");
			} else if (isRange(percent, 6, 10)) {
				ret = makeMonster("빨간달팽이");
			}
			break;
		case "위험한숲":
			ret = makeMonster("마노");
			break;
		case "리스항구외각":
			if (isRange(percent, 0, 4)) {
				ret = makeMonster("빨간달팽이");
			} else if (isRange(percent, 6, 10)) {
				ret = makeMonster("돼지");
			}
			break;
		case "해안가풀숲":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("돼지");
			} else if (isRange(percent, 5, 10)) {
				ret = makeMonster("리본돼지");
			}
			break;
		case "버섯동산":
			if (isRange(percent, 0, 8)) {
				ret = makeMonster("주황버섯");
			} else if (isRange(percent, 8, 10)) {
				ret = makeMonster("초록버섯");
			}
			break;
		case "페리온서쪽길목":
			if (isRange(percent, 0, 4)) {
				ret = makeMonster("초록버섯");
			} else if (isRange(percent, 6, 10)) {
				ret = makeMonster("스텀프");
			}
			break;
		case "페리온동쪽길목":
			if (isRange(percent, 0, 3)) {
				ret = makeMonster("스텀프");
			} else if (isRange(percent, 7, 10)) {
				ret = makeMonster("엑스텀프");
			}
			break;
		case "와일드보어의땅1":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("와일드보어");
			} else if (isRange(percent, 5, 10)) {
				ret = makeMonster("파이어보어");
			}
			break;
		case "와일드보어의땅2":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("아이언호그");
			} else if (isRange(percent, 5, 10)) {
				ret = makeMonster("아이언보어");
			}
			break;
		}
		return ret;
	}
}

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
		case "우드마스크":
			return new WoodenMask();
		case "스톤마스크":
			return new RockyMask();
		case "스켈독":
			return new Skeledog();
		case "머미독":
			return new Mummydog();
		case "스켈레톤사병":
			return new SkeletonSoldier();
		case "스켈레톤장교":
			return new SkeletonOfficer();
		case "스켈레톤지휘관":
			return new SkeletonCommander();
		case "에레고스":
			return new Ergoth();
		case "스타픽시":
			return new StarPixie();
		case "루나픽시":
			return new LunarPixie();
		case "러스터픽시":
			return new LusterPixie();
		case "샐리온":
			return new Cellion();
		case "그류핀":
			return new Grupin();
		case "라이오너":
			return new Lioner();
		case "루이넬":
			return new Lucida();
		case "엘리자":
			return new Eliza();
		case "스톤볼":
			return new Sentinel();
		case "화이트팽":
			return new WhiteFang();
		case "헥터":
			return new Hector();
		case "페페":
			return new Pepe();
		case "다크페페":
			return new DarkPepe();
		case "예티":
			return new Yeti();
		case "다크예티":
			return new DarkYeti();
		case "웨어울프":
			return new Werewolf();
		case "라이칸스로프":
			return new Lycanthrope();
		case "불독":
			return new Cerebes();
		case "파이어독":
			return new Bain();
		}
		DialogUtils.showErrorDialog("Monsterfactory.makeMonster(monsterName) 몬스터 생성 실패!");
		return null;
	}

	public static Monster readyMonster(String mapName) {
		Monster ret = null;
		int percent = (int) (Math.random() * 300.0D);
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
		case "유적발굴지":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("우드마스크");
			} else if (isRange(percent, 5, 10)) {
				ret = makeMonster("스톤마스크");
			}
			break;
		case "발굴중단지역":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("스켈독");
			} else if (isRange(percent, 5, 10)) {
				ret = makeMonster("머미독");
			}
			break;
		case "폐쇄구역":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("스켈레톤사병");
			} else if (isRange(percent, 5, 10)) {
				ret = makeMonster("스켈레톤장교");
			}
			break;
		case "군영":
			if (isRange(percent, 0, 4)) {
				ret = makeMonster("스켈레톤사병");
			} else if (isRange(percent, 4, 7)) {
				ret = makeMonster("스켈레톤장교");
			} else if (isRange(percent, 7, 10)) {
				ret = makeMonster("스켈레톤지휘관");
			}
			break;
		case "에레고스왕좌":
			ret = makeMonster("에레고스");
			break;
		case "구름공원1":
			if (isRange(percent, 0, 6)) {
				ret = makeMonster("스타픽시");
			} else if (isRange(percent, 6, 10)) {
				ret = makeMonster("루나픽시");
			}
			break;
		case "구름공원2":
			if (isRange(percent, 0, 6)) {
				ret = makeMonster("러스터픽시");
			} else if (isRange(percent, 6, 10)) {
				ret = makeMonster("루나픽시");
			}
			break;
		case "하늘계단1":
			if (isRange(percent, 0, 4)) {
				ret = makeMonster("샐리온");
			} else if (isRange(percent, 4, 8)) {
				ret = makeMonster("그류핀");
			} else if (isRange(percent, 8, 12)) {
				ret = makeMonster("라이오너");
			}
			break;
		case "하늘계단2":
			if (isRange(percent, 0, 10)) {
				ret = makeMonster("루이넬");
			}
			break;
		case "어둠의공원":
			ret = makeMonster("엘리자");
			break;
		case "오르비스탑상층":
			if (isRange(percent, 0, 10)) {
				ret = makeMonster("스톤볼");
			}
			break;
		case "오르비스탑하층":
			if (isRange(percent, 0, 10)) {
				ret = makeMonster("스톤볼");
			}
			break;
		case "얼음벌판":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("화이트팽");
			} else if(isRange(percent, 5, 10)) {
				ret = makeMonster("헥터");
			}
			break;
		case "빙판길":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("페페");
			} else if(isRange(percent, 5, 10)) {
				ret = makeMonster("다크페페");
			}
			break;
		case "위험한골짜기1":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("예티");
			} else if(isRange(percent, 5, 10)) {
				ret = makeMonster("다크페페");
			}
			break;
		case "위험한골짜기2":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("예티");
			} else if(isRange(percent, 5, 10)) {
				ret = makeMonster("다크예티");
			}
			break;
		case "늑대의영역":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("웨어울프");
			} else if(isRange(percent, 5, 10)) {
				ret = makeMonster("라이칸스로프");
			}
			break;
		case "시련의동굴":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("불독");
			} else if(isRange(percent, 5, 10)) {
				ret = makeMonster("파이어독");
			}
			break;
		}
		return ret;
	}
}

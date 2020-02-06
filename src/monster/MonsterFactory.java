package monster;

import java.util.ArrayList;
import java.util.Collections;

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
		case "자쿰":
			return new Zakum();
		case "노란모래토끼":
			return new YellowDesertRabbit();
		case "검은모래토끼":
			return new DarkDesertRabbit();
		case "카투스":
			return new Cactus();
		case "로얄카투스":
			return new LoyalCactus();
		case "벨라모아":
			return new Bellamoa();
		case "귀마개프릴드":
			return new EarPlugPlead();
		case "데우":
			return new Deo();
		case "키요":
			return new Kiyo();
		case "모래거인":
			return new DesertGiant();
		case "스콜피온":
			return new Scorpion();
		case "큐브슬라임":
			return new CubeSlime();
		case "루모":
			return new Rumo();
		case "트리플루모":
			return new TripleRumo();
		case "아이언뮤테":
			return new IronMutae();
		case "강화된아이언뮤테":
			return new ReinforcedIronMutae();
		case "미스릴뮤테":
			return new MithrilMutae();
		case "강화된미스릴뮤테":
			return new ReinforcedMithrilMutae();
		case "로이드":
			return new Roid();
		case "네오휴로이드":
			return new NeoHuroid();
		case "루루모":
			return new Rurumo();
		case "샤이티":
			return new Saitie();
		case "호문쿨루":
			return new Homunculus();
		case "호문스큘러":
			return new Homunscullo();
		case "프랑켄로이드":
			return new Frankenroid();
		case "레쉬":
			return new Rash();
		case "다크레쉬":
			return new DarkRash();
		case "비틀":
			return new Beetle();
		case "듀얼비틀":
			return new DualBeetle();
		case "호브":
			return new Hobi();
		case "헹키":
			return new Hankie();
		case "하프":
			return new Harp();
		case "블러드하프":
			return new BloodHarp();
		case "켄타우로스":
			return new Kentaurus();
		case "버크":
			return new Birk();
		case "듀얼버크":
			return new DualBirk();
		case "블루드래곤터틀":
			return new BlueDragonTurtle();
		case "레드드래곤터틀":
			return new RedDragonTurtle();
		case "블루와이번":
			return new BlueWyvern();
		case "레드와이번":
			return new RedWyvern();
		case "코니언":
			return new Cornian();
		case "다크와이번":
			return new DarkWyvern();
		case "혼테일":
			return new Horntail();
		}
		DialogUtils.showErrorDialog("Monsterfactory.makeMonster(monsterName) 몬스터 생성 실패!");
		return null;
	}
	
	public ArrayList<Monster> getSortedMonsters(){
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		monsters.add(makeMonster("파란달팽이"));
		monsters.add(makeMonster("빨간달팽이"));
		monsters.add(makeMonster("마노"));
		monsters.add(makeMonster("돼지"));
		monsters.add(makeMonster("리본돼지"));
		monsters.add(makeMonster("주황버섯"));
		monsters.add(makeMonster("초록버섯"));
		monsters.add(makeMonster("스텀프"));
		monsters.add(makeMonster("엑스텀프"));
		monsters.add(makeMonster("와일드보어"));
		monsters.add(makeMonster("파이어보어"));
		monsters.add(makeMonster("아이언호그"));
		monsters.add(makeMonster("아이언보어"));
		monsters.add(makeMonster("우드마스크"));
		monsters.add(makeMonster("스톤마스크"));
		monsters.add(makeMonster("스켈독"));
		monsters.add(makeMonster("머미독"));
		monsters.add(makeMonster("스켈레톤사병"));
		monsters.add(makeMonster("스켈레톤장교"));
		monsters.add(makeMonster("스켈레톤지휘관"));
		monsters.add(makeMonster("에레고스"));
		monsters.add(makeMonster("스타픽시"));
		monsters.add(makeMonster("루나픽시"));
		monsters.add(makeMonster("러스터픽시"));
		monsters.add(makeMonster("샐리온"));
		monsters.add(makeMonster("그류핀"));
		monsters.add(makeMonster("라이오너"));
		monsters.add(makeMonster("루이넬"));
		monsters.add(makeMonster("엘리자"));
		monsters.add(makeMonster("스톤볼"));
		monsters.add(makeMonster("화이트팽"));
		monsters.add(makeMonster("헥터"));
		monsters.add(makeMonster("페페"));
		monsters.add(makeMonster("다크페페"));
		monsters.add(makeMonster("예티"));
		monsters.add(makeMonster("다크예티"));
		monsters.add(makeMonster("웨어울프"));
		monsters.add(makeMonster("라이칸스로프"));
		monsters.add(makeMonster("불독"));
		monsters.add(makeMonster("파이어독"));
		monsters.add(makeMonster("자쿰"));
		monsters.add(makeMonster("노란모래토끼"));
		monsters.add(makeMonster("검은모래토끼"));
		monsters.add(makeMonster("카투스"));
		monsters.add(makeMonster("로얄카투스"));
		monsters.add(makeMonster("벨라모아"));
		monsters.add(makeMonster("귀마개프릴드"));
		monsters.add(makeMonster("데우"));
		monsters.add(makeMonster("키요"));
		monsters.add(makeMonster("모래거인"));
		monsters.add(makeMonster("스콜피온"));
		monsters.add(makeMonster("큐브슬라임"));
		monsters.add(makeMonster("루모"));
		monsters.add(makeMonster("트리플루모"));
		monsters.add(makeMonster("아이언뮤테"));
		monsters.add(makeMonster("강화된아이언뮤테"));
		monsters.add(makeMonster("미스릴뮤테"));
		monsters.add(makeMonster("강화된미스릴뮤테"));
		monsters.add(makeMonster("로이드"));
		monsters.add(makeMonster("네오휴로이드"));
		monsters.add(makeMonster("루루모"));
		monsters.add(makeMonster("샤이티"));
		monsters.add(makeMonster("호문쿨루"));
		monsters.add(makeMonster("호문스큘러"));
		monsters.add(makeMonster("프랑켄로이드"));
		monsters.add(makeMonster("레쉬"));
		monsters.add(makeMonster("다크레쉬"));
		monsters.add(makeMonster("비틀"));
		monsters.add(makeMonster("듀얼비틀"));
		monsters.add(makeMonster("호브"));
		monsters.add(makeMonster("헹키"));
		monsters.add(makeMonster("하프"));
		monsters.add(makeMonster("블러드하프"));
		monsters.add(makeMonster("켄타우로스"));
		monsters.add(makeMonster("버크"));
		monsters.add(makeMonster("듀얼버크"));
		monsters.add(makeMonster("블루드래곤터틀"));
		monsters.add(makeMonster("레드드래곤터틀"));
		monsters.add(makeMonster("블루와이번"));
		monsters.add(makeMonster("레드와이번"));
		monsters.add(makeMonster("코니언"));
		monsters.add(makeMonster("다크와이번"));
		monsters.add(makeMonster("혼테일"));
		Collections.sort(monsters);
		return monsters;
	}
	
	public void printAllMonster() {
		ArrayList<Monster> monsters = getSortedMonsters();
		for(int i = 0; i < monsters.size(); i++){
			System.out.println(monsters.get(i));
		}
	}

	public static Monster readyMonster(String mapName) {
		Monster ret = null;
		int percent = (int) (Math.random() * 300.0D);
		if(Main.MONSTER_TEST_MODE) percent = 500;
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
		case "자쿰의제단":
			ret = makeMonster("자쿰");
			break;
		case "마른사막":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("노란모래토끼");
			} else if(isRange(percent, 5, 10)) {
				ret = makeMonster("검은모래토끼");
			}
			break;
		case "선인장사막":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("카투스");
			} else if(isRange(percent, 5, 10)) {
				ret = makeMonster("로얄카투스");
			}
			break;
		case "작열하는사막":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("벨라모아");
			} else if(isRange(percent, 5, 10)) {
				ret = makeMonster("귀마개프릴드");
			}
			break;
		case "선인장사막북쪽":
			ret = makeMonster("데우");
			break;
		case "북쪽사막길1":
			if (isRange(percent, 0, 7)) {
				ret = makeMonster("키요");
			} else if(isRange(percent, 7, 10)) {
				ret = makeMonster("모래거인");
			}
			break;
		case "북쪽사막길2":
			if (isRange(percent, 0, 7)) {
				ret = makeMonster("키요");
			} else if(isRange(percent, 7, 10)) {
				ret = makeMonster("모래거인");
			}
			break;
		case "사헬지대":
			if (isRange(percent, 0, 10)) {
				ret = makeMonster("스콜피온");
			}
			break;
		case "연구소101호":
			if (isRange(percent, 0, 7)) {
				ret = makeMonster("큐브슬라임");
			} else if (isRange(percent, 7, 14)) {
				ret = makeMonster("루모");
			}
			break;
		case "연구소102호":
			if (isRange(percent, 0, 7)) {
				ret = makeMonster("트리플루모");
			} else if (isRange(percent, 7, 14)) {
				ret = makeMonster("루모");
			}
			break;
		case "A-1구역":
			if (isRange(percent, 0, 14)) {
				ret = makeMonster("아이언뮤테");
			}
			break;
		case "A-2구역":
			if (isRange(percent, 0, 14)) {
				ret = makeMonster("강화된아이언뮤테");
			}
			break;
		case "B-1구역":
			if (isRange(percent, 0, 14)) {
				ret = makeMonster("미스릴뮤테");
			}
			break;
		case "B-2구역":
			if (isRange(percent, 0, 14)) {
				ret = makeMonster("강화된미스릴뮤테");
			}
			break;
		case "C-1구역":
			if (isRange(percent, 0, 14)) {
				ret = makeMonster("로이드");
			}
			break;
		case "C-2구역":
			if (isRange(percent, 0, 14)) {
				ret = makeMonster("네오휴로이드");
			}
			break;
		case "연구소102호돌연변이":
			ret = makeMonster("루루모");
			break;
		case "연구소201호":
			if (isRange(percent, 0, 14)) {
				ret = makeMonster("샤이티");
			}
			break;
		case "연구소202호":
			if (isRange(percent, 0, 7)) {
				ret = makeMonster("호문쿨루");
			} else if (isRange(percent, 7, 14)) {
				ret = makeMonster("호문스큘러");
			}
			break;
		case "비밀연구소위험지역":
			ret = makeMonster("프랑켄로이드");
			break;
		case "비밀연구소1구역":
			if (isRange(percent, 0, 7)) {
				ret = makeMonster("강화된아이언뮤테");
			} else if (isRange(percent, 7, 14)) {
				ret = makeMonster("강화된미스릴뮤테");
			}
			break;
		case "비밀연구소2구역":
			if (isRange(percent, 0, 7)) {
				ret = makeMonster("로이드");
			} else if (isRange(percent, 7, 14)) {
				ret = makeMonster("네오휴로이드");
			}
			break;
		case "리프레서쪽숲":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("레쉬");
			} else if (isRange(percent, 5, 10)) {
				ret = makeMonster("다크레쉬");
			}
			break;
		case "리프레동쪽숲":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("비틀");
			} else if (isRange(percent, 5, 10)) {
				ret = makeMonster("듀얼비틀");
			}
			break;
		case "심술쟁이의숲":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("호브");
			} else if (isRange(percent, 5, 10)) {
				ret = makeMonster("헹키");
			}
			break;
		case "하늘둥지":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("하프");
			} else if (isRange(percent, 5, 10)) {
				ret = makeMonster("블러드하프");
			}
			break;
		case "켄타우로스의영역":
			if (isRange(percent, 0, 10)) {
				ret = makeMonster("켄타우로스");
			}
			break;
		case "가파른언덕":
			if (isRange(percent, 0, 10)) {
				ret = makeMonster("버크");
			}
			break;
		case "용의숲입구":
			if (isRange(percent, 0, 10)) {
				ret = makeMonster("듀얼버크");
			}
			break;
		case "용의숲1":
			if (isRange(percent, 0, 6)) {
				ret = makeMonster("블루드래곤터틀");
			} if (isRange(percent, 6, 10)) {
				ret = makeMonster("레드드래곤터틀");
			}
			break;
		case "용의숲2":
			if (isRange(percent, 0, 4)) {
				ret = makeMonster("블루드래곤터틀");
			} if (isRange(percent, 4, 10)) {
				ret = makeMonster("레드드래곤터틀");
			}
			break;
		case "용의협곡":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("블루와이번");
			} if (isRange(percent, 5, 10)) {
				ret = makeMonster("레드와이번");
			}
			break;
		case "용의둥지":
			if (isRange(percent, 0, 5)) {
				ret = makeMonster("다크와이번");
			} if (isRange(percent, 5, 10)) {
				ret = makeMonster("코니언");
			}
			break;
		case "혼테일동굴":
			ret = makeMonster("혼테일");
			break;
		}
		return ret;
	}
}

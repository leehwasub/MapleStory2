package monster;

import java.util.ArrayList;

import character.Monster;
import item.Item;
import item.ItemPool;
import maplestory.Player;
import npc.Koscu;

public class DropItemFactory {
	public static boolean isRange(int mid, int low, int high) {
		return (low <= mid) && (mid < high);
	}

	public static ArrayList<Item> dropItemWithMonster(Monster monster, Player player) {
		ArrayList<Item> getItems = new ArrayList<Item>();
		int percent = (int) (Math.random() * 100.0D);
		if (isRange(percent, 0, 50)) {
			if (monster instanceof BlueSnail) {
				getItems.add(ItemPool.getItem("파란달팽이의껍질", 1));
			} else if (monster instanceof RedSnail) {
				getItems.add(ItemPool.getItem("빨간달팽이의껍질", 1));
			} else if (monster instanceof RibbonPig) {
				getItems.add(ItemPool.getItem("돼지의리본", 1));
			} else if (monster instanceof OrangeMushroom) {
				getItems.add(ItemPool.getItem("주황버섯의갓", 1));
			} else if (monster instanceof GreenMushroom) {
				getItems.add(ItemPool.getItem("초록버섯의갓", 1));
			} else if (monster instanceof Stump) {
				getItems.add(ItemPool.getItem("나뭇가지", 1));
			} else if (monster instanceof AxeStump) {
				getItems.add(ItemPool.getItem("장작", 1));
			} else if (monster instanceof WildBoar) {
				getItems.add(ItemPool.getItem("와일드보어의송곳니", 1));
			} else if (monster instanceof FireBoar) {
				getItems.add(ItemPool.getItem("파이어보어의송곳니", 1));
			} else if (monster instanceof IronHog) {
				getItems.add(ItemPool.getItem("아이언호그의철발굽", 1));
			} else if (monster instanceof IronBoar) {
				getItems.add(ItemPool.getItem("아이언보어의갑옷조각", 1));
			} else if (monster instanceof WoodenMask) {
				getItems.add(ItemPool.getItem("목판", 1));
			} else if (monster instanceof RockyMask) {
				getItems.add(ItemPool.getItem("석판", 1));
			} else if (monster instanceof Skeledog) {
				getItems.add(ItemPool.getItem("스켈독의뼈", 1));
			} else if (monster instanceof Mummydog) {
				getItems.add(ItemPool.getItem("더러운붕대", 1));
			} else if (monster instanceof SkeletonSoldier) {
				getItems.add(ItemPool.getItem("갈비뼈", 1));
			} else if (monster instanceof SkeletonOfficer) {
				getItems.add(ItemPool.getItem("골반뼈", 1));
			} else if (monster instanceof SkeletonCommander) {
				getItems.add(ItemPool.getItem("말머리뼈", 1));
			} else if (monster instanceof StarPixie) {
				getItems.add(ItemPool.getItem("스타픽시의별조각", 1));
			} else if (monster instanceof LunarPixie) {
				getItems.add(ItemPool.getItem("루나픽시의달조각", 1));
			} else if (monster instanceof LusterPixie) {
				getItems.add(ItemPool.getItem("러스터픽시의태양조각", 1));
			} else if (monster instanceof Lioner) {
				getItems.add(ItemPool.getItem("라이오너의꼬리", 1));
			} else if (monster instanceof Grupin) {
				getItems.add(ItemPool.getItem("그류핀의꼬리", 1));
			} else if (monster instanceof Cellion) {
				getItems.add(ItemPool.getItem("샐리온의꼬리", 1));
			} else if (monster instanceof Lucida) {
				getItems.add(ItemPool.getItem("루이넬의꼬리", 1));
			} else if (monster instanceof Sentinel) {
				getItems.add(ItemPool.getItem("스톤볼의돌조각", 1));
			} else if (monster instanceof WhiteFang) {
				getItems.add(ItemPool.getItem("화이트팽의꼬리", 1));
			} else if (monster instanceof Hector) {
				getItems.add(ItemPool.getItem("헥터의꼬리", 1));
			} else if (monster instanceof Pepe) {
				getItems.add(ItemPool.getItem("페페의부리", 1));
			} else if (monster instanceof DarkPepe) {
				getItems.add(ItemPool.getItem("다크페페의부리", 1));
			} else if (monster instanceof Yeti) {
				getItems.add(ItemPool.getItem("예티의뿔", 1));
			} else if (monster instanceof DarkYeti) {
				getItems.add(ItemPool.getItem("다크예티의뿔", 1));
			} else if (monster instanceof Werewolf) {
				getItems.add(ItemPool.getItem("웨어울프의발톱", 1));
			} else if (monster instanceof Lycanthrope) {
				getItems.add(ItemPool.getItem("라이칸스로프의발톱", 1));
			} else if (monster instanceof Cerebes) {
				getItems.add(ItemPool.getItem("불독의송곳니", 1));
			} else if (monster instanceof Bain) {
				getItems.add(ItemPool.getItem("파이어독의목걸이", 1));
			} else if (monster instanceof Cactus) {
				getItems.add(ItemPool.getItem("선인장의가시", 1));
			} else if (monster instanceof LoyalCactus) {
				getItems.add(ItemPool.getItem("카투스의꽃", 1));
			} else if (monster instanceof Bellamoa) {
				getItems.add(ItemPool.getItem("뱀방울", 1));
			} else if (monster instanceof EarPlugPlead) {
				getItems.add(ItemPool.getItem("귀마개", 1));
			} else if (monster instanceof Kiyo) {
				getItems.add(ItemPool.getItem("키요의부리", 1));
			} else if (monster instanceof DesertGiant) {
				getItems.add(ItemPool.getItem("금모래가루", 1));
			} else if (monster instanceof CubeSlime) {
				getItems.add(ItemPool.getItem("젤라틴", 1));
			} else if (monster instanceof Rumo) {
				getItems.add(ItemPool.getItem("플라스크", 1));
			} else if (monster instanceof IronMutae) {
				getItems.add(ItemPool.getItem("강철파편", 1));
			} else if (monster instanceof ReinforcedIronMutae) {
				getItems.add(ItemPool.getItem("강철파편강화형", 1));
			} else if (monster instanceof MithrilMutae) {
				getItems.add(ItemPool.getItem("미스릴파편", 1));
			} else if (monster instanceof ReinforcedMithrilMutae) {
				getItems.add(ItemPool.getItem("미스릴파편강화형", 1));
			} else if (monster instanceof Roid) {
				getItems.add(ItemPool.getItem("전선다발", 1));
			} else if (monster instanceof NeoHuroid) {
				getItems.add(ItemPool.getItem("콘센트", 1));
			} else if (monster instanceof Saitie) {
				getItems.add(ItemPool.getItem("출입증", 1));
			} else if (monster instanceof Homunculus) {
				getItems.add(ItemPool.getItem("5월의이슬", 1));
			} else if (monster instanceof Homunscullo) {
				getItems.add(ItemPool.getItem("호문스큘러의흙", 1));
			} else if (monster instanceof Rash) {
				getItems.add(ItemPool.getItem("레쉬의털뭉치", 1));
			} else if (monster instanceof DarkRash) {
				getItems.add(ItemPool.getItem("다크레쉬의털뭉치", 1));
			} else if (monster instanceof Beetle) {
				getItems.add(ItemPool.getItem("비틀의뿔", 1));
			} else if (monster instanceof DualBeetle) {
				getItems.add(ItemPool.getItem("듀얼비틀의뿔", 1));
			} else if (monster instanceof Hankie) {
				getItems.add(ItemPool.getItem("헹키의팬플롯", 1));
			} else if (monster instanceof Harp) {
				getItems.add(ItemPool.getItem("하프의꼬리깃털", 1));
			} else if (monster instanceof BloodHarp) {
				getItems.add(ItemPool.getItem("블러드하프의머리관", 1));
			} else if (monster instanceof Kentaurus) {
				getItems.add(ItemPool.getItem("켄타우로스의불꽃", 1));
			} else if (monster instanceof BlueWyvern) {
				getItems.add(ItemPool.getItem("와이번의아가미", 1));
			} else if (monster instanceof Cornian) {
				getItems.add(ItemPool.getItem("해골어깨보호대", 1));
			} else if (monster instanceof DarkWyvern) {
				getItems.add(ItemPool.getItem("와이번의발톱", 1));
			} else if (monster instanceof MemoryMonkTrainee) {
				getItems.add(ItemPool.getItem("녹색고깔모자", 1));
			} else if (monster instanceof OblivionMonkTrainee) {
				getItems.add(ItemPool.getItem("푸른고깔모자", 1));
			} else if (monster instanceof QualmMonkTrainee) {
				getItems.add(ItemPool.getItem("붉은고깔모자", 1));
			} else if (monster instanceof ChiefMemoryGuardian) {
				getItems.add(ItemPool.getItem("녹색심장", 1));
			} else if (monster instanceof ChiefOblivionGuardian) {
				getItems.add(ItemPool.getItem("푸른심장", 1));
			} else if (monster instanceof ChiefQualmGuardian) {
				getItems.add(ItemPool.getItem("붉은심장", 1));
			}
		}
		if (isRange(percent, 0, 100)) {
			if (monster instanceof Dodo) {
				getItems.add(ItemPool.getItem("고래의투구", 1));
			} else if (monster instanceof Lilynouch) {
				getItems.add(ItemPool.getItem("나이트의가면", 1));
			} else if (monster instanceof Lyka) {
				getItems.add(ItemPool.getItem("수호수의뿔", 1));
			}
		}
		return getItems;
	}

	public static String dropItemWithLevel(Monster monster, Player player) {
		int percent = (int) (Math.random() * 1000.0D);
		int lv = monster.getStrength().getLevel();
		ArrayList<Item> getItems = dropItemWithMonster(monster, player);
		if (isRange(lv, 1, 5)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("초보모험가의빨간포션", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("초보모험가의파란포션", 1));
			}
		} else if(isRange(lv, 5, 10)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("빨간포션", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("파란포션", 1));
			}
		}  else if(isRange(lv, 10, 15)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("주황포션", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("파란포션", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("우드버클러", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("카알대검", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("로리카아머(남)", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("스퀘이머(여)", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("로리카바지(남)", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("소피아바지(여)", 1));
			}
		} else if(isRange(lv, 15, 20)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("하얀포션", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("파란포션", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("강철방패", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("샤브르", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("스틸그리브", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("풀헬름", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("코퍼럴", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("코퍼럴바지", 1));
			}
		} else if(isRange(lv, 20, 25)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("새우튀김", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("레몬", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("미스릴버클러", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("바이킹소드", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("스틸그리브", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("디펜더헬멧", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("서전트(남)", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("라멜(여)", 1));
			} else if(isRange(percent, 560, 570)) {
				getItems.add(ItemPool.getItem("서전트치마(남)", 1));
			} else if(isRange(percent, 570, 580)) {
				getItems.add(ItemPool.getItem("라멜치마(여)", 1));
			}
		} else if(isRange(lv, 25, 30)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("새우튀김", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("레몬", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("빨간삼각방패", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("삼지창", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("워부츠", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("버거넷헬름", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("마스터서전트(남)", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("샤크(여)", 1));
			} else if(isRange(percent, 560, 570)) {
				getItems.add(ItemPool.getItem("마스터서전트치마(남)", 1));
			} else if(isRange(percent, 570, 580)) {
				getItems.add(ItemPool.getItem("샤크치마(여)", 1));
			}
		}  else if(isRange(lv, 30, 35)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("장어구이", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("마나엘릭서", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("레드크로스실드", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("글라디우스", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("워부츠", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("미셀", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("주스창", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("지장의", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("홍무바지", 1));
			}
		}  else if(isRange(lv, 35, 40)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("장어구이", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("마나엘릭서", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("배틀실드", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("장팔사모", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("배틀그리브", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("브리건", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("주스창", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("지장의", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("홍무바지", 1));
			}
		} else if(isRange(lv, 40, 45)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("쭈쭈바", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("맑은물", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("타워실드", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("트라우스", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("배틀그리브", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("너클", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("노르만헬름", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("자진일갑주(남)", 1));
			} else if(isRange(percent, 560, 570)) {
				getItems.add(ItemPool.getItem("흑진월갑주(여)", 1));
			} else if(isRange(percent, 570, 580)) {
				getItems.add(ItemPool.getItem("백진일갑주바지(남)", 1));
			} else if(isRange(percent, 580, 590)) {
				getItems.add(ItemPool.getItem("황진월갑주바지(여)", 1));
			}
		} else if(isRange(lv, 45, 50)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("쭈쭈바", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("맑은물", 1));
			}  else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("타워실드", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("십자창", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("힐던부츠", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("너클", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("노르만헬름", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("자진일갑주(남)", 1));
			} else if(isRange(percent, 560, 570)) {
				getItems.add(ItemPool.getItem("흑진월갑주(여)", 1));
			} else if(isRange(percent, 570, 580)) {
				getItems.add(ItemPool.getItem("백진일갑주바지(남)", 1));
			} else if(isRange(percent, 580, 590)) {
				getItems.add(ItemPool.getItem("황진월갑주바지(여)", 1));
			}
		} else if(isRange(lv, 50, 55)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("살살녹는치즈", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("팥빙수", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("레전드실드", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("카알대검", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("힐던부츠", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("브리스트", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("돔", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("숄더메일(남)", 1));
			} else if(isRange(percent, 560, 570)) {
				getItems.add(ItemPool.getItem("숄더메일(여)", 1));
			} else if(isRange(percent, 570, 580)) {
				getItems.add(ItemPool.getItem("숄더메일바지(남)", 1));
			} else if(isRange(percent, 580, 590)) {
				getItems.add(ItemPool.getItem("숄더메일바지(여)", 1));
			}
		} else if(isRange(lv, 55, 60)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("살살녹는치즈", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("팥빙수", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("레전드실드", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("쥬얼쿠아다라", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("카젠부츠", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("브리스트", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("돔", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("숄더메일(남)", 1));
			} else if(isRange(percent, 560, 570)) {
				getItems.add(ItemPool.getItem("숄더메일(여)", 1));
			} else if(isRange(percent, 570, 580)) {
				getItems.add(ItemPool.getItem("숄더메일바지(남)", 1));
			} else if(isRange(percent, 580, 590)) {
				getItems.add(ItemPool.getItem("숄더메일바지(여)", 1));
			}
		} else if(isRange(lv, 60, 65)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("살살녹는치즈", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("팥빙수", 1));
			} else if (isRange(percent, 200, 300)) {
				getItems.add(ItemPool.getItem("엘릭서", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("에이전트실드", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("레드카타나", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("카젠부츠", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("클랜치", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("오리엔트헬멧", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("오리엔타이칸(남)", 1));
			} else if(isRange(percent, 560, 570)) {
				getItems.add(ItemPool.getItem("트란도트(여)", 1));
			} else if(isRange(percent, 570, 580)) {
				getItems.add(ItemPool.getItem("오리엔타이칸바지(남)", 1));
			} else if(isRange(percent, 580, 590)) {
				getItems.add(ItemPool.getItem("트란도트치마(여)", 1));
			}
		} else if(isRange(lv, 65, 70)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("살살녹는치즈", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("팥빙수", 1));
			} else if (isRange(percent, 200, 300)) {
				getItems.add(ItemPool.getItem("엘릭서", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("에이전트실드", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("페어프로즌", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("리버스부츠", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("클랜치", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("오리엔트헬멧", 1));
			} else if(isRange(percent, 550, 560)) {
				getItems.add(ItemPool.getItem("오리엔타이칸(남)", 1));
			} else if(isRange(percent, 560, 570)) {
				getItems.add(ItemPool.getItem("트란도트(여)", 1));
			} else if(isRange(percent, 570, 580)) {
				getItems.add(ItemPool.getItem("오리엔타이칸바지(남)", 1));
			} else if(isRange(percent, 580, 590)) {
				getItems.add(ItemPool.getItem("트란도트치마(여)", 1));
			}
		} else if(isRange(lv, 70, 75)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("살살녹는치즈", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("팥빙수", 1));
			} else if (isRange(percent, 200, 300)) {
				getItems.add(ItemPool.getItem("파워엘릭서", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("아퀼라실드", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("프라우테", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("리버스부츠", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("허스크", 1));
			} else if(isRange(percent, 540, 550)) {
				getItems.add(ItemPool.getItem("플라티나", 1));
			} else if(isRange(percent, 570, 580)) {
				getItems.add(ItemPool.getItem("플라티나바지(남)", 1));
			} else if(isRange(percent, 580, 590)) {
				getItems.add(ItemPool.getItem("플라티나바지(여)", 1));
			}
		} else if(isRange(lv, 75, 80)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("살살녹는치즈", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("팥빙수", 1));
			} else if (isRange(percent, 200, 300)) {
				getItems.add(ItemPool.getItem("파워엘릭서", 1));
			} else if(isRange(percent, 500, 510)) {
				getItems.add(ItemPool.getItem("아퀼라실드", 1));
			} else if(isRange(percent, 510, 520)) {
				getItems.add(ItemPool.getItem("피나카", 1));
			} else if(isRange(percent, 520, 530)) {
				getItems.add(ItemPool.getItem("허스크", 1));
			} else if(isRange(percent, 530, 540)) {
				getItems.add(ItemPool.getItem("플라티나", 1));
			} else if(isRange(percent, 570, 580)) {
				getItems.add(ItemPool.getItem("플라티나바지(남)", 1));
			} else if(isRange(percent, 580, 590)) {
				getItems.add(ItemPool.getItem("플라티나바지(여)", 1));
			}
		} else if(isRange(lv, 80, 85)) {
			if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("엘릭서", 1));
			} else if (isRange(percent, 200, 300)) {
				getItems.add(ItemPool.getItem("파워엘릭서", 1));
			}
		} else if(isRange(lv, 85, 90)) {
			if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("엘릭서", 1));
			} else if (isRange(percent, 200, 300)) {
				getItems.add(ItemPool.getItem("파워엘릭서", 1));
			}
		}
		StringBuffer getItemInfor = new StringBuffer();
		for (int i = 0; i < getItems.size(); i++) {
			player.addItem((Item) getItems.get(i));
			getItemInfor.append(((Item) getItems.get(i)).toGetInfor() + " ");
		}
		return getItemInfor.toString();
	}
}

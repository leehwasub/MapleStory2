package map;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import maplestory.Main;
import maplestory.MainMapleInterface;
import maplestory.Player;
import utils.FileLoader;
import utils.ResourceLoader;

public class MapleMapList {
	private ArrayList<MapleMap> maps = new ArrayList<MapleMap>();
	
	private static final Image PORTAL_IMAGE = ResourceLoader.getImage("componentImage", "portalImage.png");
	private static final Image GUARD_IMAGE = ResourceLoader.getImage("componentImage", "guardImage.png");
	private static final Image STORE_IMAGE = ResourceLoader.getImage("componentImage", "storeImage.png");
	private static final Image HEAL_IMAGE = ResourceLoader.getImage("componentImage", "healImage.png");
	private static MapleMapList instance;
	

	private MapleMapList() {
		initMap();
	}
	
	public static MapleMapList getInstance() {
		if(instance == null) {
			instance = new MapleMapList();
		}
		return instance;
	}
	
	public void reload() {
		initMap();
	}

	private void initMap() {
		maps.clear();
		ArrayList<String> mapNameList = null;
		try {
			mapNameList = FileLoader.getFileList("mapText");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			for (int i = 0; i < mapNameList.size(); i++) {
				InputStream in = new FileLoader().getFileStream("mapText", (String) mapNameList.get(i));
				BufferedReader bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));

				int lineNum = 0;
				MapleMap mapleMap = new MapleMap();
				String line;
				while ((line = bf.readLine()) != null) {
					String[] property = line.split(" ");
					if (lineNum == 0) {
						mapleMap.setMaxX(Integer.parseInt(property[0]));
						mapleMap.setMaxY(Integer.parseInt(property[1]));
						mapleMap.setIsland(property[2]);
						mapleMap.setName(property[3]);
						mapleMap.setBackground(property[4]);
						mapleMap.setMusic(property[5]);
						mapleMap.setMapType(Integer.parseInt(property[6]));
						mapleMap.setWarpMapName(property[7]);
						mapleMap.initMap(Integer.parseInt(property[0]), Integer.parseInt(property[1]));
						if(property.length == 9) {
							mapleMap.setTileMapName(property[8]);
							mapleMap.setTileMap(TileMapList.makeRandomTileNumbers(property[8], mapleMap.getMaxX(), mapleMap.getMaxY()));
						}
					} else {
						mapleMap.setMap(Integer.parseInt(property[0]), Integer.parseInt(property[1]),
								Integer.parseInt(property[2]));
					}
					lineNum++;
				}
				maps.add(mapleMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		makeEdge();
	}
	
	private void removeGuard() {
		for(int i = 0; i < maps.size(); i++) {
			maps.get(i).removeGuard();
		}
	}
	
	public void makeGuard(Player player, MainMapleInterface mainMapleInterface) {
		removeGuard();
		for(int i = 0; i < maps.size(); i++) {
			maps.get(i).makeGuard(player, mainMapleInterface);
		}
	}

	private void updateMap(UpdatedMapInfor infor) {
		PointMapName p = infor.getPointMapName();
		getMap(p.getMapName()).setMap(p.getX(), p.getY(), infor.getAfterState());
	}
	
	public void loadMap(Player player) {
		ArrayList<UpdatedMapInfor> updatedMapInforList = player.getUpdatedMapList();
		for(int i = 0; i < updatedMapInforList.size(); i++) {
			updateMap(updatedMapInforList.get(i));
		}
	}

	private void makeEdge() {
		//메이플 아일랜드
		getMap("초보자의숲1").addPortal(new Portal(new PointMapName(4, 9, "초보자의숲1"), new PointMapName(4, 0, "초보자의숲2")));
		getMap("초보자의숲2").addPortal(new Portal(new PointMapName(4, 0, "초보자의숲2"), new PointMapName(4, 9, "초보자의숲1")));
		getMap("초보자의숲2").addPortal(new Portal(new PointMapName(6, 14, "초보자의숲2"), new PointMapName(4, 0, "암허스트")));
		getMap("암허스트").addPortal(new Portal(new PointMapName(4, 0, "암허스트"), new PointMapName(6, 14, "초보자의숲2")));
		getMap("암허스트").addPortal(new Portal(new PointMapName(7, 16, "암허스트"), new PointMapName(7, 0, "달팽이의숲")));
		getMap("달팽이의숲").addPortal(new Portal(new PointMapName(7, 0, "달팽이의숲"), new PointMapName(7, 16, "암허스트")));
		getMap("달팽이의숲").addPortal(new Portal(new PointMapName(14, 6, "달팽이의숲"), new PointMapName(0, 0, "위험한숲")));
		getMap("달팽이의숲").addPortal(new Portal(new PointMapName(5, 14, "달팽이의숲"), new PointMapName(2, 0, "사우스페리")));
		getMap("사우스페리").addPortal(new Portal(new PointMapName(2, 0, "사우스페리"), new PointMapName(5, 14, "달팽이의숲")));
		getMap("사우스페리").addPortal(new Portal(new PointMapName(2, 15, "사우스페리"), new PointMapName(2, 1, "메이플->빅토리아")));
		//빅토리아 아일랜드
		getMap("리스항구").addPortal(new Portal(new PointMapName(14, 14, "리스항구"), new PointMapName(3, 0, "리스항구외각")));
		getMap("리스항구외각").addPortal(new Portal(new PointMapName(3, 0, "리스항구외각"), new PointMapName(14, 14, "리스항구")));
		getMap("리스항구외각").addPortal(new Portal(new PointMapName(5, 19, "리스항구외각"), new PointMapName(4, 0, "해안가풀숲")));
		getMap("해안가풀숲").addPortal(new Portal(new PointMapName(4, 0, "해안가풀숲"), new PointMapName(5, 19, "리스항구외각")));
		getMap("해안가풀숲").addPortal(new Portal(new PointMapName(9, 13, "해안가풀숲"), new PointMapName(0, 8, "버섯동산")));
		getMap("버섯동산").addPortal(new Portal(new PointMapName(0, 8, "버섯동산"), new PointMapName(9, 13, "해안가풀숲")));
		getMap("해안가풀숲").addPortal(new Portal(new PointMapName(4, 26, "해안가풀숲"), new PointMapName(8, 0, "페리온서쪽길목")));
		getMap("페리온서쪽길목").addPortal(new Portal(new PointMapName(8, 0, "페리온서쪽길목"), new PointMapName(4, 26, "해안가풀숲")));
		getMap("페리온서쪽길목").addPortal(new Portal(new PointMapName(15, 19, "페리온서쪽길목"), new PointMapName(10, 0, "페리온")));
		getMap("페리온").addPortal(new Portal(new PointMapName(10, 0, "페리온"), new PointMapName(15, 19, "페리온서쪽길목")));
		getMap("페리온").addPortal(new Portal(new PointMapName(2, 19, "페리온"), new PointMapName(8, 0, "페리온동쪽길목")));
		getMap("페리온동쪽길목").addPortal(new Portal(new PointMapName(8, 0, "페리온동쪽길목"), new PointMapName(2, 19, "페리온")));
		getMap("페리온동쪽길목").addPortal(new Portal(new PointMapName(14, 19, "페리온동쪽길목"), new PointMapName(17, 0, "와일드보어의땅1")));
		getMap("와일드보어의땅1").addPortal(new Portal(new PointMapName(17, 0, "와일드보어의땅1"), new PointMapName(14, 19, "페리온동쪽길목")));
		getMap("와일드보어의땅1").addPortal(new Portal(new PointMapName(11, 34, "와일드보어의땅1"), new PointMapName(17, 0, "와일드보어의땅2")));
		getMap("와일드보어의땅2").addPortal(new Portal(new PointMapName(17, 0, "와일드보어의땅2"), new PointMapName(11, 34, "와일드보어의땅1")));
		getMap("페리온").addPortal(new Portal(new PointMapName(17, 19, "페리온"), new PointMapName(0, 9, "유적발굴지")));
		getMap("유적발굴지").addPortal(new Portal(new PointMapName(0, 9, "유적발굴지"), new PointMapName(17, 19, "페리온")));
		getMap("유적발굴지").addPortal(new Portal(new PointMapName(9, 22, "유적발굴지"), new PointMapName(0, 4, "유적발굴캠프장")));
		getMap("유적발굴캠프장").addPortal(new Portal(new PointMapName(0, 4, "유적발굴캠프장"), new PointMapName(9, 22, "유적발굴지")));
		getMap("유적발굴캠프장").addPortal(new Portal(new PointMapName(14, 4, "유적발굴캠프장"), new PointMapName(0, 4, "발굴중단지역")));
		getMap("발굴중단지역").addPortal(new Portal(new PointMapName(0, 4, "발굴중단지역"), new PointMapName(14, 4, "유적발굴캠프장")));
		getMap("발굴중단지역").addPortal(new Portal(new PointMapName(24, 8, "발굴중단지역"), new PointMapName(17, 1, "폐쇄구역")));
		getMap("폐쇄구역").addPortal(new Portal(new PointMapName(17, 1, "폐쇄구역"), new PointMapName(24, 8, "발굴중단지역")));
		getMap("폐쇄구역").addPortal(new Portal(new PointMapName(10, 12, "폐쇄구역"), new PointMapName(14, 0, "군영")));
		getMap("군영").addPortal(new Portal(new PointMapName(14, 0, "군영"), new PointMapName(10, 12, "폐쇄구역")));
		getMap("폐쇄구역").addPortal(new Portal(new PointMapName(10, 12, "폐쇄구역"), new PointMapName(14, 0, "군영")));
		getMap("폐쇄구역").addPortal(new Portal(new PointMapName(0, 24, "폐쇄구역"), new PointMapName(7, 0, "샤레니안왕성1")));
		getMap("샤레니안왕성1").addPortal(new Portal(new PointMapName(4, 34, "샤레니안왕성1"), new PointMapName(6, 0, "샤레니안왕성2")));
		getMap("샤레니안왕성2").addPortal(new Portal(new PointMapName(0, 30, "샤레니안왕성2"), new PointMapName(0, 0, "에레고스왕좌")));
		getMap("리스항구").addPortal(new Portal(new PointMapName(0, 0, "리스항구"), new PointMapName(3, 12, "빅토리아->엘나스산맥승강장")));
		getMap("빅토리아->엘나스산맥승강장").addPortal(new Portal(new PointMapName(3, 12, "빅토리아->엘나스산맥승강장"), new PointMapName(0, 0, "리스항구")));
		getMap("빅토리아->엘나스산맥승강장").addPortal(new Portal(new PointMapName(3, 0, "빅토리아->엘나스산맥승강장"), new PointMapName(1, 1, "빅토리아->엘나스산맥")));
		//오시리아 대륙
		getMap("오르비스").addPortal(new Portal(new PointMapName(2, 0, "오르비스"), new PointMapName(12, 0, "구름공원1")));
		getMap("구름공원1").addPortal(new Portal(new PointMapName(12, 0, "구름공원1"), new PointMapName(2, 0, "오르비스")));
		getMap("구름공원1").addPortal(new Portal(new PointMapName(10, 39, "구름공원1"), new PointMapName(12, 0, "구름공원2")));
		getMap("구름공원2").addPortal(new Portal(new PointMapName(12, 0, "구름공원2"), new PointMapName(10, 39, "구름공원1")));
		getMap("구름공원2").addPortal(new Portal(new PointMapName(10, 39, "구름공원2"), new PointMapName(11, 0, "하늘계단1")));
		getMap("하늘계단1").addPortal(new Portal(new PointMapName(11, 0, "하늘계단1"), new PointMapName(10, 39, "구름공원2")));
		getMap("하늘계단1").addPortal(new Portal(new PointMapName(9, 39, "하늘계단1"), new PointMapName(5, 0, "하늘계단2")));
		getMap("하늘계단2").addPortal(new Portal(new PointMapName(5, 0, "하늘계단2"), new PointMapName(9, 39, "하늘계단1")));
		getMap("하늘계단2").addPortal(new Portal(new PointMapName(8, 39, "하늘계단2"), new PointMapName(0, 0, "어둠의공원")));
		getMap("오르비스").addPortal(new Portal(new PointMapName(21, 24, "오르비스"), new PointMapName(0, 5, "오르비스탑상층")));
		getMap("오르비스탑상층").addPortal(new Portal(new PointMapName(0, 5, "오르비스탑상층"), new PointMapName(21, 24, "오르비스")));
		getMap("오르비스탑상층").addPortal(new Portal(new PointMapName(55, 5, "오르비스탑상층"), new PointMapName(0, 5, "오르비스탑하층")));
		getMap("오르비스탑하층").addPortal(new Portal(new PointMapName(0, 5, "오르비스탑하층"), new PointMapName(55, 5, "오르비스탑상층")));
		getMap("오르비스탑하층").addPortal(new Portal(new PointMapName(55, 5, "오르비스탑하층"), new PointMapName(10, 0, "얼음벌판")));
		getMap("얼음벌판").addPortal(new Portal(new PointMapName(10, 0, "얼음벌판"), new PointMapName(55, 5, "오르비스탑하층")));
		getMap("얼음벌판").addPortal(new Portal(new PointMapName(4, 34, "얼음벌판"), new PointMapName(6, 0, "엘나스")));
		getMap("엘나스").addPortal(new Portal(new PointMapName(6, 0, "엘나스"), new PointMapName(4, 34, "얼음벌판")));
		getMap("엘나스").addPortal(new Portal(new PointMapName(4, 29, "엘나스"), new PointMapName(9, 0, "빙판길")));
		getMap("빙판길").addPortal(new Portal(new PointMapName(9, 0, "빙판길"), new PointMapName(4, 29, "엘나스")));
		getMap("빙판길").addPortal(new Portal(new PointMapName(4, 34, "빙판길"), new PointMapName(44, 1, "위험한골짜기1")));
		getMap("위험한골짜기1").addPortal(new Portal(new PointMapName(44, 1, "위험한골짜기1"), new PointMapName(4, 34, "빙판길")));
		getMap("위험한골짜기1").addPortal(new Portal(new PointMapName(0, 4, "위험한골짜기1"), new PointMapName(44, 8, "위험한골짜기2")));
		getMap("위험한골짜기2").addPortal(new Portal(new PointMapName(44, 8, "위험한골짜기2"), new PointMapName(0, 4, "위험한골짜기1")));
		getMap("위험한골짜기2").addPortal(new Portal(new PointMapName(0, 3, "위험한골짜기2"), new PointMapName(44, 9, "늑대의영역")));
		getMap("늑대의영역").addPortal(new Portal(new PointMapName(44, 9, "늑대의영역"), new PointMapName(0, 3, "위험한골짜기2")));
		getMap("늑대의영역").addPortal(new Portal(new PointMapName(0, 4, "늑대의영역"), new PointMapName(6, 0, "시련의동굴")));
		getMap("시련의동굴").addPortal(new Portal(new PointMapName(6, 0, "시련의동굴"), new PointMapName(0, 4, "늑대의영역")));
		getMap("시련의동굴").addPortal(new Portal(new PointMapName(24, 39, "시련의동굴"), new PointMapName(3, 0, "자쿰의제단입구")));
		getMap("자쿰의제단입구").addPortal(new Portal(new PointMapName(3, 0, "자쿰의제단입구"), new PointMapName(24, 39, "시련의동굴")));
		getMap("자쿰의제단입구").addPortal(new Portal(new PointMapName(3, 13, "자쿰의제단입구"), new PointMapName(0, 0, "자쿰의제단")));
		getMap("오르비스").addPortal(new Portal(new PointMapName(0, 17, "오르비스"), new PointMapName(5, 21, "오르비스승강장")));
		getMap("오르비스승강장").addPortal(new Portal(new PointMapName(5, 21, "오르비스승강장"), new PointMapName(0, 17, "오르비스")));
		getMap("오르비스승강장").addPortal(new Portal(new PointMapName(3, 0, "오르비스승강장"), new PointMapName(4, 18, "엘나스산맥->빅토리아승강장")));
		getMap("엘나스산맥->빅토리아승강장").addPortal(new Portal(new PointMapName(4, 18, "엘나스산맥->빅토리아승강장"), new PointMapName(3, 0, "오르비스승강장")));
		getMap("엘나스산맥->빅토리아승강장").addPortal(new Portal(new PointMapName(4, 0, "엘나스산맥->빅토리아승강장"), new PointMapName(1, 1, "엘나스산맥->빅토리아")));
		getMap("오르비스승강장").addPortal(new Portal(new PointMapName(7, 0, "오르비스승강장"), new PointMapName(4, 18, "엘나스산맥->니할사막승강장")));
		getMap("엘나스산맥->니할사막승강장").addPortal(new Portal(new PointMapName(4, 18, "엘나스산맥->니할사막승강장"), new PointMapName(7, 0, "오르비스승강장")));
		getMap("엘나스산맥->니할사막승강장").addPortal(new Portal(new PointMapName(4, 0, "엘나스산맥->니할사막승강장"), new PointMapName(1, 1, "엘나스산맥->니할사막")));
		//니할사막
		getMap("아리안트").addPortal(new Portal(new PointMapName(7, 0, "아리안트"), new PointMapName(17, 44, "선인장사막")));
		getMap("선인장사막").addPortal(new Portal(new PointMapName(17, 44, "선인장사막"), new PointMapName(7, 0, "아리안트")));
		getMap("선인장사막").addPortal(new Portal(new PointMapName(44, 20, "선인장사막"), new PointMapName(16, 0, "작열하는사막")));
		getMap("선인장사막").addPortal(new Portal(new PointMapName(0, 20, "선인장사막"), new PointMapName(0, 0, "선인장사막북쪽")));
		getMap("작열하는사막").addPortal(new Portal(new PointMapName(16, 0, "작열하는사막"), new PointMapName(44, 20, "선인장사막")));
		getMap("작열하는사막").addPortal(new Portal(new PointMapName(16, 44, "작열하는사막"), new PointMapName(44, 22, "마른사막")));
		getMap("마른사막").addPortal(new Portal(new PointMapName(44, 22, "마른사막"), new PointMapName(16, 44, "작열하는사막")));
		getMap("마른사막").addPortal(new Portal(new PointMapName(16, 0, "마른사막"), new PointMapName(7, 39, "아리안트")));
		getMap("아리안트").addPortal(new Portal(new PointMapName(7, 39, "아리안트"), new PointMapName(16, 0, "마른사막")));
		getMap("아리안트").addPortal(new Portal(new PointMapName(0, 19, "아리안트"), new PointMapName(24, 0, "북쪽사막길1")));
		getMap("북쪽사막길1").addPortal(new Portal(new PointMapName(24, 0, "북쪽사막길1"), new PointMapName(0, 19, "아리안트")));
		getMap("북쪽사막길1").addPortal(new Portal(new PointMapName(18, 69, "북쪽사막길1"), new PointMapName(16, 0, "북쪽사막길2")));
		getMap("북쪽사막길2").addPortal(new Portal(new PointMapName(16, 0, "북쪽사막길2"), new PointMapName(18, 69, "북쪽사막길1")));
		getMap("북쪽사막길2").addPortal(new Portal(new PointMapName(25, 69, "북쪽사막길2"), new PointMapName(13, 0, "사헬지대")));
		getMap("사헬지대").addPortal(new Portal(new PointMapName(13, 0, "사헬지대"), new PointMapName(25, 69, "북쪽사막길2")));
		getMap("아리안트").addPortal(new Portal(new PointMapName(14, 22, "아리안트"), new PointMapName(5, 0, "아리안트마을")));
		getMap("아리안트마을").addPortal(new Portal(new PointMapName(5, 0, "아리안트마을"), new PointMapName(14, 22, "아리안트")));
		getMap("아리안트마을").addPortal(new Portal(new PointMapName(0, 9, "아리안트마을"), new PointMapName(3, 3, "빈집1")));
		getMap("빈집1").addPortal(new Portal(new PointMapName(3, 3, "빈집1"), new PointMapName(0, 9, "아리안트마을")));
		getMap("아리안트마을").addPortal(new Portal(new PointMapName(0, 17, "아리안트마을"), new PointMapName(3, 3, "빈집2")));
		getMap("빈집2").addPortal(new Portal(new PointMapName(3, 3, "빈집2"), new PointMapName(0, 17, "아리안트마을")));
		getMap("아리안트마을").addPortal(new Portal(new PointMapName(0, 25, "아리안트마을"), new PointMapName(3, 3, "빈집3")));
		getMap("빈집3").addPortal(new Portal(new PointMapName(3, 3, "빈집3"), new PointMapName(0, 25, "아리안트마을")));
		getMap("아리안트마을").addPortal(new Portal(new PointMapName(9, 9, "아리안트마을"), new PointMapName(0, 0, "빈집4")));
		getMap("빈집4").addPortal(new Portal(new PointMapName(0, 0, "빈집4"), new PointMapName(9, 9, "아리안트마을")));
		getMap("아리안트마을").addPortal(new Portal(new PointMapName(9, 17, "아리안트마을"), new PointMapName(0, 0, "빈집5")));
		getMap("빈집5").addPortal(new Portal(new PointMapName(0, 0, "빈집5"), new PointMapName(9, 17, "아리안트마을")));
		getMap("아리안트마을").addPortal(new Portal(new PointMapName(9, 25, "아리안트마을"), new PointMapName(0, 0, "빈집6")));
		getMap("빈집6").addPortal(new Portal(new PointMapName(0, 0, "빈집6"), new PointMapName(9, 25, "아리안트마을")));
		getMap("아리안트").addPortal(new Portal(new PointMapName(0, 32, "아리안트"), new PointMapName(6, 3, "아리안트궁전입구")));
		getMap("아리안트궁전입구").addPortal(new Portal(new PointMapName(6, 3, "아리안트궁전입구"), new PointMapName(0, 32, "아리안트")));
		getMap("아리안트궁전입구").addPortal(new Portal(new PointMapName(0, 3, "아리안트궁전입구"), new PointMapName(3, 0, "아리안트궁전복도")));
		getMap("아리안트궁전복도").addPortal(new Portal(new PointMapName(3, 0, "아리안트궁전복도"), new PointMapName(0, 3, "아리안트궁전입구")));
		getMap("아리안트궁전복도").addPortal(new Portal(new PointMapName(3, 20, "아리안트궁전복도"), new PointMapName(3, 0, "아리안트궁전")));
		getMap("아리안트궁전").addPortal(new Portal(new PointMapName(3, 0, "아리안트궁전"), new PointMapName(3, 20, "아리안트궁전복도")));
		getMap("아리안트궁전복도").addPortal(new Portal(new PointMapName(5, 18, "아리안트궁전복도"), new PointMapName(0, 0, "아리안트궁전지하1층")));
		getMap("아리안트궁전지하1층").addPortal(new Portal(new PointMapName(0, 0, "아리안트궁전지하1층"), new PointMapName(5, 18, "아리안트궁전복도")));
		getMap("아리안트궁전지하1층").addPortal(new Portal(new PointMapName(29, 11, "아리안트궁전지하1층"), new PointMapName(0, 5, "아리안트궁전지하2층")));
		getMap("아리안트궁전지하2층").addPortal(new Portal(new PointMapName(0, 5, "아리안트궁전지하2층"), new PointMapName(29, 11, "아리안트궁전지하1층")));
		getMap("사헬지대").addPortal(new Portal(new PointMapName(12, 49, "사헬지대"), new PointMapName(9, 0, "마가티아")));
		getMap("마가티아").addPortal(new Portal(new PointMapName(9, 0, "마가티아"), new PointMapName(12, 49, "사헬지대")));
		getMap("마가티아").addPortal(new Portal(new PointMapName(0, 10, "마가티아"), new PointMapName(4, 9, "제뉴미스트연구소")));
		getMap("제뉴미스트연구소").addPortal(new Portal(new PointMapName(4, 9, "제뉴미스트연구소"), new PointMapName(0, 10, "마가티아")));
		getMap("제뉴미스트연구소").addPortal(new Portal(new PointMapName(0, 0, "제뉴미스트연구소"), new PointMapName(0, 10, "연구소1층복도")));
		getMap("연구소1층복도").addPortal(new Portal(new PointMapName(0, 10, "연구소1층복도"), new PointMapName(0, 0, "제뉴미스트연구소")));
		getMap("연구소1층복도").addPortal(new Portal(new PointMapName(0, 3, "연구소1층복도"), new PointMapName(1, 19, "연구소101호")));
		getMap("연구소101호").addPortal(new Portal(new PointMapName(1, 19, "연구소101호"), new PointMapName(0, 3, "연구소1층복도")));
		getMap("연구소1층복도").addPortal(new Portal(new PointMapName(0, 17, "연구소1층복도"), new PointMapName(1, 0, "연구소102호")));
		getMap("연구소102호").addPortal(new Portal(new PointMapName(1, 0, "연구소102호"), new PointMapName(0, 17, "연구소1층복도")));
		getMap("연구소102호").addPortal(new Portal(new PointMapName(4, 29, "연구소102호"), new PointMapName(0, 0, "연구소102호돌연변이")));
		getMap("연구소1층복도").addPortal(new Portal(new PointMapName(4, 10, "연구소1층복도"), new PointMapName(0, 10, "연구소2층복도")));
		getMap("연구소2층복도").addPortal(new Portal(new PointMapName(0, 10, "연구소2층복도"), new PointMapName(4, 10, "연구소1층복도")));
		getMap("연구소2층복도").addPortal(new Portal(new PointMapName(0, 3, "연구소2층복도"), new PointMapName(3, 19, "연구소201호")));
		getMap("연구소201호").addPortal(new Portal(new PointMapName(3, 19, "연구소201호"), new PointMapName(0, 3, "연구소2층복도")));
		getMap("연구소2층복도").addPortal(new Portal(new PointMapName(0, 17, "연구소2층복도"), new PointMapName(3, 0, "연구소202호")));
		getMap("연구소202호").addPortal(new Portal(new PointMapName(3, 0, "연구소202호"), new PointMapName(0, 17, "연구소2층복도")));
		getMap("마가티아").addPortal(new Portal(new PointMapName(19, 22, "마가티아"), new PointMapName(4, 0, "알카드노연구소")));
		getMap("알카드노연구소").addPortal(new Portal(new PointMapName(4, 0, "알카드노연구소"), new PointMapName(19, 22, "마가티아")));
		getMap("알카드노연구소").addPortal(new Portal(new PointMapName(0, 9, "알카드노연구소"), new PointMapName(0, 4, "연구소중앙게이트")));
		getMap("연구소중앙게이트").addPortal(new Portal(new PointMapName(0, 4, "연구소중앙게이트"), new PointMapName(0, 9, "알카드노연구소")));
		getMap("연구소중앙게이트").addPortal(new Portal(new PointMapName(4, 8, "연구소중앙게이트"), new PointMapName(4, 0, "A-1구역")));
		getMap("A-1구역").addPortal(new Portal(new PointMapName(4, 0, "A-1구역"), new PointMapName(4, 8, "연구소중앙게이트")));
		getMap("A-1구역").addPortal(new Portal(new PointMapName(8, 10, "A-1구역"), new PointMapName(0, 4, "A-2구역")));
		getMap("A-2구역").addPortal(new Portal(new PointMapName(0, 4, "A-2구역"), new PointMapName(8, 10, "A-1구역")));
		getMap("A-1구역").addPortal(new Portal(new PointMapName(4, 19, "A-1구역"), new PointMapName(4, 0, "B-1구역")));
		getMap("B-1구역").addPortal(new Portal(new PointMapName(4, 0, "B-1구역"), new PointMapName(4, 19, "A-1구역")));
		getMap("B-1구역").addPortal(new Portal(new PointMapName(8, 12, "B-1구역"), new PointMapName(0, 4, "B-2구역")));
		getMap("B-2구역").addPortal(new Portal(new PointMapName(0, 4, "B-2구역"), new PointMapName(8, 12, "B-1구역")));
		getMap("B-1구역").addPortal(new Portal(new PointMapName(4, 24, "B-1구역"), new PointMapName(4, 0, "C-1구역")));
		getMap("C-1구역").addPortal(new Portal(new PointMapName(4, 0, "C-1구역"), new PointMapName(4, 24, "B-1구역")));
		getMap("C-1구역").addPortal(new Portal(new PointMapName(8, 15, "C-1구역"), new PointMapName(0, 4, "C-2구역")));
		getMap("C-2구역").addPortal(new Portal(new PointMapName(0, 4, "C-2구역"), new PointMapName(8, 15, "C-1구역")));
		getMap("C-2구역").addPortal(new Portal(new PointMapName(0, 4, "C-2구역"), new PointMapName(8, 15, "C-1구역")));
		getMap("C-1구역").addPortal(new Portal(new PointMapName(4, 29, "C-1구역"), new PointMapName(3, 0, "비밀연구소1구역")));
		getMap("비밀연구소1구역").addPortal(new Portal(new PointMapName(3, 34, "비밀연구소1구역"), new PointMapName(3, 0, "비밀연구소2구역")));
		getMap("비밀연구소2구역").addPortal(new Portal(new PointMapName(3, 34, "비밀연구소2구역"), new PointMapName(3, 1, "비밀연구소3구역")));
		getMap("비밀연구소3구역").addPortal(new Portal(new PointMapName(3, 7, "비밀연구소3구역"), new PointMapName(0, 0, "비밀연구소위험지역")));
		getMap("비밀연구소3구역").addPortal(new Portal(new PointMapName(3, 14, "비밀연구소3구역"), new PointMapName(4, 29, "C-1구역")));
		getMap("아리안트").addPortal(new Portal(new PointMapName(0, 8, "아리안트"), new PointMapName(4, 15, "아리안트승강장")));
		getMap("아리안트승강장").addPortal(new Portal(new PointMapName(4, 15, "아리안트승강장"), new PointMapName(0, 8, "아리안트")));
		getMap("아리안트승강장").addPortal(new Portal(new PointMapName(2, 0, "아리안트승강장"), new PointMapName(3, 15, "니할사막->엘나스산맥승강장")));
		getMap("니할사막->엘나스산맥승강장").addPortal(new Portal(new PointMapName(3, 15, "니할사막->엘나스산맥승강장"), new PointMapName(2, 0, "아리안트승강장")));
		getMap("니할사막->엘나스산맥승강장").addPortal(new Portal(new PointMapName(3, 0, "니할사막->엘나스산맥승강장"), new PointMapName(1, 1, "니할사막->엘나스산맥")));
		getMap("아리안트승강장").addPortal(new Portal(new PointMapName(6, 0, "아리안트승강장"), new PointMapName(3, 15, "니할사막->미나르숲승강장")));
		getMap("니할사막->미나르숲승강장").addPortal(new Portal(new PointMapName(3, 15, "니할사막->미나르숲승강장"), new PointMapName(6, 0, "아리안트승강장")));
		getMap("니할사막->미나르숲승강장").addPortal(new Portal(new PointMapName(3, 0, "니할사막->미나르숲승강장"), new PointMapName(1, 1, "니할사막->미나르숲")));
		//리프레숲
		getMap("리프레").addPortal(new Portal(new PointMapName(7, 0, "리프레"), new PointMapName(9, 34, "리프레서쪽숲")));
		getMap("리프레서쪽숲").addPortal(new Portal(new PointMapName(9, 34, "리프레서쪽숲"), new PointMapName(7, 0, "리프레")));
		getMap("리프레").addPortal(new Portal(new PointMapName(7, 29, "리프레"), new PointMapName(7, 0, "리프레동쪽숲")));
		getMap("리프레동쪽숲").addPortal(new Portal(new PointMapName(7, 0, "리프레동쪽숲"), new PointMapName(7, 29, "리프레")));
		getMap("리프레서쪽숲").addPortal(new Portal(new PointMapName(24, 13, "리프레서쪽숲"), new PointMapName(0, 8, "심술쟁이의숲")));
		getMap("심술쟁이의숲").addPortal(new Portal(new PointMapName(0, 8, "심술쟁이의숲"), new PointMapName(24, 13, "리프레서쪽숲")));
		getMap("리프레동쪽숲").addPortal(new Portal(new PointMapName(24, 21, "리프레동쪽숲"), new PointMapName(0, 10, "하늘둥지")));
		getMap("하늘둥지").addPortal(new Portal(new PointMapName(0, 10, "하늘둥지"), new PointMapName(24, 21, "리프레동쪽숲")));
		getMap("켄타우로스의영역").addPortal(new Portal(new PointMapName(16, 0, "켄타우로스의영역"), new PointMapName(15, 19, "심술쟁이의숲")));
		getMap("심술쟁이의숲").addPortal(new Portal(new PointMapName(15, 19, "심술쟁이의숲"), new PointMapName(16, 0, "켄타우로스의영역")));
		getMap("켄타우로스의영역").addPortal(new Portal(new PointMapName(16, 34, "켄타우로스의영역"), new PointMapName(14, 0, "하늘둥지")));
		getMap("하늘둥지").addPortal(new Portal(new PointMapName(14, 0, "하늘둥지"), new PointMapName(16, 34, "켄타우로스의영역")));
		getMap("심술쟁이의숲").addPortal(new Portal(new PointMapName(29, 10, "심술쟁이의숲"), new PointMapName(0, 4, "가파른언덕")));
		getMap("가파른언덕").addPortal(new Portal(new PointMapName(0, 4, "가파른언덕"), new PointMapName(29, 10, "심술쟁이의숲")));
		getMap("하늘둥지").addPortal(new Portal(new PointMapName(29, 9, "하늘둥지"), new PointMapName(0, 9, "가파른언덕")));
		getMap("가파른언덕").addPortal(new Portal(new PointMapName(0, 9, "가파른언덕"), new PointMapName(29, 9, "하늘둥지")));
		getMap("가파른언덕").addPortal(new Portal(new PointMapName(30, 0, "가파른언덕"), new PointMapName(6, 36, "용의숲입구")));
		getMap("용의숲입구").addPortal(new Portal(new PointMapName(6, 36, "용의숲입구"), new PointMapName(30, 0, "가파른언덕")));
		getMap("용의숲입구").addPortal(new Portal(new PointMapName(6, 0, "용의숲입구"), new PointMapName(8, 44, "용의숲1")));
		getMap("용의숲1").addPortal(new Portal(new PointMapName(8, 44, "용의숲1"), new PointMapName(6, 0, "용의숲입구")));
		getMap("용의숲1").addPortal(new Portal(new PointMapName(6, 0, "용의숲1"), new PointMapName(8, 44, "용의숲2")));
		getMap("용의숲2").addPortal(new Portal(new PointMapName(8, 44, "용의숲2"), new PointMapName(6, 0, "용의숲1")));
		getMap("용의숲2").addPortal(new Portal(new PointMapName(5, 0, "용의숲2"), new PointMapName(46, 12, "용의협곡")));
		getMap("용의협곡").addPortal(new Portal(new PointMapName(46, 12, "용의협곡"), new PointMapName(5, 0, "용의숲2")));
		getMap("용의협곡").addPortal(new Portal(new PointMapName(0, 11, "용의협곡"), new PointMapName(44, 37, "용의둥지")));
		getMap("용의둥지").addPortal(new Portal(new PointMapName(44, 37, "용의둥지"), new PointMapName(0, 11, "용의협곡")));
		getMap("용의둥지").addPortal(new Portal(new PointMapName(0, 5, "용의둥지"), new PointMapName(5, 20, "혼테일동굴입구")));
		getMap("혼테일동굴입구").addPortal(new Portal(new PointMapName(5, 20, "혼테일동굴입구"), new PointMapName(0, 5, "용의둥지")));
		getMap("혼테일동굴입구").addPortal(new Portal(new PointMapName(5, 0, "혼테일동굴입구"), new PointMapName(0, 0, "혼테일동굴")));
		//시간의신전
	}
	
	
	public static Image getPortalImage() {
		return PORTAL_IMAGE;
	}
	
	public static Image getGuardImage() {
		return GUARD_IMAGE;
	}

	public static Image getStoreImage() {
		return STORE_IMAGE;
	}
	
	public static Image getHealImage() {
		return HEAL_IMAGE;
	}

	public MapleMap getMap(String mapName) {
		for (int i = 0; i < maps.size(); i++) {
			if (((MapleMap) maps.get(i)).getName().equals(mapName)) {
				return (MapleMap) maps.get(i);
			}
		}
		return null;
	}
	
	
}

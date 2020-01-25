package map;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import maplestory.Player;
import utils.FileLoader;

public class MapleMapList {
	private ArrayList<MapleMap> maps = new ArrayList<MapleMap>();
	
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
		//리프레숲
		
		
		//시간의신전
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

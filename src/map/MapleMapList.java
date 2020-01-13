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

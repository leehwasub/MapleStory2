package map;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import utils.FileLoader;

public class MapleMapList {
	private static ArrayList<MapleMap> maps = new ArrayList<MapleMap>();

	static {
		initMap();
		makeEdge();
	}

	private static void initMap() {
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
	}

	private static void makeEdge() {
		getMap("초보자의숲1").addPortal(new Portal(new PointMapName(4, 9, "초보자의숲1"), new PointMapName(4, 0, "초보자의숲2")));
		getMap("초보자의숲2").addPortal(new Portal(new PointMapName(4, 0, "초보자의숲2"), new PointMapName(4, 9, "초보자의숲1")));
		getMap("초보자의숲2").addPortal(new Portal(new PointMapName(6, 14, "초보자의숲2"), new PointMapName(4, 0, "암허스트")));
		getMap("암허스트").addPortal(new Portal(new PointMapName(4, 0, "암허스트"), new PointMapName(6, 14, "초보자의숲2")));
		getMap("암허스트").addPortal(new Portal(new PointMapName(7, 16, "암허스트"), new PointMapName(7, 0, "달팽이의숲")));
		getMap("달팽이의숲").addPortal(new Portal(new PointMapName(7, 0, "달팽이의숲"), new PointMapName(7, 16, "암허스트")));
		getMap("달팽이의숲").addPortal(new Portal(new PointMapName(14, 6, "달팽이의숲"), new PointMapName(0, 0, "위험한숲")));
		getMap("달팽이의숲").addPortal(new Portal(new PointMapName(5, 14, "달팽이의숲"), new PointMapName(5, 0, "사우스페리")));
		getMap("사우스페리").addPortal(new Portal(new PointMapName(5, 0, "사우스페리"), new PointMapName(5, 14, "달팽이의숲")));
	}

	public static MapleMap getMap(String mapName) {
		for (int i = 0; i < maps.size(); i++) {
			if (((MapleMap) maps.get(i)).getName().equals(mapName)) {
				return (MapleMap) maps.get(i);
			}
		}
		return null;
	}
}

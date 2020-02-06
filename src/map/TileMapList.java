package map;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import utils.ColorUtils;

public class TileMapList {
	
	private static ArrayList<TileMap> tileMapList = new ArrayList<TileMap>();
	
	static {
		init();
	}

	private static void init() {
		tileMapList.clear();
		tileMapList.add(new TileMap("magatia", ColorUtils.GRAY_40));
		tileMapList.add(new TileMap("dragonCliff", ColorUtils.SEA_40));
		tileMapList.add(new TileMap("elnath", ColorUtils.WHITE_40));
		tileMapList.add(new TileMap("dangerousCliff", ColorUtils.WHITE_40));
		tileMapList.add(new TileMap("hellCave", ColorUtils.GRAY_40));
		tileMapList.add(new TileMap("orbisTower", ColorUtils.GRAY_40));
		tileMapList.add(new TileMap("pellion", ColorUtils.DARK_GOLD_40));
		tileMapList.add(new TileMap("excavationArea", ColorUtils.DARK_GOLD_40));
		tileMapList.add(new TileMap("militaryCamp", ColorUtils.GRAY_40));
		tileMapList.add(new TileMap("forest", ColorUtils.GREEN_40));
		tileMapList.add(new TileMap("leafre", ColorUtils.GREEN_40));
		tileMapList.add(new TileMap("dragonForest", ColorUtils.DRAGON_FOREST_40));
		tileMapList.add(new TileMap("sharenianCastle", ColorUtils.GRAY_40));
		tileMapList.add(new TileMap("genumist", ColorUtils.GRAY_40));
		tileMapList.add(new TileMap("alcadno", ColorUtils.GRAY_40));
		tileMapList.add(new TileMap("ariant", ColorUtils.DARK_GOLD_40));
		tileMapList.add(new TileMap("ariantPalace", ColorUtils.WHITE_40));
		tileMapList.add(new TileMap("emptyHouse", ColorUtils.DARK_GOLD_40));
		tileMapList.add(new TileMap("amherst", ColorUtils.GREEN_40));
		tileMapList.add(new TileMap("lithHarbor", ColorUtils.WHITE_40));
		tileMapList.add(new TileMap("orbisNear", ColorUtils.WHITE_40));
		tileMapList.add(new TileMap("orbis", ColorUtils.WHITE_40));
	}
	
	private static TileMap getTileMapWithName(String tileName) {
		for(int i = 0; i < tileMapList.size(); i++) {
			if(tileMapList.get(i).getTileName().equals(tileName)) {
				return tileMapList.get(i);
			}
		}
		return null;
	}
	
	public static int[][] makeRandomTileNumbers(String tileName, int x, int y){
		return getTileMapWithName(tileName).makeRandomTileNumbers(x, y);
	}
	
	public static Image getTileImage(String tileName, int index){
		return getTileMapWithName(tileName).getTileImage(index);
	}
	
	public static Color getFloorColor(String tileName){
		return getTileMapWithName(tileName).getFloorColor();
	}
	
	
}

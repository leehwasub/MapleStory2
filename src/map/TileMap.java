package map;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import utils.ResourceLoader;

public class TileMap {
	
	public static final int IMAGE_NUM = 4;
	
	private String tileName;
	private Color floorColor;
	private Image tileImage[] = new Image[IMAGE_NUM];
	
	public TileMap(String tileName, Color floorColor) {
		this.tileName = tileName;
		this.floorColor = floorColor;
		initTileImage();
	}
	
	private void initTileImage(){
		for(int i = 0; i < IMAGE_NUM; i++) {
			tileImage[i] = ResourceLoader.getImage("tileImage", tileName + "" + (i+1) + "TileImage.png");
		}
	}
	
	public Image getTileImage(int index) {
		return tileImage[index];
	}
	
	public int[][] makeRandomTileNumbers(int x, int y) {
		int[][] ret = new int[x][y];
		Random random = new Random(10);
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				ret[i][j] = random.nextInt(IMAGE_NUM);
			}
		}
		return ret;
	}
	
	public Color getFloorColor() {
		return floorColor;
	}

	public String getTileName() {
		return tileName;
	}
	
}

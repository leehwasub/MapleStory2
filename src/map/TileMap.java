package map;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import utils.ResourceLoader;

public class TileMap {
	
	public static final int IMAGE_NUM = 4;
	
	private String tileName;
	private Color floorColor;
	private Image tileImage;
	
	public TileMap(String tileName, Color floorColor) {
		this.tileName = tileName;
		this.floorColor = floorColor;
		initTileImage();
	}
	
	private void initTileImage(){
		tileImage = ResourceLoader.getImage("tileImage", tileName + "TileImage.png");
	}
	
	public Image getTileImage() {
		return tileImage;
	}

	public Color getFloorColor() {
		return floorColor;
	}

	public String getTileName() {
		return tileName;
	}
	
}

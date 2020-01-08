package shop;

import java.awt.Image;
import java.util.ArrayList;

import item.Item;
import map.PointMapName;

public class Shop {
	protected Image npcImage;
	protected PointMapName pointMapName;
	protected ArrayList<Item> shareItemList = new ArrayList<Item>();
	protected ArrayList<Item> consumableItemList = new ArrayList<Item>();
	protected ArrayList<Item> warriorItemList = new ArrayList<Item>();
	protected ArrayList<Item> magicianItemList = new ArrayList<Item>();
	protected ArrayList<Item> thiefItemList = new ArrayList<Item>();
	protected ArrayList<Item> archerItemList = new ArrayList<Item>();

	public Image getNpcImage() {
		return this.npcImage;
	}

	public PointMapName getPointMapName() {
		return this.pointMapName;
	}

	public ArrayList<Item> getShareItemList() {
		return this.shareItemList;
	}

	public ArrayList<Item> getConsumableItemList() {
		return this.consumableItemList;
	}

	public ArrayList<Item> getWarriorItemList() {
		return this.warriorItemList;
	}

	public ArrayList<Item> getMagicianItemList() {
		return this.magicianItemList;
	}

	public ArrayList<Item> getThiefItemList() {
		return this.thiefItemList;
	}

	public ArrayList<Item> getArcherItemList() {
		return this.archerItemList;
	}
}

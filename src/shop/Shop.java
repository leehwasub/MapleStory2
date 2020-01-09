package shop;

import java.awt.Image;
import java.util.ArrayList;

import item.Item;
import map.PointMapName;

public class Shop {
	protected Image npcImage;
	protected PointMapName pointMapName;
	protected ArrayList<Item> weaponItemList = new ArrayList<Item>();
	protected ArrayList<Item> equipmentItemList = new ArrayList<Item>();
	protected ArrayList<Item> consumableItemList = new ArrayList<Item>();

	public Image getNpcImage() {
		return this.npcImage;
	}

	public PointMapName getPointMapName() {
		return this.pointMapName;
	}

	public ArrayList<Item> getWeaponItemList() {
		return weaponItemList;
	}

	public ArrayList<Item> getEquipmentItemList() {
		return equipmentItemList;
	}

	public ArrayList<Item> getConsumableItemList() {
		return consumableItemList;
	}

	public void setWeaponItemList(ArrayList<Item> weaponItemList) {
		this.weaponItemList = weaponItemList;
	}

	public void setEquipmentItemList(ArrayList<Item> equipmentItemList) {
		this.equipmentItemList = equipmentItemList;
	}

	public void setConsumableItemList(ArrayList<Item> consumableItemList) {
		this.consumableItemList = consumableItemList;
	}
	
}

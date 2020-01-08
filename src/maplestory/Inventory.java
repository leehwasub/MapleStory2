package maplestory;

import java.io.Serializable;
import java.util.ArrayList;

import character.Adventurer;
import item.ConsumableItem;
import item.EquipmentItem;
import item.MaterialItem;

public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<EquipmentItem> equipmentInventory = new ArrayList<EquipmentItem>();
	private ArrayList<MaterialItem> materialInventory = new ArrayList<MaterialItem>();
	private ArrayList<ConsumableItem> consumableInventory = new ArrayList<ConsumableItem>();
	private Adventurer mainAdventurer;
	int money;

	public Inventory(Adventurer adventurer) {
		this.mainAdventurer = adventurer;
	}

	public ArrayList<EquipmentItem> getEquipmentInventory() {
		return this.equipmentInventory;
	}

	public ArrayList<MaterialItem> getMaterialInventory() {
		return this.materialInventory;
	}

	public ArrayList<ConsumableItem> getConsumableInventory() {
		return this.consumableInventory;
	}

	public int getMoney() {
		return this.money;
	}

	public void addMoney(int money) {
		this.money += money;
	}

	public void subMoney(int money) {
		this.money -= money;
	}

	public void setEquipmentInventory(ArrayList<EquipmentItem> equipmentInventory) {
		this.equipmentInventory = equipmentInventory;
	}

	public void setMaterialInventory(ArrayList<MaterialItem> materialInventory) {
		this.materialInventory = materialInventory;
	}

	public void setConsumableInventory(ArrayList<ConsumableItem> consumableInventory) {
		this.consumableInventory = consumableInventory;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Adventurer getMainAdventurer() {
		return this.mainAdventurer;
	}

	public void setMainAdventurer(Adventurer mainAdventurer) {
		this.mainAdventurer = mainAdventurer;
	}
}
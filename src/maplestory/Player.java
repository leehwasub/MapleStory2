package maplestory;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import character.Adventurer;
import character.AdventurerFactory;
import character.Monster;
import item.BuffItem;
import item.ConsumableItem;
import item.EquipmentItem;
import item.HealItem;
import item.Item;
import item.ItemPool;
import item.MaterialItem;
import map.MapleMap;
import map.MapleMapList;
import map.Point;
import map.PointMapName;
import map.UpdatedMapInfor;
import npc.Npc;
import npc.NpcList;
import npc.UpdatedNpcInfor;
import quest.Quest;
import quest.QuestProceed;
import skill.Skill;
import utils.FontUtils;
import utils.MusicUtils;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private Inventory inventory;
	private Adventurer mainAdventurer;
	private MapleMap _curMap;
	private int _curX;
	private int _curY;
	private boolean isCanMove;
	private boolean isHunt;
	private boolean isCanUseSkill;
	private boolean isConversation;
	private boolean isCanEndConversation;
	private boolean isCanSave;
	private boolean isCanUsePortion;
	private ArrayList<String> visitList = new ArrayList<String>();
	private HashMap<String, Integer> killList = new HashMap<String, Integer>();
	private ArrayList<UpdatedMapInfor> updatedMapList = new ArrayList<UpdatedMapInfor>();
	private ArrayList<UpdatedNpcInfor> updatedNpcList = new ArrayList<UpdatedNpcInfor>();
	private ArrayList<Npc> npcList = new ArrayList<Npc>();
	private Npc curNpc;
	private Quest quest;
	private QuestProceed questProceed;
	private static final int[] dx = { 0, 0, -1, 1 };
	private static final int[] dy = { -1, 1, 0, 0 };
	public static final int MOVE_LEFT = 0;
	public static final int MOVE_RIGHT = 1;
	public static final int MOVE_UP = 2;
	public static final int MOVE_DOWN = 3;

	public Player(String name, String type) {
		this._curMap = MapleMapList.getInstance().getMap("초보자의숲1");
		this.mainAdventurer = AdventurerFactory.makeAdventurer(name, type);
		this.inventory = new Inventory(this.mainAdventurer);
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public Adventurer getMainAdventurer() {
		return this.mainAdventurer;
	}

	public MapleMap get_curMap() {
		return this._curMap;
	}

	public int getCurX() {
		return this._curX;
	}

	public int getCurY() {
		return this._curY;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setMainAdventurer(Adventurer mainAdventurer) {
		this.mainAdventurer = mainAdventurer;
	}

	public void set_curMap(MapleMap curMap) {
		this._curMap = curMap;
	}

	public void setCurX(int curX) {
		this._curX = curX;
	}

	public void setCurY(int curY) {
		this._curY = curY;
	}

	public boolean getIsCanMove() {
		return isCanMove;
	}

	public void setIsCanMove(boolean isCanMove) {
		this.isCanMove = isCanMove;
	}

	public ArrayList<String> getVisitList() {
		return this.visitList;
	}

	public HashMap<String, Integer> getKillList() {
		return this.killList;
	}

	public void setVisitList(ArrayList<String> visitList) {
		this.visitList = visitList;
	}

	public void setKillList(HashMap<String, Integer> killList) {
		this.killList = killList;
	}

	public void addVisitList(String visit) {
		this.visitList.add(visit);
	}

	public void addKillList(String monsterName) {
		if (this.killList.containsKey(monsterName)) {
			int num = this.killList.get(monsterName);
			this.killList.put(monsterName, num + 1);
		} else {
			this.killList.put(monsterName, 1);
		}
	}

	public int getKillNum(String monsterName) {
		if (this.killList.get(monsterName) == null) {
			return 0;
		}
		int getNum = this.killList.get(monsterName);
		return getNum;
	}

	public boolean isKilledEnough(String monsterName, int num) {
		if (this.killList.get(monsterName) == null) {
			return false;
		}
		int getNum = this.killList.get(monsterName);
		return getNum >= num;
	}
	
	public int getMaterialItemNum(String itemName) {
		int retNum = 0;
		ArrayList<MaterialItem> materialItemInventory = inventory.getMaterialInventory();
		for(int i = 0; i < materialItemInventory.size(); i++) {
			MaterialItem item = materialItemInventory.get(i);
			if(item.getName().equals(itemName)) {
				retNum += item.getNum();
			}
		}
		return retNum;
	}

	public void initVisitList() {
		this.visitList.clear();
	}

	public void initKillList() {
		this.killList.clear();
	}

	public boolean isConversation() {
		return this.isConversation;
	}

	public void setConversation(boolean isConversation) {
		this.isConversation = isConversation;
	}

	public ArrayList<Npc> getNpcList() {
		return this.npcList;
	}

	public void setNpcList(ArrayList<Npc> npcList) {
		this.npcList = npcList;
	}

	public void addNpcList(Npc npc) {
		this.npcList.add(npc);
	}

	public void initCurNpc(PointMapName pointMapName) {
		this.curNpc = NpcList.getInstance().getNpc(pointMapName);
	}

	public Npc getCurNpc() {
		return this.curNpc;
	}

	public void setCurNpc(Npc curNpc) {
		this.curNpc = curNpc;
	}

	public boolean conversation(MainMapleInterface m) {
		return this.curNpc.process(this, m);
	}

	public PointMapName getPlayerPointMapName() {
		return new PointMapName(this._curX, this._curY, get_curMap().getName());
	}

	public void addMainAdventurerExp(int exp) {
		this.mainAdventurer.addExp(exp);
	}

	public boolean isHunt() {
		return this.isHunt;
	}

	public void setHunt(boolean isHunt) {
		this.isHunt = isHunt;
	}

	public boolean isCanEndConversation() {
		return this.isCanEndConversation;
	}

	public void setCanEndConversation(boolean isCanEndConversation) {
		this.isCanEndConversation = isCanEndConversation;
	}

	public Quest getQuest() {
		return this.quest;
	}

	public void setQuest(Quest quest) {
		initKillList();
		this.quest = quest;
	}

	public QuestProceed getQuestProceed() {
		return this.questProceed;
	}

	public void setQuestProceed(QuestProceed questProceed) {
		this.questProceed = questProceed;
	}

	public void questClear() {
		this.quest.getReward(this);
		this.quest = null;
		initKillList();
		initVisitList();
		MusicUtils.startEffectSound("questClear");
	}

	public void drawMainStatus(Graphics2D g) {
		g.setFont(FontUtils.guideMessageFont);
		g.setColor(Color.yellow);
		g.drawString(this.mainAdventurer.getName(), 25, 590);
		g.setFont(FontUtils.generalFont);
		g.setColor(Color.orange);
		g.drawString("Lv" + this.mainAdventurer.getStrength().getLevel(), 350, 590);
		g.setColor(Color.red);
		g.drawString("HP", 440, 590);
		g.setColor(Color.white);
		g.drawString(this.mainAdventurer.getCurHp() + "/" + this.mainAdventurer.getStrength().getMaxHp(), 490, 590);
		g.setColor(Color.blue);
		g.drawString("MP", 650, 590);
		g.setColor(Color.white);
		g.drawString(this.mainAdventurer.getCurMp() + "/" + this.mainAdventurer.getStrength().getMaxMp(), 730, 590);
		g.setColor(Color.cyan);
		g.drawString(this.mainAdventurer.getCareer(), 880, 590);
		g.setColor(Color.yellow);
		g.drawString("Exp", 970, 590);
		g.setColor(Color.green);
	}

	public void move(int dir) {
		if (!this.isCanMove) {
			return;
		}
		MapleMap curMap = MapleMapList.getInstance().getMap(get_curMap().getName());
		int maxX = curMap.getMaxX();
		int maxY = curMap.getMaxY();
		for (int i = 0; i < 4; i++) {
			if (dir == i) {
				int xx = dx[i] + this._curX;
				int yy = dy[i] + this._curY;
				if ((xx >= 0) && (yy >= 0) && (xx < maxX) && (yy < maxY)) {
					int state = curMap.getMap(xx, yy);
					Point basePoint = curMap.getBasePoint();
					if (state != 1) {
						this._curX = xx;
						this._curY = yy;
						if (xx >= basePoint.getX() + Math.min(maxX, MapleMap.MAX_MAP_VIEW_X) - 2
								&& (basePoint.getX() + Math.min(maxX, MapleMap.MAX_MAP_VIEW_X) < maxX)) {
							basePoint.setX(basePoint.getX() + 1);
						}
						if ((xx <= basePoint.getX() + 2) && (basePoint.getX() > 0)) {
							basePoint.setX(basePoint.getX() - 1);
						}
						if ((yy <= basePoint.getY() + 2) && (basePoint.getY() > 0)) {
							basePoint.setY(basePoint.getY() - 1);
						}
						if ((yy >= basePoint.getY() + Math.min(maxY, MapleMap.MAX_MAP_VIEW_Y) - 2)
								&& (basePoint.getY() + Math.min(maxY, MapleMap.MAX_MAP_VIEW_Y) < maxY)) {
							basePoint.setY(basePoint.getY() + 1);
						}
						System.out.println(basePoint.toString());
					}
				}
			}
		}
	}

	public void calState() {
		mainAdventurer.calState();
	}

	public ConsumableItem registQuickItem(int itemIndex, int keyIndex) {
		if (itemIndex >= getInventory().getConsumableInventory().size()) {
			return null;
		}
		ConsumableItem e = (ConsumableItem) getInventory().getConsumableInventory().get(itemIndex);
		if (mainAdventurer.getQuickItemByIndex(keyIndex) != null) {
			removeQuickItem(keyIndex);
		}
		mainAdventurer.setQuickItemByIndex(keyIndex, e);
		return null;
	}

	public boolean removeQuickItem(int keyIndex) {
		if (mainAdventurer.getQuickItemByIndex(keyIndex) == null) {
			return false;
		}
		mainAdventurer.setQuickItemByIndex(keyIndex, null);
		calState();
		return true;
	}
	
	public ConsumableItem registQuickSkill(int level, int index, int keyIndex) {
		Skill skill = mainAdventurer.getSkillWithLevelIndex(level, index);
		if (mainAdventurer.getQuickItemByIndex(keyIndex) != null) {
			removeQuickSkill(keyIndex);
		}
		mainAdventurer.setQuickSkillByIndex(keyIndex, skill);
		return null;
	}

	public boolean removeQuickSkill(int keyIndex) {
		mainAdventurer.setQuickSkillByIndex(keyIndex, null);
		calState();
		return true;
	}

	public EquipmentItem wearEquipment(int index) {
		if (index >= getInventory().getEquipmentInventory().size()) {
			return null;
		}
		EquipmentItem e = (EquipmentItem) getInventory().getEquipmentInventory().get(index);
		if (mainAdventurer.getWearEquipmentByIndex(e.getType()) != null) {
			takeOffEquipment(e.getType());
		}
		e.setNum(e.getNum() - 1);
		removeEmptyItem();
		mainAdventurer.setWearEquipmentByIndex(e.getType(), (EquipmentItem) ItemPool.getItem(e.getName(), 1));
		calState();
		return (EquipmentItem) ItemPool.getItem(e.getName(), 1);
	}

	public void getWearEquipment(String eqipmentName) {
		EquipmentItem e = (EquipmentItem) ItemPool.getItem(eqipmentName, 1);
		if (mainAdventurer.getWearEquipmentByIndex(e.getType()) != null) {
			takeOffEquipment(e.getType());
		}
		removeEmptyItem();
		mainAdventurer.setWearEquipmentByIndex(e.getType(), e);
		calState();
	}

	public boolean takeOffEquipment(int type) {
		if (mainAdventurer.getWearEquipmentByIndex(type) == null) {
			return false;
		}
		addItem((EquipmentItem) ItemPool.getItem(mainAdventurer.getWearEquipmentByIndex(type).getName(), 1));
		mainAdventurer.setWearEquipmentByIndex(type, null);
		calState();
		return true;
	}

	private boolean isCanAddItem(Item item) {
		Inventory inventory = getInventory();
		ArrayList<EquipmentItem> equipmentInventory = inventory.getEquipmentInventory();
		ArrayList<ConsumableItem> consumableInventory = inventory.getConsumableInventory();
		ArrayList<MaterialItem> materialInventory = inventory.getMaterialInventory();
		int num = item.getNum();
		if ((item instanceof ConsumableItem)) {
			for (int i = 0; (i < consumableInventory.size()) && (num >= 1); i++) {
				String curItem = ((ConsumableItem) consumableInventory.get(i)).getName();
				int curItemNum = ((ConsumableItem) consumableInventory.get(i)).getNum();
				if (item.getName().equals(curItem)) {
					num -= 1000 - curItemNum;
				}
			}
			if (num < 0) {
				return true;
			}
			if ((consumableInventory.size() <= 49) && (num <= 1000)) {
				return true;
			}
		} else if ((item instanceof EquipmentItem)) {
			for (int i = 0; (i < equipmentInventory.size()) && (num >= 1); i++) {
				String curItem = ((EquipmentItem) equipmentInventory.get(i)).getName();
				int curItemNum = ((EquipmentItem) equipmentInventory.get(i)).getNum();
				if (item.getName().equals(curItem)) {
					num -= 1000 - curItemNum;
				}
			}
			if (num < 0) {
				return true;
			}
			if ((equipmentInventory.size() <= 49) && (num <= 1000)) {
				return true;
			}
		} else if ((item instanceof Item)) {
			for (int i = 0; (i < materialInventory.size()) && (num >= 1); i++) {
				String curItem = ((MaterialItem) materialInventory.get(i)).getName();
				int curItemNum = ((MaterialItem) materialInventory.get(i)).getNum();
				if (item.getName().equals(curItem)) {
					num -= 1000 - curItemNum;
				}
			}
			if (num < 0) {
				return true;
			}
			if ((materialInventory.size() <= 49) && (num <= 1000)) {
				return true;
			}
		}
		return false;
	}

	public boolean addItem(Item item) {
		Inventory inventory = getInventory();
		ArrayList<EquipmentItem> equipmentInventory = inventory.getEquipmentInventory();
		ArrayList<ConsumableItem> consumableInventory = inventory.getConsumableInventory();
		ArrayList<MaterialItem> materialInventory = inventory.getMaterialInventory();
		if (!isCanAddItem(item)) {
			return false;
		}
		if (((item instanceof HealItem)) || ((item instanceof BuffItem))) {
			ConsumableItem newItem = null;
			if ((item instanceof HealItem)) {
				newItem = (HealItem) ItemPool.getItem(item.getName(), item.getNum());
			}
			if ((item instanceof BuffItem)) {
				newItem = (BuffItem) ItemPool.getItem(item.getName(), item.getNum());
			}
			for (int i = 0; (i < consumableInventory.size()) && (newItem.getNum() >= 1); i++) {
				String curItem = ((ConsumableItem) consumableInventory.get(i)).getName();
				if (item.getName().equals(curItem)) {
					int AfterInsertNum = ((ConsumableItem) consumableInventory.get(i)).getNum() + newItem.getNum();
					((ConsumableItem) consumableInventory.get(i)).setNum(
							Math.min(((ConsumableItem) consumableInventory.get(i)).getNum() + newItem.getNum(), 1000));
					newItem.setNum(Math.max(AfterInsertNum - 1000, 0));
				}
			}
			if ((consumableInventory.size() <= 49) && (newItem.getNum() >= 1)) {
				consumableInventory.add(newItem);
			}
		} else if ((item instanceof EquipmentItem)) {
			EquipmentItem newItem = (EquipmentItem) ItemPool.getItem(item.getName(), item.getNum());
			for (int i = 0; (i < equipmentInventory.size()) && (newItem.getNum() >= 1); i++) {
				String curItem = ((EquipmentItem) equipmentInventory.get(i)).getName();
				if (item.getName().equals(curItem)) {
					int AfterInsertNum = ((EquipmentItem) equipmentInventory.get(i)).getNum() + newItem.getNum();
					((EquipmentItem) equipmentInventory.get(i)).setNum(
							Math.min(((EquipmentItem) equipmentInventory.get(i)).getNum() + newItem.getNum(), 1000));
					newItem.setNum(Math.max(AfterInsertNum - 1000, 0));
				}
			}
			if ((equipmentInventory.size() <= 49) && (newItem.getNum() >= 1)) {
				equipmentInventory.add(newItem);
			}
		} else if ((item instanceof MaterialItem)) {
			MaterialItem newItem = (MaterialItem) ItemPool.getItem(item.getName(), item.getNum());
			for (int i = 0; (i < materialInventory.size()) && (newItem.getNum() >= 1); i++) {
				String curItem = ((MaterialItem) materialInventory.get(i)).getName();
				if (item.getName().equals(curItem)) {
					int AfterInsertNum = ((MaterialItem) materialInventory.get(i)).getNum() + newItem.getNum();
					((MaterialItem) materialInventory.get(i)).setNum(
							Math.min(((MaterialItem) materialInventory.get(i)).getNum() + newItem.getNum(), 1000));
					newItem.setNum(Math.max(AfterInsertNum - 1000, 0));
				}
			}
			if ((materialInventory.size() <= 49) && (newItem.getNum() >= 1)) {
				materialInventory.add(newItem);
			}
		}
		return true;
	}

	public void removeItem(String itemName, int num) {
		Inventory inventory = getInventory();
		ArrayList<EquipmentItem> equipmentInventory = inventory.getEquipmentInventory();
		ArrayList<ConsumableItem> consumableInventory = inventory.getConsumableInventory();
		ArrayList<MaterialItem> materialInventory = inventory.getMaterialInventory();
		for (int i = 0; i < equipmentInventory.size(); i++) {
			EquipmentItem inven = (EquipmentItem) equipmentInventory.get(i);
			if ((inven.getName().equals(itemName)) && (inven.getNum() >= num)) {
				inven.setNum(inven.getNum() - num);
				removeEmptyItem();
				return;
			}
		}
		for (int i = 0; i < consumableInventory.size(); i++) {
			Item inven = (Item) consumableInventory.get(i);
			if ((inven.getName().equals(itemName)) && (inven.getNum() >= num)) {
				inven.setNum(inven.getNum() - num);
				removeEmptyItem();
				return;
			}
		}
		for (int i = 0; i < materialInventory.size(); i++) {
			Item inven = (Item) materialInventory.get(i);
			if ((inven.getName().equals(itemName)) && (inven.getNum() >= num)) {
				inven.setNum(inven.getNum() - num);
				removeEmptyItem();
				return;
			}
		}
	}

	public void removeEmptyItem() {
		Inventory inventory = getInventory();
		ArrayList<EquipmentItem> equipmentInventory = inventory.getEquipmentInventory();
		ArrayList<ConsumableItem> consumableInventory = inventory.getConsumableInventory();
		ArrayList<MaterialItem> materialInventory = inventory.getMaterialInventory();
		int n = equipmentInventory.size();
		for (int i = n - 1; i >= 0; i--) {
			if (((EquipmentItem) equipmentInventory.get(i)).getNum() == 0) {
				equipmentInventory.remove(i);
			}
		}
		n = consumableInventory.size();
		for (int i = n - 1; i >= 0; i--) {
			if (((ConsumableItem) consumableInventory.get(i)).getNum() == 0) {
				consumableInventory.remove(i);
			}
		}
		n = materialInventory.size();
		for (int i = n - 1; i >= 0; i--) {
			if (((MaterialItem) materialInventory.get(i)).getNum() == 0) {
				materialInventory.remove(i);
			}
		}
	}

	public EquipmentItem getPlayerEquipmentByIndex(int i) {
		return mainAdventurer.getWearEquipmentByIndex(i);
	}

	public EquipmentItem[] getPlayerEquipment() {
		return mainAdventurer.getWearEquipment();
	}

	public ConsumableItem getPlayerQuickItemByIndex(int i) {
		return mainAdventurer.getQuickItemByIndex(i);
	}

	public ConsumableItem[] getPlayerQuickItem() {
		return mainAdventurer.getQuickItem();
	}
	
	public Skill getPlayerQuickSkillByIndex(int i) {
		return mainAdventurer.getQuickSkillByIndex(i);
	}

	public Skill[] getPlayerSkillItem() {
		return mainAdventurer.getQuickSkill();
	}

	public void usePortion(ConsumableItem item) {
		mainAdventurer.usePortion(item);
		mainAdventurer.removeEmptyQuickItem();
		removeEmptyItem();
	}

	public String getSpoils(Monster monster) {
		StringBuffer b = new StringBuffer();
		StringBuffer tmp = new StringBuffer();
		getInventory().addMoney(monster.getMoney());
		mainAdventurer.addExp(monster.getExp());
		addKillList(monster.getName());
		tmp.append(monster.dropItem(this));
		b.append("경험치 " + monster.getExp() + " 획득! 메소 " + monster.getMoney() + " 획득! ");
		b.append(tmp);
		return b.toString();
	}

	public boolean isQuestsClear() {
		return this.quest.isCanClear(this);
	}

	public void allSetAlive() {
		mainAdventurer.setDead(false);
	}

	public void addMoney(int rewardMoney) {
		this.inventory.addMoney(rewardMoney);
	}

	public void allAdventuerFullHeal() {
		MusicUtils.startEffectSound("heal");
		mainAdventurer.fullHeal();
	}

	public void subMoney(int money) {
		this.inventory.subMoney(money);
	}

	public boolean isCanSave() {
		return this.isCanSave;
	}

	public void setCanSave(boolean isCanSave) {
		this.isCanSave = isCanSave;
	}

	public ArrayList<UpdatedMapInfor> getUpdatedMapList() {
		return updatedMapList;
	}

	public void addUpdatedMap(UpdatedMapInfor infor) {
		PointMapName p = infor.getPointMapName();
		System.out.println(infor);
		MapleMapList.getInstance().getMap(p.getMapName()).setMap(p.getX(), p.getY(), infor.getAfterState());
		updatedMapList.add(infor);
	}

	public ArrayList<UpdatedNpcInfor> getUpdatedNpcList() {
		return updatedNpcList;
	}

	public void addUpdatedNpc(UpdatedNpcInfor infor) {
		NpcList.getInstance().getNpcWithName(infor.getNpcName()).setPointMapName(infor.getPointMapName());
		updatedNpcList.add(infor);
	}


	public boolean isCanUsePortion() {
		return isCanUsePortion;
	}

	public void setCanUsePortion(boolean isCanUsePortion) {
		this.isCanUsePortion = isCanUsePortion;
	}

	public boolean isCanUseSkill() {
		return isCanUseSkill;
	}

	public void setCanUseSkill(boolean isCanUseSkill) {
		this.isCanUseSkill = isCanUseSkill;
	}

}

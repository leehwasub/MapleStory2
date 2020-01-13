package quest;

import java.io.Serializable;
import java.util.ArrayList;

import item.Item;
import map.MapleMapList;
import map.PointMapName;
import map.UpdatedMapInfor;
import maplestory.Player;
import npc.NpcList;
import npc.UpdatedNpcInfor;

public class QuestReward implements Serializable {
	private static final long serialVersionUID = 1L;
	private int rewardExp;
	private int rewardMoney;
	private ArrayList<Item> rewardItem = new ArrayList<Item>();
	private QuestProceed questProceed;
	private ArrayList<QuestNpcProceed> questNpcProceedList = new ArrayList<QuestNpcProceed>();
	private ArrayList<UpdatedMapInfor> questUpdateMapInfor = new ArrayList<UpdatedMapInfor>();
	private ArrayList<UpdatedNpcInfor> questUpdateNpcInfor = new ArrayList<UpdatedNpcInfor>();

	public void givePlayerReward(Player player) {
		player.addMainAdventurerExp(this.rewardExp);
		player.addMoney(this.rewardMoney);
		for (int i = 0; i < this.rewardItem.size(); i++) {
			player.addItem((Item) this.rewardItem.get(i));
		}
		arrayListInit();
		for (int i = 0; i < questNpcProceedList.size(); i++) {
			QuestNpcProceed q = (QuestNpcProceed) this.questNpcProceedList.get(i);
			NpcList.getInstance().getNpcWithName(q.getNpcName()).setProcess(q.getNpcProceed());
		}
		for (int i = 0; i < questUpdateMapInfor.size(); i++) {
			UpdatedMapInfor infor = (UpdatedMapInfor)questUpdateMapInfor.get(i);
			player.addUpdatedMap(infor);
		}
		for (int i = 0; i < questUpdateNpcInfor.size(); i++) {
			UpdatedNpcInfor infor = (UpdatedNpcInfor)questUpdateNpcInfor.get(i);
			player.addUpdatedNpc(infor);
		}
	}

	private void arrayListInit() {
		if(questNpcProceedList == null) {
			questNpcProceedList = new ArrayList<QuestNpcProceed>();
		}
		if(questUpdateMapInfor == null) {
			questUpdateMapInfor = new ArrayList<UpdatedMapInfor>();
		}
		if(questUpdateNpcInfor == null) {
			questUpdateNpcInfor = new ArrayList<UpdatedNpcInfor>();
		}
	}

	public String getRewardString() {
		StringBuffer b = new StringBuffer();
		if (this.rewardExp != 0) {
			b.append(this.rewardExp + " 경험치 획득! ");
		}
		if (this.rewardMoney != 0) {
			b.append(this.rewardMoney + " 메소 획득! ");
		}
		for (int i = 0; i < this.rewardItem.size(); i++) {
			Item item = (Item) this.rewardItem.get(i);
			b.append(item.getName() + " " + item.getNum() + "개 획득! ");
		}
		return b.toString();
	}

	public int getRewardExp() {
		return this.rewardExp;
	}

	public int getRewardMoney() {
		return this.rewardMoney;
	}

	public ArrayList<Item> getRewardItem() {
		return this.rewardItem;
	}

	public void setRewardExp(int rewardExp) {
		this.rewardExp = rewardExp;
	}

	public void setRewardMoney(int rewardMoney) {
		this.rewardMoney = rewardMoney;
	}

	public void setRewardItem(ArrayList<Item> rewardItem) {
		this.rewardItem = rewardItem;
	}

	public void addRewardItem(Item rewardItem) {
		this.rewardItem.add(rewardItem);
	}

	public QuestProceed getQuestProceed() {
		return this.questProceed;
	}

	public void setQuestProceed(QuestProceed questProceed) {
		this.questProceed = questProceed;
	}

	public void addQuestNpcProceed(QuestNpcProceed questNpcProceed) {
		this.questNpcProceedList.add(questNpcProceed);
	}
	
	public void addQuestUpdateMapInfor(UpdatedMapInfor updatedMapInfor) {
		questUpdateMapInfor.add(updatedMapInfor);
	}
	
	public void addQuestUpdateNpcInfor(UpdatedNpcInfor updatedNpcInfor) {
		questUpdateNpcInfor.add(updatedNpcInfor);
	}
	
}

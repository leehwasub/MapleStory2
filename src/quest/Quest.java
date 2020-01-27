package quest;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import character.Status;
import item.ItemPool;
import map.PointMapName;
import map.UpdatedMapInfor;
import maplestory.Player;
import npc.UpdatedNpcInfor;
import utils.FontUtils;

public class Quest implements Serializable {
	private static final long serialVersionUID = 1L;
	private int chapter;
	private int questId;
	private String title;
	private ArrayList<QuestCondition> questCondition = new ArrayList<QuestCondition>();
	private StringBuffer message = new StringBuffer();
	private QuestReward questReward = new QuestReward();

	private Quest(int chapter, int questId, String title) {
		this.chapter = chapter;
		this.questId = questId;
		this.title = title;
	}

	public static Quest makeQuest(int chapter, int questId, String title) {
		return new Quest(chapter, questId, title);
	}

	public boolean isCanClear(Player player) {
		for (int i = 0; i < this.questCondition.size(); i++) {
			if (!((QuestCondition) this.questCondition.get(i)).checkClear(player)) {
				System.out.println(((QuestCondition) this.questCondition.get(i)).checkClear(player));
				return false;
			}
		}
		return true;
	}

	public Quest addQuestMaterial(String materialName, int num) {
		this.questCondition.add(new QuestMaterial(materialName, num));
		return this;
	}

	public Quest addQuestKill(String monsterName, int num) {
		this.questCondition.add(new QuestKill(monsterName, num));
		return this;
	}
	
	public Quest addQuestStatus(int str, int dex, int Int, int luk) {
		this.questCondition.add(new QuestStatus(new Status(str, dex, Int, luk)));
		return this;
	}
	
	public Quest addQuestLevel(int level) {
		this.questCondition.add(new QuestLevel(level));
		return this;
	}

	public Quest addQuestVisit(String name) {
		this.questCondition.add(new QuestVisit(name));
		return this;
	}
	
	public Quest addQuestSpendAllSkillPoint(int level) {
		this.questCondition.add(new QuestSkillPoint(level));
		return this;
	}

	public Quest addMessage(String message) {
		this.message.append(message);
		return this;
	}

	public Quest setRewardMoney(int rewardMoney) {
		this.questReward.setRewardMoney(rewardMoney);
		return this;
	}

	public Quest setRewardExp(int rewardExp) {
		this.questReward.setRewardExp(rewardExp);
		return this;
	}

	public Quest addRewardItem(String itemName, int num) {
		this.questReward.addRewardItem(ItemPool.getItem(itemName, num));
		return this;
	}

	public Quest setPlayerQuestProceed(QuestProceed questProceed) {
		this.questReward.setQuestProceed(questProceed);
		return this;
	}

	public Quest addRewardNpcQuestProceed(String npcName, int process) {
		this.questReward.addQuestNpcProceed(new QuestNpcProceed(npcName, process));
		return this;
	}
	
	public Quest addRewardUpdateMap(String mapName, int x, int y, int afterState) {
		this.questReward.addQuestUpdateMapInfor(new UpdatedMapInfor(new PointMapName(x, y, mapName), afterState));
		return this;
	}
	
	public Quest addRewardUpdateNpc(String mapName, int x, int y, String npcName) {
		this.questReward.addQuestUpdateNpcInfor(new UpdatedNpcInfor(new PointMapName(x, y, mapName), npcName));
		return this;
	}

	public String getRewardString() {
		return this.questReward.getRewardString();
	}
	

	public ArrayList<QuestMaterial> getQuestMaterial() {
		ArrayList<QuestMaterial> ret = new ArrayList<QuestMaterial>();
		for(int i = 0; i < questCondition.size(); i++) {
			if(questCondition.get(i) instanceof QuestMaterial) {
				ret.add((QuestMaterial)questCondition.get(i));
			}
		}
		return ret;
	}

	public void questDraw(Graphics2D g, Player player) {
		g.setFont(FontUtils.BIG_FONT);
		g.setColor(Color.YELLOW);
		if (this.chapter == 0) {
			g.drawString("Tutorial - " + this.questId, 35, 45);
		} else {
			g.drawString("Chapter" + this.chapter + " - " + this.questId, 35, 45);
		}
		g.setFont(FontUtils.generalFont);
		g.setColor(Color.CYAN);
		g.drawString(this.title, 250, 42);
		g.setColor(Color.white);
		int preIndex = 0;
		int line = 0;
		for (int i = 0; i < this.message.length(); i++) {
			FontMetrics fm = g.getFontMetrics();
			int width = fm.stringWidth(this.message.substring(preIndex, i));
			if (width > 1000) {
				g.drawString(this.message.substring(preIndex, i), 45, 110 + line * 25);
				preIndex = i;
				line++;
			}
		}
		g.drawString(this.message.substring(preIndex), 45, 110 + line * 25);
		g.setColor(Color.MAGENTA);
		for (int i = 0; i < this.questCondition.size(); i++) {
			g.drawString(((QuestCondition) this.questCondition.get(i)).checkState(player), 35, 360 + 25 * i);
		}
	}

	public StringBuffer getMessage() {
		return this.message;
	}

	public void setMessage(StringBuffer message) {
		this.message = message;
	}

	public int getChapter() {
		return this.chapter;
	}

	public int getQuestId() {
		return this.questId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	public void setQuestId(int questId) {
		this.questId = questId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void getReward(Player player) {
		this.questReward.givePlayerReward(player);
	}
}
package npc;

import character.Adventurer;
import character.AdventurerFactory;
import item.ItemPool;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class DancesWithBalrog extends Npc{

	private static final long serialVersionUID = 1L;

	public DancesWithBalrog(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		if(clearNum == 0) {
			Adventurer adventurer = player.getMainAdventurer();
			AdventurerFactory.upgradeAdventurer("검사", adventurer);
			adventurer.setCareer("검사");
			adventurer.setCareerLevel(1);
			player.addItem(ItemPool.getItem("카알대검", 1));
			if(adventurer.getSex().equals("남자")) {
				player.addItem(ItemPool.getItem("로리카아머(남)", 1));
				player.addItem(ItemPool.getItem("로리카바지(남)", 1));
			}else if(adventurer.getSex().equals("여자")) {
				player.addItem(ItemPool.getItem("스퀘이머(여)", 1));
				player.addItem(ItemPool.getItem("소피아바지(여)", 1));
			}
		}
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 4, "전사 전직").addMessage("전사로 전직하기 위해 페리온에서 주먹펴고 일어서를 만났다.")
					.addMessage("그는 전사로 전직하기 위해서는 힘35 래벨 10이상이 되어야 한다고 한다. 조건이 충족되었는지 확인한후 다시 찾아가 말을 걸어보자.")
					.addQuestStatus(35, 0, 0, 0).setRewardExp(10).setPlayerQuestProceed(QuestProceed.DANCESWITHBALROG_QUEST_1)
					.addQuestLevel(10);
			player.setQuest(quest);
		}
	}

}

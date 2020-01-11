package npc;

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
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 4, "전사 전직").addMessage("전사로 전직하기 위해 페리온에서 주먹펴고 일어서를 만났다.")
					.addMessage("그는 전사로 전직하기 위해서는 힘35 래벨 10이상이 되어야 한다고 한다. 조건이 충족되었는지 확인한후 다시 찾아가 말을 걸어보자.")
					.addQuestStatus(35, 0, 0, 0).setRewardExp(10).setPlayerQuestProceed(QuestProceed.DANCESWITHBALROG_QUEST_1);
			player.setQuest(quest);
		}
	}

}

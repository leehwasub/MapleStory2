package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Jane extends Npc{

	private static final long serialVersionUID = 1L;

	public Jane(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 3, "요리 재료").addMessage("당장 요리를 대접하고 싶지만 재료가 부족하다고 한다. 주황 버섯의 갓 10개만 모아와 주면 당장 요리를 시작할 수 있다는데.")
					.addQuestMaterial("주황버섯의갓", 10).setRewardExp(150).setRewardMoney(270).setPlayerQuestProceed(QuestProceed.JANE_QUEST_1)
					.addRewardNpcQuestProceed("주먹펴고일어서", 1);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Ayan extends Npc{

	private static final long serialVersionUID = 1L;

	public Ayan(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		if(clearNum == 0) {
			
		}
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 19, "오르비스로").addMessage("'이얀'의 말에 의하면 리스항구 북서쪽 포탈로 들어가면 배를 타는 승강장으로 이동할수 있다고 한다.")
					.addMessage("모든 준비가 끝났다면 이동하도록 하자.").setRewardExp(100).setPlayerQuestProceed(QuestProceed.EYAN_QUEST_1);
			player.setQuest(quest);
		}
	}

}

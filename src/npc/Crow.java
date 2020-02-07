package npc;

import map.MapleMap;
import map.PointMapName;
import map.UpdatedMapInfor;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Crow extends Npc{

	private static final long serialVersionUID = 1L;

	public Crow(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(6, 0, "리프레승강장"), MapleMap.MAP_PORTAL_STATE));
			quest = Quest.makeQuest(4, 13, "시간의 신전으로").addMessage("리프레에 있는 '크로우'와 이야기를 나누었다. 그녀는 리프레에서 시간의 신전에서 함께 맞서 싸울 모험가를 구하고 있다고 한다. ")
					.addMessage("얼마전 검은 마법사가 최후의 수단으로 모든 마력을 쏟아부어 핑크빈이라는 괴물을 만들어 냈고 이괴물을 지금 신들의 황혼을 초토화시키고 있다고 한다. 가만히 있을 수는 없다. 시간의 신전에 있는 엘레나에게 가서 말을 걸어보자.")
					.addQuestVisit("헬레나").addRewardItem("파워엘릭서", 50).setRewardExp(10000).setPlayerQuestProceed(QuestProceed.CROW_QUEST_1);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

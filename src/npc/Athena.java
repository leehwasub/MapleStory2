package npc;

import map.MapleMap;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Athena extends Npc{

	private static final long serialVersionUID = 1L;

	public Athena(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(5, 1, "힘의 증명 1").addMessage("시간의 신전에 무사히 도착하여 시간의 신전안에 있는 궁수 전직관 '헬레나'와 대화를 하였다. 그녀는 현재 시간의 신전에서 검은 마법사")
					.addMessage("의 잔당을 처리중이고 신들의 황혼에 나타난 괴물을 처리하기 위해서는 자신의 힘을 증명하여 문을 열어야 된다고 한다. ")
					.addMessage("그 첫번째 관문은 바로 추억의 신관 30마리와 추억의 수호대장 30마리를 처리하는것. 처리이후에 신전 관리인에게 가면 문을 열어 줄 거라고 하는데.")
					.addQuestKill("추억의신관", 30).addQuestKill("추억의수호대장", 30).addRewardUpdateMap("추억의길2", 0, 18, MapleMap.MAP_PORTAL_STATE)
					.addRewardItem("파워엘릭서", 50).setRewardExp(200000).setRewardMoney(400000).setPlayerQuestProceed(QuestProceed.ATHENA_QUEST_1);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

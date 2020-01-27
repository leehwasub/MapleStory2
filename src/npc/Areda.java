package npc;

import map.MapleMap;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Areda extends Npc{

	private static final long serialVersionUID = 1L;

	public Areda(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 11, "열쇠는 어디에?").addMessage("아리안트 궁전에 있는 왕녀 '아레다'와 대화를 나누었다. 별다른 이야기는 하지 않았고 바로 열쇠를 찾기위해 움직이기 시작했다.")
					.addMessage("마침 왕녀 '아레다'가 '세헤라자드'라는 이름을 언급하였다. 뭔가 단서를 얻을 수 있을지 모르니 한번 대화를 나눠 보도록하자.").addQuestVisit("세헤라자드")
					.addRewardUpdateMap("아리안트궁전복도", 5, 18, MapleMap.MAP_PORTAL_STATE)
					.setRewardExp(500).setPlayerQuestProceed(QuestProceed.AREDA_QUEST_1);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

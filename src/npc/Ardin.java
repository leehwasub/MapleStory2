package npc;

import map.MapleMap;
import map.MapleMapList;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Ardin extends Npc{

	private static final long serialVersionUID = 1L;

	public Ardin(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 6, "선인장 사막에서의 수련").addMessage("세잔의 말대로 데우를 처리하기 위해 선인장 사막에 있는 아딘을 만났다. 아딘은 데우 또한 선인장 몬스터이기 때문에")
					.addMessage(" 이들을 먼저 사냥해 보는것이 도움이 될거라고 한다. 주변에서 카투스와 로얄 카투스를 사냥하도록 하자.")
					.addQuestKill("카투스", 15).addQuestKill("로얄카투스", 15)
					.setRewardExp(8500).setRewardMoney(17000).addRewardUpdateMap("선인장사막", 0, 20, MapleMap.MAP_PORTAL_STATE)
					.setPlayerQuestProceed(QuestProceed.ARDIN_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(3, 7, "데우 처리").addMessage("카투스를 어느정도 사냥한 이후 아딘은 충분히 데우를 처리 할 수 있을 거라며 선인장 사막 북쪽으로 가보라고 한다.")
					.addMessage("다만 데우 또한 보스 몬스터급에 속하기 때문에 여전히 방심은 금물이다. 만반의 준비를 갖춰서 가도록 하자.")
					.addQuestKill("데우", 1).addRewardNpcQuestProceed("자노", 1)
					.setRewardExp(10000).setRewardMoney(20000).setPlayerQuestProceed(QuestProceed.ARDIN_QUEST_2);
			player.setQuest(quest);
		} else if(questNum == 2) {
			quest = Quest.makeQuest(3, 8, "자노").addMessage("드디어 데우를 쓰러트렸다. 이제 출입증을 얻기위해 아리안트 마을에 있는 자노에게 가보라고 한다.")
					.addRewardNpcQuestProceed("시린", 1)
					.addMessage("아리안트 마을 빈집중 한곳에 자노가 있다. 찾아 보도록 하자.").setRewardExp(500).setPlayerQuestProceed(QuestProceed.ARDIN_QUEST_3);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

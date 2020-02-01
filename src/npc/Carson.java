package npc;

import map.MapleMap;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Carson extends Npc{

	private static final long serialVersionUID = 1L;

	public Carson(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 24, "제뉴미스트 연구실장 베딘").addMessage("알카드노의 협회장 '카슨'과 이야기를 나누었다. 그는 이미 알카드노에게서 이야기를 들어 나를 알고 있었으며 현재 제뉴미스트의")
					.addMessage("상황이 좋지 않다며 도움이 필요한 시점이라고 한다. 연구에 관한 자세한 이야기는 제뉴미스트 연구실장 '베딘'에게 들으면 된다고 한다.")
					.addRewardUpdateMap("연구소102호", 4, 29, MapleMap.MAP_PORTAL_STATE)
					.addQuestVisit("베딘").setRewardExp(1500).setPlayerQuestProceed(QuestProceed.CARSON_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(3, 30, "알카드노 비밀 연구실 조사").addMessage("알카드노의 협회장 '카슨'과 다시 이야기를 나누었다. '베딘'과의 의뢰 도중에 엄청난 사실을 발견했고 이에 대해 모두 설명했다.")
					.addMessage("카슨의 말로는 이것이 밝혀 졌다고 해도 섣불리 움직였다가는 놈들이 바로 연구실을 폐기하고 뒷짐 질 것이 뻔하기 때문에 신중하게 ")
					.addMessage("움직여야 한다고 한다. 카슨은 나에게 이에 대한 조사를 부탁하였고 연구에 대한 증거를 확보한뒤 연구실을 폐기 하면 된다고 한다.")
					.addMessage("연구소 비밀번호는 276410이었다. 까먹지 말고 제대로 입력해서 몰래 비밀 연구소로 들어가도록 하자. 알카드노 연구소 C-1구역에서 통로를 찾을 수 있을것이다.")
					.addQuestMaterial("비밀문서", 3).addQuestKill("프랑켄로이드", 1).setRewardExp(30000).setRewardMoney(80000).addRewardItem("휀넬", 1)
					.addRewardItem("엘릭서", 50).setPlayerQuestProceed(QuestProceed.CARSON_QUEST_2);
			player.setQuest(quest);
		}  else if(questNum == 2) {
			quest = Quest.makeQuest(3, 31, "들리는 소문").addMessage("이제 마가티아에서 내가 할일은 끝났다. 그런 도중에 마가티아에서 검은마법사에 대한 소문을 들었다. ")
					.addMessage("리프레와 시간의 신전에서 검은 마법사의 잔당이 나타나고 있다는 소문이다. 뭔가 심상치 않은데.... ")
					.addMessage("일단 리프레로 한번 가보도록 하자. 리프레는 니할 사막 정거장을 통해 갈 수 있다.").addQuestVisit("쿠포")
					.setRewardExp(2000).setPlayerQuestProceed(QuestProceed.CARSON_QUEST_3);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

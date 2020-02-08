package npc;

import map.MapleMap;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class TempleKeeper extends Npc{

	private static final long serialVersionUID = 1L;

	public TempleKeeper(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(5, 2, "힘의 증명 2").addMessage("추억의 길에서 나타나는 신관과 수호대장을 충분히 처리하였다. 이제 문지기 '도도'만 처리하면 후회의 길로가는 문을 열 수 있을것이다.")
					.addQuestKill("도도", 1).addRewardUpdateMap("추억의길2", 10, 36, MapleMap.MAP_PORTAL_STATE)
					.addRewardItem("최상급영웅의비약", 50)
					.addRewardItem("파워엘릭서", 50).setRewardExp(200000).setRewardMoney(400000).setPlayerQuestProceed(QuestProceed.TEMPLEKEPPER_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(5, 3, "힘의 증명 3").addMessage("이제 후회의 길로 가는 문이 열렸다. 이제 망각의 길로 가는 문을 열기 위해 마찬가지로 후회의 신관 30마리와 수호대장 30마리를 처리하자.")
					.addQuestKill("후회의신관", 30).addQuestKill("후회의수호대장", 30).addRewardUpdateMap("후회의길2", 18, 20, MapleMap.MAP_PORTAL_STATE)
					.addRewardItem("파워엘릭서", 50).setRewardExp(200000).setRewardMoney(400000).setPlayerQuestProceed(QuestProceed.TEMPLEKEPPER_QUEST_2);
			player.setQuest(quest);
		} else if(questNum == 2) {
			quest = Quest.makeQuest(5, 4, "힘의 증명 4").addMessage("후회의 길에서 나타나는 신관과 수호대장을 충분히 처리하였다. 이제 문지기 '릴리노흐'만 처리하면 망각의 길로가는 문을 열 수 있을것이다.")
					.addQuestKill("릴리노흐", 1).addRewardUpdateMap("후회의길2", 30, 0, MapleMap.MAP_PORTAL_STATE)
					.addRewardItem("타임리스카이트실드", 1)
					.addRewardItem("파워엘릭서", 50).setRewardExp(200000).setRewardMoney(400000).setPlayerQuestProceed(QuestProceed.TEMPLEKEPPER_QUEST_3);
			player.setQuest(quest);
		} else if(questNum == 3) {
			quest = Quest.makeQuest(5, 5, "힘의 증명 5").addMessage("이제 망각의 길에서 '힘'을 증명하는 일만 남았다. 신들의 황혼으로 통하는 무너진 회랑으로 가기 위해서는 필요한 과정이다.")
					.addMessage("망각의 신관 30마리와 망각의 수호대장 30마리를 처리해 가도록 하자.")
					.addQuestKill("망각의신관", 30).addQuestKill("망각의수호대장", 30).addRewardUpdateMap("망각의길2", 20, 18, MapleMap.MAP_PORTAL_STATE)
					.addRewardItem("파워엘릭서", 50).setRewardExp(200000).setRewardMoney(400000).setPlayerQuestProceed(QuestProceed.TEMPLEKEPPER_QUEST_4);
			player.setQuest(quest);
		} else if(questNum == 4) {
			quest = Quest.makeQuest(5, 6, "힘의 증명 6").addMessage("망각의 길에서 나타나는 신관과 수호대장을 충분히 처리하였다. 이제 문지기 '라이카'만 처리하면 무너진 회랑으로가는 문을 열 수 있을것이다.")
					.addQuestKill("라이카", 1).addRewardUpdateMap("망각의길2", 10, 0, MapleMap.MAP_PORTAL_STATE)
					.addRewardItem("타임리스엑서큐서너스", 1).addRewardItem("타임리스알슈피스", 1).addRewardItem("파워엘릭서", 50).setRewardExp(200000).setRewardMoney(400000).setPlayerQuestProceed(QuestProceed.TEMPLEKEPPER_QUEST_5);
			player.setQuest(quest);
		} else if(questNum == 5) {
			quest = Quest.makeQuest(5, 7, "최후의 결전").addMessage("드디어 결전의 순간이 다가왔다. 검은 마법사가 모든 마력을 사용해 소환한 핑크빈을 처리하면 검은 마법사는 모든 힘을 잃고 영원히 소멸하게")
					.addMessage("될것이다. 잊혀진 황혼에 있는 '잊혀진 신전 관리인'에게 말을 걸면 신들의 황혼으로 가는 문을 열어 줄 거라고 한다.")
					.addRewardNpcQuestProceed("헬레나", NpcList.getInstance().getNpcProcess("헬레나") + 1)
					.addQuestKill("핑크빈", 1).addRewardItem("메이플월드의영웅", 1).setRewardExp(400000).setRewardMoney(800000)
					.setPlayerQuestProceed(QuestProceed.TEMPLEKEPPER_QUEST_6);
			player.setQuest(quest);
		} else if(questNum == 6) {
			quest = Quest.makeQuest(5, 8, "메이플 월드의 평화").addMessage("핑크빈을 물리치고 난이후에 시간의 신전의 시스템이 정상적으로 작동하기 시작했다. 메이플 월드 곳곳에 일어나던 재앙도 사라졌고 메이플 월드에는 평화가 찾아왔다. ")
					.addMessage("앞으로도 더 많은 곳을 모험해 보고싶다는 생각이 든다. 아직 내모험은 끝나지 않았다. -THE END-")
					.setPlayerQuestProceed(QuestProceed.TEMPLEKEPPER_QUEST_7);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

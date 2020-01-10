package npc;

import java.io.Serializable;

import map.MapleMap;
import map.PointMapName;
import map.UpdatedMapInfor;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Mai extends Npc implements Serializable {
	private static final long serialVersionUID = 1L;

	public Mai(String image, String name, PointMapName pointMapName) {
		super(image, name, pointMapName);
	}

	public void requestQuest(Player player) {
		Quest quest = null;
		if (this.questNum == 0) {
			quest = Quest.makeQuest(0, 2, "마이의 첫번쨰 수련").addMessage(
							"슈가와 대화를 끝낸이후 초보자의 숲2에서 초보 수련자 마이와 만났다. 마이는 간단하게 몸풀기로 파란달팽이 5마리를 잡아오라고 한다.")
							.addMessage("첫번째 수련답게 어렵지 않을것같다.").addQuestKill("파란달팽이", 5)
							.setRewardExp(20).setRewardMoney(100).setPlayerQuestProceed(QuestProceed.MAI_QUEST_1);
			player.setQuest(quest);
		} else if (this.questNum == 1) {
			quest = Quest.makeQuest(0, 3, "암허스트").addMessage(
							"첫번째 수련을 마치고 휴식을 취할 시간이다. 초보자의 숲2에서 동쪽으로 가게되 면 암허스트라는 마을이 있는데 이곳에 있으면 될것같다.")
							.addMessage("이후에 마을 동쪽 포탈로 이동하게 되면 달팽이의 숲이 있다고 한다. 마이가 그곳에서 기다린다고 하니 그곳에서 다음 수련을 진행하자.")
							.setRewardExp(10).setPlayerQuestProceed(QuestProceed.MAI_QUEST_2);
		} else if (this.questNum == 2) {
			quest = Quest.makeQuest(0, 4, "마이의 두번째 수련").addMessage(
							"마이의 두번째 수련이 시작되었다. 달팽이의 숲에서 빨간 달팽이 10마리를 잡아와 달라고한다. 이번에도 어렵지 않게 해결할 수 있을것 같다.")
							.addQuestKill("빨간달팽이", 10).setRewardExp(50).setRewardMoney(200)
							.addRewardItem("초보모험가의빨간포션", 20).setPlayerQuestProceed(QuestProceed.MAI_QUEST_3);
		} else if (this.questNum == 3) {
			String itemName = null;
			if (player.getMainAdventurer().getSex().equals("남자")) {
				itemName = "파란색원라인티셔츠(남)";
			} else if (player.getMainAdventurer().getSex().equals("여자")) {
				itemName = "분홍별무늬티셔츠(여)";
			}
			quest = Quest.makeQuest(0, 5, "마이의 마지막 수련").addMessage(
							"마이의 마지막 수련이다. 위험한 숲으로 가서 마노를 잡아와 달라고 한다. 마노는 보스급 몬스터에 해당하므로 이번에는 조금 주의를 기울여서 퀘스트를 진행해야 할것같다.")
							.addQuestKill("마노", 1).setRewardExp(100)
							.setRewardMoney(300).addRewardItem(itemName, 1)
							.setPlayerQuestProceed(QuestProceed.MAI_QUEST_4);
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(14, 6, "달팽이의숲"), MapleMap.MAP_PORTAL_STATE));
		}
		player.setQuest(quest);
	}

	public void clearEvent(Player player) {
		if (clearNum == 0) {
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(3, 8, "초보자의숲2"), MapleMap.MAP_EMPTY_STATE));
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(6, 7, "달팽이의숲"), MapleMap.MAP_NPC_STATE));
			player.addUpdatedNpc(new UpdatedNpcInfor(new PointMapName(6, 7, "달팽이의숲"), "마이"));
			NpcList.getInstance().getNpcWithName("마이").setPointMapName(new PointMapName(6, 7, "달팽이의숲"));
		} else if (clearNum == 3) {
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(5, 14, "달팽이의숲"), MapleMap.MAP_PORTAL_STATE));
		}
	}
}

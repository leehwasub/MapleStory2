package npc;

import map.MapleMap;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Lisa extends Npc{

	private static final long serialVersionUID = 1L;

	public Lisa(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(2, 3, "엘리자 유인").addMessage("엘리자는 사람을 피하는 습성이 있기 때문에 처리 하고 싶다고 만날수 있는 몬스터가 아니라고 한다.")
					.addMessage("그렇기에 주니어 몬스터 급인 루이넬을 처리하여 엘리자가 나타나도록 유인할 수 밖에 없다고 하는데. 이를 위해 하늘계단 2에 서식하는 루이넬을 20마리 정도 처치 하도록 하자.")
					.addQuestKill("루이넬", 20).setRewardExp(1200).setRewardMoney(2400)
					.addRewardUpdateMap("하늘계단2", 8, 39, MapleMap.MAP_PORTAL_STATE)
					.setPlayerQuestProceed(QuestProceed.LISA_QUEST_1);
			player.setQuest(quest);
		} if(questNum == 1) {
			NpcList npcList = NpcList.getInstance();
			quest = Quest.makeQuest(2, 4, "엘리자의 분노").addMessage("루이넬의 개체수가 눈에 띄게 줄어든걸 눈치챈 엘리자는 어둠의 공원에서 더 강력한 마법공격을 준비 한다고 한다.")
					.addMessage("엘리자가 나타났으므로 더 큰일이 벌어지기 전에 엘리자를 처리하는것이 좋겠다.")
					.addQuestKill("엘리자", 1).setRewardExp(1500).setRewardMoney(3000)
					.setPlayerQuestProceed(QuestProceed.LISA_QUEST_2).addRewardNpcQuestProceed("티나", npcList.getNpcProcess("티나") + 1);
			player.setQuest(quest);
		} if(questNum == 2) {
			quest = Quest.makeQuest(2, 5, "보수 작업 준비?").addMessage("엘리자를 처리한이후 몬스터들의 공격으로 훼손된 오르비스탑을 보수하기 위한 작업을 한다는 소식을 들었다.")
					.addMessage("이에 관심이 있다면 티나한테 다시 가보라고 한다.").setRewardExp(200)
					.setPlayerQuestProceed(QuestProceed.LISA_QUEST_3);
			player.setQuest(quest);
		}
	}

}

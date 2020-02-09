package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Trina extends Npc{

	private static final long serialVersionUID = 1L;

	public Trina(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(2, 1, "하늘공원의 몬스터").addMessage("요정족인 티나는 요즘 오르비스에서 몬스터의 출몰이 잦아지고 있다고 한다. 구름공원은 원래 요종족의 놀이터였으나 현재 많은 요정 픽시 몬스터 때문에 위험한 곳이 되어 버렸다는데")
					.addMessage("티나의 부탁대로 하늘공원에서 출몰하는 몬스터를 정리해 주도록 하자.")
					.addQuestKill("스타픽시", 10).addQuestKill("루나픽시", 10).addQuestKill("러스터픽시", 5).setRewardExp(1600).setRewardMoney(3200)
					.addRewardNpcQuestProceed("리사", 1).setPlayerQuestProceed(QuestProceed.TRINA_QUEST_1);
			player.setQuest(quest);
		} if(questNum == 1) {
			quest = Quest.makeQuest(2, 2, "오르비스의 위기").addMessage("하늘공원에 있는 몬스터를 정리했지만 여전히 요정 몬스터의 마법공격으로 인해 오르비스가 위험한 상황이다.")
					.addMessage("이에 대해 자세한 이야기를 듣고싶다면 오르비스에 있는 '리사' NPC를 찾아가 보라고 하는데.").setRewardExp(200)
					.setPlayerQuestProceed(QuestProceed.TRINA_QUEST_2);
			player.setQuest(quest);
		} if(questNum == 2) {
			quest = Quest.makeQuest(2, 6, "오르비스탑 보수작업").addMessage("엘리자를 쓰러트린 이후로 오르비스 곳곳에서 보수작업이 진행중이라고 한다.")
					.addMessage("특히 오르비스탑이 많은 손상을 입었다고한다. 오르비스탑을 보수하기 위해서 많은 재료가 필요하다고 하는데. 오르비스탑에서 출몰하는 스톤볼의 단단한 돌조각을 이용해서 보수작업을 진행할 예정이라고 한다.")
					.addMessage("이를 돕기 위해 스톤볼에게서 돌조각을 15개 구해서 티나에게 가져가도록 하자.").addQuestMaterial("스톤볼의돌조각", 15)
					.setRewardExp(2500).setRewardMoney(30000).addRewardNpcQuestProceed("스카두르", 1)
					.setPlayerQuestProceed(QuestProceed.TRINA_QUEST_3);
			player.setQuest(quest);
		} if(questNum == 3) {
			quest = Quest.makeQuest(2, 7, "엘나스로").addMessage("티나에게 돌조각을 건네주고 난후에 엘나스에 한번 가보는게 어떻겠냐는 말을 들었다.")
					.addMessage("눈으로 뒤덮힌 아름다운 마을이라고 하는데 오르비스에 볼일이 끝나면 한번 가보기로 하였다. 마을 주변에서 몬스터가 출몰 할 수 있으므로 조심하자.").setRewardExp(200)
					.setPlayerQuestProceed(QuestProceed.TRINA_QUEST_4);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

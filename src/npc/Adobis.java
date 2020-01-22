package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Adobis extends Npc{

	private static final long serialVersionUID = 1L;

	public Adobis(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		NpcList npcList = NpcList.getInstance();
		if(questNum == 0) {
			quest = Quest.makeQuest(2, 16, "자쿰 퇴치").addMessage("아도비스에게 재료를 건네주고 자쿰 소환을 위한 절차가 완료되었다. 자쿰의 제단으로 가서 자쿰을 퇴치하도록 하자.")
					.addQuestKill("자쿰", 1).setRewardExp(5000).setRewardMoney(15000)
					.addRewardNpcQuestProceed("알케스터", npcList.getNpcProcess("알케스터") + 1)
					.setPlayerQuestProceed(QuestProceed.ADOBIS_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(2, 17, "자쿰 퇴치후 보고").addMessage("아도비스는 엘나스를 구해준것에 대해 감사를 표하며 이제 알케스터에게 가보라고 한다. 엘나스로 돌아가도록 하자.")
					.setRewardExp(500).setPlayerQuestProceed(QuestProceed.ADOBIS_QUEST_2);
			player.setQuest(quest);
		}
	}

}

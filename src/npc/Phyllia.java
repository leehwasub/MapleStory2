package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Phyllia extends Npc{

	private static final long serialVersionUID = 1L;

	public Phyllia(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 28, "글자 해독 완료").addMessage("'필리아'에게서 해독내용을 들어서 메모해 두었다. 그런데 내용이 뭔가 심상치 않은데... C-1구역으로 연결되는")
					.addMessage("비밀 연구소라... 아마 전에 콘센트와 전선다발을 가져와 달라고 한 퀘스트랑 연관이 있을지도 모른다. 어쨌든 '베딘'을 다시 찾아가보자.")
					.addRewardNpcQuestProceed("카슨", NpcList.getInstance().getNpcProcess("카슨") + 1)
					.addQuestVisit("베딘").setRewardExp(10000).setPlayerQuestProceed(QuestProceed.PHYLLIA_QUEST_1);
			player.setQuest(quest);
		} 
	}

	@Override
	public void normalEvent(Player player) {
	
	}

}

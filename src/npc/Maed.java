package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Maed extends Npc{

	private static final long serialVersionUID = 1L;

	public Maed(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 19, "알카드노의 연구실장 러셀론").addMessage("알카드노의 협회장 '매드'와 이야기를 나누었다. 그는 나에게 알카드노를 도울 생각이 있다면 자기로서는 굉장히 좋은 일이라며")
					.addMessage(" 연구에 관한 이야기는 연구실장 러셀론에게서 들으라고 한다. 알카드노 연구소 중앙게이트로 가보도록 하자.")
					.setRewardExp(1100).addQuestVisit("러셀론").setPlayerQuestProceed(QuestProceed.MAED_QUEST_1);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

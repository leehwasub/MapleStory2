package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Keeny extends Npc{

	private static final long serialVersionUID = 1L;

	public Keeny(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 17, "기초 재료 수집").addMessage("마가티아에서 '키니'와 대화를 나누었다. 그녀는 내가 협회와 이야기를 하기위해 재료를 만들어 줄 수 있다고 한다.")
					.addMessage("플라스크 10개 젤라틴 10개만 있으면 만들 수 있다고 하는데. 모아서 키니에서 가져다 주도록 하자. 플라스크와 젤라틴은 제뉴미스트 연구소 101호에서 출몰하는")
					.addMessage("몬스터에게서 얻을 수 있다.").setRewardExp(20000).setRewardMoney(40000).addRewardItem("연금술사의돌", 1)
					.addRewardNpcQuestProceed("매드", 1).addQuestMaterial("플라스크", 10).addQuestMaterial("젤라틴", 10)
					.setPlayerQuestProceed(QuestProceed.KEENY_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(3, 18, "알카드노 협회로").addMessage("'키니'에게 재료를 가져간후 얼마뒤에 연금술사의 돌이 완성되었다. 이는 장비를 만드는데 중요한 물품이라고 하는데.")
					.addMessage("이것을 알카드노 협회에 가져가 보도록 하자.").addQuestVisit("매드").setRewardExp(1000).addQuestMaterial("연금술사의돌", 1)
					.addRewardNpcQuestProceed("러셀론", 1)
					.setPlayerQuestProceed(QuestProceed.KEENY_QUEST_2);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

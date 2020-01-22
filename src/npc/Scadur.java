package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Scadur extends Npc{

	private static final long serialVersionUID = 1L;

	public Scadur(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(2, 8, "스카두르의 사냥").addMessage("엘나스에 거주중인 스카두르는 요즘 추워진 엘나스의 날씨 탓에 몬스터의 털이 높은 값에 거래되고 있다고 한다.")
					.addMessage("스카두르는 자신의 몬스터 사냥을 도와주면 자신의 이익중 일부를 보상으로 주겠다고 한다. 헥터의 꼬리 10개와 화이트팽의 꼬리를 10개 정도 모아가면 충분 할 것 같다.")
					.addQuestMaterial("헥터의꼬리", 10).addQuestMaterial("화이트팽의꼬리", 10).setRewardExp(2500).setRewardMoney(30000)
					.addRewardNpcQuestProceed("브라보중사", 1).setPlayerQuestProceed(QuestProceed.SCADUR_QUEST_1);
			player.setQuest(quest);
		}
	}

}

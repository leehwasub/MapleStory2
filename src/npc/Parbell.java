package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Parbell extends Npc{

	private static final long serialVersionUID = 1L;

	public Parbell(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 1, "파벨의 농사").addMessage("리스항구 주변 농장에서 농사를 하고 있는 파벨은 요즘 숲에서 나타나는 돼지가 골치 거리라고 한다.")
					.addMessage("돼지 수를 줄이면 농장 피해를 더 줄 일수 있을 것 같다. 리스항구 외각이나 해안가 숲에서 출몰하는 것 같으니 그쪽으로 가보자.")
					.addQuestKill("돼지", 15).setRewardExp(100).setRewardMoney(250).setPlayerQuestProceed(QuestProceed.PARBELL_QUEST_1)
					.addRewardNpcQuestProceed("제인", 1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(1, 2, "대접").addMessage("파벨이 보답을 하고 싶다면서 밥 한 끼 대접해주고 싶다고 한다. 자신의 딸한테 한번 가보라는데.")
					.setRewardExp(20).setPlayerQuestProceed(QuestProceed.PARBELL_QUEST_2);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

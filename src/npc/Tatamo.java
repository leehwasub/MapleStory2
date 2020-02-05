package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Tatamo extends Npc{

	private static final long serialVersionUID = 1L;

	public Tatamo(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(4, 9, "혼테일의 광란").addMessage("촌장 '타타모'를 만나 이야기를 나누었다. 촌장님이 말하길 코스쿠에서도 연락을 받았는데 혼테일의 상태가 이상하다고 한다.")
					.addMessage("코스쿠는 혼테일 동굴 입구에 있다고 하는데... 리프레를 구할 용기가 있다면 코스쿠에게 가보라고 한다. ")
					.addMessage("신중히 생각하자... 혼테일은 리프레에서는 현존 최강의 용족이다. 그것을 잠재울 만한 힘과 용기가 있는지....")
					.addQuestVisit("코스쿠").setRewardExp(5000).setPlayerQuestProceed(QuestProceed.TATAMO_QUEST_1);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

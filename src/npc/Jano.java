package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Jano extends Npc{

	private static final long serialVersionUID = 1L;

	public Jano(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 9, "아리안트 마을의 위기").addMessage("아리안트 마을에 있는 빈집에서 모래 그림단의 단장 '자노'를 만났다.")
					.addMessage("그는 내가 아리안트 마을에 왔을때부터 모래그림단 일원들이 나의 힘을 시험해 왔고 여기까지 오도록 만들었다는 사실에 대해 밝혔다.")
					.addMessage("그리고 왕녀를 끌어내리고 아리안트 마을을 살리는것을 도와주면 백만 메소를 보상으로 줄것을 약속 한다고 한다.")
					.addMessage("만약 관심이 있다면 아리안트 마을에 있는 '시린'에게 가서 자세한 이야기를 들을 수 있다고 하는데.")
					.setRewardExp(500).setPlayerQuestProceed(QuestProceed.JANO_QUEST_1);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

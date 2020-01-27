package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Blackbull extends Npc{

	private static final long serialVersionUID = 1L;

	public Blackbull(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 5, "엑스텀프 사냥").addMessage("전사로 전직한 이후 페리온 에서'돼지와 함께 춤을'을 만났다.")
					.addMessage("그는 나에게 전사로 전직을 했지만 강력한 힘을 가지기 위해서는 많은 수련이 필요하다는데. 수련의 일환으로 엑스텀프를 15마리 정도 잡아와 달라고한다.")
					.addMessage("엑스컴프는 페리온 동쪽 골목에서 만날 수 있다.")
					.addQuestKill("엑스텀프", 15).setRewardExp(250).setRewardMoney(400).setPlayerQuestProceed(QuestProceed.BLACKBULL_QUEST_1)
					.addRewardNpcQuestProceed("만지", 1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(1, 6, "만지").addMessage("수련을 마친이후 '돼지와 함께 춤을'이 말하길 페리온 동쪽 길목에 있는 '만지'를 만나보라고 한다.")
					.addMessage("'만지'는 페리온 동쪽 골목에서 만날 수 있다.").setRewardExp(50).setPlayerQuestProceed(QuestProceed.BLACKBULL_QUEST_2);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

package npc;

import map.MapleMap;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Jiyur extends Npc{

	private static final long serialVersionUID = 1L;

	public Jiyur(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 2, "울고있는 아이").addMessage("바이런과 대화한 이후 근처에서 어떤 아이가 울고 있는 것을 발견했다.")
					.addMessage("잘은 모르겠지만 아리안트 궁전에 언니가 끌려갔다고 하는데. 한번 아리안트 궁전으로 가보도록 하자.").setRewardExp(300)
					.addRewardNpcQuestProceed("세잔", 1).setPlayerQuestProceed(QuestProceed.JIYUR_QUEST_1);
			player.setQuest(quest);
		}
	}

}

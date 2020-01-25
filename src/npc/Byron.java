package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Byron extends Npc{

	private static final long serialVersionUID = 1L;

	public Byron(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			NpcList.getInstance().setNpcProcess("지유르", 2);
			quest = Quest.makeQuest(3, 1, "여행자 바이런").addMessage("아리안트에서 바이런을 만났다. 바이런은 아리안트의 곳곳을 돌아다니며 여행을 하는 중인데 이것만으론 뭔가 부족한 느낌이 든다고 한다.")
					.addMessage("혹시나 무언가 정보를 얻게되면 알려주도록 하자. 그나저나 주변에 어떤아이가 우는 소리가 들린다. 무슨일인지 한번 가보도록 하자.").setRewardExp(300)
					.addRewardNpcQuestProceed("티건", 1).setPlayerQuestProceed(QuestProceed.BYRON_QUEST_1);
			player.setQuest(quest);
		}
	}

}

package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Tigun extends Npc{

	private static final long serialVersionUID = 1L;

	public Tigun(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 3, "출입 거부").addMessage("궁전 경비병 티건의 말로는 아리안트 궁전에 출입하기 위해서는 아리안트 궁전 출입증이 있어야 된다고 한다.")
					.addMessage("어떻게 하면 출입증을 구할 수 있을까? 아리안트 마을에 있는 사람들에게 말을 걸어보자.").setRewardExp(400)
					.setPlayerQuestProceed(QuestProceed.TIGUN_QUEST_1);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

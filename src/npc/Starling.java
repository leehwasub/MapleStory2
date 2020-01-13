package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Starling extends Npc{

	private static final long serialVersionUID = 1L;

	public Starling(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 14, "에레고스 처치 준비").addMessage("폐쇄 구역에서 '세릴'을 만났다. 에릴의 말에 의하면 에레고스를 처치하기 위해서는 샤레니안 궁전에 가야하고 에레고스를 봉인하고 있는 샤레니안 궁전의 결계를")
					.addMessage("부수지 않고 들어가기 위해서는 마법 포탈을 만들 필요가 있다고 한다. 에릴은 마법사가 아니기때문에 재료가 있어야 마법포탈을 만들 수 있다고 하는데. 마법 포탈을 만들기 위해 폐쇄 구역과 군영에서 나오는 몬스터들의 재료를 모아가면 될것같다.")
					.addQuestMaterial("갈비뼈", 10).addQuestMaterial("골반뼈", 10).addQuestMaterial("말머리뼈", 5).setRewardExp(500).setRewardMoney(1200)
					.setPlayerQuestProceed(QuestProceed.STARLING_QUEST_1);
			player.setQuest(quest);
		}
	}

}

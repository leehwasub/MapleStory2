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
			quest = Quest.makeQuest(3, 17, "sdffsd").addMessage("마가티아에서 '한'이라는 자와 대화를 나누었다. 그는 마가티아에서 브로커로서 활동하고 있다고 한다.")
					.addMessage("그는 마가티아 주변 사막에서 출몰하는 스콜피온때문에 많은 사람들이 피해를 입고 있다며 스콜피온을 처리해 준다면")
					.addMessage("마가티아에 대한 정보를 알려주겠다고 한다. 그리고 금모래 가루를 가져와 주면 좋은 아이템도 줄거라고 하는데. 세상에 공짜는 없는법. 스콜피온을 20마리 처리하고")
					.addMessage("금모래가루를 5개 구해가도록 하자. 금모래가루는 모래거인에게서 얻을 수 있다.").setRewardExp(10000).setRewardMoney(20000)
					.addRewardNpcQuestProceed("키니", 2).addQuestKill("스콜피온", 20).addQuestMaterial("금모래가루", 5).addRewardItem("3차스킬북", 1)
					.setPlayerQuestProceed(QuestProceed.HANBROKER_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

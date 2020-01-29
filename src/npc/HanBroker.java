package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class HanBroker extends Npc{

	private static final long serialVersionUID = 1L;

	public HanBroker(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 15, "마가티아에 대한 정보").addMessage("마가티아에서 '한'이라는 자와 대화를 나누었다. 그는 마가티아에서 브로커로서 활동하고 있다고 한다.")
					.addMessage("그는 마가티아 주변 사막에서 출몰하는 스콜피온때문에 많은 사람들이 피해를 입고 있다며 스콜피온을 처리해 준다면")
					.addMessage("마가티아에 대한 정보를 알려주겠다고 한다. 그리고 금모래 가루를 가져와 주면 좋은 아이템도 줄거라고 하는데. 세상에 공짜는 없는법. 스콜피온을 20마리 처리하고")
					.addMessage("금모래가루를 5개 구해가도록 하자. 금모래가루는 모래거인에게서 얻을 수 있다.").setRewardExp(10000).setRewardMoney(20000)
					.addRewardNpcQuestProceed("키니", 1).addQuestKill("스콜피온", 20).addQuestMaterial("금모래가루", 5).addRewardItem("3차스킬북", 1)
					.setPlayerQuestProceed(QuestProceed.HANBROKER_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(3, 16, "천재 연금술사 키니").addMessage("한에게서 마가티아에 대해 많은 이야기를 들었다. 마가티아는 연금술로 유명하며 이를 집중적으로 연구하는 협회 2개가 존재한다고")
					.addMessage("한다. 그 협회에서 무언가 공적을 내면 좋은 장비나 무기를 얻을 수 있으며 칭호까지 받을 수 있다고 한다.")
					.addMessage("하지만 협회에서 이야기를 진행하려면 연금술과 관련된 무언가가 있어야 된다고하는데. 이것은 마가티아에 있는 '키니'와 대화를")
					.addMessage("해보라는 이야기를 들었다. '키니'를 한번 찾아 보도록 하자.").setRewardExp(700)
					.addQuestVisit("키니").setPlayerQuestProceed(QuestProceed.HANBROKER_QUEST_2);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

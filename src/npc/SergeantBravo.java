package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class SergeantBravo extends Npc{

	private static final long serialVersionUID = 1L;

	public SergeantBravo(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			NpcList.getInstance().setNpcProcess("숨겨진바위", 1);
			quest = Quest.makeQuest(2, 9, "엘나스 조사단").addMessage("엘나스 주변에서 날씨가 추워지는 원인을 조사하던 브라보 중사는 위험한 골짜기에서 이상한 기운이 느껴지는 것을 발견했다고 한다.")
					.addMessage("하지만 날씨가 매우 춥고 주변에는 흉폭한 예티가 많이 출몰하기 때문에 조사하기가 굉장히 어려운 상황이라고 한다. 거기다가 몇명의 조사단은 조사중에 행방불명된 상태라 조사에 많은 난항을 겪고 있다고 하는데")
					.addMessage("브라보 중사는 위험한 골짜기에서 무언가 단서를 발견하게 된다면 자신에게 알려달라고 한다. 혹시 발견하게 된것이 있다면 알려 주도록 하자.").addQuestVisit("숨겨진바위")
					.setRewardExp(2200).addRewardNpcQuestProceed("알케스터", 1).setPlayerQuestProceed(QuestProceed.SERGEANTBRAVO_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(2, 10, "브라보 중사의 부탁").addMessage("위험한 골짜기에 있는 바위에서 이상한 아이템을 발견하여 브라보 중사에게 가져다 주었다. 뭔가 심상치 않는 아이템인것 같은데.")
					.addMessage("브라보 중사의 부탁대로 위험한 골짜기에서 얻은 아이템을 알케스터에게 가져다 주도록 하자.").setRewardExp(250)
					.setPlayerQuestProceed(QuestProceed.SERGEANTBRAVO_QUEST_2);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

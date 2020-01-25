package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Sejan extends Npc{

	private static final long serialVersionUID = 1L;

	public Sejan(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 4, "모래토끼 사냥").addMessage("여러 사람에서 말을 걸어 보았으나 별다른 대답을 들을 수 없었다. 그런 와중에 '세잔'이라는 사람과 대화를 하였다.")
					.addMessage("그는 아리안트 마을을 위해 모래토끼를 처리해온다면 출입증을 구하는데에 협력하겠다고 한다.")
					.addMessage("모래토끼는 아리안트 마을 동쪽 부근에서 볼 수 있다고 하는데. 한번 가보도록 하자.")
					.addQuestKill("노란모래토끼", 10).addQuestKill("갈색모래토끼", 10)
					.setRewardExp(7500).setRewardMoney(16000).addRewardNpcQuestProceed("아딘", 1)
					.setPlayerQuestProceed(QuestProceed.SEJAN_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(3, 5, "세잔의 제안").addMessage("모래토끼를 처리한 이후 본격적인 이야기를 세잔에게서 들었다. 세잔은 궁전 출입증을 얻기위해 아리안트 마을에서 어떠한")
					.addMessage("공로를 인정받는다면 출입증을 얻을 수 있다고 한다. 최근 아리안트 마을 주변에서 '데우'라는 몬스터가 다시 출몰하기 시작했는데 관광객이나 마을 사람들에게 많은 피해를 준다고 한다.")
					.addMessage("이 몬스터를 처리하면 쉽게 출입증을 얻을 수 있을 거라고 한다. 또한 '붉은 구슬'을 얻게되면 더욱 강력한 힘도 덤으로 얻을 수 있다고 하는데.")
					.addMessage("그전에 데우를 처리하기 위한 사막 몬스터와의 전투 경험과 이에 대한 수련이 필요하다고 한다.")
					.addMessage("이에 대해서는 선인장 사막에 있는 '아딘'에게 가보라고 한다. 수련을 받을 준비가 되었으면 가보도록 하자.")
					.setRewardExp(400).setPlayerQuestProceed(QuestProceed.SEJAN_QUEST_2);
			player.setQuest(quest);
		}
	}

}

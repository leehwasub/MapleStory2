package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Russellon extends Npc{

	private static final long serialVersionUID = 1L;

	public Russellon(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 20, "강철 재료 수집").addMessage("알카드노의 연구실장 '러셀론'과 이야기를 나누었다. 그는 최근에 알카드노가 연구에 가장 힘든점은 단단한 재료들을 다루는 것")
					.addMessage("이라고 한다. 강철, 미스릴로된 재료들은 자력으로 해체하여 연금술에 활용하기가 어렵다고 하는데. 하지만 이들은 연금술 연구에")
					.addMessage("많은 도움이 되기때문에 알카드노를 위해 필요한 작업이라고 한다. 강철 파편 10개, 강철 파편 강화형 10개를 구해 가도록 하자.")
					.addQuestMaterial("강철파편", 10).addQuestMaterial("강철파편강화형", 10)
					.setRewardExp(27000).setRewardMoney(60000).setPlayerQuestProceed(QuestProceed.RUSSELLON_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(3, 21, "미스릴 재료 수집").addMessage("강철 파편을 모두 모아가자 러셀론은 연금술 개발에 도움이 될거라며 기뻐했다. 다음으로는 미스릴 파편을 모아가도록 하자.")
					.addQuestMaterial("미스릴파편", 10).addQuestMaterial("미스릴파편강화형", 10)
					.setRewardExp(29000).setRewardMoney(65000).setPlayerQuestProceed(QuestProceed.RUSSELLON_QUEST_2);
			player.setQuest(quest);
		} else if(questNum == 2) {
			quest = Quest.makeQuest(3, 22, "비밀 연구 재료 수집").addMessage("미스릴 파편까지 전부 모아서 러셀론에게 가져다 주었다. 이번에는 마지막으로 자신들의 비밀 프로젝트를 위해")
					.addMessage("로이드에게서 전선 다발 15개와 네오 휴로이드에게서 콘센트 10개를 가져다 달라고 한다.")
					.addQuestMaterial("전선다발", 15).addQuestMaterial("콘센트", 10).addRewardNpcQuestProceed("카슨", 1)
					.setRewardExp(32000).setRewardMoney(70000).addRewardItem("네오스", 1)
					.setPlayerQuestProceed(QuestProceed.RUSSELLON_QUEST_3);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Tylus extends Npc{

	private static final long serialVersionUID = 1L;

	public Tylus(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(2, 13, "타일러스의 시험").addMessage("타일러스에게 검은 마법사가 소환한 '자쿰'이라는 몬스터에 대해 이야기를 들었다.")
					.addMessage("엘나스를 구하고 싶다면 일단 자신의 힘을 증명해 보라고 한다. 늑대의 영역에서 라이칸스로프를 20마리 처리하고 그증거로 라이칸스로프의 발톱 10개를 가져오라고 한다. 라이칸스로프는 매우 사나운 늑대 몬스터이기 때문에 주의하자.")
					.addQuestKill("라이칸스로프", 20).addQuestMaterial("라이칸스로프의발톱", 10).setRewardExp(3000).setRewardMoney(7500).addRewardNpcQuestProceed("제프", 1)
					.setPlayerQuestProceed(QuestProceed.TYLUS_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(2, 14, "늑대의 영역으로").addMessage("타일러스는 나의 힘을 인정하고 정말로 생각이 있다면 늑대의 영역에 있는 제프에게 가보라고 한다.")
					.addMessage("그는 시련의 동굴 앞에서 사람의 출입을 막는 출입 통제관이라고 한다. 한번 가보도록 하자.").addRewardNpcQuestProceed("아도비스", 1)
					.setRewardExp(300).setPlayerQuestProceed(QuestProceed.TYLUS_QUEST_2);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

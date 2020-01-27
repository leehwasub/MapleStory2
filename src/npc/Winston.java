package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Winston extends Npc{

	private static final long serialVersionUID = 1L;

	public Winston(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 12, "발굴지 몬스터 정리").addMessage("우드마스크에서 발견된 물질에 대해 설명하자 윈스턴씨는 이 이야기를 듣고 놀라는 기색을 보이며 세릴에게 이사실을 전해주고 오겠다고 한다.")
					.addMessage("그리고 이주변에서 몬스터가 많이 나타나서 유적발굴은 커녕 움직이기도 위험한 상황이라는데. 일단 발굴 지역 주변의 몬스터 개체수를 줄여야 한다. 발굴 중단 지역에서 스켈독 10마리, 머미독 10마리를 잡아가자.")
					.addQuestKill("스켈독", 10).addQuestKill("머미독", 10).setRewardExp(450).setRewardMoney(800).setPlayerQuestProceed(QuestProceed.WINSTON_QUEST_1)
					.addRewardNpcQuestProceed("세릴", 1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(1, 13, "세릴에게로").addMessage("발굴 캠프장 주변에 몬스터를 정리한 이후 윈스턴과 에레고스 퇴치에 관한 이야기를 했다.")
					.addMessage("에레고스의 부활은 점점 가까워 지고 있고 완전히 부활 되었을때는 수백년전과 똑같은 전쟁이 벌어질거라고 하는데. 에레고스 퇴치에대해 관심이 있다면 세릴을 찾아가 보라고 한다. 세릴은 폐쇄구역에서 만날수 있다.")
					.setRewardExp(50).setPlayerQuestProceed(QuestProceed.WINSTON_QUEST_2);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

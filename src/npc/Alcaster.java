package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Alcaster extends Npc{

	private static final long serialVersionUID = 1L;

	public Alcaster(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(2, 11, "예티 사냥").addMessage("위험한 골짜기에서 얻은 아이템을 본 알케스터는 검은 마법사 조직이 사용한 마법의 잔재라는것을 알고 사태의 심각성을 깨닫는다.")
					.addMessage("하지만 아직 정확한 정보를 알지 못하기 때문에 섣불리 움직일 수 없는 상황이라고 한다.")
					.addMessage("알케스터는 위험한 골짜기의 조사를 위해서 예티의 수를 줄여달라고 부탁했다. 예티와 다크예티를 15마리 정도 사냥 하면 될것같다.")
					.addQuestKill("예티", 15).addQuestKill("다크예티", 15)
					.setRewardExp(3000).setRewardMoney(7500).addRewardNpcQuestProceed("타일러스", 1)
					.setPlayerQuestProceed(QuestProceed.ALCASTER_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(2, 12, "엘나스의 용사 타일러스").addMessage("알케스터는 예티의 수를 줄여준것에 대해 감사를 표했고 이에 관련된 일은 검은 마법사가 관련되어 있을 가능성이 확실하다고 한다.")
					.addMessage("알케스터는 메이플 월드를 구할 용기가 있다면 타일러스에게 가보라고 한다. 지금 검은 마법사를 견제하지 않으면 나중에는 손쓸 도리가 없는 상황이 발생 할 수도있다고 하는데.")
					.setRewardExp(300).setPlayerQuestProceed(QuestProceed.ALCASTER_QUEST_2);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

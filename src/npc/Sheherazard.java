package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Sheherazard extends Npc{

	private static final long serialVersionUID = 1L;

	public Sheherazard(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 12, "스카이롬을 찾아서").addMessage("아리안트 궁전에 있는 왕녀 '세헤라자드'와 대화를 나누었다. 그녀에게 이때까지 아리안트에서 어떤일이 있었는지 설명했다.")
					.addMessage("그녀의 말로는 스카이롬이 있는방은 최근에 많은 경비병들이 있어 확보하기 어려울 수도 있다고 한다.")
					.addMessage("하지만 여기서 뒷걸음질 칠수는 없고 반드시 스카이롬을 사수해야한다. 이나라의 백성들과 임무에 따른 보상을 위해서.")
					.addRewardNpcQuestProceed("자노", NpcList.getInstance().getNpcProcess("자노") + 1)
					.addQuestMaterial("스카이롬", 1).setRewardExp(5000).setPlayerQuestProceed(QuestProceed.SHEHERAZARD_QUEST_1);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

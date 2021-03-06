package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Manji extends Npc{

	private static final long serialVersionUID = 1L;

	public Manji(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 7, "만지의 시험 1").addMessage("페리온 동쪽골목에 있는 만지와 만났다. 그는 페리온의 역사에대해 설명하며 현재 지금 현재 에레고스가 부활할 징조가 나타나고 있다고 한다.")
					.addMessage("만약 에레고스 퇴치와 샤레니안에 관해서 흥미가 있다면 먼저 파이어 보어 15마리를 잡아서 힘을 증명하라고 한다. 파이어보어는 와일드 땅1에서 만날 수 있다.").addQuestKill("파이어보어", 15)
					.setRewardExp(600).setRewardMoney(1200).addRewardItem("하얀포션", 50).setPlayerQuestProceed(QuestProceed.MANJI_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(1, 8, "만지의 시험 2").addMessage("첫번째 시험을 끝낸이후 이번에는 와일드 보어의땅 2에가서 아이언 호그와 아이언 보어를 각각 10마리를 잡아와라고한다.")
					.addMessage("놈들이 입고있는 강력한 갑옷을 조심하자.").addQuestKill("아이언호그", 10).addQuestKill("아이언보어", 10)
					.setRewardExp(600).setRewardMoney(1200).addRewardItem("일룬", 1).setPlayerQuestProceed(QuestProceed.MANJI_QUEST_2)
					.addRewardNpcQuestProceed("주먹펴고일어서", NpcList.getInstance().getNpcProcess("주먹펴고일어서") + 1);
			player.setQuest(quest);
		} else if(questNum == 2) {
			quest = Quest.makeQuest(1, 9, "더 강한 힘을 위해").addMessage("마지막 시험이 끝난이후 현재 상태로는 아무래도 에레고스를 상대하기는 힘드니 일단 2차전직을 위해 주먹펴고 일어서를 찾아가 보라고한다.")
					.addQuestVisit("주먹펴고일어서").setRewardExp(50).setPlayerQuestProceed(QuestProceed.MANJI_QUEST_3);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

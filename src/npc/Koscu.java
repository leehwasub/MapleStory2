package npc;

import map.MapleMap;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Koscu extends Npc{

	private static final long serialVersionUID = 1L;

	public Koscu(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(4, 10, "혼테일 약화").addMessage("혼테일동굴 입구에 있는 '코스쿠'와 대화를 나누었다. 그는 혼테일을 처치하기 위해서는 일단 혼테일에게 힘을 주고 있는 주변의 용족들을 처리하여 ")
					.addMessage("혼테일을 약화시킬 필요가 있다고한다. 주변에 있는 용족 몬스터를 어느정도 사냥한후 다시 코스쿠를 찾아가도록 하자.")
					.addQuestKill("블루와이번", 15).addQuestKill("레드와이번", 15).addQuestKill("다크와이번", 15)
					.addRewardItem("파워엘릭서", 50).addRewardUpdateMap("혼테일동굴입구", 5, 0, MapleMap.MAP_PORTAL_STATE)
					.setRewardExp(80000).setRewardMoney(160000).setPlayerQuestProceed(QuestProceed.KOSCU_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(4, 11, "혼테일과의 전투").addMessage("촌장님의 말대로 지금 이 근방에서 혼테일의 울음소리가 계속해서 들린다. 엄청난 지진과 함께 하늘이 어두워지고있다.")
					.addMessage("코스쿠는 혼테일을 진정시키는건 아주 어려울것이라고 했다. 하지만 이대로 혼테일을 놔두면 리프레가 어떻게 될지는 뻔하다.")
					.addMessage("혼테일의 동굴로 들어가서 혼테일을 진정시키도록 하자.")
					.addQuestKill("혼테일", 1).setRewardExp(100000).setRewardMoney(200000).setPlayerQuestProceed(QuestProceed.KOSCU_QUEST_2);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

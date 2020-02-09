package npc;

import map.MapleMap;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Starling extends Npc{

	private static final long serialVersionUID = 1L;

	public Starling(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 14, "에레고스 처치 준비").addMessage("폐쇄 구역에서 '세릴'을 만났다. 에릴의 말에 의하면 에레고스를 처치하기 위해서는 샤레니안 궁전에 가야하고 에레고스를 봉인하고 있는 샤레니안 궁전의 결계를")
					.addMessage("부수지 않고 들어가기 위해서는 마법 포탈을 만들 필요가 있다고 한다. 에릴은 마법사가 아니기때문에 재료가 있어야 마법포탈을 만들 수 있다고 하는데. 마법 포탈을 만들기 위해 폐쇄 구역과 군영에서 나오는 몬스터들의 재료를 모아가면 될것같다.")
					.addQuestMaterial("갈비뼈", 10).addQuestMaterial("골반뼈", 10).addQuestMaterial("말머리뼈", 5).setRewardExp(1200).setRewardMoney(2400)
					.addRewardUpdateMap("폐쇄구역", 0, 24, MapleMap.MAP_PORTAL_STATE).addRewardItem("장어구이", 50)
					.setPlayerQuestProceed(QuestProceed.STARLING_QUEST_1);
			player.setQuest(quest);
		} if(questNum == 1) {
			NpcList npclist = NpcList.getInstance();
			quest = Quest.makeQuest(1, 15, "에레고스 처치").addMessage("세릴이 재료를 사용하여 마법 포탈을 만들었고 샤레니안 왕성으로 들어갈 준비는 끝났다. 왕성으로 들어가기 전에 빼먹은 것이 없는지")
					.addMessage("확실히 확인하고 들어가도록 하자.").addQuestKill("에레고스", 1).setRewardExp(1500).setRewardMoney(3000)
					.addRewardNpcQuestProceed("슈앵", npclist.getNpcProcess("슈앵") + 1).addRewardNpcQuestProceed("윈스턴", npclist.getNpcProcess("윈스턴") + 1)
					.addRewardNpcQuestProceed("주먹펴고일어서", npclist.getNpcProcess("주먹펴고일어서") + 1)
					.setPlayerQuestProceed(QuestProceed.STARLING_QUEST_2);
			player.setQuest(quest);
		} if(questNum == 2) {
			quest = Quest.makeQuest(1, 16, "에레고스 처치 보고").addMessage("에레고스 처치를 완료하고 세릴을 찾아갔다. 세릴은 에레고스를 처치한 사실에 놀라며 윈스턴씨에게 알리고 오겠다고 한다. 덕분에 유물 발굴단 작업이 다시 진행 될 것 이라는데")
					.addMessage("이쪽은 에레고스를 처치한 것 에대해 '주먹 펴고 일어서'에게 전해 주도록 하자.").setRewardExp(100)
					.setPlayerQuestProceed(QuestProceed.STARLING_QUEST_3);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

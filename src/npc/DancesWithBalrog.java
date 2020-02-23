package npc;

import character.Adventurer;
import character.AdventurerFactory;
import item.ItemPool;
import map.MapleMap;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class DancesWithBalrog extends Npc{

	private static final long serialVersionUID = 1L;

	public DancesWithBalrog(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		if(clearNum == 0) {
			Adventurer adventurer = player.getMainAdventurer();
			AdventurerFactory.upgradeAdventurer("검사", adventurer);
			adventurer.setCareer("검사");
			adventurer.setCareerLevel(1);
			player.addItem(ItemPool.getItem("카알대검", 1));
			if(adventurer.getSex().equals("남자")) {
				player.addItem(ItemPool.getItem("로리카아머(남)", 1));
				player.addItem(ItemPool.getItem("로리카바지(남)", 1));
			}else if(adventurer.getSex().equals("여자")) {
				player.addItem(ItemPool.getItem("스퀘이머(여)", 1));
				player.addItem(ItemPool.getItem("소피아바지(여)", 1));
			}
			player.addItem(ItemPool.getItem("주황포션", 50));
			player.addItem(ItemPool.getItem("초보모험가의파란포션", 50));
			player.addMoney(5000);
			player.calState();
		}
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 4, "전사 전직").addMessage("전사로 전직하기 위해 페리온에서 주먹펴고 일어서를 만났다.")
					.addMessage("그는 전사로 전직하기 위해서는 힘35 래벨 10이상이 되어야 한다고 한다. 조건이 충족되었는지 확인한후 다시 찾아가 말을 걸어보자.")
					.addQuestStatus(35, 0, 0, 0).setRewardExp(10).setPlayerQuestProceed(QuestProceed.DANCESWITHBALROG_QUEST_1)
					.addQuestLevel(10).addRewardNpcQuestProceed("돼지와함께춤을", 1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(1, 10, "2차 전직").addMessage("2차전직을 하기위해 '주먹펴고 일어서'를 만났다. 그는 에레고스를 처리하기 위해서는 더강한 힘이 필요하다고 한다.")
					.addMessage("2차전직을 위해서는 래벨 20이상 힘 60이상 그리고 래벨20까지의 모든 스킬포인트를 사용해야 한다고 한다. 조건이 충족되는지 확인한후 다시 찾아가 보자.")
					.addQuestSpendAllSkillPoint(20).addQuestStatus(60, 0, 0, 0).setPlayerQuestProceed(QuestProceed.DANCESWITHBALROG_QUEST_2)
					.addQuestLevel(20).addRewardNpcQuestProceed("열마리의부기", 1);
			player.setQuest(quest);
		}  else if(questNum == 2) {
			quest = Quest.makeQuest(1, 11, "유물발굴단").addMessage("2차전직을 완료했다. 이제 유물발굴단 일원중 한명인 '열마리의부기'에게 가서 현재 발굴지에서 일어나고 있는 상황에 대해서 들을수 있다고한다. ")
					.addMessage("에레고스가 언제 부활할지 모르는 상황이므로 최대한 빨리 가보도록 하자.").setRewardExp(70)
					.addQuestVisit("열마리의부기").setPlayerQuestProceed(QuestProceed.DANCESWITHBALROG_QUEST_3);
			player.setQuest(quest);
		}  else if(questNum == 3) {
			NpcList.getInstance().setNpcProcess("이얀", 1);
			quest = Quest.makeQuest(1, 19, "대륙이동").addMessage("2차 전직을 완료 하였다. '주먹 펴고 일어서'는 이제 더큰 세계로 모험을 떠나는 것이 좋을것이라고 한다.")
					.addMessage("대륙 이동에 대해서는 '이얀'에게 물어보면 된다고 하는데. 곧바로 가보도록 하자.").addRewardUpdateMap("리스항구", 0, 0, MapleMap.MAP_PORTAL_STATE)
					.setRewardExp(100).setPlayerQuestProceed(QuestProceed.DANCESWITHBALROG_QUEST_4);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

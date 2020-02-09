package npc;

import character.Adventurer;
import character.AdventurerFactory;
import item.ItemPool;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class TenBoogies extends Npc{

	private static final long serialVersionUID = 1L;

	public TenBoogies(String imageUrl, String name, PointMapName pointMapName) {
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
			player.calState();
		}
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(1, 10, "우드마스크 조사").addMessage("페리온에서 유물 발굴단의 일원인 '열 마리의 부기를'만났다. 그녀는 최근 페리온 주변에서 마스크를 쓰고 다니는 이상한 몬스터가 발견 되고 있다고 한다.")
					.addMessage("이 몬스터들을 잡아서 표본을 조사해야 원인이 되는 실마리를 찾을수 있을것 같다는데.").addQuestKill("우드마스크", 15)
					.setRewardExp(600).setRewardMoney(1200).setPlayerQuestProceed(QuestProceed.TENBOOGIES_QUEST_1)
					.addRewardNpcQuestProceed("윈스턴", 1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(1, 11, "유적 발굴 캠프장").addMessage("'열마리의 부기'는 우드마스크에서 발견된 물질에 대해서 유적 발굴 캠프단에게 알려야 한다고 한다.")
					.addMessage("유적 발굴 캠프장에 있는 윈스턴씨에게 이사실을 전해 주면 될것같다. 가는길에 몬스터를 만날수 있으므로 조심하자.").setRewardExp(50).setPlayerQuestProceed(QuestProceed.TENBOOGIES_QUEST_2);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

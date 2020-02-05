package npc;

import item.ItemPool;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Sirin extends Npc{

	private static final long serialVersionUID = 1L;

	public Sirin(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			player.addItem(ItemPool.getItem("가짜스카이롬", 1));
			player.addItem(ItemPool.getItem("궁전출입자격증", 1));
			quest = Quest.makeQuest(3, 10, "스카이롬").addMessage("아리안트 마을에 있는 빈집에서 모래 그림단의 단원중 한명인'시린'을 만났다.")
					.addMessage("그녀에게서 스카이롬에 대해 이때까지 모래그림단이 얻은 정보와 스카이롬을 얻을 수 있는 방법에 대해 자세한 설명을 들었다.")
					.addMessage("왕녀에게 친한척 대화를 나눈후 주변에서 스카이롬으로 가는 열쇠에 대한 정보를 얻어야 한다고 한다.")
					.addMessage("대화 이후 그녀에게서 궁전 통행증과 가짜 스카이롬을 받았다. 준비가 되었다면 궁전으로 가서 작전을 개시하도록 하자.")
					.addRewardNpcQuestProceed("세헤라자드", 1)
					.addQuestVisit("아레다").setRewardExp(12000).setRewardMoney(25000).setPlayerQuestProceed(QuestProceed.SIRIN_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(3, 13, "스카이롬 임무 완료").addMessage("스카이롬을 '시린'에게 무사히 건넨이후 자노에게 다시 가보라고한다.")
					.addMessage("빈집에 있는 자노에게 가보도록하자.").addQuestVisit("자노").addRewardNpcQuestProceed("바이런", NpcList.getInstance().getNpcProcess("바이런") + 1)
					.addRewardItem("블레이즈캡슐", 20)
					.setRewardExp(20000).setRewardMoney(1000000).setPlayerQuestProceed(QuestProceed.SIRIN_QUEST_2);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Kupo extends Npc{

	private static final long serialVersionUID = 1L;

	public Kupo(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(4, 1, "방어 무기 제작 1").addMessage("리프레에 도착한 이후 제일먼저 '쿠포'와 만났다. 검은 마법사의 활동 재개로 현재 리프레 뿐만 아니라 메이플 월드 전체가 긴장 상태라고 한다.")
					.addMessage("자신은 리프레의 마을을 지키기 위해 전투원을 위한 방어구를 만드는 중인데 그것을 위한 재료를 구해줄 수 없겠냐는 부탁을 했다.")
					.addMessage("방어구의 보온성을 높이기위해 레쉬와 다크레쉬의 털뭉치가 필요하다고 한다. 쿠포의 방어구 제작을 도와주도록 하자.")
					.addQuestMaterial("레쉬의털뭉치", 10).addQuestMaterial("다크레쉬의털뭉치", 10)
					.setRewardExp(40000).setRewardMoney(80000).setPlayerQuestProceed(QuestProceed.KUPO_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(4, 2, "방어 무기 제작 2").addMessage("'쿠포'는 털뭉치를 받은이후 방어구의 틀을 제작하기 위해 단단한 재료가 필요하다고 한다.")
					.addMessage("리프레 동쪽숲에서 서식하는 비틀에게서 뿔을 얻을 수 있는데 이뿔이 단단해서 재료로 적합하다고 한다. 비틀의 뿔 10개 듀얼 비틀의 뿔 10개를 가져다 주도록 하자.")
					.addQuestMaterial("비틀의뿔", 10).addQuestMaterial("듀얼비틀의뿔", 10)
					.setRewardExp(44000).setRewardMoney(90000).setPlayerQuestProceed(QuestProceed.KUPO_QUEST_2);
			player.setQuest(quest);
		}  else if(questNum == 2) {
			quest = Quest.makeQuest(4, 3, "방어 무기 제작 3").addMessage("마지막으로 방어구에 속성 내성을 강화하기 위해 수속성,화속성 몬스터인 요정몬스터를 처리하고 전리품을 가져와 달라고 한다.")
					.addMessage("하프의꼬리깃털 10개와 블러드하프의머리관 10개를 가져다 주도록 하자.")
					.addQuestMaterial("하프의꼬리깃털", 10).addQuestMaterial("블러드하프의머리관", 10).addRewardNpcQuestProceed("데임", 1)
					.setRewardExp(50000).setRewardMoney(100000).setPlayerQuestProceed(QuestProceed.KUPO_QUEST_3);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Dame extends Npc{

	private static final long serialVersionUID = 1L;

	public Dame(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(4, 4, "용의 협곡으로 1").addMessage("리프레 주변에서 검은마법사 잔당 퇴치 임무를 수행중이던 '데임'을 만났다. 그는 용의 협곡에서 수상한 마법사가 ")
					.addMessage("발견되었다는 소문을 듣고 임무 수행을 위해 리프레로 파견왔다고 한다. 하지만 용의 협곡으로 가기위해 그 길에 있는 몬스터를 혼자 처리하기엔 너무 많고 몬스터들이 강력하다고 한다.")
					.addMessage("데임이 임무를 원활하게 수행하기 위해 버크 15마리 듀얼 버크 15마리를 처리해 주도록 하자.")
					.addQuestKill("버크", 15).addQuestKill("듀얼버크", 15).addRewardItem("코카콜라제로알약", 10)
					.setRewardExp(50000).setRewardMoney(100000).setPlayerQuestProceed(QuestProceed.DAME_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(4, 5, "용의 협곡으로 2").addMessage("버크를 처리한이후 '데임'은 이제 용의 숲 입구까지는 비전투 요원까지 데리고 와서 조사를 할 수 있을 거라고 한다. ")
					.addMessage("하지만 용의 협곡으로 가는길에는 용의 숲이 있는데 거기서 엄청나게 강력한 드래곤 터틀이 다수 출몰한다고 한다.")
					.addMessage("용의 협곡으로 가기위해 이번에는 숲에서 출몰하는 블루 드래곤 터틀과 레드 드래곤 터틀을 각각 20마리를 처리하도록 하자.")
					.addQuestKill("블루드래곤터틀", 20).addQuestKill("레드드래곤터틀", 20).addRewardItem("파워엘릭서", 30)
					.addRewardNpcQuestProceed("수상한마법사", 1)
					.setRewardExp(55000).setRewardMoney(110000).setPlayerQuestProceed(QuestProceed.DAME_QUEST_2);
			player.setQuest(quest);
		}  else if(questNum == 2) {
			quest = Quest.makeQuest(4, 6, "용의 협곡 조사").addMessage("이제 몬스터를 어느정도 정리했으니 용의 협곡까지 가서 본격적인 조사를 시작 할 수 있을것이다. ")
					.addMessage("용의협곡에서 어떤 단서를 발견하거나 수상한 마법사를 발견하면 바로 처리하거나 '데임'에게 알려주도록 하자.").addQuestVisit("수상한마법사")
					.setRewardExp(5000).setPlayerQuestProceed(QuestProceed.DAME_QUEST_3);
			player.setQuest(quest);
		} else if(questNum == 3) {
			quest = Quest.makeQuest(4, 8, "리프레 촌장에게로").addMessage("'데임'에게 의문의 마법사를 만난 사실을 전했으나 상당히 놀란")
					.addMessage("눈치였고 이상황에서 어떻게 하면 좋을지 감을 못잡고 있는듯하다. 일단 데임의 말대로 이사실을 촌장님에게 전하도록 하자.")
					.addRewardNpcQuestProceed("코스쿠", 1).addQuestVisit("타타모").setRewardExp(5000).setPlayerQuestProceed(QuestProceed.DAME_QUEST_4);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

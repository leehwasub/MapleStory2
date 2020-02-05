package npc;

import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class MysteriousMagic extends Npc{

	private static final long serialVersionUID = 1L;

	public MysteriousMagic(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(4, 7, "의문의 마법사 사건 보고").addMessage("용의 협곡에서 '의문의 마법사'를 만났지만 그는 이상한 말만을 남기고 사라졌다.")
					.addMessage("혼테일이 광란상태에 빠지고 리프레를 혼란에 빠르린다라... '데임'에게 이사실을 전해주도록 하자.").addRewardNpcQuestProceed("타타모", 1)
					.addQuestVisit("데임").setRewardExp(25000).setPlayerQuestProceed(QuestProceed.MYSTERIOUSMAGIC_QUEST_1);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		
	}

}

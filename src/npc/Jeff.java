package npc;

import map.MapleMap;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Jeff extends Npc{

	private static final long serialVersionUID = 1L;

	public Jeff(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(2, 15, "자쿰 소환을 위한 준비").addMessage("출입 통제관 제프를 만나 자쿰 소환 절차에 대한 이야기를 나누었다.")
					.addMessage("타일러스의 말대로 자쿰을 소환하기 위해서는 재료가 필요하다. 시련의 동굴 안에서 몬스터를 처리하여 재료를 얻도록 하자. 불독의 뿔 10개와 파이어독의 목걸이 10개 정도면 충분하다고 한다.")
					.addRewardUpdateMap("자쿰의제단입구", 3, 13, MapleMap.MAP_PORTAL_STATE).addRewardItem("쭈쭈바", 50)
					.addQuestMaterial("불독의송곳니", 10).addQuestMaterial("파이어독의목걸이", 10).setRewardExp(4000).setRewardMoney(8000).setPlayerQuestProceed(QuestProceed.JEFF_QUEST_1);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
		// TODO Auto-generated method stub
		
	}

}

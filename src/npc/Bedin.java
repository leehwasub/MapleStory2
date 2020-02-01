package npc;

import map.MapleMap;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Bedin extends Npc{

	private static final long serialVersionUID = 1L;

	public Bedin(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		Quest quest = null;
		if(questNum == 0) {
			quest = Quest.makeQuest(3, 25, "돌연변이 몬스터 처리").addMessage("알카드노의 연구실장 '베딘'과 이야기를 나누었다. 그는 제뉴미스트 연구소의 현재 가장큰 문제점은 실험으로 생겨난 돌연변이 몬스터라고 한다.")
					.addMessage("일단 102호에 있는 '루루모'를 처리해 달라고 한다. 보스급 몬스터 이기 때문에 만반의 준비를 갖추고 가도록 하자.").addRewardItem("살살녹는치즈", 50)
					.addQuestKill("루루모", 1).setRewardExp(30000).setRewardMoney(70000).setPlayerQuestProceed(QuestProceed.BEDIN_QUEST_1);
			player.setQuest(quest);
		} else if(questNum == 1) {
			quest = Quest.makeQuest(3, 26, "연구실의 유령").addMessage("돌연변이 몬스터를 처리한이후 다시 베딘을 찾아갔다. 베딘의 말로는 요즘 제뉴미스트 연구실에서 유령이 나타난다는 소문이 돈다고 한다.")
					.addMessage("옛날 제뉴미스트 연구소에서 알 수 없는 사고로 사망한 연구원의 유령이라는 소문이다. 일단 연구실을 돌아다니면서 단서를 찾아 보도록 하자.")
					.addMessage("그리고 5월의 이슬도 5개정도 구해서 가져가도록 하자. 오늘 실험에 쓸 재료로 필요하다고 한다.")
					.addQuestMaterial("출입증", 10).addQuestMaterial("5월의이슬", 5).setRewardExp(35000).setRewardMoney(80000)
					.addRewardNpcQuestProceed("필리아", 1).addRewardItem("마나엘릭서", 50)
					.setPlayerQuestProceed(QuestProceed.BEDIN_QUEST_2);
			player.setQuest(quest);
		} else if(questNum == 2) {
			quest = Quest.makeQuest(3, 27, "글자 해독").addMessage("연구실에서 유령이 나타나는 연구실을 찾아냈다. 그 유령에게서 몇개의 출입증을 얻어내는데에 성공했다.")
					.addMessage("하지만 그 출입증에는 베딘도 알 수 없는 글자가 새겨져 있어서 읽을 수가 없다고 하는데. 이를 해독하기 위해서 마가티아 마을에 있는 '필리아'를 찾아가 보도록 하자.")
					.addQuestVisit("필리아").setRewardExp(2000).setPlayerQuestProceed(QuestProceed.BEDIN_QUEST_3);
			player.setQuest(quest);
		} else if(questNum == 3) {
			quest = Quest.makeQuest(3, 29, "제뉴미스트 협회장으로의 보고").addMessage("출입증의 내용을 보고 놀란 '베딘'은 놀람을 감추지 못하며 이 사실을 협회장에게 알려야 한다고 말했다.")
					.addMessage("연금술의 역사에 기록될지도 모르는 중대 사건이라고 하는데... 일단 협회장님에게 가보도록 하자.").addRewardUpdateMap("C-1구역", 4, 29, MapleMap.MAP_PORTAL_STATE)
					.addQuestVisit("카슨").setRewardExp(2000).setPlayerQuestProceed(QuestProceed.BEDIN_QUEST_4);
			player.setQuest(quest);
		}
	}

	@Override
	public void normalEvent(Player player) {
	
	}

}

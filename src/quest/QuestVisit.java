package quest;

import maplestory.Player;

public class QuestVisit extends QuestCondition {
	
	private static final long serialVersionUID = 1L;
	
	private String npcName;

	public QuestVisit(String npcName) {
		this.npcName = npcName;
	}

	public boolean checkClear(Player player) {
		return player.isVisited(npcName);
	}

	public String checkState(Player player) {
		return npcName + " : " + (player.isVisited(npcName) ? "방문" : "미방문");
	}
	
}
package quest;

import maplestory.Player;

public class QuestVisit extends QuestCondition {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private boolean isVisited;

	public QuestVisit(String name) {
		this.name = name;
	}

	public boolean checkClear(Player player) {
		return this.isVisited;
	}

	public String checkState(Player player) {
		return null;
	}
}
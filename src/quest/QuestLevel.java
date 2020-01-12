package quest;

import java.io.Serializable;

import character.Status;
import maplestory.Player;

public class QuestLevel extends QuestCondition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int level;

	public QuestLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean checkClear(Player player) {
		int playerLevel = player.getMainAdventurer().getStrength().getLevel();
		return (playerLevel >= level);
	}

	public String checkState(Player player) {
		int playerLevel = player.getMainAdventurer().getStrength().getLevel();
		return "LEVEL : " + playerLevel + " / " + level;
	}
}
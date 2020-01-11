package quest;

import java.io.Serializable;

import maplestory.Player;

public abstract class QuestCondition implements Serializable {
	private static final long serialVersionUID = 1L;

	public abstract String checkState(Player player);
	public abstract boolean checkClear(Player player);
}

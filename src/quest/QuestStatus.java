package quest;

import java.io.Serializable;

import character.Status;
import maplestory.Player;

public class QuestStatus extends QuestCondition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Status status;

	public QuestStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean checkClear(Player player) {
		Status playerStatus = player.getMainAdventurer().getStatus();
		return (playerStatus.getStr() >= status.getStr() && playerStatus.getDex() >= status.getDex() && 
				playerStatus.getInt() >= status.getInt() && playerStatus.getLuk() >= status.getLuk()); 
	}

	public String checkState(Player player) {
		StringBuffer ret = new StringBuffer();
		Status playerStatus = player.getMainAdventurer().getStatus();
		if(status.getStr() != 0) {
			ret.append("STR : " + playerStatus.getStr() + " / " + status.getStr());
		}
		if(status.getDex() != 0) {
			if(ret.length() != 0) ret.append("\n");
			ret.append("DEX : " + playerStatus.getDex() + " / " + status.getDex());
		}
		if(status.getInt() != 0) {
			if(ret.length() != 0) ret.append("\n");
			ret.append("INT : " + playerStatus.getInt() + " / " + status.getInt());
		}
		if(status.getLuk() != 0) {
			if(ret.length() != 0) ret.append("\n");
			ret.append("LUK : " + playerStatus.getLuk() + " / " + status.getLuk());
		}
		return ret.toString();
	}
}
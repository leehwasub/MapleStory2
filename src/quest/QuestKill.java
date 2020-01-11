package quest;

import java.io.Serializable;

import maplestory.Main;
import maplestory.Player;

public class QuestKill extends QuestCondition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String monsterName;
	int num;

	public QuestKill(String monsterName, int num) {
		this.monsterName = monsterName;
		this.num = num;
		if(Main.QUEST_TEST) {
			this.num /= 10;
		}
	}

	public String getMonsterName() {
		return this.monsterName;
	}

	public int getNum() {
		return this.num;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean checkClear(Player player) {
		return player.isKilledEnough(this.monsterName, this.num);
	}

	public String checkState(Player player) {
		return this.monsterName + " : " + player.getKillNum(this.monsterName) + " / " + this.num;
	}
}
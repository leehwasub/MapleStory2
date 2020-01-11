package quest;

import java.io.Serializable;

import maplestory.Main;
import maplestory.Player;

public class QuestMaterial extends QuestCondition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String materialName;
	int num;

	public QuestMaterial(String materialName, int num) {
		this.materialName = materialName;
		this.num = num;
		if(Main.QUEST_TEST) {
			this.num /= 10;
		}
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public int getNum() {
		return this.num;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String checkState(Player player) {
		return this.materialName + " : " + player.getMaterialItemNum(materialName) + " / " + this.num;
	}

	@Override
	public boolean checkClear(Player player) {
		return player.getMaterialItemNum(materialName) >= this.num;
	}
	
	
}

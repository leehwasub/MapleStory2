package quest;

import java.io.Serializable;

import maplestory.Player;

public class QuestMaterial extends QuestCondition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String materialName;
	int num;

	public QuestMaterial(String materialName, int num) {
		this.materialName = materialName;
		this.num = num;
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
	public String checkState(Player paramPlayer) {
		return null;
	}

	@Override
	public boolean checkClear(Player paramPlayer) {
		return false;
	}
	
	
}

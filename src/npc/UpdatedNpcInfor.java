package npc;

import java.io.Serializable;

import map.PointMapName;

public class UpdatedNpcInfor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private PointMapName pointMapName;
	private String npcName;
	
	public UpdatedNpcInfor(PointMapName pointMapName, String npcName) {
		this.pointMapName = pointMapName;
		this.npcName = npcName;
	}

	public PointMapName getPointMapName() {
		return pointMapName;
	}

	public String getNpcName() {
		return npcName;
	}

	public void setPointMapName(PointMapName pointMapName) {
		this.pointMapName = pointMapName;
	}

	public void setNpcName(String npcName) {
		this.npcName = npcName;
	}

	@Override
	public String toString() {
		return "UpdatedNpcInfor [pointMapName=" + pointMapName + ", npcName=" + npcName + "]";
	}

}

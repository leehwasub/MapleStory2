package map;

import java.io.Serializable;

public class UpdatedMapInfor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private PointMapName pointMapName;
	private int afterState;
	
	public UpdatedMapInfor(PointMapName pointMapName, int afterState) {
		this.pointMapName = pointMapName;
		this.afterState = afterState;
	}

	public PointMapName getPointMapName() {
		return pointMapName;
	}

	public int getAfterState() {
		return afterState;
	}

	public void setPointMapName(PointMapName pointMapName) {
		this.pointMapName = pointMapName;
	}

	public void setAfterState(int afterState) {
		this.afterState = afterState;
	}

}

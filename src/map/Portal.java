package map;

import java.io.Serializable;

public class Portal implements Serializable {
	private static final long serialVersionUID = 1L;
	PointMapName nowMapInfor;
	PointMapName nextMapInfor;

	public Portal(PointMapName nowMapInfor, PointMapName nextMapInfor) {
		this.nowMapInfor = nowMapInfor;
		this.nextMapInfor = nextMapInfor;
	}

	public PointMapName getNowMapInfor() {
		return this.nowMapInfor;
	}

	public PointMapName getNextMapInfor() {
		return this.nextMapInfor;
	}

	public void setNowMapInfor(PointMapName nowMapInfor) {
		this.nowMapInfor = nowMapInfor;
	}

	public void setNextMapInfor(PointMapName nextMapInfor) {
		this.nextMapInfor = nextMapInfor;
	}
}

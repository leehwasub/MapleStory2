package map;

import java.io.Serializable;

public class PointMapName implements Serializable {
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	String mapName;

	public PointMapName(int x, int y, String mapName) {
		this.x = x;
		this.y = y;
		this.mapName = mapName;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setXYMapName(int x, int y, String mapName) {
		this.x = x;
		this.y = y;
		this.mapName = mapName;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getMapName() {
		return this.mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public boolean equals(Object obj) {
		PointMapName other = (PointMapName) obj;
		if ((this.mapName.equals(other.getMapName())) && (this.x == other.getX()) && (this.y == other.getY())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "PointMapName [x=" + x + ", y=" + y + ", mapName=" + mapName + "]";
	}
	
}

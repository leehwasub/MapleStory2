package character;

import java.io.Serializable;
import java.util.ArrayList;

public class Status implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	int str;
	int dex;
	int Int;
	int luk;

	public Status(int str, int dex, int Int, int luk) {
		this.str = str;
		this.dex = dex;
		this.Int = Int;
		this.luk = luk;
	}
	
	public ArrayList<String> getStatusItemInfor() {
		ArrayList<String> ret = new ArrayList<String>();
		if (this.str != 0) {
			ret.add("STR +" + this.str);
		}if (this.dex != 0) {
			ret.add("DEX +" + this.dex);
		} if (this.Int != 0) {
			ret.add("INT +" + this.Int);
		} if (this.luk != 0) {
			ret.add("LUK +" + this.luk);
		}
		return ret;
	}

	public int getStr() {
		return this.str;
	}

	public int getDex() {
		return this.dex;
	}

	public int getInt() {
		return this.Int;
	}

	public int getLuk() {
		return this.luk;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public void setInt(int i) {
		this.Int = i;
	}

	public void setLuk(int luk) {
		this.luk = luk;
	}

	public void addStr() {
		this.str += 1;
	}

	public void addDex() {
		this.dex += 1;
	}

	public void addInt() {
		this.Int += 1;
	}

	public void addLuk() {
		this.luk += 1;
	}
	
	public void addStr(int str) {
		this.str += str;
	}

	public void addDex(int dex) {
		this.dex += dex;
	}

	public void addInt(int Int) {
		this.Int += Int;
	}

	public void addLuk(int luk) {
		this.luk += luk;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}

package character;

import java.io.Serializable;
import java.util.ArrayList;

public class Resistance implements Serializable {
	private static final long serialVersionUID = 1L;
	int fire;
	int ice;
	int posion;
	int thunder;
	int dark;
	int holy;

	public Resistance(int fire, int ice, int posion, int thunder, int dark, int holy) {
		this.fire = fire;
		this.ice = ice;
		this.posion = posion;
		this.thunder = thunder;
		this.dark = dark;
		this.holy = holy;
	}

	public ArrayList<String> getResistenceItemInfor() {
		ArrayList<String> ret = new ArrayList<String>();
		if (this.fire != 0) {
			ret.add("불 저항 +" + this.fire);
		} if (this.ice != 0) {
			ret.add("암흑 저항 +" + this.ice);
		} if (this.posion != 0) {
			ret.add("독 저항 +" + this.posion);
		} if (this.thunder != 0) {
			ret.add("번개 저항 +" + this.thunder);
		} if (this.dark != 0) {
			ret.add("암흑 저항 +" + this.dark);
		} if (this.holy != 0) {
			ret.add("성 저항 +" + this.holy);
		}
		return ret;
	}

	public int getFire() {
		return this.fire;
	}

	public int getIce() {
		return this.ice;
	}

	public int getPosion() {
		return this.posion;
	}

	public int getThunder() {
		return this.thunder;
	}

	public int getDark() {
		return this.dark;
	}

	public int getHoly() {
		return this.holy;
	}

	public void setFire(int fire) {
		this.fire = fire;
	}

	public void setIce(int ice) {
		this.ice = ice;
	}

	public void setPosion(int posion) {
		this.posion = posion;
	}

	public void setThunder(int thunder) {
		this.thunder = thunder;
	}

	public void setDark(int dark) {
		this.dark = dark;
	}

	public void setHoly(int holy) {
		this.holy = holy;
	}

	public String toString() {
		return "Resistance [fire=" + this.fire + ", ice=" + this.ice + ", posion=" + this.posion + ", thunder="
				+ this.thunder + ", dark=" + this.dark + ", holy=" + this.holy + "]";
	}
}

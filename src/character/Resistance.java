package character;

import java.io.Serializable;
import java.util.ArrayList;

import buff.Buffable;

public class Resistance implements Serializable, Cloneable, Buffable {
	private static final long serialVersionUID = 1L;
	private int fire;
	private int ice;
	private int posion;
	private int thunder;
	private int dark;
	private int holy;
	
	public Resistance() {
		this.fire = 0;
		this.ice = 0;
		this.posion = 0;
		this.thunder = 0;
		this.dark = 0;
		this.holy = 0;
	}

	/**
	 * 
	 * @param fire 불 저항
	 * @param ice 얼음 저항
	 * @param posion 독 저항
	 * @param thunder 번개 저항
	 * @param dark 어둠 저항
	 * @param holy 성 저항
	 */
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
	
	public void addFire(int fire) {
		this.fire += fire;
	}

	public void addIce(int ice) {
		this.ice += ice;
	}

	public void addPosion(int posion) {
		this.posion += posion;
	}

	public void addThunder(int thunder) {
		this.thunder += thunder;
	}

	public void addDark(int dark) {
		this.dark += dark;
	}
	
	public void addHoly(int holy) {
		this.holy += holy;
	}
	
	
	public void addAllResistance(int resistance) {
		this.fire += resistance;
		this.ice += resistance;
		this.posion += resistance;
		this.thunder += resistance;
		this.dark += resistance;
		this.holy += resistance;
	}
	
	public void subAllResistance(int resistance) {
		this.fire -= resistance;
		this.ice -= resistance;
		this.posion -= resistance;
		this.thunder -= resistance;
		this.dark -= resistance;
		this.holy -= resistance;
	}

	public void resetResistence() {
		this.fire = 100;
		this.ice = 100;
		this.posion = 100;
		this.thunder = 100;
		this.dark = 100;
		this.holy = 100;
	}
	
	public boolean isOverlapEffect(Buffable buffable) {
		Resistance resistance = (Resistance)buffable;
		if(this.fire > 0 && resistance.fire > 0) return true;
		if(this.ice > 0 && resistance.ice > 0) return true;
		if(this.posion > 0 && resistance.posion > 0) return true;
		if(this.thunder > 0 && resistance.thunder > 0) return true;
		if(this.dark > 0 && resistance.dark > 0) return true;
		if(this.holy > 0 && resistance.holy > 0) return true;
		return false;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String toString() {
		return "Resistance [fire=" + this.fire + ", ice=" + this.ice + ", posion=" + this.posion + ", thunder="
				+ this.thunder + ", dark=" + this.dark + ", holy=" + this.holy + "]";
	}
	
}

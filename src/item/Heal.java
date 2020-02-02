package item;

import java.io.Serializable;
import java.util.ArrayList;

public class Heal implements Serializable {
	private static final long serialVersionUID = 1L;
	private int healHp;
	private int healMp;
	private int healPercentHp;
	private int healPercentMp;
	
	public Heal(int healHp, int healMp) {
		this.healHp = healHp;
		this.healMp = healMp;
	}

	public Heal(int healHp, int healMp, int healPercentHp, int healPercentMp) {
		this.healHp = healHp;
		this.healMp = healMp;
		this.healPercentHp = healPercentHp;
		this.healPercentMp = healPercentMp;
	}

	public ArrayList<String> getStrengthItemInfor() {
		ArrayList<String> ret = new ArrayList<String>();
		if (this.healHp != 0) {
			ret.add("HP +" + this.healHp + " 회복");
		} if (this.healMp != 0) {
			ret.add("MP +" + this.healMp + " 회복");
		} if (this.healPercentHp != 0) {
			ret.add("HP " + this.healPercentHp + "% 회복");
		} if (this.healPercentMp != 0) {
			ret.add("MP " + this.healPercentMp + "% 회복");
		}
		return ret;
	}

	public int getHealHp() {
		return this.healHp;
	}

	public int getHealMp() {
		return this.healMp;
	}

	public int getHealPercentHp() {
		return this.healPercentHp;
	}

	public int getHealPercentMp() {
		return this.healPercentMp;
	}

	public void setHealHp(int healHp) {
		this.healHp = healHp;
	}

	public void setHealMp(int healMp) {
		this.healMp = healMp;
	}

	public void setHealPercentHp(int healPercentHp) {
		this.healPercentHp = healPercentHp;
	}

	public void setHealPercentMp(int healPercentMp) {
		this.healPercentMp = healPercentMp;
	}

	public String toString() {
		return "Heal [healHp=" + this.healHp + ", healMp=" + this.healMp + ", healPercentHp=" + this.healPercentHp
				+ ", healPercentMp=" + this.healPercentMp + "]";
	}
}

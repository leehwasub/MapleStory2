package character;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author Leehwasub
 *
 */
public class Strength implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private Resistance resistance;
	private int level;
	private int maxHp;
	private int maxMp;
	private int physicalDamage;
	private int magicDamage;
	private int physicalDefense;
	private int magicDefense;
	private int accuracyRate;
	private int evasionRate;
	private int criticalRate;

	/**
	 * 
	 * @param resistance 저항력
	 * @param level 래벨
	 * @param maxHp 최대체력
	 * @param maxMp 최대마법력
	 * @param physicalDamage 물리공격력
	 * @param magicDamage 마법공격력
	 * @param physicalDefense 물리방어력
	 * @param magicDefense 마법방어력
	 * @param accuracyRate 적중률
	 * @param evasionRate 회피율
	 * @param criticalRate 크리티컬확률
	 */
	public Strength(Resistance resistance, int level, int maxHp, int maxMp, int physicalDamage, int magicDamage,
			int physicalDefense, int magicDefense, int accuracyRate, int evasionRate, int criticalRate) {
		this.resistance = resistance;
		this.level = level;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
		this.physicalDamage = physicalDamage;
		this.magicDamage = magicDamage;
		this.physicalDefense = physicalDefense;
		this.magicDefense = magicDefense;
		this.accuracyRate = accuracyRate;
		this.evasionRate = evasionRate;
		this.criticalRate = criticalRate;
	}

	/**
	 * 
	 * @return 
	 */
	public ArrayList<String> getStrengthItemInfor() {
		ArrayList<String> ret = this.resistance.getResistenceItemInfor();
		if (this.maxHp != 0) {
			ret.add("최대 HP +" + this.maxHp);
		}if (this.maxMp != 0) {
			ret.add("최대 MP +" + this.maxMp);
		} if (this.physicalDamage != 0) {
			ret.add("물리 공격력 +" + this.physicalDamage);
		} if (this.magicDamage != 0) {
			ret.add("마법 공격력 +" + this.magicDamage);
		} if (this.physicalDefense != 0) {
			ret.add("물리 방어력 +" + this.physicalDefense);
		} if (this.magicDefense != 0) {
			ret.add("마법 방어력 +" + this.magicDefense);
		} if (this.accuracyRate != 0) {
			ret.add("적중률 +" + this.accuracyRate);
		} if (this.evasionRate != 0) {
			ret.add("회피율 +" + this.evasionRate);
		} if(this.criticalRate != 0) {
			ret.add("크리티컬 확률 +" + this.evasionRate+"%");
		}
		return ret;
	}

	public Strength() {
		this.resistance = new Resistance(100, 100, 100, 100, 100, 100);
		this.maxHp = 15;
		this.maxMp = 4;
	}

	public Resistance getResistance() {
		return this.resistance;
	}

	public int getLevel() {
		return this.level;
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public int getMaxMp() {
		return this.maxMp;
	}

	public int getPhysicalDamage() {
		return this.physicalDamage;
	}

	public int getMagicDamage() {
		return this.magicDamage;
	}

	public int getPhysicalDefense() {
		return this.physicalDefense;
	}

	public int getMagicDefense() {
		return this.magicDefense;
	}

	public int getAccuracyRate() {
		return this.accuracyRate;
	}

	public int getEvasionRate() {
		return this.evasionRate;
	}

	public void setResistance(Resistance resistance) {
		this.resistance = resistance;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	public void setPhysicalDamage(int physicalDamage) {
		this.physicalDamage = physicalDamage;
	}

	public void setMagicDamage(int magicDamage) {
		this.magicDamage = magicDamage;
	}

	public void setPhysicalDefense(int physicalDefense) {
		this.physicalDefense = physicalDefense;
	}

	public void setMagicDefense(int magicDefense) {
		this.magicDefense = magicDefense;
	}

	public void setAccuracyRate(int accuracyRate) {
		this.accuracyRate = accuracyRate;
	}

	public void setEvasionRate(int evasionRate) {
		this.evasionRate = evasionRate;
	}

	public void addPhysicalDamage(int physicalDamage) {
		this.physicalDamage += physicalDamage;
	}

	public void addMagicDamage(int magicDamage) {
		this.magicDamage += magicDamage;
	}

	public void addPhysicalDefense(int physicalDefense) {
		this.physicalDefense += physicalDefense;
	}

	public void addMagicDefense(int magicDefense) {
		this.magicDefense += magicDefense;
	}

	public void addAccuracyRate(int accuracyRate) {
		this.accuracyRate += accuracyRate;
	}

	public void addEvasionRate(int evasionRate) {
		this.evasionRate += evasionRate;
	}
	
	public void addCriticalRate(int criticalRate) {
		this.criticalRate = criticalRate;
	}

	public void levelUp() {
		this.level += 1;
	}

	public void addMaxHp(int maxHp) {
		this.maxHp += maxHp;
	}

	public void addMaxMp(int maxMp) {
		this.maxMp += maxMp;
	}

	public int getCriticalRate() {
		return criticalRate;
	}

	public void setCriticalRate(int criticalRate) {
		this.criticalRate = criticalRate;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Strength strength = (Strength)super.clone();
		strength.setResistance((Resistance)resistance.clone());
		return super.clone();
	}

	@Override
	public String toString() {
		return "Strength [resistance=" + resistance + ", level=" + level + ", maxHp=" + maxHp + ", maxMp=" + maxMp
				+ ", physicalDamage=" + physicalDamage + ", magicDamage=" + magicDamage + ", physicalDefense="
				+ physicalDefense + ", magicDefense=" + magicDefense + ", accuracyRate=" + accuracyRate
				+ ", evasionRate=" + evasionRate + ", criticalRate=" + criticalRate + "]";
	}
	
}

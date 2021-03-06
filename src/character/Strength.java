package character;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import buff.Buffable;
/**
 * 
 * @author Leehwasub
 *
 */
public class Strength implements Serializable, Cloneable, Buffable {
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
	
	private int physicalDefenseRate;
	private int magicDefenseRate;

	/**
	 *  플레이어 생성 or 플레이어 버프
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
	 * 몬스터 버프 생성용
	 * @param resistance
	 * @param level
	 * @param maxHp
	 * @param maxMp
	 * @param physicalDamage
	 * @param magicDamage
	 * @param physicalDefenseRate
	 * @param magicDefenseRate
	 * @param accuracyRate
	 * @param evasionRate
	 */
	public Strength(Resistance resistance, int level, int maxHp, int maxMp, int physicalDamage, int magicDamage,
			int physicalDefenseRate, int magicDefenseRate, int accuracyRate, int evasionRate) {
		this.resistance = resistance;
		this.level = level;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
		this.physicalDamage = physicalDamage;
		this.magicDamage = magicDamage;
		this.physicalDefenseRate = physicalDefenseRate;
		this.magicDefenseRate = magicDefenseRate;
		this.accuracyRate = accuracyRate;
		this.evasionRate = evasionRate;
	}
	
	
	/**
	 *  몬스터 생성용 constructor
	 * @param resistance
	 * @param level
	 * @param maxHp
	 * @param maxMp
	 * @param physicalDefenseRate
	 * @param magicDefenceRate
	 * @param accuracyRate
	 * @param evasionRate
	 */
	public Strength(Resistance resistance, int level, int maxHp, int maxMp, int physicalDefenseRate, int magicDefenseRate, int accuracyRate, int evasionRate) {
		this.resistance = resistance;
		this.level = level;
		this.maxHp = maxHp;
		this.maxMp = maxMp;
		this.physicalDefenseRate = physicalDefenseRate;
		this.magicDefenseRate = magicDefenseRate;
		this.accuracyRate = accuracyRate;
		this.evasionRate = evasionRate;
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
			ret.add("크리티컬 확률 +" + this.criticalRate+"%");
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
		this.physicalDamage = Math.max(0, this.physicalDamage + physicalDamage);
	}

	public void addMagicDamage(int magicDamage) {
		this.magicDamage = Math.max(0, this.magicDamage + magicDamage);
	}

	public void addPhysicalDefense(int physicalDefense) {
		this.physicalDefense = Math.max(0, this.physicalDefense + physicalDefense);
	}

	public void addMagicDefense(int magicDefense) {
		this.magicDefense = Math.max(0, this.magicDefense + magicDefense);
	}

	public void addAccuracyRate(int accuracyRate) {
		this.accuracyRate = Math.max(0, this.accuracyRate + accuracyRate);
	}

	public void addEvasionRate(int evasionRate) {
		this.evasionRate = Math.max(0, this.evasionRate + evasionRate);
	}
	
	public void addCriticalRate(int criticalRate) {
		this.criticalRate = Math.max(0, this.criticalRate + criticalRate);
	}
	
	public void addPhysicalDefenseRate(int physicalDefenseRate) {
		this.physicalDefenseRate = Math.max(0, this.physicalDefenseRate + physicalDefenseRate);
	}
	
	public void addMagicDefenseRate(int magicDefenseRate) {
		this.magicDefenseRate = Math.max(0, this.magicDefenseRate + magicDefenseRate);
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

	public int getPhysicalDefenseRate() {
		return physicalDefenseRate;
	}

	public int getMagicDefenseRate() {
		return magicDefenseRate;
	}

	public void setPhysicalDefenseRate(int physicalDefenseRate) {
		this.physicalDefenseRate = physicalDefenseRate;
	}

	public void setMagicDefenseRate(int magicDefenseRate) {
		this.magicDefenseRate = magicDefenseRate;
	}

	@Override
	public boolean isOverlapEffect(Buffable buffable) {
		Strength strength = (Strength)buffable;
		if(level > 0 && strength.level > 0) return true;
		if(maxHp > 0 && strength.maxHp > 0) return true;
		if(maxMp > 0 && strength.maxMp > 0) return true;
		if(physicalDamage > 0 && strength.physicalDamage > 0) return true;
		if(magicDamage > 0 && strength.magicDamage > 0) return true;
		if(physicalDefense > 0 && strength.physicalDefense > 0) return true;
		if(magicDefense > 0 && strength.magicDefense > 0) return true;
		if(accuracyRate > 0 && strength.accuracyRate > 0) return true;
		if(evasionRate > 0 && strength.evasionRate > 0) return true;
		if(criticalRate > 0 && strength.criticalRate > 0) return true;
		if(physicalDefenseRate > 0 && strength.physicalDefenseRate > 0) return true;
		if(magicDefenseRate > 0 && strength.magicDefenseRate > 0) return true;
		return resistance.isOverlapEffect(strength.resistance);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Strength strength = (Strength)super.clone();
		strength.setResistance((Resistance)resistance.clone());
		return strength;
	}

	@Override
	public String toString() {
		return "Strength [resistance=" + resistance + ", level=" + level + ", maxHp=" + maxHp + ", maxMp=" + maxMp
				+ ", physicalDamage=" + physicalDamage + ", magicDamage=" + magicDamage + ", physicalDefense="
				+ physicalDefense + ", magicDefense=" + magicDefense + ", accuracyRate=" + accuracyRate
				+ ", evasionRate=" + evasionRate + ", criticalRate=" + criticalRate + ", physicalDefenseRate="
				+ physicalDefenseRate + ", magicDefenseRate=" + magicDefenseRate + "]";
	}

	
}

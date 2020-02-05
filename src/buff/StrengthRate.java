package buff;

public class StrengthRate implements Buffable{

	private double maxHp;
	private double maxMp;
	private double physicalDamage;
	private double magicDamage;
	private double physicalDefense;
	private double magicDefense;
	private double accuracyRate;
	private double evasionRate;
	private double criticalRate;
	
	
	/**
	 * 
	 * @param maxHp
	 * @param maxMp
	 * @param physicalDamage
	 * @param magicDamage
	 * @param physicalDefense
	 * @param magicDefense
	 * @param accuracyRate
	 * @param evasionRate
	 * @param criticalRate
	 */
	public StrengthRate(double maxHp, double maxMp, double physicalDamage, double magicDamage,
			double physicalDefense, double magicDefense, double accuracyRate, double evasionRate, double criticalRate) {
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
	
	public double getMaxHp() {
		return maxHp;
	}
	public double getMaxMp() {
		return maxMp;
	}
	public double getPhysicalDamage() {
		return physicalDamage;
	}
	public double getMagicDamage() {
		return magicDamage;
	}
	public double getPhysicalDefense() {
		return physicalDefense;
	}
	public double getMagicDefense() {
		return magicDefense;
	}
	public double getAccuracyRate() {
		return accuracyRate;
	}
	public double getEvasionRate() {
		return evasionRate;
	}
	public double getCriticalRate() {
		return criticalRate;
	}
	public void setMaxHp(double maxHp) {
		this.maxHp = maxHp;
	}
	public void setMaxMp(double maxMp) {
		this.maxMp = maxMp;
	}
	public void setPhysicalDamage(double physicalDamage) {
		this.physicalDamage = physicalDamage;
	}
	public void setMagicDamage(double magicDamage) {
		this.magicDamage = magicDamage;
	}
	public void setPhysicalDefense(double physicalDefense) {
		this.physicalDefense = physicalDefense;
	}
	public void setMagicDefense(double magicDefense) {
		this.magicDefense = magicDefense;
	}
	public void setAccuracyRate(double accuracyRate) {
		this.accuracyRate = accuracyRate;
	}
	public void setEvasionRate(double evasionRate) {
		this.evasionRate = evasionRate;
	}
	public void setCriticalRate(double criticalRate) {
		this.criticalRate = criticalRate;
	}
	
	@Override
	public boolean isOverlapEffect(Buffable buffable) {
		StrengthRate strength = (StrengthRate)buffable;
		if(maxHp > 0 && strength.maxHp > 0) return true;
		if(maxMp > 0 && strength.maxMp > 0) return true;
		if(physicalDamage > 0 && strength.physicalDamage > 0) return true;
		if(magicDamage > 0 && strength.magicDamage > 0) return true;
		if(physicalDefense > 0 && strength.physicalDefense > 0) return true;
		if(magicDefense > 0 && strength.magicDefense > 0) return true;
		if(accuracyRate > 0 && strength.accuracyRate > 0) return true;
		if(evasionRate > 0 && strength.evasionRate > 0) return true;
		if(criticalRate > 0 && strength.criticalRate > 0) return true;
		return false;
	}
	
	
}

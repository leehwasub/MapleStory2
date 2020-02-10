package attack;

import character.Character;

public class AttackInfor {
	
	private Character attacker;
	private Property property;
	private int physicalDamage;
	private int magicDamage;
	private DamageType damageType;
	private boolean isMustCritical;
	private boolean isCritical;

	public AttackInfor(Character attacker, Property property, int physicalDamage, int magicDamage, DamageType damageType) {
		this.attacker = attacker;
		this.property = property;
		this.physicalDamage = physicalDamage;
		this.magicDamage = magicDamage;
		this.damageType = damageType;
	}
	
	public AttackInfor(Character attacker, Property property, int physicalDamage, int magicDamage, DamageType damageType, boolean isMustCritical) {
		this.attacker = attacker;
		this.property = property;
		this.physicalDamage = physicalDamage;
		this.magicDamage = magicDamage;
		this.damageType = damageType;
		this.isMustCritical = isMustCritical;
	}
	
	public int getTotalDamage() {
		return (this.physicalDamage + this.magicDamage);
	}

	public Character getAttacker() {
		return this.attacker;
	}

	public void setAttacker(Character attacker) {
		this.attacker = attacker;
	}

	public Property getProperty() {
		return this.property;
	}

	public int getPhysicalDamage() {
		return this.physicalDamage;
	}

	public int getMagicDamage() {
		return this.magicDamage;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public void setPhysicalDamage(int physicalDamage) {
		this.physicalDamage = physicalDamage;
	}
	
	public void subPhysicalDamage(int physicalDamage) {
		this.physicalDamage = Math.max(this.physicalDamage - physicalDamage, 0);
	}
	
	public void addPhysicalDamage(int physicalDamage) {
		this.physicalDamage = Math.max(this.physicalDamage + physicalDamage, 0);
	}

	public void setMagicDamage(int magicDamage) {
		this.magicDamage = magicDamage;
	}
	
	public void subMagicDamage(int magicDamage) {
		this.magicDamage = Math.max(this.magicDamage - magicDamage, 0);
	}
	
	public void addMagicDamage(int magicDamage) {
		this.magicDamage = Math.max(this.magicDamage + magicDamage, 0);
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}

	public boolean isMustCritical() {
		return isMustCritical;
	}

	public void setMustCritical(boolean isMustCritical) {
		this.isMustCritical = isMustCritical;
	}

	public boolean isCritical() {
		return isCritical;
	}

	public void setCritical(boolean isCritical) {
		this.isCritical = isCritical;
	}

	@Override
	public String toString() {
		return "AttackInfor [attacker=" + attacker + ", property=" + property + ", physicalDamage=" + physicalDamage
				+ ", magicDamage=" + magicDamage + ", damageType=" + damageType + ", isMustCritical=" + isMustCritical
				+ "]";
	}
	
}
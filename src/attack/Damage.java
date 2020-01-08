package attack;

import character.Character;

public class Damage {
	private Character attacker;
	private Property property;
	private int physicalDamage;
	private int magicDamage;

	public Damage(Character attacker, Property property, int physicalDamage, int magicDamage) {
		this.attacker = attacker;
		this.property = property;
		this.physicalDamage = physicalDamage;
		this.magicDamage = magicDamage;
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

	public void setMagicDamage(int magicDamage) {
		this.magicDamage = magicDamage;
	}

	public String toString() {
		return "Damage [property=" + this.property + ", physicalDamage=" + this.physicalDamage + ", magicDamage="
				+ this.magicDamage + "]";
	}
}
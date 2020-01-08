package buff;

import character.Character;
import character.Strength;

public abstract class Buff {
	Strength strength;

	public Buff(Strength strength) {
		this.strength = strength;
	}

	public void effect(Character character) {
		Strength str = character.getStrength();
		str.addPhysicalDamage(this.strength.getPhysicalDamage());
		str.addPhysicalDefense(this.strength.getPhysicalDefense());
		str.addMagicDamage(this.strength.getMagicDamage());
		str.addMagicDefense(this.strength.getMagicDefense());
		str.addAccuracyRate(this.strength.getAccuracyRate());
		str.addEvasionRate(this.strength.getEvasionRate());
	}

	public Strength getStrength() {
		return this.strength;
	}

	public void setStrength(Strength strength) {
		this.strength = strength;
	}
}

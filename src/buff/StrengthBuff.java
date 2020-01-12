package buff;

import java.awt.Graphics2D;

import attack.Property;
import character.Character;
import character.Strength;

public final class StrengthBuff extends Buff{

	private Strength strength;

	public StrengthBuff(String imageUri, String name, int last, String infor, Strength strength) {
		super(imageUri, name, last, infor);
		this.strength = strength;
	}
	
	@Override
	public void draw(Graphics2D g) {
		
	}
	
	public void effect(Character character) {
		Strength str = character.getStrength();
		str.addPhysicalDamage(this.strength.getPhysicalDamage());
		str.addPhysicalDefense(this.strength.getPhysicalDefense());
		str.addMagicDamage(this.strength.getMagicDamage());
		str.addMagicDefense(this.strength.getMagicDefense());
		str.addAccuracyRate(this.strength.getAccuracyRate());
		str.addEvasionRate(this.strength.getEvasionRate());
		str.addCriticalRate(this.strength.getCriticalRate());
	}

}

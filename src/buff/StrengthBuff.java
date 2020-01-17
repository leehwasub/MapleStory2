package buff;

import java.awt.Graphics2D;

import character.Adventurer;
import character.Character;
import character.Monster;
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
		str.addMaxHp(strength.getMaxHp());
		str.addMaxMp(strength.getMaxMp());
		if(character instanceof Monster) {
			character.addMinPhysicalDamage(strength.getPhysicalDamage());
			character.addMaxPhysicalDamage(strength.getPhysicalDamage());
			character.addMinMagicDamage(strength.getMagicDamage());
			character.addMaxMagicDamage(strength.getMagicDamage());
		} else if(character instanceof Adventurer) {
			str.addPhysicalDamage(strength.getPhysicalDamage());
			str.addMagicDamage(strength.getMagicDamage());
		}
		str.addPhysicalDefense(this.strength.getPhysicalDefense());
		str.addMagicDefense(this.strength.getMagicDefense());
		str.addAccuracyRate(this.strength.getAccuracyRate());
		str.addEvasionRate(this.strength.getEvasionRate());
		str.addCriticalRate(this.strength.getCriticalRate());
	}
	
	@Override
	public boolean isDebuff() {
		return (strength.getMaxHp() < 0 || strength.getMaxMp() < 0 || strength.getPhysicalDamage() < 0 || strength.getPhysicalDefense() < 0
				|| strength.getMagicDamage() < 0 || strength.getMagicDefense() < 0 || strength.getAccuracyRate() < 0 
				|| strength.getEvasionRate() < 0 || strength.getCriticalRate() < 0);
	}

}

package buff;

import java.awt.Graphics2D;

import character.Adventurer;
import character.Character;
import character.Monster;
import character.Strength;

public final class StrengthBuff extends Buff{
	
	private Strength strength;
	private StrengthBuffType buffType;
	
	public StrengthBuff(String imageUri, String name, int last, String infor, Strength strength, StrengthBuffType buffType) {
		super(imageUri, name, last, infor);
		this.strength = strength;
		this.buffType = buffType;
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
			str.addPhysicalDefenseRate(strength.getPhysicalDefenseRate());
			str.addMagicDefenseRate(strength.getMagicDefenseRate());
		} else if(character instanceof Adventurer) {
			str.addPhysicalDamage(strength.getPhysicalDamage());
			str.addMagicDamage(strength.getMagicDamage());
			str.addPhysicalDefense(strength.getPhysicalDefense());
			str.addMagicDefense(strength.getMagicDefense());
		}
		str.addAccuracyRate(strength.getAccuracyRate());
		str.addEvasionRate(strength.getEvasionRate());
		str.addCriticalRate(strength.getCriticalRate());
		str.getResistance().addAllResistance(strength.getResistance());
	}
	
	@Override
	public boolean isDebuff() {
		return (strength.getMaxHp() < 0 || strength.getMaxMp() < 0 || strength.getPhysicalDamage() < 0 || strength.getPhysicalDefense() < 0
				|| strength.getMagicDamage() < 0 || strength.getMagicDefense() < 0 || strength.getAccuracyRate() < 0 
				|| strength.getEvasionRate() < 0 || strength.getCriticalRate() < 0);
	}

	public StrengthBuffType getBuffType() {
		return buffType;
	}

	public void setBuffType(StrengthBuffType buffType) {
		this.buffType = buffType;
	}
	
	public Strength getStrength() {
		return strength;
	}

	public void setStrength(Strength strength) {
		this.strength = strength;
	}

	@Override
	public boolean isOverlapEffect(Buffable buffable) {
		return strength.isOverlapEffect(((StrengthBuff)buffable).getStrength());
	}
	

}

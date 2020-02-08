package buff;

import java.awt.Graphics2D;

import character.Adventurer;
import character.Character;
import character.Monster;
import character.Strength;

public final class StrengthRateBuff extends Buff{
	
	private StrengthRate strengthRate;
	private StrengthBuffType buffType;
	
	public StrengthRateBuff(String imageUri, String name, int last, String infor, StrengthRate strength, StrengthBuffType buffType) {
		super(imageUri, name, last, infor);
		this.strengthRate = strength;
		this.buffType = buffType;
	}
	
	public void effect(Character character) {
		Strength str = character.getStrength();
		str.setMaxHp((int)(str.getMaxHp() * strengthRate.getMaxHp()));
		str.setMaxMp((int)(str.getMaxMp() * strengthRate.getMaxMp()));
		str.setPhysicalDamage((int)(str.getPhysicalDamage() * strengthRate.getPhysicalDamage()));
		str.setMagicDamage((int)(str.getMagicDamage() * strengthRate.getMagicDamage()));
		str.setPhysicalDefense((int)(str.getPhysicalDefense() * strengthRate.getPhysicalDefense()));
		str.setMagicDefense((int)(str.getMagicDefense() * strengthRate.getMagicDefense()));
		str.setAccuracyRate((int)(str.getAccuracyRate() * strengthRate.getAccuracyRate()));
		str.setEvasionRate((int)(str.getEvasionRate() * strengthRate.getEvasionRate()));
		str.setCriticalRate((int)(str.getCriticalRate() * strengthRate.getCriticalRate()));
	}
	
	@Override
	public boolean isDebuff() {
		return (strengthRate.getMaxHp() < 1.0 || strengthRate.getMaxMp() < 1.0 || strengthRate.getPhysicalDamage() < 1.0 || strengthRate.getPhysicalDefense() < 1.0
				|| strengthRate.getMagicDamage() < 1.0 || strengthRate.getMagicDefense() < 1.0 || strengthRate.getAccuracyRate() < 1.0 
				|| strengthRate.getEvasionRate() < 1.0 || strengthRate.getCriticalRate() < 1.0);
	}

	public StrengthBuffType getBuffType() {
		return buffType;
	}

	public void setBuffType(StrengthBuffType buffType) {
		this.buffType = buffType;
	}
	
	public StrengthRate getStrength() {
		return strengthRate;
	}

	public void setStrength(StrengthRate strength) {
		this.strengthRate = strength;
	}

	@Override
	public boolean isOverlapEffect(Buffable buffable) {
		return strengthRate.isOverlapEffect(((StrengthRate)buffable));
	}
	

}

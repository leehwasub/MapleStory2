package buff;

import java.awt.Graphics2D;

import attack.DamageType;
import attack.Property;
import character.Character;

public final class AbnormalBuff extends Buff{
	
	private Property property;
	private int damage;
	private DamageType damageType;
	
	public AbnormalBuff(String imageUri, String name, int last, String infor, Property property, int damage, DamageType damageType) {
		super(imageUri, name, last, infor);
		this.property = property;
		this.damage = damage;
		this.damageType = damageType;
	}
	
	@Override
	public final void effect(Character character) {
		int getDamage = character.calResistenceDamage(damage, property);
		if(damageType == DamageType.DAMAGE_HP_TYPE) {
			character.subCurHp(getDamage);
		} else if(damageType == DamageType.DAMAGE_MP_TYPE) {
			character.subCurMp(getDamage);
		}
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public boolean isDebuff() {
		return true;
	}

	@Override
	public boolean isOverlapEffect(Buffable buffable) {
		return false;
	}

}

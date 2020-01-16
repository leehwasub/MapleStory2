package buff;

import java.awt.Graphics2D;

import attack.Property;
import character.Character;

public final class AbnormalBuff extends Buff{
	
	private Property property;
	private int damage;
	
	public AbnormalBuff(String imageUri, String name, int last, String infor, Property property, int damage) {
		super(imageUri, name, last, infor);
		this.property = property;
		this.damage = damage;
	}

	@Override
	public void draw(Graphics2D g) {
		
	}
	
	@Override
	public final void effect(Character character) {
		
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

}

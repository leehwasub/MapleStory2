package buff;

import java.awt.Graphics2D;

import attack.Property;
import character.Character;

public final class AbnormalBuff extends Buff{
	
	private int damage;
	
	public AbnormalBuff(String imageUri, String name, Property property, int last, String infor, int damage) {
		super(imageUri, name, property, last, infor);
		this.damage = damage;
	}

	@Override
	public void draw(Graphics2D g) {
		
	}
	
	@Override
	public void effect(Character character) {
		
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}

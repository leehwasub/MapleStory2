package buff;

import java.awt.Graphics2D;

import attack.Property;
import character.Character;

public class SpecialBuff extends Buff{

	public SpecialBuff(String imageUri, String name, Property property, int last, String infor) {
		super(imageUri, name, property, last, infor);
	}
	
	@Override
	public void draw(Graphics2D g) {
		
	}
	
	@Override
	public void effect(Character character) {
		
	}

}
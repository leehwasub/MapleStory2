package buff;

import java.awt.Graphics2D;

import character.Character;

public class SpecialBuff extends Buff{

	public SpecialBuff(String imageUri, String name, int last, String infor) {
		super(imageUri, name, last, infor);
	}

	@Override
	public void draw(Graphics2D g) {
		
	}
	
	@Override
	public void effect(Character character) {
		
	}

	@Override
	public boolean isDebuff() {
		return true;
	}

	
}

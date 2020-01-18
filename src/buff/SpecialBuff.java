package buff;

import java.awt.Graphics2D;

import character.Character;

public class SpecialBuff extends Buff{
	
	private boolean isDebuff;

	public SpecialBuff(String imageUri, String name, int last, String infor, boolean isDebuff) {
		super(imageUri, name, last, infor);
		this.isDebuff = isDebuff;
	}

	@Override
	public void draw(Graphics2D g) {
		
	}
	
	@Override
	public void effect(Character character) {
		
	}

	@Override
	public boolean isDebuff() {
		return isDebuff;
	}

	
}

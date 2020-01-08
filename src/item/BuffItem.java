package item;

import java.awt.Graphics2D;
import java.io.Serializable;
import character.Character;
import character.Strength;
import map.Point;

public class BuffItem extends ConsumableItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private Strength strength;
	private int lastTime;
	private int cancelRate;

	public BuffItem(String name, int cost, String imageUrl, int num, Strength strength, int lastTime, int cancelRate) {
		super(name, cost, imageUrl, num);
		this.strength = strength;
		this.lastTime = lastTime;
		this.cancelRate = cancelRate;
	}

	public void use(Character character) {}
	@Override
	public void drawInfor(Graphics2D g, Point basePoint) {}

	public int getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(int lastTime) {
		this.lastTime = lastTime;
	}

	public Strength getStrength() {
		return this.strength;
	}

	public void setStrength(Strength strength) {
		this.strength = strength;
	}

	public int getCancelRate() {
		return cancelRate;
	}

	public void setCancelRate(int cancelRate) {
		this.cancelRate = cancelRate;
	}
	
	
}

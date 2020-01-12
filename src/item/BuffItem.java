package item;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import buff.StrengthBuff;
import character.Character;
import character.Strength;
import map.Point;
import utils.MusicUtils;

public class BuffItem extends ConsumableItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private Strength strength;
	private int lastTime;

	public BuffItem(String name, int cost, String imageUrl, int num, int level, Strength strength, int lastTime) {
		super(name, cost, imageUrl, num, level);
		this.strength = strength;
		this.lastTime = lastTime;
	}

	public void use(Character character) {
		if (getNum() >= 1) {
			MusicUtils.startEffectSound("portionUse");
			setNum(getNum() - 1);
			character.addBuff(new StrengthBuff(imageUrl, name, lastTime, getInforForBuff(), strength));
		}
	}
	
	public String getInforForBuff() {
		ArrayList<String> ret = strength.getStrengthItemInfor();
		StringBuffer sb = new StringBuffer();
		sb.append(lastTime + "턴간 ");
		for(int i = 0; i < ret.size(); i++) {
			sb.append("," + ret.get(i));
		}
		return sb.toString();
	}
	
	@Override
	public void drawInfor(Graphics2D g, Point basePoint) {
		
	}

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
	
	
}

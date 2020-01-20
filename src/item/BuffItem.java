package item;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import buff.StrengthBuff;
import buff.StrengthBuff.StrengthBuffType;
import character.Character;
import character.Strength;
import map.Point;
import maplestory.MainMapleInterface;
import maplestory.MapleInterface;
import maplestory.Player;
import utils.ColorUtils;
import utils.FontUtils;
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

	public void use(Player player, MainMapleInterface mainMapleInterface) {
		if (getNum() >= 1) {
			MusicUtils.startEffectSound("portionUse");
			setNum(getNum() - 1);
			player.getMainAdventurer().addBuff(new StrengthBuff(imageUrl, name, lastTime, getInforForBuff(), strength, StrengthBuffType.PORTION_BUFF));
			player.removeEmptyItem();
			mainMapleInterface.mainStateBarUpdate();
		}
	}
	
	public String getInforForBuff() {
		ArrayList<String> ret = strength.getStrengthItemInfor();
		StringBuffer sb = new StringBuffer();
		sb.append(lastTime + "턴간");
		for(int i = 0; i < ret.size(); i++) {
			sb.append(", " + ret.get(i));
		}
		return sb.toString();
	}
	
	public ArrayList<String> getInfor() {
		ArrayList<String> ret = strength.getStrengthItemInfor();
		ret.add(0, lastTime + "턴간 지속");
		return ret;
	}
	
	@Override
	public void drawInfor(Graphics2D g, Point p) {
		g.setColor(Color.BLACK);
		g.fillRect(p.getX(), p.getY(), 200, 160 + getInfor().size() * 20);
		g.setFont(FontUtils.SMALL_FONT);
		this.fm = g.getFontMetrics(FontUtils.SMALL_FONT);
		g.setColor(Color.WHITE);
		int width = this.fm.stringWidth(getName());
		g.drawString(this.name, p.getX() + (200 - width) / 2, p.getY() + 25);
		g.drawImage(this.image, p.getX() + 20, p.getY() + 45, null);
		g.setColor(Color.YELLOW);
		g.drawString("분류", p.getX() + 80, p.getY() + 57);
		g.drawString("래벨", p.getX() + 80, p.getY() + 82);
		g.setColor(Color.WHITE);
		g.drawString("소모품", p.getX() + 120, p.getY() + 57);
		g.drawString(this.level+"", p.getX() + 120, p.getY() + 82);
		ArrayList<String> arr = getInfor();
		for (int i = 0; i < arr.size(); i++) {
			int width2 = this.fm.stringWidth((String) arr.get(i));
			g.drawString((String) arr.get(i), p.getX() + (200 - width2) / 2, p.getY() + 120 + i * 20);
		}
		g.setColor(ColorUtils.SEA);
		g.setFont(FontUtils.SMALL_FONT);
		g.drawString(this.cost + " 메소", p.getX() + 20, p.getY() + 160 + (getInfor().size()-1) * 20);
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

	@Override
	public boolean isNeedQuickReigster() {
		return true;
	}
	
	
}

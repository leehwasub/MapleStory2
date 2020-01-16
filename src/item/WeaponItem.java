package item;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import character.SexType;
import character.Strength;
import map.Point;
import utils.ColorUtils;
import utils.FontUtils;

public class WeaponItem extends EquipmentItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private WeaponType weaponType;
	

	public WeaponItem(String name, int cost, String imageUrl, int num, Strength strength, int type, SexType sex,
			boolean isRare, WeaponType weaponType) {
		super(name, cost, imageUrl, num, strength, type, sex, isRare);
		this.weaponType = weaponType;
	}
	
	public void drawInfor(Graphics2D g, Point p) {
		ArrayList<String> arr = getStrength().getStrengthItemInfor();
		g.setColor(Color.BLACK);
		g.fillRect(p.getX(), p.getY(), 200, 160 + arr.size() * 20);
		g.setFont(FontUtils.SMALL_FONT);
		this.fm = g.getFontMetrics(FontUtils.SMALL_FONT);
		g.setColor(Color.WHITE);
		int width = this.fm.stringWidth(name);
		g.drawString(getName(), p.getX() + (200 - width) / 2, p.getY() + 25);
		g.drawImage(getImage(), p.getX() + 20, p.getY() + 45, null);
		g.setColor(Color.YELLOW);
		g.drawString("분류", p.getX() + 80, p.getY() + 57);
		g.drawString("래벨", p.getX() + 80, p.getY() + 82);
		g.setColor(Color.WHITE);
		g.drawString(getTypeString(weaponType), p.getX() + 120, p.getY() + 57);
		g.drawString(getStrength().getLevel()+"", p.getX() + 120, p.getY() + 82);
		for (int i = 0; i < arr.size(); i++) {
			int width2 = this.fm.stringWidth((String) arr.get(i));
			g.drawString((String) arr.get(i), p.getX() + (200 - width2) / 2, p.getY() + 120 + i * 20);
		}
		g.setColor(ColorUtils.SEA);
		g.setFont(FontUtils.SMALL_FONT);
		g.drawString(this.cost + " 메소", p.getX() + 20,  p.getY() + 160 + (arr.size()-1) * 20);
	}

	private String getTypeString(WeaponType type) {
		String ret = "";
		switch (type) {
		case SWORD:
			ret = "검";
			break;
		case SPEAR:
			ret = "창";
			break;
		}
		return ret;
	}
	

	public WeaponType getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}

	
}

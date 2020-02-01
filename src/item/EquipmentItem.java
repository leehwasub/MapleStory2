package item;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import character.SexType;
import character.Status;
import character.Strength;
import map.Point;
import utils.ColorUtils;
import utils.FontUtils;
import utils.ResourceLoader;

public class EquipmentItem extends Item implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int EQUIPMENT_TYPE_CLOTHES = 0;
	public static final int EQUIPMENT_TYPE_PANTS = 1;
	public static final int EQUIPMENT_TYPE_WAEPON = 2;
	public static final int EQUIPMENT_TYPE_SHIELD = 3;
	public static final int EQUIPMENT_TYPE_HELMET = 4;
	public static final int EQUIPMENT_TYPE_SHOES = 5;
	public static final int EQUIPMENT_TYPE_GLOVE = 6;
	public static final int EQUIPMENT_TYPE_TITLE = 7;
	private Strength strength;
	private int type;
	private SexType sex;
	private Status status;
	private boolean isRare = false;
	
	public EquipmentItem(String name, int cost, String imageUrl, int num, Strength strength, int type, SexType sex,
			boolean isRare) {
		super(name, cost, imageUrl, num);
		this.strength = strength;
		this.type = type;
		this.sex = sex;
		this.isRare = isRare;
		this.status = new Status(0, 0, 0, 0);
		setImageWithTypeForInit();
	}
	
	public EquipmentItem(String name, int cost, String imageUrl, int num, Strength strength, int type, SexType sex,
			boolean isRare, Status status) {
		super(name, cost, imageUrl, num);
		this.strength = strength;
		this.type = type;
		this.sex = sex;
		this.isRare = isRare;
		this.status = status;
		setImageWithTypeForInit();
	}

	public void setImageWithTypeForInit() {
		if ((this instanceof EquipmentItem)) {
			if (this.type == 2) {
				this.image = ResourceLoader.getImage("weaponItemImage", this.imageUrl + "ItemImage.png");
			} else if (this.type == 0) {
				this.image = ResourceLoader.getImage("clothsItemImage", this.imageUrl + "ItemImage.png");
			} else if (this.type == 1) {
				this.image = ResourceLoader.getImage("pantsItemImage", this.imageUrl + "ItemImage.png");
			} else if (this.type == 4) {
				this.image = ResourceLoader.getImage("helmetItemImage", this.imageUrl + "ItemImage.png");
			} else if (this.type == 3) {
				this.image = ResourceLoader.getImage("shieldItemImage", this.imageUrl + "ItemImage.png");
			} else if (this.type == 6) {
				this.image = ResourceLoader.getImage("gloveItemImage", this.imageUrl + "ItemImage.png");
			} else if (this.type == 5) {
				this.image = ResourceLoader.getImage("shoesItemImage", this.imageUrl + "ItemImage.png");
			} else if (this.type == 7) {
				this.image = ResourceLoader.getImage("titleItemImage", this.imageUrl + "ItemImage.png");
			}
			System.out.println(this.imageUrl);
		}
	}

	public void drawInfor(Graphics2D g, Point p) {
		ArrayList<String> arr = strength.getStrengthItemInfor();
		if(status != null) {
			arr.addAll(status.getStatusItemInfor());
		}
		g.setColor(Color.BLACK);
		g.fillRect(p.getX(), p.getY(), 200, 160 + arr.size() * 20);
		g.setFont(FontUtils.SMALL_FONT);
		this.fm = g.getFontMetrics(FontUtils.SMALL_FONT);
		int width = this.fm.stringWidth(name);
		if(isRare) {
			g.setColor(ColorUtils.PURPLE);
		} else {
			g.setColor(Color.WHITE);
		}
		g.drawString(getName(), p.getX() + (200 - width) / 2, p.getY() + 25);
		g.setColor(Color.WHITE);
		g.drawImage(getImage(), p.getX() + 20, p.getY() + 45, null);
		g.setColor(Color.YELLOW);
		g.drawString("분류", p.getX() + 80, p.getY() + 57);
		g.drawString("래벨", p.getX() + 80, p.getY() + 82);
		g.setColor(Color.WHITE);
		g.drawString(getTypeString(this.type), p.getX() + 120, p.getY() + 57);
		g.drawString(this.strength.getLevel()+"", p.getX() + 120, p.getY() + 82);
		for (int i = 0; i < arr.size(); i++) {
			int width2 = this.fm.stringWidth((String) arr.get(i));
			g.drawString((String) arr.get(i), p.getX() + (200 - width2) / 2, p.getY() + 120 + i * 20);
		}
		g.setColor(ColorUtils.SEA);
		g.setFont(FontUtils.SMALL_FONT);
		g.drawString(this.cost + " 메소", p.getX() + 20,  p.getY() + 160 + (arr.size()-1) * 20);
	}

	private String getTypeString(int type) {
		String ret = "";
		switch (type) {
		case 0:
			ret = "상의";
			break;
		case 1:
			ret = "하의";
			break;
		case 2:
			ret = "무기";
			break;
		case 3:
			ret = "방패";
			break;
		case 4:
			ret = "모자";
			break;
		case 5:
			ret = "신발";
			break;
		case 6:
			ret = "장갑";
			break;
		case 7:
			ret = "칭호";
		}
		return ret;
	}

	public Strength getStrength() {
		return this.strength;
	}

	public int getType() {
		return this.type;
	}

	public SexType getSex() {
		return this.sex;
	}

	public void setStrength(Strength strength) {
		this.strength = strength;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setSex(SexType sex) {
		this.sex = sex;
	}

	public boolean isRare() {
		return this.isRare;
	}

	public void setRare(boolean isRare) {
		this.isRare = isRare;
	}

	public String toString() {
		return "EquipmentItem [strength=" + this.strength + ", type=" + this.type + ", sex=" + this.sex + "] "
				+ super.toString();
	}

	public Status getStatus() {
		if(status == null) status = new Status(0, 0, 0, 0);
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public boolean isSellable() {
		return true;
	}
}

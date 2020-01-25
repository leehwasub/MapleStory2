package item;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.io.Serializable;

import map.Point;
import utils.ColorUtils;
import utils.FontUtils;

public class MaterialItem extends Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private String infor;
	private boolean isSellable;

	public MaterialItem(String name, int cost, String imageUrl, int num, String infor) {
		super(name, cost, imageUrl, num);
		this.infor = infor;
		this.isSellable = true;
	}
	
	public MaterialItem(String name, int cost, String imageUrl, int num, String infor, boolean isSellable) {
		super(name, cost, imageUrl, num);
		this.infor = infor;
		this.isSellable = isSellable;
	}

	public void drawInfor(Graphics2D g, Point p) {
		int totalLine = getLine(g);
		g.setColor(Color.BLACK);
		g.fillRect(p.getX(), p.getY(), 200, 160 + totalLine * 20);
		g.setFont(FontUtils.SMALL_FONT);
		this.fm = g.getFontMetrics(FontUtils.SMALL_FONT);
		g.setColor(Color.WHITE);
		int width = this.fm.stringWidth(getName());
		g.drawString(getName(), p.getX() + (200 - width) / 2, p.getY() + 25);
		g.drawImage(getImage(), p.getX() + 20, p.getY() + 45, null);
		g.setColor(Color.YELLOW);
		g.drawString("분류", p.getX() + 80, p.getY() + 70);
		g.setColor(Color.WHITE);
		g.drawString("재료", p.getX() + 120, p.getY() + 70);
		int preIndex = 0;
		int line = 0;
		int width2 = 0;
		for (int i = 0; i < this.infor.length(); i++) {
			FontMetrics fm = g.getFontMetrics();
			width2 = fm.stringWidth(this.infor.substring(preIndex, i));
			if (width2 > 160) {
				g.drawString(this.infor.substring(preIndex, i), p.getX() + (200 - width2) / 2,
						p.getY() + 120 + line * 20);
				preIndex = i;
				line++;
			}
		}
		width2 = fm.stringWidth(this.infor.substring(preIndex));
		g.drawString(this.infor.substring(preIndex), p.getX() + (200 - width2) / 2, p.getY() + 120 + line * 20);
		g.setColor(ColorUtils.SEA);
		g.setFont(FontUtils.SMALL_FONT);
		if(isSellable) {
			g.drawString(this.cost + " 메소", p.getX() + 20, p.getY() + 160 + (totalLine-1) * 20);
		}
	}
	
	private int getLine(Graphics2D g) {
		int preIndex = 0;
		int line = 0;
		int width2 = 0;
		for (int i = 0; i < this.infor.length(); i++) {
			FontMetrics fm = g.getFontMetrics();
			width2 = fm.stringWidth(this.infor.substring(preIndex, i));
			if (width2 > 160) {
				preIndex = i;
				line++;
			}
		}
		return ++line;
	}

	public String getInfor() {
		return this.infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

	@Override
	public boolean isSellable() {
		return isSellable;
	}
}

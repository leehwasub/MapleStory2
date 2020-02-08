package buff;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;

import character.Character;
import map.Point;
import utils.ColorUtils;
import utils.FontUtils;
import utils.ResourceLoader;

public abstract class Buff implements Buffable {
	
	private Image image;
	private String name;
	private int last;
	private String infor;
	
	private FontMetrics fm;
	
	public Buff(String imageUri, String name, int last, String infor) {
		this.image =  ResourceLoader.getImage("buffImage", imageUri + "BuffImage.png");
		this.name = name;
		this.last = last;
		this.infor = infor;
	}

	public final void draw(Graphics2D g, Point p) {
		fm = g.getFontMetrics();
		int totalLine = getLine(g);
		g.setColor(Color.BLACK);
		g.fillRect(p.getX(), p.getY(), 200, 160 + totalLine * 20);
		g.setFont(FontUtils.SMALL_FONT);
		fm = g.getFontMetrics(FontUtils.SMALL_FONT);
		g.setColor(Color.WHITE);
		int width = fm.stringWidth(getName());
		g.drawString(getName(), p.getX() + (200 - width) / 2, p.getY() + 25);
		g.drawImage(getImage(), p.getX() + 20, p.getY() + 45, null);
		g.setColor(Color.YELLOW);
		g.drawString("분류", p.getX() + 80, p.getY() + 65);
		g.setColor(Color.WHITE);
		String buffType = "";
		if(this instanceof AbnormalBuff) {
			buffType = "상태이상";
		} else if(isDebuff()) {
			buffType = "디버프";
		} else {
			buffType = "버프";
		}
		g.drawString(buffType, p.getX() + 120, p.getY() + 65);
		int preIndex = 0;
		int line = 0;
		int width2 = 0;
		for (int i = 0; i < this.infor.length(); i++) {
			FontMetrics fm = g.getFontMetrics();
			width2 = fm.stringWidth(this.infor.substring(preIndex, i));
			if (width2 > 150) {
				g.drawString(this.infor.substring(preIndex, i), p.getX() + (200 - width2) / 2, p.getY() + 120 + line * 20);
				preIndex = i;
				line++;
			}
		}
		width2 = fm.stringWidth(this.infor.substring(preIndex));
		g.drawString(this.infor.substring(preIndex), p.getX() + (200 - width2) / 2, p.getY() + 120 + line * 20);
		g.setColor(ColorUtils.SEA);
		g.setFont(FontUtils.SMALL_FONT);
	}
	
	private int getLine(Graphics2D g) {
		int preIndex = 0;
		int line = 0;
		int width2 = 0;
		for (int i = 0; i < this.infor.length(); i++) {
			FontMetrics fm = g.getFontMetrics();
			width2 = fm.stringWidth(this.infor.substring(preIndex, i));
			if (width2 > 150) {
				preIndex = i;
				line++;
			}
		}
		return ++line;
	}
	
	public abstract void effect(Character character);
	public abstract boolean isDebuff();

	public String getName() {
		return name;
	}
	
	public int getLast() {
		return last;
	}
	
	public boolean isEnd() {
		return (last == 0);
	}
	
	public void oneTurnLast() {
		last--;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getInfor() {
		return infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

}

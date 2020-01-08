package attack;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import utils.FontUtils;

public class DamageText extends Thread {
	private int x;
	private int y;
	private int damage;
	private int type;
	private FontMetrics fm;
	public static final int DAMAGE_HP_TYPE = 0;
	public static final int DAMAGE_MP_TYPE = 0;

	public DamageText(int x, int y, int damage, int type) {
		this.x = x;
		this.y = y;
		this.damage = damage;
	}

	public void draw(Graphics2D g) {
		g.setFont(FontUtils.generalFont);
		if (this.type == 0) {
			g.setColor(Color.RED);
		} else if (this.type == 0) {
			g.setColor(Color.BLUE);
		}
		this.fm = g.getFontMetrics();
		if (this.damage != 0) {
			int width = this.fm.stringWidth(this.damage+"");
			g.drawString(this.damage+"", this.x + 170 + (180 - width) / 2, this.y + 45);
		} else {
			int width = this.fm.stringWidth("MISS");
			g.drawString("MISS", this.x + 170 + (180 - width) / 2, this.y + 45);
		}
	}

	public void run() {
		for (int i = 0; i < 15; i++) {
			try {
				this.y -= 3;
				Thread.sleep(50L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		interrupt();
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getDamage() {
		return this.damage;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}

package attack;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import utils.FontUtils;

public class DamageText extends Thread {
	
	private Hit hit;
	private int x;
	private int y;
	private FontMetrics fm;

	public DamageText(Hit hit, int x, int y) {
		this.hit = hit;
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics2D g) {
		g.setFont(FontUtils.generalFont);
		if (hit.getType() == DamageType.DAMAGE_HP_TYPE) {
			g.setColor(Color.RED);
		} else if (hit.getType() == DamageType.DAMAGE_MP_TYPE) {
			g.setColor(Color.BLUE);
		}
		this.fm = g.getFontMetrics();
		if (this.hit.getDamage() != 0) {
			int width = this.fm.stringWidth(this.hit.getDamage()+"");
			g.drawString(this.hit.getDamage()+"", this.x + 170 + (180 - width) / 2, this.y + 45
					+ (hit.getType() == DamageType.DAMAGE_HP_TYPE ? 0 : 30));
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

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Hit getHit() {
		return hit;
	}

	public void setHit(Hit hit) {
		this.hit = hit;
	}

}

package attack;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import character.Monster;
import component.StateBox;
import utils.FontUtils;

public class DamageText extends Thread {
	
	private Hit hit;
	private int x;
	private int y;
	private FontMetrics fm;

	public DamageText(Hit hit, StateBox stateBox) {
		this.hit = hit;
		int startX = (stateBox.getCharacter() instanceof Monster ? 170 : 50);
		this.x = stateBox.getX() + startX;
		this.y = stateBox.getY() + 45;
	}

	public void draw(Graphics2D g) {
		g.setFont(FontUtils.generalFont);
		if (hit.getType() == DamageType.DAMAGE_HP_TYPE) {
			g.setColor(Color.RED);
		} else if (hit.getType() == DamageType.DAMAGE_MP_TYPE) {
			g.setColor(Color.BLUE);
		}
		fm = g.getFontMetrics();
		if (hit.getDamage() != 0) {
			if(hit.isCritical()) {
				g.setFont(FontUtils.LITTLE_MID_FONT);
				fm = g.getFontMetrics();
				if(hit.getType() == DamageType.DAMAGE_HP_TYPE) {
					g.setColor(Color.MAGENTA);
				} else if(hit.getType() == DamageType.DAMAGE_MP_TYPE) {
					g.setColor(Color.CYAN);
				}
			}
			int width = fm.stringWidth(hit.getDamage()+"");
			g.drawString(hit.getDamage()+"", x + (180 - width) / 2, y
					+ (hit.getType() == DamageType.DAMAGE_HP_TYPE ? 0 : 30));
		} else {
			int width = this.fm.stringWidth("MISS");
			g.drawString("MISS", x + (180 - width) / 2, y);
		}
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
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
	
	public void subX(int x) {
		this.x -= x;
	}

	public void subY(int y) {
		this.y -= y;
	}

	
	public void addX(int x) {
		this.x += x;
	}

	public void addY(int y) {
		this.y += y;
	}

	public Hit getHit() {
		return hit;
	}

	public void setHit(Hit hit) {
		this.hit = hit;
	}

}

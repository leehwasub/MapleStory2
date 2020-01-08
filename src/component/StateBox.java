package component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import attackImage.SkillImage;
import character.Character;
import map.Point;
import utils.FontUtils;
import utils.ResourceLoader;

public class StateBox extends Thread {
	private static final Image STATE_BOX_IMAGE = ResourceLoader.getImage("componentImage", "stateBoxImage.png");
	public static final int STATE_BOX_LEFT_X = 40;
	public static final int STATE_BOX_RIGHT_X = 870;
	public static final int[] STATE_BOX_Y = { 70, 205, 340 };
	private int x;
	private int y;
	private Character character;
	private MapleHpBar mapleHpBar;
	private MapleMpBar mapleMpBar;
	private int dir;
	public static final int DIR_LEFT = 0;
	public static final int DIR_RIGHT = 1;
	private ArrayList<SkillImage> skillImageList = new ArrayList<SkillImage>();

	public StateBox(int x, int y, Character character, int dir, JPanel panel) {
		this.x = x;
		this.y = y;
		this.character = character;
		this.mapleHpBar = new MapleHpBar(character);
		this.mapleMpBar = new MapleMpBar(character);
		this.mapleHpBar.setBounds(x + 170, y + 50, 180, 20);
		panel.add(this.mapleHpBar);
		this.mapleMpBar.setBounds(x + 170, y + 80, 180, 20);
		panel.add(this.mapleMpBar);
		this.dir = dir;
	}

	public void removeFromPanel(JPanel panel) {
		panel.remove(this.mapleHpBar);
		this.mapleHpBar.revalidate();
		panel.remove(this.mapleMpBar);
		this.mapleMpBar.revalidate();
	}

	public void draw(Graphics2D g, JPanel panel) {
		g.drawImage(STATE_BOX_IMAGE, this.x, this.y, panel);
		g.drawImage(this.character.getImage(), this.x + 15, this.y + 15, panel);
		g.setFont(FontUtils.generalFont);
		g.setColor(Color.red);
		g.drawString("HP", this.x + 130, this.y + 66);
		g.setColor(Color.blue);
		g.drawString("MP", this.x + 130, this.y + 96);
		g.setFont(FontUtils.SMALL_FONT_2);
		g.setColor(Color.white);
		g.drawString(this.character.getName(), this.x + 190, this.y + 35);
		g.setColor(Color.yellow);
		g.drawString("Lv " + this.character.getStrength().getLevel(), this.x + 140, this.y + 35);
	}

	public void updateBounds() {
		this.mapleHpBar.setBounds(this.x + 170, this.y + 50, 180, 20);
		this.mapleMpBar.setBounds(this.x + 170, this.y + 80, 180, 20);
	}

	public void updateStateBox() {
		this.mapleHpBar.progressUpdate();
		this.mapleMpBar.progressUpdate();
	}

	public void barSetVisibleFalse() {
		this.mapleHpBar.setVisible(false);
		this.mapleMpBar.setVisible(false);
	}

	public void barSetVisibleTrue() {
		this.mapleHpBar.setVisible(true);
		this.mapleMpBar.setVisible(true);
	}

	public void attackForwardMotion() {
		try {
			for (int i = 0; i < 50; i++) {
				if (this.dir == 0) {
					this.x += 3;
				} else {
					this.x -= 3;
				}
				Thread.sleep(5L);
				updateBounds();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void attackBackMotion() {
		try {
			for (int i = 0; i < 50; i++) {
				if (this.dir == 0) {
					this.x -= 3;
				} else {
					this.x += 3;
				}
				Thread.sleep(5L);
				updateBounds();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Character getCharacter() {
		return this.character;
	}

	public MapleHpBar getMapleHpBar() {
		return this.mapleHpBar;
	}

	public MapleMpBar getMapleMpBar() {
		return this.mapleMpBar;
	}

	public void setCharacter(Character character) {
		this.character = character;
		this.mapleHpBar.setChatacter(character);
		this.mapleMpBar.setCharacter(character);
		updateStateBox();
	}

	public void setMapleHpBar(MapleHpBar mapleHpBar) {
		this.mapleHpBar = mapleHpBar;
	}

	public void setMapleMpBar(MapleMpBar mapleMpBar) {
		this.mapleMpBar = mapleMpBar;
	}
	
	public Point getPoint() {
		return new Point(x, y);
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

	public String getCharacterName() {
		return this.character.getName();
	}
}

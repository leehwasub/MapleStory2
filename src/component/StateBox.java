package component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import buff.Buff;
import character.Character;
import hunt.HuntEvent;
import map.Point;
import maplestory.MainMapleInterface;
import panel.BuffTooltipPanel;
import utils.ColorUtils;
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
	private ArrayList<Buff> buffList;
	private MainMapleInterface mainMapleInterface;
	private BuffTooltipPanel buffTooltipPanel;
	
	public StateBox(int x, int y, Character character, int dir, JPanel panel, MainMapleInterface mainMapleInterface) {
		this.x = x;
		this.y = y;
		this.character = character;
		this.mapleHpBar = new MapleHpBar(character);
		this.mapleMpBar = new MapleMpBar(character);
		if(dir == DIR_RIGHT) {
			this.mapleHpBar.setBounds(x + 170, y + 50, 180, 20);
			this.mapleMpBar.setBounds(x + 170, y + 80, 180, 20);
		} else if(dir == DIR_LEFT) {
			this.mapleHpBar.setBounds(x + 50, y + 50, 180, 20);
			this.mapleMpBar.setBounds(x + 50, y + 80, 180, 20);
		}
		buffTooltipPanel = new BuffTooltipPanel();
		buffTooltipPanel.setBounds(0, 0, 1200, 600);
		panel.add(buffTooltipPanel);
		panel.add(mapleHpBar);
		panel.add(mapleMpBar);
		this.dir = dir;
		buffList = character.getBuffList();
		this.mainMapleInterface = mainMapleInterface;
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int cursorIndex = -1;
				if(buffList != null && buffList.size() != 0) {
					for(int i = buffList.size() - 1; i >= 0; i--) {
						if(e.getX() >= StateBox.this.x + (32 * i) + 5 && e.getX() <= 37 +  StateBox.this.x + (32 * i) && 
								e.getY() >= StateBox.this.y + 140 && e.getY() <= StateBox.this.y + 172 && buffList.get(i) != null) {
							cursorIndex = i;
						}
					}
				}
				if(cursorIndex != -1 && buffList.get(cursorIndex) != null) {
					buffTooltipPanel.setBuff( buffList.get(cursorIndex));
					buffTooltipPanel.setPoint(new Point(e.getX(), e.getY()));
					buffTooltipPanel.setVisible(true);
				} else{
					buffTooltipPanel.setVisible(false);
				}
			}
		});
	}
	
	public void reload(Character character) {
		this.character = character;
		mapleHpBar.setChatacter(character);
		mapleMpBar.setCharacter(character);
		buffList = character.getBuffList();
	}

	public void draw(Graphics2D g, JPanel panel) {
		g.drawImage(STATE_BOX_IMAGE, this.x, this.y, panel);
		if(dir == DIR_RIGHT) {
			g.drawImage(this.character.getImage(), this.x + 65 - character.getImage().getWidth(panel) / 2, this.y + 65 - character.getImage().getHeight(panel) / 2, panel);
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
		} else if(dir == DIR_LEFT) {
			g.drawImage(character.getImage(), x + 300 - character.getImage().getWidth(panel) / 2, y + 65 - character.getImage().getHeight(panel) / 2, panel);
			g.setFont(FontUtils.generalFont);
			g.setColor(Color.red);
			g.drawString("HP", x + 10, y + 66);
			g.setColor(Color.blue);
			g.drawString("MP", x + 10, y + 96);
			g.setFont(FontUtils.SMALL_FONT_2);
			g.setColor(Color.white);
			g.drawString(character.getName(), x + 70, y + 35);
			g.setColor(Color.yellow);
			g.drawString("Lv " + character.getStrength().getLevel(), x + 20, y + 35);
		}
		
		g.setFont(FontUtils.SMALL_FONT);
		if(buffList != null && buffList.size() != 0) {
			g.setColor(ColorUtils.BLACK_80);
			g.fillRect(x, y + 135, 32 * buffList.size() + 10, 60);
			for(int i = buffList.size() - 1; i >= 0; i--) {
				Buff buff = buffList.get(i);
				if(buff != null) {
					if(buff.isDebuff()) {
						g.setColor(Color.RED);
					} else {
						g.setColor(Color.YELLOW);
					}
				}
				if(buff != null) {
					g.drawString("X"+buff.getLast(), x + 10 + (32 * i), y + 185);
					g.drawImage(buff.getImage(), x + (32 * i) + 5, y + 140, panel);
				}
			}
		}
	}

	public void updateBounds() {
		if(dir == DIR_RIGHT) {
			mapleHpBar.setBounds(x + 170, y + 50, 180, 20);
			mapleMpBar.setBounds(x + 170, y + 80, 180, 20);
		} else if(dir == DIR_LEFT) {
			mapleHpBar.setBounds(x + 50, y + 50, 180, 20);
			mapleMpBar.setBounds(x + 50, y + 80, 180, 20);
		}
	}

	public void updateStateBox() {
		this.mapleHpBar.progressUpdate();
		this.mapleMpBar.progressUpdate();
		mainMapleInterface.updateMainStateBar();
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

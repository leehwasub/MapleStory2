package component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import character.Adventurer;
import item.ConsumableItem;
import utils.FontUtils;
import utils.ResourceLoader;

public class HuntQuickButtons {
	private ImageIcon quickCancelBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickCancelButtonBasic.png"));
	private ImageIcon quickCancelEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickCancelButtonEntered.png"));
	private ImageIcon quickItemButtonImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickItemButton.png"));
	private QuickItemButton[] quickItemButton = new QuickItemButton[4];
	private MapleButton[] quickItemCancelButton = new MapleButton[4];
	private QuickSkillButton[] quickSkillButton = new QuickSkillButton[4];
	private MapleButton[] quickSkillCancelButton = new MapleButton[4];
	private StateBox adventurer;
	private boolean isCanUsePortion;
	private boolean isVisible;
	private static HuntQuickButtons instance;

	public void loadAdventurers(StateBox adventurer) {
		this.adventurer = adventurer;
	}


	public static HuntQuickButtons getInstance() {
		if (instance == null) {
			return null;
		}
		return instance;
	}

	public static HuntQuickButtons getInstance(JPanel panel) {
		if (instance == null) {
			instance = new HuntQuickButtons(panel);
		}
		return instance;
	}

	private HuntQuickButtons(JPanel panel) {
		makeQuickItemSpace(panel);
		makeQuickItemCancelSpace(panel);
		setQucikItemListener(panel);
	}

	private void setQucikItemListener(JPanel panel) {
		panel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if ((HuntQuickButtons.this.quickItemButton[0].isVisible()) && (HuntQuickButtons.this.isCanUsePortion)) {
					if (e.getKeyCode() == 81) {
						HuntQuickButtons.this.quickItemEvent(0);
					} else if (e.getKeyCode() == 87) {
						HuntQuickButtons.this.quickItemEvent(1);
					} else if (e.getKeyCode() == 69) {
						HuntQuickButtons.this.quickItemEvent(2);
					} else if (e.getKeyCode() == 82) {
						HuntQuickButtons.this.quickItemEvent(3);
					}
				}
			}
		});
	}

	private void makeQuickItemSpace(JPanel panel) {
		for (int i = 0; i < 4; i++) {
			final int index = i;
			this.quickItemButton[i] = new QuickItemButton(this.quickItemButtonImage);
			this.quickItemButton[i].setBounds(750 + i * 60, 470, 50, 50);
			this.quickItemButton[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					HuntQuickButtons.this.quickItemEvent(index);
				}
			});
			panel.add(this.quickItemButton[i]);
		}
	}

	public void quickItemEvent(int index) {
		if ((this.quickItemButton[index].getItem() == null) || (!this.isCanUsePortion)) {
			return;
		}
		getAdventuer().usePortion(this.quickItemButton[index].getItem());
		adventurer.updateStateBox();
		setQuickItemImage();
		this.isCanUsePortion = false;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.setFont(FontUtils.SMALL_FONT);
		ConsumableItem[] quickItemArray = getAdventuer().getQuickItem();
		if (quickItemArray != null) {
			for (int i = 0; i < quickItemArray.length; i++) {
				int x = this.quickItemButton[i].getLocation().x + 5;
				int y = this.quickItemButton[i].getLocation().y - 5;
				if (quickItemArray[i] != null) {
					g.drawString("X" + quickItemArray[i].getNum(), x, y);
				}
			}
		}
	}

	private void makeQuickItemCancelSpace(JPanel panel) {
		for (int i = 0; i < 4; i++) {
			final int keyIndex = i;
			this.quickItemCancelButton[i] = new MapleButton(this.quickCancelBasicImage, this.quickCancelEnteredImage);
			this.quickItemCancelButton[i].setBounds(755 + i * 60, 525, 40, 20);
			this.quickItemCancelButton[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					HuntQuickButtons.this.quickItemCancelEvent(keyIndex);
				}
			});
			panel.add(this.quickItemCancelButton[i]);
		}
	}

	private Adventurer getAdventuer() {
		return (Adventurer)adventurer.getCharacter();
	}

	private void quickItemCancelEvent(int keyIndex) {
		getAdventuer().removeQuickItem(keyIndex);
		setQuickItemImage();
	}

	public void setQuickItemImage() {
		Adventurer adventurer = getAdventuer();
		if (adventurer == null) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (adventurer.getQuickItemByIndex(i) != null) {
				this.quickItemButton[i].setItem(adventurer.getQuickItemByIndex(i));
			} else {
				this.quickItemButton[i].setItem(null);
			}
		}
	}

	public void setSkillImage() {
	}

	public void setVisibleTrueComponent() {
		for (int i = 0; i < 4; i++) {
			this.quickItemButton[i].setVisible(true);
			this.quickItemCancelButton[i].setVisible(true);
			this.isVisible = true;
		}
	}

	public void setVisibleFalseComponent() {
		for (int i = 0; i < 4; i++) {
			this.quickItemButton[i].setVisible(false);
			this.quickItemCancelButton[i].setVisible(false);
			this.isVisible = false;
		}
	}

	public boolean isCanUsePortion() {
		return this.isCanUsePortion;
	}

	public void setCanUsePortion(boolean isCanUsePortion) {
		this.isCanUsePortion = isCanUsePortion;
	}

	public boolean isVisible() {
		return this.isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
}

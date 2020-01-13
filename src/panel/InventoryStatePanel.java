package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import character.Adventurer;
import character.Status;
import component.MapleButton;
import component.QuickItemButton;
import item.ConsumableItem;
import item.EquipmentItem;
import item.ItemButton;
import maplestory.Player;
import utils.FontUtils;
import utils.ResourceLoader;

public class InventoryStatePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon inventoryItemSpaceButtonImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryItemSpaceButton.png"));
	private ImageIcon quickItemButtonImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickItemButton.png"));
	private ImageIcon quickCancelBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickCancelButtonBasic.png"));
	private ImageIcon quickCancelEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickCancelButtonEntered.png"));
	private ImageIcon stateUpButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "stateUpButtonBasic.png"));
	private ImageIcon stateUpButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "stateUpButtonEntered.png"));
	private MapleButton[] stateUpButton = new MapleButton[4];
	private ItemButton[] inventoryMyInfoButton = new ItemButton[8];
	private QuickItemButton[] quickItemButton = new QuickItemButton[Adventurer.QUICK_ITEM_ARRAY_SIZE];
	private MapleButton[] quickCancelButton = new MapleButton[Adventurer.QUICK_ITEM_ARRAY_SIZE];
	private Player player;
	
	private ItemTooltipPanel toolTipPanel = new ItemTooltipPanel();

	public InventoryStatePanel(Player player) {
		setLayout(null);
		setVisible(true);
		this.player = player;
		toolTipPanel.setBounds(0, 0, 1100, 420);
		add(toolTipPanel);
		
		makeInventoryMyInfo();
		setBackground(new Color(0, 0, 0, 0));
		setEquipmentStateImage();
		makeQuickItemSpace();
		makeQuickCancelSpace();
		makeStateUpButton();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		Adventurer adventurer = this.player.getMainAdventurer();
		g.setFont(FontUtils.generalFont);
		g.setColor(Color.yellow);
		g.drawString("이름", 50, 40);
		g.setColor(Color.white);
		g.drawString(adventurer.getName(), 100, 40);
		g.setColor(Color.yellow);
		g.drawString("성별", 50, 70);
		g.setColor(Color.white);
		if (adventurer.getSex().equals("남자")) {
			g.drawString("남자", 100, 70);
		} else if (adventurer.getSex().equals("여자")) {
			g.drawString("여자", 100, 70);
		}
		g.setColor(Color.yellow);
		g.drawString("래벨", 50, 100);
		g.setColor(Color.white);
		g.drawString(adventurer.getStrength().getLevel()+"", 100, 100);
		g.setColor(Color.yellow);
		g.drawString("경험치", 50, 130);
		g.setColor(Color.white);
		g.drawString(adventurer.getExp() + "/" + adventurer.getNeedExp(), 110, 130);
		g.setColor(Color.red);
		g.drawString("HP", 50, 160);
		g.setColor(Color.white);
		g.drawString(adventurer.getCurHp() + "/" + adventurer.getStrength().getMaxHp(), 95, 160);
		g.setColor(Color.blue);
		g.drawString("MP", 50, 190);
		g.setColor(Color.white);
		g.drawString(adventurer.getCurMp() + "/" + adventurer.getStrength().getMaxMp(), 95, 190);
		g.setColor(Color.YELLOW);
		g.drawString("물리 공격력", 50, 220);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getPhysicalDamage()+"", 150, 220);
		g.setColor(Color.YELLOW);
		g.drawString("마법 공격력", 50, 250);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getMagicDamage()+"", 150, 250);
		g.setColor(Color.YELLOW);
		g.drawString("물리 방어력", 50, 280);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getPhysicalDefense()+"", 150, 280);
		g.setColor(Color.YELLOW);
		g.drawString("마법 방어력", 50, 310);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getMagicDefense()+"", 150, 310);
		g.setColor(Color.YELLOW);
		g.drawString("적중률", 50, 340);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getAccuracyRate()+"", 110, 340);
		g.setColor(Color.YELLOW);
		g.drawString("회피율", 50, 370);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getEvasionRate()+"", 110, 370);
		g.setColor(Color.YELLOW);
		g.drawString("메소", 50, 400);
		g.setColor(Color.WHITE);
		g.drawString(this.player.getInventory().getMoney()+"", 90, 400);
		g.setColor(Color.YELLOW);
		g.drawString("STR", 350, 40);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStatus().getStr()+"", 410, 40);
		g.setColor(Color.YELLOW);
		g.drawString("DEX", 350, 70);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStatus().getDex()+"", 410, 70);
		g.setColor(Color.YELLOW);
		g.drawString("INT", 350, 100);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStatus().getInt()+"", 410, 100);
		g.setColor(Color.YELLOW);
		g.drawString("LUK", 350, 130);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStatus().getLuk()+"", 410, 130);
		g.setColor(Color.YELLOW);
		g.drawString("스텟 포인트", 350, 160);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStatePoint()+"", 450, 160);
		g.setColor(Color.YELLOW);
		g.drawString("물리 데미지", 350, 190);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getMinPhysicalDamage() + "~" + adventurer.getMaxPhysicalDamage(), 450, 190);
		g.setColor(Color.YELLOW);
		g.drawString("마법 데미지", 350, 220);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getMinMagicDamage() + "~" + adventurer.getMaxMagicDamage(), 450, 220);
		g.setColor(Color.YELLOW);
		g.drawString("직업", 350, 250);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getCareer(), 400, 250);
		g.setColor(Color.YELLOW);
		g.drawString("포션 단축키", 550, 40);
		g.setColor(Color.white);
		g.drawString("Q W E R", 650, 40);
		g.setColor(Color.YELLOW);
		g.drawString("스킬 단축키", 550, 70);
		g.setColor(Color.white);
		g.drawString("Z X C V", 650, 70);
		g.setColor(Color.YELLOW);
		g.drawString("상의", 790, 45);
		g.drawString("하의", 790, 105);
		g.drawString("무기", 790, 165);
		g.drawString("방패", 790, 225);
		g.drawString("모자", 790, 285);
		g.drawString("신발", 790, 345);
		g.drawString("장갑", 790, 405);
		g.drawString("칭호", 940, 405);
		g.setColor(Color.YELLOW);
		g.setFont(FontUtils.SMALL_FONT);
		ConsumableItem[] quickItemArray = this.player.getPlayerQuickItem();
		if (quickItemArray != null) {
			for (int i = 0; i < quickItemArray.length; i++) {
				int x = this.quickItemButton[i].getLocation().x + 5;
				int y = this.quickItemButton[i].getLocation().y - 5;
				if (quickItemArray[i] != null && quickItemArray[i].getNum() != 0) {
					g.drawString("X" + quickItemArray[i].getNum(), x, y);
				}
			}
		}
	}

	private void setEquipmentStateImage() {
		for (int i = 0; i < 8; i++) {
			if (this.player.getPlayerEquipmentByIndex(i) != null) {
				this.inventoryMyInfoButton[i].setItem(this.player.getPlayerEquipmentByIndex(i));
			} else {
				this.inventoryMyInfoButton[i].setItem(null);
			}
		}
	}

	private void makeInventoryMyInfo() {
		for (int i = 0; i < 8; i++) {
			this.inventoryMyInfoButton[i] = new ItemButton(this.inventoryItemSpaceButtonImage);
			if (i != 7) {
				this.inventoryMyInfoButton[i].setBounds(850, 15 + i * 60, 50, 50);
			} else {
				this.inventoryMyInfoButton[i].setBounds(1000, 15 + i * 60 - 60, 50, 50);
			}
			inventoryMyInfoButton[i].setItemToolTip(toolTipPanel);
			final int index = i;
			this.inventoryMyInfoButton[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					InventoryStatePanel.this.player.takeOffEquipment(index);
					InventoryStatePanel.this.setEquipmentStateImage();
				}
			});
			add(this.inventoryMyInfoButton[i]);
		}
	}

	private void makeQuickItemSpace() {
		for (int i = 0; i < Adventurer.QUICK_ITEM_ARRAY_SIZE; i++) {
			final int index = i;
			this.quickItemButton[i] = new QuickItemButton(this.quickItemButtonImage);
			this.quickItemButton[i].setBounds(235 + i * 60, 330, 50, 50);
			this.quickItemButton[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					InventoryStatePanel.this.quickItemEvent(index);
				}
			});
			add(this.quickItemButton[i]);
		}
	}

	public void quickItemEvent(int index) {
		if (this.quickItemButton[index].getItem() == null) {
			return;
		}
		this.player.usePortion(this.quickItemButton[index].getItem());
		setQuickItemImage();
		setEquipmentStateImage();
	}

	private void makeQuickCancelSpace() {
		for (int i = 0; i < Adventurer.QUICK_ITEM_ARRAY_SIZE; i++) {
			final int keyIndex = i;
			this.quickCancelButton[i] = new MapleButton(this.quickCancelBasicImage, this.quickCancelEnteredImage);
			this.quickCancelButton[i].setBounds(240 + i * 60, 385, 40, 20);
			this.quickCancelButton[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					InventoryStatePanel.this.quickItemCancelEvent(keyIndex);
				}
			});
			add(this.quickCancelButton[i]);
		}
	}

	public void reload() {
		setQuickItemImage();
		setEquipmentStateImage();
		repaint();
	}

	private void quickItemCancelEvent(int keyIndex) {
		this.player.removeQuickItem(keyIndex);
		setQuickItemImage();
	}

	public void setQuickItemImage() {
		for (int i = 0; i < Adventurer.QUICK_ITEM_ARRAY_SIZE; i++) {
			ConsumableItem item = this.player.getPlayerQuickItemByIndex(i);
			if (item != null && item.getNum() != 0) {
				this.quickItemButton[i].setItem(this.player.getPlayerQuickItemByIndex(i));
			} else {
				this.quickItemButton[i].setItem(null);
			}
		}
	}

	private void makeStateUpButton() {
		for (int i = 0; i < 4; i++) {
			final int index = i;
			this.stateUpButton[i] = new MapleButton(this.stateUpButtonBasicImage, this.stateUpButtonEnteredImage);
			this.stateUpButton[i].setBounds(450, 25 + i * 30, 20, 20);
			this.stateUpButton[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					InventoryStatePanel.this.stateUpButtonEvent(index);
				}
			});
			add(this.stateUpButton[i]);
		}
	}

	private void stateUpButtonEvent(int index) {
		Status st = this.player.getMainAdventurer().getStatus();
		if (this.player.getMainAdventurer().getStatePoint() >= 1) {
			if (index == 0) {
				st.addStr();
			} else if (index == 1) {
				st.addDex();
			} else if (index == 2) {
				st.addInt();
			} else if (index == 3) {
				st.addLuk();
			}
			this.player.getMainAdventurer().spendStatePoint();
		}
		this.player.calState();
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
}
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
import character.Resistance;
import character.Status;
import component.MapleButton;
import component.QuickItemButton;
import item.ConsumableItem;
import item.ItemButton;
import maplestory.MainMapleInterface;
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
	private MainMapleInterface mainMapleInterface;
	
	private static final int LINE_X[] = {50, 300, 550};
	
	private ItemTooltipPanel toolTipPanel = new ItemTooltipPanel();

	public InventoryStatePanel(Player player, MainMapleInterface mainMapleInterface) {
		setLayout(null);
		setVisible(true);
		this.player = player;
		this.mainMapleInterface = mainMapleInterface;
		toolTipPanel.setBounds(0, 0, InventoryMainPanel.INVENTORY_COMPONENT_WIDTH - 10, InventoryMainPanel.INVENTORY_COMPONENT_HEIGHT - 10);
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
		g.drawString("래벨", LINE_X[0], 100);
		g.setColor(Color.white);
		g.drawString(adventurer.getStrength().getLevel()+"", LINE_X[0] + 50, 100);
		g.setColor(Color.yellow);
		g.drawString("경험치", LINE_X[0], 130);
		g.setColor(Color.white);
		g.drawString(adventurer.getExp() + "/" + adventurer.getNeedExp(), LINE_X[0] + 60, 130);
		g.setColor(Color.red);
		g.drawString("HP", LINE_X[0], 160);
		g.setColor(Color.white);
		g.drawString(adventurer.getCurHp() + "/" + adventurer.getStrength().getMaxHp(), LINE_X[0] + 45, 160);
		g.setColor(Color.blue);
		g.drawString("MP", LINE_X[0], 190);
		g.setColor(Color.white);
		g.drawString(adventurer.getCurMp() + "/" + adventurer.getStrength().getMaxMp(), LINE_X[0] + 45, 190);
		g.setColor(Color.YELLOW);
		g.drawString("물리 공격력", LINE_X[0], 220);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getPhysicalDamage()+"", LINE_X[0] + 100, 220);
		g.setColor(Color.YELLOW);
		g.drawString("마법 공격력", LINE_X[0], 250);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getMagicDamage()+"", LINE_X[0] + 100, 250);
		g.setColor(Color.YELLOW);
		g.drawString("물리 방어력", LINE_X[0], 280);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getPhysicalDefense()+"", LINE_X[0] + 100, 280);
		g.setColor(Color.YELLOW);
		g.drawString("마법 방어력", LINE_X[0], 310);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getMagicDefense()+"", LINE_X[0] + 100, 310);
		g.setColor(Color.YELLOW);
		g.drawString("적중률", LINE_X[0], 340);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getAccuracyRate()+"", 110, 340);
		g.setColor(Color.YELLOW);
		g.drawString("회피율", LINE_X[0], 370);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getEvasionRate()+"", 110, 370);
		g.setColor(Color.YELLOW);
		g.drawString("메소", LINE_X[0], 400);
		g.setColor(Color.WHITE);
		g.drawString(this.player.getInventory().getMoney()+"", 90, 400);
		g.setColor(Color.YELLOW);
		g.drawString("STR", LINE_X[1], 40);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getTempStatus().getStr()+"", LINE_X[1] + 60, 40);
		g.setColor(Color.YELLOW);
		g.drawString("DEX", LINE_X[1], 70);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getTempStatus().getDex()+"", LINE_X[1] + 60, 70);
		g.setColor(Color.YELLOW);
		g.drawString("INT", LINE_X[1], 100);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getTempStatus().getInt()+"", LINE_X[1] + 60, 100);
		g.setColor(Color.YELLOW);
		g.drawString("LUK", LINE_X[1], 130);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getTempStatus().getLuk()+"", LINE_X[1] + 60, 130);
		g.setColor(Color.YELLOW);
		g.drawString("스텟 포인트", LINE_X[1], 160);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStatePoint()+"", LINE_X[1] + 100, 160);
		g.setColor(Color.YELLOW);
		g.drawString("물리 데미지", LINE_X[1], 190);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getMinPhysicalDamage() + "~" + adventurer.getMaxPhysicalDamage(), LINE_X[1] +100, 190);
		g.setColor(Color.YELLOW);
		g.drawString("마법 데미지", LINE_X[1], 220);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getMinMagicDamage() + "~" + adventurer.getMaxMagicDamage(), LINE_X[1] + 100, 220);
		g.setColor(Color.YELLOW);
		g.drawString("크리티컬확률", LINE_X[1], 250);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getStrength().getCriticalRate()+"%", LINE_X[1] + 110, 250);
		g.setColor(Color.YELLOW);
		g.drawString("직업", LINE_X[1], 280);
		g.setColor(Color.WHITE);
		g.drawString(adventurer.getCareer(), LINE_X[1] + 50, 280);
		g.setColor(Color.YELLOW);
		g.drawString("포션 단축키", LINE_X[2], 40);
		g.setColor(Color.white);
		g.drawString("Q W E R T", LINE_X[2] + 100, 40);
		g.setColor(Color.YELLOW);
		g.drawString("스킬 단축키", LINE_X[2], 70);
		g.setColor(Color.white);
		g.drawString("Z X C V B", LINE_X[2] + 100, 70);
		g.setColor(Color.YELLOW);
		g.drawString("상의", 790, 55);
		g.drawString("하의", 790, 115);
		g.drawString("무기", 790, 175);
		g.drawString("방패", 790, 235);
		g.drawString("모자", 940, 55);
		g.drawString("신발", 940, 115);
		g.drawString("장갑", 940, 175);
		g.drawString("칭호", 940, 235);
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
		g.setFont(FontUtils.generalFont);
		Resistance resistance = player.getMainAdventurer().getStrength().getResistance();
		g.setColor(Color.YELLOW);
		g.drawString("불 저항", LINE_X[2], 130);
		g.drawString("얼음 저항", LINE_X[2], 160);
		g.drawString("독 저항", LINE_X[2], 190);
		g.drawString("번개 저항", LINE_X[2], 220);
		g.drawString("어둠 저항", LINE_X[2], 250);
		g.drawString("성 저항", LINE_X[2], 280);
		g.setColor(Color.WHITE);
		g.drawString(resistance.getFire()+"", LINE_X[2] + 100, 130);
		g.drawString(resistance.getIce()+"", LINE_X[2] + 100, 160);
		g.drawString(resistance.getPosion()+"", LINE_X[2] + 100, 190);
		g.drawString(resistance.getThunder()+"", LINE_X[2] + 100, 220);
		g.drawString(resistance.getDark()+"", LINE_X[2] + 100, 250);
		g.drawString(resistance.getHoly()+"", LINE_X[2] + 100, 280);
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
			if (i < 4) {
				this.inventoryMyInfoButton[i].setBounds(850, 25 + i * 60, 50, 50);
			} else {
				this.inventoryMyInfoButton[i].setBounds(1000, 25 + (i-4) * 60, 50, 50);
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
		if (this.quickItemButton[index].getItem() == null || player.isHunt()) {
			return;
		}
		player.usePortion(mainMapleInterface, this.quickItemButton[index].getItem());
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
			this.stateUpButton[i].setBounds(410, 25 + i * 30, 20, 20);
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
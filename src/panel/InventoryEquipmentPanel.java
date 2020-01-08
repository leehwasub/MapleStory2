package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import item.EquipmentItem;
import item.Item;
import item.ItemButton;
import maplestory.Player;
import utils.FontUtils;
import utils.ResourceLoader;

public class InventoryEquipmentPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon inventoryItemSpaceButtonImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryItemSpaceButton.png"));
	private ItemButton[] inventoryItemSpace = new ItemButton[50];
	private Player player;

	public InventoryEquipmentPanel(Player player) {
		this.player = player;
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		setVisible(false);
		makeSpace();
		setEquipmentItemImage();
	}

	public void inventoryItemEvent(int index) {
		if (this.player.getInventory().getEquipmentInventory().size() <= index) {
			return;
		}
		for (int i = 0; i < 50; i++) {
			this.inventoryItemSpace[i].setVisible(true);
		}
		setEquipmentItemImage();
	}

	private void setEquipmentItemImage() {
		ArrayList<EquipmentItem> equipmentInventory = this.player.getInventory().getEquipmentInventory();
		for (int i = 0; i < equipmentInventory.size(); i++) {
			this.inventoryItemSpace[i].setItem((Item) equipmentInventory.get(i));
		}
		for (int i = equipmentInventory.size(); i < 50; i++) {
			this.inventoryItemSpace[i].setItem(null);
		}
	}

	private void makeSpace() {
		int x = 50;
		int y = 30;
		ArrayList<EquipmentItem> equipmentInventory = this.player.getInventory().getEquipmentInventory();
		for (int i = 0; i < 50; i++) {
			final int index = i;
			this.inventoryItemSpace[i] = new ItemButton(this.inventoryItemSpaceButtonImage);
			if (i < equipmentInventory.size()) {
				this.inventoryItemSpace[i].setItem((Item) equipmentInventory.get(i));
			}
			this.inventoryItemSpace[i].setBounds(x + i % 10 * 100, y + i / 10 * 70, 50, 50);
			this.inventoryItemSpace[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					InventoryEquipmentPanel.this.inventoryItemEvent(index);
				}
			});
			add(this.inventoryItemSpace[i]);
		}
	}

	private void setNearInventoryItemVisibleTrue(int a) {

		for (int i = 0; i < 4; i++) {
			int b = a + i * 10;
			if (b < 50) {
				this.inventoryItemSpace[b].setVisible(true);
			}
		}
		if (a % 10 != 9) {
			for (int i = 0; i < 4; i++) {
				int b = a + i * 10 + 1;
				if (b < 50) {
					this.inventoryItemSpace[b].setVisible(true);
				}
			}
		}
	}

	private void setNearInventoryItemVisibleFalse(int a) {

		for (int i = 0; i < 4; i++) {
			int b = a + i * 10;
			if (b < 50) {
				this.inventoryItemSpace[b].setVisible(false);
			}
		}
		if (a % 10 != 9) {
			for (int i = 0; i < 4; i++) {
				int b = a + i * 10 + 1;
				if (b < 50) {
					this.inventoryItemSpace[b].setVisible(false);
				}
			}
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		g.setColor(Color.YELLOW);
		g.setFont(FontUtils.SMALL_FONT);
		ArrayList<EquipmentItem> equipmentInventory = this.player.getInventory().getEquipmentInventory();
		for (int i = 0; i < equipmentInventory.size(); i++) {
			int x = this.inventoryItemSpace[i].getLocation().x + 5;
			int y = this.inventoryItemSpace[i].getLocation().y - 5;
			g.drawString("X" + ((EquipmentItem) equipmentInventory.get(i)).getNum(), x, y);
			if (this.inventoryItemSpace[i].drawInfor(g)) {
				setNearInventoryItemVisibleFalse(i);
				break;
			}
			setNearInventoryItemVisibleTrue(i);
		}
		repaint();
	}

	public void reload() {
		setEquipmentItemImage();
		repaint();
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
}

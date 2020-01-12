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

import dialog.ItemKeySelectDialog;
import item.ConsumableItem;
import item.Item;
import item.ItemButton;
import maplestory.MainMapleInterface;
import maplestory.Player;
import utils.FontUtils;
import utils.ResourceLoader;

public class InventoryConsumablePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ItemButton[] inventoryItemSpace = new ItemButton[50];
	private Player player;
	private ImageIcon inventoryItemSpaceButtonImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryItemSpaceButton.png"));
	private MainMapleInterface mainMapleInterface;
	
	private ItemTooltipPanel toolTipPanel = new ItemTooltipPanel();

	public InventoryConsumablePanel(Player player, MainMapleInterface mainMapleInterface) {
		this.mainMapleInterface = mainMapleInterface;
		this.player = player;
		
		toolTipPanel.setBounds(0, 0, 1100, 420);
		add(toolTipPanel);
		
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		setVisible(false);
		makeSpace();
		setConsumableItemImage();
		
	}

	private void setConsumableItemImage() {
		ArrayList<ConsumableItem> consumableInventory = this.player.getInventory().getConsumableInventory();
		for (int i = 0; i < consumableInventory.size(); i++) {
			this.inventoryItemSpace[i].setItem((Item) consumableInventory.get(i));
		}
		for (int i = consumableInventory.size(); i < 50; i++) {
			this.inventoryItemSpace[i].setItem(null);
		}
	}

	private void makeSpace() {
		int x = 50;
		int y = 30;
		for (int i = 0; i < 50; i++) {
			final int index = i;
			this.inventoryItemSpace[i] = new ItemButton(this.inventoryItemSpaceButtonImage);
			this.inventoryItemSpace[i].setBounds(x + i % 10 * 100, y + i / 10 * 70, 50, 50);
			this.inventoryItemSpace[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					inventoryItemEvent(index);
				}
			});
			this.inventoryItemSpace[i].setItemToolTip(toolTipPanel);
			add(this.inventoryItemSpace[i]);
		}
	}

	public void reload() {
		setConsumableItemImage();
		repaint();
	}

	public void inventoryItemEvent(int index) {
		if (this.player.getInventory().getConsumableInventory().size() <= index) {
			return;
		}
		int keyIndex = getKeySelectWithDialog();
		if (keyIndex == -1) {
			return;
		}
		this.player.registQuickItem(index, keyIndex);
		setConsumableItemImage();
		mainMapleInterface.setQuickItemImage();
		for (int i = 0; i < 50; i++) {
			this.inventoryItemSpace[i].setVisible(true);
		}
	}

	public int getKeySelectWithDialog() {
		ItemKeySelectDialog dialog = new ItemKeySelectDialog();
		dialog.setVisible(true);
		int getIndex = dialog.getReturnIndex();
		dialog.dispose();
		return getIndex;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		g.setColor(Color.YELLOW);
		g.setFont(FontUtils.SMALL_FONT);
		ArrayList<ConsumableItem> consumableInventory = this.player.getInventory().getConsumableInventory();
		for (int i = 0; i < consumableInventory.size(); i++) {
			int x = this.inventoryItemSpace[i].getLocation().x + 5;
			int y = this.inventoryItemSpace[i].getLocation().y - 5;
			g.drawString("X" + ((ConsumableItem) consumableInventory.get(i)).getNum(), x, y);
		}
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
}

package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import component.MapleButton;
import component.MapleButtonGroup;
import item.ConsumableItem;
import item.EquipmentItem;
import item.Item;
import item.MaterialItem;
import item.PlayerItemRenderer;
import map.Point;
import maplestory.Player;
import utils.ColorUtils;
import utils.FontUtils;
import utils.InputValidUtils;
import utils.ResourceLoader;

public class StoreInventoryPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon inventoryEquipmentButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryEquipmentButtonBasic.png"));
	private ImageIcon inventoryEquipmentButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryEquipmentButtonEntered.png"));
	private ImageIcon inventoryConsumableButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryConsumableButtonBasic.png"));
	private ImageIcon inventoryConsumableButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryConsumableButtonEntered.png"));
	private ImageIcon inventoryMaterialButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryMaterialButtonBasic.png"));
	private ImageIcon inventoryMaterialButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryMaterialButtonEntered.png"));
	private MapleButton inventoryEquipmentButton = new MapleButton(this.inventoryEquipmentButtonBasicImage,
			this.inventoryEquipmentButtonEnteredImage);
	private MapleButton inventoryConsumableButton = new MapleButton(this.inventoryConsumableButtonBasicImage,
			this.inventoryConsumableButtonEnteredImage);
	private MapleButton inventoryMaterialButton = new MapleButton(this.inventoryMaterialButtonBasicImage,
			this.inventoryMaterialButtonEnteredImage);
	public static final int STORE_INVENTORY_WIDTH = 390;
	public static final int STORE_INVENTORY_HEIGHT = 430;
	public static final int BORDER_WIDTH = 4;
	private static final int STORE_INVENTORY_EQUIPMENT = 0;
	private static final int STORE_INVENTORY_CONSUMABLE = 1;
	private static final int STORE_INVENTORY_MATERIAL = 2;
	private TooltipPanel itemTooltip = new TooltipPanel();
	JScrollPane scrollPane;
	DefaultListModel<Item> dm = new DefaultListModel();
	JList<Item> jList = new JList();
	MapleButtonGroup mapleButtonGroup;
	private Player player;
	private int curType;

	public StoreInventoryPanel(final Player player) {
		this.player = player;
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));

		this.itemTooltip.setBounds(0, 0, 450, 600);
		add(this.itemTooltip);

		this.jList.setBounds(20, 20, 250, 365);
		add(this.jList);

		ArrayList<MapleButton> group = new ArrayList();

		this.inventoryEquipmentButton.setSelectedInGroup(true);
		this.inventoryEquipmentButton.setIcon(this.inventoryEquipmentButtonEnteredImage);
		this.inventoryEquipmentButton.setBounds(290, 20, 80, 40);
		this.inventoryEquipmentButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StoreInventoryPanel.this.storeInventorySwapEvent(STORE_INVENTORY_EQUIPMENT);
			}
		});
		group.add(this.inventoryEquipmentButton);
		add(this.inventoryEquipmentButton);
		this.inventoryConsumableButton.setBounds(290, 70, 80, 40);
		this.inventoryConsumableButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StoreInventoryPanel.this.storeInventorySwapEvent(STORE_INVENTORY_CONSUMABLE);
			}
		});
		group.add(this.inventoryConsumableButton);
		add(this.inventoryConsumableButton);
		this.inventoryMaterialButton.setBounds(290, 120, 80, 40);
		this.inventoryMaterialButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StoreInventoryPanel.this.storeInventorySwapEvent(STORE_INVENTORY_MATERIAL);
			}
		});
		group.add(this.inventoryMaterialButton);
		add(this.inventoryMaterialButton);

		this.mapleButtonGroup = new MapleButtonGroup(group);

		this.jList.setCellRenderer(new PlayerItemRenderer());
		this.jList.setModel(this.dm);
		this.jList.setFixedCellHeight(50);
		this.jList.setBorder(new EmptyBorder(10, 10, 10, 10));

		this.jList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Item item = (Item) StoreInventoryPanel.this.jList.getSelectedValue();
				if (item != null) {
					UIManager.put("OptionPane.messageFont", FontUtils.SMALL_FONT);
					String input = JOptionPane.showInputDialog(null, item.getName() + "��(��) ���� ���� ������������?");
					if (input == null) {
						return;
					}
					if (InputValidUtils.isValidIntString(input)) {
						int num = Integer.parseInt(input);
						if (item.getNum() >= num) {
							player.addMoney(num * (item.getCost() / 10));
							item.setNum(item.getNum() - num);
							JOptionPane.showMessageDialog(null, "������ ��������������.");
							player.removeEmptyItem();
							StoreInventoryPanel.this.updateStoreInventory();
						} else {
							JOptionPane.showMessageDialog(null, "������ ����������.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "1000이하의 올바른 숫자를 입력해 주세요.");
					}
				}
			}

			public void mouseExited(MouseEvent e) {
				StoreInventoryPanel.this.itemTooltip.setVisible(false);
			}
		});
		this.jList.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				JList<Item> l = (JList) e.getSource();
				ListModel<Item> m = l.getModel();
				if (m.getSize() == 0) {
					return;
				}
				int index = l.locationToIndex(e.getPoint());
				JScrollBar b = StoreInventoryPanel.this.scrollPane.getVerticalScrollBar();
				StoreInventoryPanel.this.itemTooltip.setPoint(new Point(e.getX() + 20, e.getY() + 20 - b.getValue()));
				StoreInventoryPanel.this.itemTooltip.setVisible(true);
				StoreInventoryPanel.this.itemTooltip.setItem((Item) m.getElementAt(index));
				StoreInventoryPanel.this.repaint();
			}
		});
		this.scrollPane = new JScrollPane(this.jList);
		this.scrollPane.setBounds(20, 20, 250, 365);
		add(this.scrollPane);

		storeInventorySwapEvent(0);
	}

	public void storeInventorySwapEvent(int type) {
		this.curType = type;
		this.dm.clear();
		if (type == 0) {
			ArrayList<EquipmentItem> itemList = this.player.getInventory().getEquipmentInventory();
			for (int i = 0; i < itemList.size(); i++) {
				this.dm.addElement((Item) itemList.get(i));
			}
		} else if (type == 1) {
			ArrayList<ConsumableItem> itemList = this.player.getInventory().getConsumableInventory();
			for (int i = 0; i < itemList.size(); i++) {
				this.dm.addElement((Item) itemList.get(i));
			}
		} else if (type == 2) {
			ArrayList<MaterialItem> itemList = this.player.getInventory().getMaterialInventory();
			for (int i = 0; i < itemList.size(); i++) {
				this.dm.addElement((Item) itemList.get(i));
			}
		}
		this.jList.setModel(this.dm);
	}

	public void updateStoreInventory() {
		storeInventorySwapEvent(this.curType);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		g.setColor(ColorUtils.PANEL_CENTER);
		g.fillRect(0, 0, 390, 430);
		g.setColor(ColorUtils.PANEL_BORDER);
		g.fillRect(0, 0, 4, 430);
		g.fillRect(386, 0, 4, 430);
		g.fillRect(0, 0, 390, 4);
		g.fillRect(0, 426, 390, 4);
		g.setFont(FontUtils.SMALL_FONT_2);
		g.setColor(Color.YELLOW);
		g.drawString(this.player.getInventory().getMoney() + " 메소", 25, 410);
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
}

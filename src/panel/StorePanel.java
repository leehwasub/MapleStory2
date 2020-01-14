package panel;

import java.awt.Color;
import java.awt.Graphics;
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
import item.Item;
import item.ItemPool;
import map.Point;
import maplestory.Player;
import renderer.StoreItemRenderer;
import shop.Shop;
import utils.ColorUtils;
import utils.FontUtils;
import utils.InputValidUtils;
import utils.ResourceLoader;

public class StorePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int STORE_INVENTORY_WIDTH = 510;
	public static final int STORE_INVENTORY_HEIGHT = 430;
	public static final int BORDER_WIDTH = 4;
	private static final int STORE_WEAPON = 0;
	private static final int STORE_EQUIPMENT = 1;
	private static final int STORE_CONSUMABLE = 2;
	private ImageIcon storeWeaponButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeWeaponButtonBasic.png"));
	private ImageIcon storeWeaponButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeWeaponButtonEntered.png"));
	private ImageIcon storeEquipmentButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryEquipmentButtonBasic.png"));
	private ImageIcon storeEquipmentButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryEquipmentButtonEntered.png"));
	private ImageIcon storeConsumableButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryConsumableButtonBasic.png"));
	private ImageIcon storeConsumableButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryConsumableButtonEntered.png"));
	private MapleButton storeWeaponButton = new MapleButton(storeWeaponButtonBasicImage,
			storeWeaponButtonEnteredImage);
	private MapleButton storeEquipmentButton = new MapleButton(storeEquipmentButtonBasicImage,
			storeEquipmentButtonEnteredImage);
	private MapleButton storeConsumableButton = new MapleButton(this.storeConsumableButtonBasicImage,
			storeConsumableButtonEnteredImage);
	private ItemTooltipPanel itemTooltip = new ItemTooltipPanel();
	DefaultListModel<Item> dm = new DefaultListModel<Item>();
	JList<Item> jList = new JList<Item>();
	MapleButtonGroup mapleButtonGroup;
	private Player player;
	private Shop shop;
	private int curType;
	private JScrollPane scrollPane;

	public StorePanel(Shop shop, final Player player) {
		this.player = player;
		this.shop = shop;
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		this.itemTooltip.setBounds(0, 0, 600, 600);
		add(this.itemTooltip);

		this.jList.setBounds(140, 20, 250, 365);
		add(this.jList);

		ArrayList<MapleButton> group = new ArrayList<MapleButton>();

		this.storeWeaponButton.setSelectedInGroup(true);
		this.storeWeaponButton.setIcon(this.storeWeaponButtonEnteredImage);
		this.storeWeaponButton.setBounds(410, 20, 80, 40);
		this.storeWeaponButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StorePanel.this.storeSwapEvent(STORE_WEAPON);
			}
		});
		group.add(storeWeaponButton);
		add(storeWeaponButton);
		
		this.storeEquipmentButton.setBounds(410, 70, 80, 40);
		this.storeEquipmentButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StorePanel.this.storeSwapEvent(STORE_EQUIPMENT);
			}
		});
		group.add(storeEquipmentButton);
		add(storeEquipmentButton);
		
		this.storeConsumableButton.setBounds(410, 120, 80, 40);
		this.storeConsumableButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StorePanel.this.storeSwapEvent(STORE_CONSUMABLE);
			}
		});
		group.add(this.storeConsumableButton);
		add(this.storeConsumableButton);


		this.mapleButtonGroup = new MapleButtonGroup(group);

		this.jList.setCellRenderer(new StoreItemRenderer());
		this.jList.setModel(this.dm);
		this.jList.setFixedCellHeight(50);
		this.jList.setBorder(new EmptyBorder(10, 10, 10, 10));

		this.jList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Item item = (Item) StorePanel.this.jList.getSelectedValue();
				if (item != null) {
					UIManager.put("OptionPane.messageFont", FontUtils.SMALL_FONT);
					String input = JOptionPane.showInputDialog(null, item.getName() + "을(를) 몇개 구매 하시겠습니까?");
					if (input == null) {
						return;
					}
					if (InputValidUtils.isValidIntString(input)) {
						int num = Integer.parseInt(input);
						if (player.getInventory().getMoney() >= num * item.getCost()) {
							player.subMoney(num * item.getCost());
							player.addItem(ItemPool.getItem(item.getName(), num));
							JOptionPane.showMessageDialog(null, "구매가 완료되었습니다.");
						} else {
							JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "1000이하의 올바른 숫자를 입력해 주세요.");
					}
				}
			}

			public void mouseExited(MouseEvent e) {
				itemTooltip.setVisible(false);
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
				JScrollBar b = StorePanel.this.scrollPane.getVerticalScrollBar();
				StorePanel.this.itemTooltip.setPoint(new Point(e.getX() + 140, e.getY() + 20 - b.getValue()));
				StorePanel.this.itemTooltip.setVisible(true);
				StorePanel.this.itemTooltip.setItem((Item) m.getElementAt(index));
			}
		});
		this.scrollPane = new JScrollPane(this.jList);
		this.scrollPane.setBounds(140, 20, 250, 365);
		add(this.scrollPane);

		storeSwapEvent(0);
	}

	public void storeSwapEvent(int type) {
		this.curType = type;
		this.dm.clear();
		ArrayList<Item> itemList = new ArrayList<Item>();
		if (type == STORE_WEAPON) {
			itemList = this.shop.getWeaponItemList();
		} else if (type == STORE_EQUIPMENT) {
			itemList = this.shop.getEquipmentItemList();
		} else if (type == STORE_CONSUMABLE) {
			itemList = this.shop.getConsumableItemList();
		}
		for (int i = 0; i < itemList.size(); i++) {
			this.dm.addElement((Item) itemList.get(i));
		}
		this.jList.setModel(this.dm);
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
		storeSwapEvent(this.curType);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(ColorUtils.PANEL_CENTER);
		g.fillRect(0, 0, 510, 430);
		g.setColor(ColorUtils.PANEL_BORDER);
		g.fillRect(0, 0, 4, 430);
		g.fillRect(506, 0, 4, 430);
		g.fillRect(0, 0, 510, 4);
		g.fillRect(0, 426, 510, 4);
		g.drawImage(this.shop.getNpcImage(), 20, 20, this);
	}
}

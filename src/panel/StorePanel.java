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
import item.StoreItemRenderer;
import map.Point;
import maplestory.Player;
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
	private static final int STORE_SHARE = 0;
	private static final int STORE_CONSUMABLE = 1;
	private static final int STORE_WARRIOR = 2;
	private static final int STORE_MAGICIAN = 3;
	private static final int STORE_THIEF = 4;
	private static final int STORE_ARCHER = 5;
	private ImageIcon storeShareButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeShareButtonBasic.png"));
	private ImageIcon storeShareButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeShareButtonEntered.png"));
	private ImageIcon storeConsumableButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryConsumableButtonBasic.png"));
	private ImageIcon storeConsumableButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryConsumableButtonEntered.png"));
	private ImageIcon storeWarriorButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeWarriorButtonBasic.png"));
	private ImageIcon storeWarriorButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeWarriorButtonEntered.png"));
	private ImageIcon storeMagicianButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeMagicianButtonBasic.png"));
	private ImageIcon storeMagicianButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeMagicianButtonEntered.png"));
	private ImageIcon storeThiefButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeThiefButtonBasic.png"));
	private ImageIcon storeThiefButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeThiefButtonEntered.png"));
	private ImageIcon storeArcherButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeArcherButtonBasic.png"));
	private ImageIcon storeArcherButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeArcherButtonEntered.png"));
	private MapleButton storeShareButton = new MapleButton(this.storeShareButtonBasicImage,
			this.storeShareButtonEnteredImage);
	private MapleButton storeConsumableButton = new MapleButton(this.storeConsumableButtonBasicImage,
			this.storeConsumableButtonEnteredImage);
	private MapleButton storeWarriorButton = new MapleButton(this.storeWarriorButtonBasicImage,
			this.storeWarriorButtonEnteredImage);
	private MapleButton storeMagicianButton = new MapleButton(this.storeMagicianButtonBasicImage,
			this.storeMagicianButtonEnteredImage);
	private MapleButton storeThiefButton = new MapleButton(this.storeThiefButtonBasicImage,
			this.storeThiefButtonEnteredImage);
	private MapleButton storeArcherButton = new MapleButton(this.storeArcherButtonBasicImage,
			this.storeArcherButtonEnteredImage);
	private TooltipPanel itemTooltip = new TooltipPanel();
	DefaultListModel<Item> dm = new DefaultListModel();
	JList<Item> jList = new JList();
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

		this.storeShareButton.setSelectedInGroup(true);
		this.storeShareButton.setIcon(this.storeShareButtonEnteredImage);
		this.storeShareButton.setBounds(410, 20, 80, 40);
		this.storeShareButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StorePanel.this.storeSwapEvent(0);
			}
		});
		group.add(this.storeShareButton);
		add(this.storeShareButton);
		this.storeConsumableButton.setBounds(410, 70, 80, 40);
		this.storeConsumableButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StorePanel.this.storeSwapEvent(1);
			}
		});
		group.add(this.storeConsumableButton);
		add(this.storeConsumableButton);
		this.storeWarriorButton.setBounds(410, 120, 80, 40);
		this.storeWarriorButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StorePanel.this.storeSwapEvent(2);
			}
		});
		group.add(this.storeWarriorButton);
		add(this.storeWarriorButton);
		this.storeMagicianButton.setBounds(410, 170, 80, 40);
		this.storeMagicianButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StorePanel.this.storeSwapEvent(3);
			}
		});
		group.add(this.storeMagicianButton);
		add(this.storeMagicianButton);
		this.storeThiefButton.setBounds(410, 220, 80, 40);
		this.storeThiefButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StorePanel.this.storeSwapEvent(4);
			}
		});
		group.add(this.storeThiefButton);
		add(this.storeThiefButton);
		this.storeArcherButton.setBounds(410, 270, 80, 40);
		this.storeArcherButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				StorePanel.this.storeSwapEvent(5);
			}
		});
		group.add(this.storeArcherButton);
		add(this.storeArcherButton);

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
				StorePanel.this.itemTooltip.setVisible(false);
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
		ArrayList<Item> itemList = new ArrayList();
		if (type == 0) {
			itemList = this.shop.getShareItemList();
		} else if (type == 1) {
			itemList = this.shop.getConsumableItemList();
		} else if (type == 2) {
			itemList = this.shop.getWarriorItemList();
		} else if (type == 3) {
			itemList = this.shop.getMagicianItemList();
		} else if (type == 4) {
			itemList = this.shop.getThiefItemList();
		} else if (type == 5) {
			itemList = this.shop.getArcherItemList();
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

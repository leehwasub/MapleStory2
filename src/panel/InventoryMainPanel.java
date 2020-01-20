package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import component.MapleButton;
import component.MapleButtonGroup;
import maplestory.MainMapleInterface;
import maplestory.Player;
import utils.ResourceLoader;

public class InventoryMainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image inventoryMainImage = ResourceLoader.getImage("componentImage", "inventoryMainImage.png");
	private Player player;
	boolean isActive;
	private ImageIcon inventoryStateButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryStateButtonBasic.png"));
	private ImageIcon inventoryStateButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryStateButtonEntered.png"));
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
	private ImageIcon inventoryQuestButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryQuestButtonBasic.png"));
	private ImageIcon inventoryQuestButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryQuestButtonEntered.png"));
	private ImageIcon inventorySkillButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventorySkillButtonBasic.png"));
	private ImageIcon inventorySkillButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventorySkillButtonEntered.png"));
	private ImageIcon inventorySystemButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventorySystemButtonBasic.png"));
	private ImageIcon inventorySystemButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventorySystemButtonEntered.png"));
	private MapleButton inventoryStateButton = new MapleButton(this.inventoryStateButtonBasicImage,
			this.inventoryStateButtonEnteredImage);
	private MapleButton inventoryEquipmentButton = new MapleButton(this.inventoryEquipmentButtonBasicImage,
			this.inventoryEquipmentButtonEnteredImage);
	private MapleButton inventoryConsumableButton = new MapleButton(this.inventoryConsumableButtonBasicImage,
			this.inventoryConsumableButtonEnteredImage);
	private MapleButton inventoryMaterialButton = new MapleButton(this.inventoryMaterialButtonBasicImage,
			this.inventoryMaterialButtonEnteredImage);
	private MapleButton inventoryQuestButton = new MapleButton(this.inventoryQuestButtonBasicImage,
			this.inventoryQuestButtonEnteredImage);
	private MapleButton inventorySkillButton = new MapleButton(this.inventorySkillButtonBasicImage,
			this.inventorySkillButtonEnteredImage);
	private MapleButton inventorySystemButton = new MapleButton(this.inventorySystemButtonBasicImage,
			this.inventorySystemButtonEnteredImage);
	public static final int INVENTORY_STATE = 0;
	public static final int INVENTORY_EQUIPMENT = 1;
	public static final int INVENTORY_CONSUMABLE = 2;
	public static final int INVENTORY_MATERIAL = 3;
	public static final int INVENTORY_QUEST = 4;
	public static final int INVENTORY_SKILL = 5;
	public static final int INVENTORY_SYSTEM = 6;
	private InventoryStatePanel inventoryStatePanel;
	private InventoryEquipmentPanel inventoryEquipmentPanel;
	private InventoryConsumablePanel inventoryConsumablePanel;
	private InventoryMaterialPanel inventoryMaterialPanel;
	private InventoryQuestPanel inventoryQuestPanel;
	private InventorySkillPanel inventorySkillPanel;
	private InventorySystemPanel inventorySystemPanel;
	private int inventoryState;
	
	private MapleButtonGroup mapleButtonGroup;
	
	private MainMapleInterface mainMapleInterface;
	
	public static final int INVENTORY_COMPONENT_WIDTH = 1190;
	public static final int INVENTORY_COMPONENT_HEIGHT = 552;

	public InventoryMainPanel(Player player, MainMapleInterface mainMapleInterface) {
		setLayout(null);
		setVisible(false);
		setBackground(new Color(0, 0, 0, 0));
		
		this.player = player;
		this.mainMapleInterface = mainMapleInterface;
		this.inventoryStatePanel = new InventoryStatePanel(player, mainMapleInterface);
		this.inventoryStatePanel.setBounds(50, 98, INVENTORY_COMPONENT_WIDTH, INVENTORY_COMPONENT_HEIGHT);
		add(this.inventoryStatePanel);

		this.inventoryEquipmentPanel = new InventoryEquipmentPanel(player);
		this.inventoryEquipmentPanel.setBounds(50, 98, INVENTORY_COMPONENT_WIDTH, INVENTORY_COMPONENT_HEIGHT);
		add(this.inventoryEquipmentPanel);

		this.inventoryConsumablePanel = new InventoryConsumablePanel(player, mainMapleInterface);
		this.inventoryConsumablePanel.setBounds(50, 98, INVENTORY_COMPONENT_WIDTH, INVENTORY_COMPONENT_HEIGHT);
		add(this.inventoryConsumablePanel);

		this.inventoryMaterialPanel = new InventoryMaterialPanel(player);
		this.inventoryMaterialPanel.setBounds(50, 98, INVENTORY_COMPONENT_WIDTH, INVENTORY_COMPONENT_HEIGHT);
		add(this.inventoryMaterialPanel);

		this.inventoryQuestPanel = new InventoryQuestPanel(player);
		this.inventoryQuestPanel.setBounds(50, 98, INVENTORY_COMPONENT_WIDTH, INVENTORY_COMPONENT_HEIGHT);
		add(this.inventoryQuestPanel);

		this.inventorySkillPanel = new InventorySkillPanel(player, mainMapleInterface);
		this.inventorySkillPanel.setBounds(50, 98, INVENTORY_COMPONENT_WIDTH, INVENTORY_COMPONENT_HEIGHT);
		add(this.inventorySkillPanel);

		this.inventorySystemPanel = new InventorySystemPanel(player, mainMapleInterface);
		this.inventorySystemPanel.setBounds(50, 98, INVENTORY_COMPONENT_WIDTH, INVENTORY_COMPONENT_HEIGHT);
		add(this.inventorySystemPanel);
		
		ArrayList<MapleButton> group = new ArrayList<MapleButton>();

		this.inventoryStateButton.setBounds(80, 40, 80, 40);
		this.inventoryStateButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				InventoryMainPanel.this.inventorySwapEvent(0);
			}
		});
		add(this.inventoryStateButton);
		group.add(inventoryStateButton);
		this.inventoryEquipmentButton.setBounds(170, 40, 80, 40);
		this.inventoryEquipmentButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				InventoryMainPanel.this.inventorySwapEvent(1);
			}
		});
		add(this.inventoryEquipmentButton);
		group.add(inventoryEquipmentButton);
		this.inventoryConsumableButton.setBounds(260, 40, 80, 40);
		this.inventoryConsumableButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				InventoryMainPanel.this.inventorySwapEvent(2);
			}
		});
		add(this.inventoryConsumableButton);
		group.add(inventoryConsumableButton);
		this.inventoryMaterialButton.setBounds(350, 40, 80, 40);
		this.inventoryMaterialButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				InventoryMainPanel.this.inventorySwapEvent(3);
			}
		});
		add(this.inventoryMaterialButton);
		group.add(inventoryMaterialButton);
		this.inventoryQuestButton.setBounds(440, 40, 80, 40);
		this.inventoryQuestButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				InventoryMainPanel.this.inventorySwapEvent(4);
			}
		});
		add(this.inventoryQuestButton);
		group.add(inventoryQuestButton);
		this.inventorySkillButton.setBounds(530, 40, 80, 40);
		this.inventorySkillButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				InventoryMainPanel.this.inventorySwapEvent(5);
			}
		});
		add(this.inventorySkillButton);
		group.add(inventorySkillButton);
		this.inventorySystemButton.setBounds(620, 40, 80, 40);
		this.inventorySystemButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				InventoryMainPanel.this.inventorySwapEvent(6);
			}
		});
		add(this.inventorySystemButton);
		group.add(inventorySystemButton);
		
		mapleButtonGroup = new MapleButtonGroup(group);
	}

	private void setVisibleFalsePanels() {
		if (this.inventoryState != 0) {
			this.inventoryStatePanel.setVisible(false);
		} else {
			this.inventoryStatePanel.setVisible(true);
			this.inventoryStatePanel.reload();
		}
		if (this.inventoryState != 1) {
			this.inventoryEquipmentPanel.setVisible(false);
		} else {
			this.inventoryEquipmentPanel.setVisible(true);
			this.inventoryEquipmentPanel.reload();
		}
		if (this.inventoryState != 2) {
			this.inventoryConsumablePanel.setVisible(false);
		} else {
			this.inventoryConsumablePanel.setVisible(true);
			this.inventoryConsumablePanel.reload();
		}
		if (this.inventoryState != 3) {
			this.inventoryMaterialPanel.setVisible(false);
		} else {
			this.inventoryMaterialPanel.setVisible(true);
			this.inventoryMaterialPanel.reload();
		}
		if (this.inventoryState != 4) {
			this.inventoryQuestPanel.setVisible(false);
		} else {
			this.inventoryQuestPanel.setVisible(true);
		}
		if (this.inventoryState != 5) {
			this.inventorySkillPanel.setVisible(false);
		} else {
			this.inventorySkillPanel.setVisible(true);
			inventorySkillPanel.skillLoad();
		}
		if (this.inventoryState != 6) {
			this.inventorySystemPanel.setVisible(false);
		} else {
			this.inventorySystemPanel.setVisible(true);
		}
	}

	private void inventorySwapEvent(int inventoryState) {
		this.inventoryState = inventoryState;
		this.player.getMainAdventurer().calState();
		setVisibleFalsePanels();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		g.drawImage(this.inventoryMainImage, 0, 0, this);
		repaint();
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}

	public boolean toggleMapleInventory() {
		if (this.isActive) {
			this.isActive = false;
		} else {
			this.isActive = true;
			setVisibleFalsePanels();
		}
		return this.isActive;
	}
}

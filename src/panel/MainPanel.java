package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import attack.DamageText;
import character.Monster;
import component.MapleButton;
import component.MapleExpBar;
import component.MapleHpBar;
import component.MapleIsland;
import component.MapleMpBar;
import component.MessageBox;
import component.MessageBoxComponent;
import component.StateBox;
import dialog.JobSelectDialog;
import hunt.HuntComponent;
import map.MapleMap;
import map.PointMapName;
import maplestory.MainMapleInterface;
import maplestory.MapleInterface;
import maplestory.Message;
import maplestory.MessageList;
import maplestory.Player;
import monster.MonsterFactory;
import sailing.Sailing;
import sailing.SailingFactory;
import shop.MapleIslandShop;
import shop.Shop;
import shop.ShopList;
import utils.DrawUtils;
import utils.MusicUtils;
import utils.ResourceLoader;

public class MainPanel extends JPanel implements MainMapleInterface {
	private static final long serialVersionUID = 1L;
	private Image backgroundImage = ResourceLoader.getImage("backgroundImage", "mainBackgroundImage.png");
	private Image messageSpaceImage = ResourceLoader.getImage("componentImage", "messageSpaceImage.png");
	private Image stateBoxImage = ResourceLoader.getImage("componentImage", "stateBoxImage.png");
	private Image meetEventSpaceImage = ResourceLoader.getImage("componentImage", "meetEventSpaceImage.png");
	private ImageIcon inventoryButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryButtonBasic.png"));
	private ImageIcon inventoryButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryButtonEntered.png"));
	private ImageIcon islandMapButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "islandMapButtonBasic.png"));
	private ImageIcon islandMapButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "islandMapButtonEntered.png"));
	private ImageIcon meetNpcButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "meetNpcButtonBasic.png"));
	private ImageIcon meetNpcButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "meetNpcButtonEntered.png"));
	private ImageIcon moveOtherMapButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "moveOtherMapButtonBasic.png"));
	private ImageIcon moveOtherMapButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "moveOtherMapButtonEntered.png"));
	private ImageIcon nextButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "nextButtonBasic.png"));
	private ImageIcon nextButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "nextButtonEntered.png"));
	private ImageIcon buyItemButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "buyItemButtonBasic.png"));
	private ImageIcon buyItemButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "buyItemButtonEntered.png"));
	private ImageIcon storeOutButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeOutButtonBasic.png"));
	private ImageIcon storeOutButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "storeOutButtonEntered.png"));
	private ArrayList<JProgressBar> mainProgressBars = new ArrayList<JProgressBar>();
	private MapleHpBar hpBar;
	private MapleMpBar mpBar;
	private MapleExpBar expBar;
	private MapleButton inventoryButton = new MapleButton(this.inventoryButtonBasicImage,
			this.inventoryButtonEnteredImage);
	private MapleButton islandMapButton = new MapleButton(this.islandMapButtonBasicImage,
			this.islandMapButtonEnteredImage);
	private MapleButton meetNpcButton = new MapleButton(this.meetNpcButtonBasicImage, this.meetNpcButtonEnteredImage,
			false);
	private MapleButton moveOtherMapButton = new MapleButton(this.moveOtherMapButtonBasicImage,
			this.moveOtherMapButtonEnteredImage, false);
	private MapleButton nextButton = new MapleButton(this.nextButtonBasicImage, this.nextButtonEnteredImage, false);
	private MapleButton buyItemButton = new MapleButton(this.buyItemButtonBasicImage, this.buyItemButtonEnteredImage,
			false);
	private MapleButton storeOutButton = new MapleButton(this.storeOutButtonBasicImage, this.storeOutButtonEnteredImage,
			false);
	private static final int BUTTON_WIDTH = 300;
	private static final int BUTTON_HEIGHT = 75;
	private static final int POSITON_X = 490;
	private static final int POSITON_Y = 300;
	private static final int POSITON_INTERVAL = 90;
	private MapleIsland mapleIsland = new MapleIsland();
	private MapleInterface mapleInterface;
	private Player player;
	private InventoryMainPanel inventoryMainPanel;
	private MessageList messageList = new MessageList();
	private ArrayList<DamageText> damageTextList = new ArrayList<DamageText>();
	private String messageString;
	private HuntComponent huntComponent;
	private StoreInventoryPanel storeInventory;
	private StorePanel store;
	private MessageBox mainMessageBox = new MessageBox(1010, 130, 2, Color.CYAN);
	
	private QuickButtonPanel quickButtonPanel;

	public MainPanel(MapleInterface mapleInterface, final Player player) {
		setLayout(null);
		this.player = player;
		this.mapleInterface = mapleInterface;
		MusicUtils.changeMusic(player.get_curMap().getMusic());
		this.backgroundImage = player.get_curMap().getBackground();

		this.inventoryButton.setBounds(1140, 20, 120, 40);
		this.inventoryButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MainPanel.this.inventoryButtonEvent();
			}

			public void mouseReleased(MouseEvent e) {
				MainPanel.this.repaint();
			}
		});
		add(this.inventoryButton);

		this.islandMapButton.setBounds(1010, 20, 120, 40);
		this.islandMapButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MainPanel.this.islandMapButtonEvent();
			}

			public void mouseReleased(MouseEvent e) {
				MainPanel.this.repaint();
			}
		});
		add(this.islandMapButton);

		this.meetNpcButton.setBounds(1140, 70, 120, 40);
		this.meetNpcButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MainPanel.this.converstionStartEvent();
			}
		});
		add(this.meetNpcButton);

		this.moveOtherMapButton.setBounds(1140, 70, 120, 40);
		this.moveOtherMapButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MainPanel.this.moveOtherMapEvent();
			}
		});
		add(this.moveOtherMapButton);

		this.buyItemButton.setBounds(1140, 70, 120, 40);
		this.buyItemButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MainPanel.this.storeOpenEvent();
			}
		});
		add(this.buyItemButton);

		this.storeOutButton.setBounds(1050, 60, 30, 30);
		this.storeOutButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MainPanel.this.storeCloseEvent();
			}
		});
		add(this.storeOutButton);

		this.nextButton.setBounds(1200, 620, 60, 60);
		this.nextButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (!player.isCanEndConversation()) {
					MainPanel.this.conversationEvent();
				} else {
					MainPanel.this.converstionEndEvent();
					player.setCanEndConversation(false);
				}
				MainPanel.this.repaint();
			}
		});
		add(this.nextButton);

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (player.getIsCanMove()) {
					if (e.getKeyCode() == 38) {
						player.move(2);
						moveEvent();
					} else if (e.getKeyCode() == 37) {
						player.move(0);
						moveEvent();
					} else if (e.getKeyCode() == 39) {
						player.move(1);
						moveEvent();
					} else if (e.getKeyCode() == 40) {
						player.move(3);
						moveEvent();
					}
					MainPanel.this.repaint();
				}
				if (nextButton.isVisible() && (e.getKeyCode() == 39)) {
					if (!player.isCanEndConversation()) {
						conversationEvent();
					} else {
						converstionEndEvent();
						player.setCanEndConversation(false);
					}
					mainStateBarUpdate();
					repaint();
				}
				if (meetNpcButton.isVisible() && (e.getKeyCode() == 80)) {
					converstionStartEvent();
				}
				if (moveOtherMapButton.isVisible() && (e.getKeyCode() == 80)) {
					moveOtherMapEvent();
				}
				if (islandMapButton.isVisible() && (e.getKeyCode() == 79)) {
					islandMapButtonEvent();
					Thread thread = new Thread() {
						public void run() {
							try {
								sleep(50L);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							MainPanel.this.repaint();
						}
					};
					thread.start();
				}
				if (inventoryButton.isVisible() && (e.getKeyCode() == 73)) {
					MainPanel.this.inventoryButtonEvent();
					Thread thread = new Thread() {
						public void run() {
							try {
								sleep(50L);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							MainPanel.this.repaint();
						}
					};
					thread.start();
				}
				if (storeOutButton.isVisible() && (e.getKeyCode() == 27)) {
					MainPanel.this.storeCloseEvent();
				}
				if (buyItemButton.isVisible() && (e.getKeyCode() == 75)) {
					storeOpenEvent();
				}
				if(e.getKeyCode() == KeyEvent.VK_M) {
					JobSelectDialog dialog = new JobSelectDialog();
					dialog.setVisible(true);
				}
			}
		});
		player.setCanSave(true);
		player.setIsCanMove(true);
		this.mapleIsland.setImage(player);
		this.inventoryMainPanel = new InventoryMainPanel(player, this);
		this.inventoryMainPanel.setBounds(40, 70, 1240, 650);
		add(this.inventoryMainPanel);

		this.storeInventory = new StoreInventoryPanel(player);
		this.storeInventory.setBounds(690, 100, 740, 630);
		this.storeInventory.setVisible(false);
		add(this.storeInventory);

		this.store = new StorePanel(new MapleIslandShop(), player);
		this.store.setBounds(170, 100, 860, 630);
		this.store.setVisible(false);
		add(store);
		
		quickButtonPanel = new QuickButtonPanel(player, this, this);
		quickButtonPanel.setBounds(0, 450, 1280, 120);
		add(quickButtonPanel);
		
		this.hpBar = new MapleHpBar(player.getMainAdventurer());
		this.hpBar.setBounds(480, 575, 150, 20);
		add(this.hpBar);

		this.mpBar = new MapleMpBar(player.getMainAdventurer());
		this.mpBar.setBounds(690, 575, 150, 20);
		add(this.mpBar);

		this.expBar = new MapleExpBar(player.getMainAdventurer());
		this.expBar.setBounds(1020, 575, 150, 20);
		add(this.expBar);
		
		huntComponent = new HuntComponent(this, this);
		
		player.setCanUsePortion(true);
		player.setCanUseSkill(false);
	}

	public void moveEvent() {
		int mapState = this.player.get_curMap().getMap(this.player.getCurX(), this.player.getCurY());
		switch (mapState) {
		case MapleMap.MAP_EMPTY_STATE:
			this.meetNpcButton.setVisible(false);
			this.moveOtherMapButton.setVisible(false);
			this.buyItemButton.setVisible(false);
			mainMessageBox.clearMessageBox();
			meetMonsterEvent();
			break;
		case MapleMap.MAP_NPC_STATE:
			this.moveOtherMapButton.setVisible(false);
			this.meetNpcButton.setVisible(true);
			this.buyItemButton.setVisible(false);
			mainMessageBox.reloadMessageBox(new MessageBoxComponent("Npc", Color.YELLOW, player.getWillMeetNpcName(), Color.WHITE));
			break;
		case MapleMap.MAP_PORTAL_STATE:
			this.meetNpcButton.setVisible(false);
			this.moveOtherMapButton.setVisible(true);
			this.buyItemButton.setVisible(false);
			mainMessageBox.reloadMessageBox(new MessageBoxComponent("다음 맵", Color.YELLOW, player.getNextMapName(), Color.WHITE));
			break;
		case MapleMap.MAP_STORE_STATE:
			this.buyItemButton.setVisible(true);
			this.moveOtherMapButton.setVisible(false);
			this.meetNpcButton.setVisible(false);
			mainMessageBox.clearMessageBox();
			break;
		case MapleMap.MAP_HEAL_STATE:
			this.player.allAdventuerFullHeal();
			mainMessageBox.clearMessageBox();
			break;
		}
		updateMainStateBar();
	}

	private void storeOpenEvent() {
		Shop shop = ShopList.getShop(this.player.getPlayerPointMapName());
		if (shop == null) {
			return;
		}
		this.store.setShop(shop);
		this.player.setIsCanMove(false);
		this.buyItemButton.setVisible(false);
		this.islandMapButton.setVisible(false);
		this.inventoryButton.setVisible(false);
		this.storeInventory.setVisible(true);
		this.store.setVisible(true);
		this.storeOutButton.setVisible(true);
	}

	private void storeCloseEvent() {
		this.player.setIsCanMove(true);
		this.buyItemButton.setVisible(true);
		this.islandMapButton.setVisible(true);
		this.inventoryButton.setVisible(true);
		this.storeInventory.setVisible(false);
		this.store.setVisible(false);
		this.storeOutButton.setVisible(false);
	}

	private void meetMonsterEvent() {
		Monster monster = MonsterFactory.readyMonster(this.player.get_curMap().getName());
		if (monster != null) {
			player.setIsCanMove(false);
			player.setHunt(true);
			player.setCanSave(false);
			huntComponent.startHunt(player, player.getMainAdventurer(), monster);
		}
	}

	public void converstionStartEvent() {
		this.player.initCurNpc(
				new PointMapName(this.player.getCurX(), this.player.getCurY(), this.player.get_curMap().getName()));
		if (this.player.getCurNpc() == null) {
			return;
		}
		conversationEvent();
		mainMessageBox.clearMessageBox();
		this.player.setIsCanMove(false);
		this.nextButton.setVisible(true);
		this.player.setConversation(true);
		this.meetNpcButton.setVisible(false);
		this.islandMapButton.setVisible(false);
		this.inventoryButton.setVisible(false);
		repaint();
	}

	public void converstionEndEvent() {
		mainMessageBox.reloadMessageBox(new MessageBoxComponent("Npc", Color.YELLOW, player.getWillMeetNpcName(), Color.WHITE));
		this.player.setIsCanMove(true);
		this.nextButton.setVisible(false);
		this.player.setConversation(false);
		this.meetNpcButton.setVisible(true);
		this.islandMapButton.setVisible(true);
		this.inventoryButton.setVisible(true);
		repaint();
	}

	public void islandMapButtonEvent() {
		if (!this.mapleIsland.toggleMapleIsland()) {
			this.player.setIsCanMove(true);
			setButtonWithPlayerLoc();
			mainStateBarSetVisibleTrue();
			this.inventoryButton.setVisible(true);
		} else {
			mapleIsland.setImage(player);
			this.player.setIsCanMove(false);
			setMenuDownSideButtonVisibleFalse();
			mainStateBarSetVisibleFalse();
			this.inventoryButton.setVisible(false);
			this.buyItemButton.setVisible(false);
		}
		repaint();
	}

	public void inventoryButtonEvent() {
		if (!this.inventoryMainPanel.toggleMapleInventory()) {
			this.player.setIsCanMove(true);
			setButtonWithPlayerLoc();
			mainStateBarSetVisibleTrue();
			this.islandMapButton.setVisible(true);
			this.inventoryMainPanel.setVisible(false);
		} else {
			this.player.setIsCanMove(false);
			setMenuDownSideButtonVisibleFalse();
			mainStateBarSetVisibleFalse();
			this.islandMapButton.setVisible(false);
			this.inventoryMainPanel.setVisible(true);
			this.buyItemButton.setVisible(false);
		}
		reloadPanel();
	}

	public void reloadPanel() {
		revalidate();
		repaint();
	}

	public void mainStateBarSetVisibleFalse() {
		this.hpBar.setVisible(false);
		this.mpBar.setVisible(false);
		this.expBar.setVisible(false);
	}

	public void mainStateBarSetVisibleTrue() {
		this.hpBar.setVisible(true);
		this.mpBar.setVisible(true);
		this.expBar.setVisible(true);
	}

	public void mainStateBarUpdate() {
		player.calState();
		this.hpBar.progressUpdate();
		this.mpBar.progressUpdate();
		this.expBar.progressUpdate();
	}

	private void moveOtherMapEvent() {
		int type = player.getNextMapType();
		switch(type) {
		case MapleMap.MAP_SAILING_TYPE:
			int ans = JOptionPane.showConfirmDialog(null, "배에 탑승하면 도중에 내릴 수 없습니다. 탑승하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
			if(ans == JOptionPane.YES_OPTION) {
				moveOtherMapButton.setVisible(false);
				Sailing sailing = SailingFactory.makeSailing(player, this, player.get_curMap().getName());
				sailing.start();
			}else {
				return;
			}
			break;
		case MapleMap.MAP_BOSS_TYPE:
			ans = JOptionPane.showConfirmDialog(null, "보스맵에 입장합니다. 입장하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
			if(ans != JOptionPane.YES_OPTION) {
				return;
			}
			moveOtherMapButton.setVisible(false);
			break;
		case MapleMap.MAP_HARBOR_TYPE:
			MusicUtils.startEffectSound("harborEnter");
			break;
		case MapleMap.MAP_DUNGEON_TYPE:
			if(player.get_curMap().getMapType() == MapleMap.MAP_DUNGEON_TYPE) break;
			ans = JOptionPane.showConfirmDialog(null, "던전에 입장한 이후에는 저장할 수 없으며 클리어시까지 퇴장할 수 없습니다. 입장 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
			if(ans != JOptionPane.YES_OPTION) {
				return;
			}
			moveOtherMapButton.setVisible(false);
			break;
		}
		
		this.player.get_curMap().moveOtherMap(this.player, this);
		
		int mapState = player.get_curMap().getMap(player.getCurX(), player.getCurY());
		switch(mapState) {
		case MapleMap.MAP_PORTAL_STATE:
			mainMessageBox.reloadMessageBox(new MessageBoxComponent("다음 맵", Color.YELLOW, player.getNextMapName(), Color.WHITE));
			break;
		default:
			mainMessageBox.clearMessageBox();
			break;
		}
		
		if (this.player.get_curMap().getMapType() == MapleMap.MAP_BOSS_TYPE) {
			meetMonsterEvent();
		}
	}

	public void setMenuDownSideButtonVisibleFalse() {
		this.meetNpcButton.setVisible(false);
		this.moveOtherMapButton.setVisible(false);
	}

	public void setButtonWithPlayerLoc() {
		int mapState = player.get_curMap().getMap(player.getCurX(), player.getCurY());
		switch (mapState) {
		case MapleMap.MAP_EMPTY_STATE:
			break;
		case MapleMap.MAP_NPC_STATE:
			this.meetNpcButton.setVisible(true);
			break;
		case MapleMap.MAP_PORTAL_STATE:
			this.moveOtherMapButton.setVisible(true);
			break;
		case MapleMap.MAP_STORE_STATE:
			this.buyItemButton.setVisible(true);
			break;
		case MapleMap.MAP_HEAL_STATE:
			break;
		}
	}

	public void conversationEvent() {
		if (!player.conversation(this)) {
			player.setCanEndConversation(true);
		}
	}

	public void reload() {
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void getFocus() {
		setRequestFocusEnabled(true);
		setFocusable(true);
		requestFocus();
		grabFocus();
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		getFocus();
		g.drawImage(this.backgroundImage, 0, 0, this);
		g.drawImage(this.messageSpaceImage, 0, 550, this);
		this.player.drawMainStatus(g);
		this.player.get_curMap().drawMap(g, this.player);
		this.player.get_curMap().drawMiniMap(g, this.player);
		if (this.player.isConversation()) {
			g.drawImage(this.meetEventSpaceImage, 480, 100, this);
			this.player.getCurNpc().draw(g);
		}
		this.messageList.draw(g);
		this.mapleIsland.draw(g);

		repaint();
		if (this.huntComponent != null) {
			this.huntComponent.draw(g, this);
			for (int i = this.damageTextList.size() - 1; i >= 0; i--) {
				if (!((DamageText) this.damageTextList.get(i)).isAlive()) {
					this.damageTextList.remove(i);
				} else {
					((DamageText) this.damageTextList.get(i)).draw(g);
				}
			}
		}
		mainMessageBox.drawMessageBox(g);
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}

	public void myRepaint() {
		repaint();
	}

	public void changeBackground(Image image) {
		this.backgroundImage = image;
		repaint();
	}

	public void addDamageText(DamageText damageText) {
		for(int i = 0; i < damageTextList.size(); i++) {
			damageTextList.get(i).subY(damageText.getHit().isCritical() ? 14 : 12);
		}
		damageText.start();
		damageTextList.add(damageText);
	}

	public void endHunt() {
		updateMainStateBar();
		player.setIsCanMove(true);
		if(player.get_curMap().getMapType() != MapleMap.MAP_DUNGEON_TYPE) {
			player.setCanSave(true);
		}
		player.getMainAdventurer().setUsedSkill(null);
		player.setHunt(false);
		messageList.clearMessage();
		player.allSetAlive();
		player.setCanUsePortion(true);
		player.setCanUseSkill(false);
		player.getMainAdventurer().removeAllBuff();
		player.calState();
		setQuickSkillEnabled();
	}

	public void pushMessage(Message message) {
		this.messageList.pushMessage(message);
	}

	public void updateMainStateBar() {
		this.hpBar.progressUpdate();
		this.mpBar.progressUpdate();
		this.expBar.progressUpdate();
	}

	@Override
	public void toMainMenu() {
		mapleInterface.toMainMenu();
	}

	@Override
	public void loadStateBoxOnQuickButton(StateBox stateBox) {
		quickButtonPanel.loadStateBox(stateBox);
	}

	@Override
	public void setQuickItemImage() {
		quickButtonPanel.setQuickItemImage();
	}
	
	@Override
	public void setQuickSkillImage() {
		quickButtonPanel.setQuickSkillImage();
	}

	@Override
	public void nextTurn() {
		if(huntComponent != null) {
			huntComponent.wakeUp();
		}
	}

	@Override
	public void playerUseSkill(String skillName) {
		huntComponent.playerSetAttack(skillName);
	}

	@Override
	public void setQuickSkillEnabled() {
		quickButtonPanel.setQuickSkillEnabled();
	}

	

}
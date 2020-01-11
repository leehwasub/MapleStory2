package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import character.Adventurer;
import component.MapleButton;
import component.QuickItemButton;
import component.QuickSkillButton;
import component.StateBox;
import item.ConsumableItem;
import item.Item;
import maplestory.MainMapleInterface;
import maplestory.Player;
import skill.Skill;
import utils.FontUtils;
import utils.ResourceLoader;

public class QuickButtonPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private ImageIcon quickCancelBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickCancelButtonBasic.png"));
	private ImageIcon quickCancelEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickCancelButtonEntered.png"));
	private ImageIcon quickItemButtonImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickItemButton.png"));

	private QuickItemButton[] quickItemButton = new QuickItemButton[Adventurer.QUICK_ITEM_ARRAY_SIZE];
	private MapleButton[] quickItemCancelButton = new MapleButton[Adventurer.QUICK_ITEM_ARRAY_SIZE];
	private QuickSkillButton[] quickSkillButton = new QuickSkillButton[Adventurer.QUICK_SKILL_ARRAY_SIZE];
	private MapleButton[] quickSkillCancelButton = new MapleButton[Adventurer.QUICK_SKILL_ARRAY_SIZE];
	
	private MainMapleInterface mainMapleInterface;
	private Player player;
	private StateBox stateBox;

	public QuickButtonPanel(Player player, MainMapleInterface mainMapleInterface, JPanel panel) {
		this.player = player;
		this.mainMapleInterface = mainMapleInterface;
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		makeQuickItemSpace();
		makeQuickItemCancelSpace();
		makeQuickSkillSpace();
		makeSkillCancelSpace();
		itemAddKeyListener(panel);
		skillAddKeyListener(panel);
		setQuickItemImage();
		setQuickSkillImage();
	}

	private void skillAddKeyListener(JPanel panel) {
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int index = -1;
				switch(e.getKeyCode()) {
				case KeyEvent.VK_Z:
					index = 0;
					break;
				case KeyEvent.VK_X:
					index = 1;
					break;
				case KeyEvent.VK_C:
					index = 2;
					break;
				case KeyEvent.VK_V:
					index = 3;
					break;
				case KeyEvent.VK_B:
					index = 4;
					break;
				}
				if(index != -1) {
					quickSkillEvent(index);
				}
			}
		});
	}
	
	private void itemAddKeyListener(JPanel panel) {
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int index = -1;
				switch(e.getKeyCode()) {
				case KeyEvent.VK_Q:
					index = 0;
					break;
				case KeyEvent.VK_W:
					index = 1;
					break;
				case KeyEvent.VK_E:
					index = 2;
					break;
				case KeyEvent.VK_R:
					index = 3;
					break;
				case KeyEvent.VK_V:
					index = 4;
					break;
				}
				if(index != -1) {
					quickItemEvent(index);
				}
			}
		});
	}
	
	public void loadStateBox(StateBox stateBox) {
		this.stateBox = stateBox;
	}
	
	private void makeQuickSkillSpace() {
		for (int i = 0; i < Adventurer.QUICK_SKILL_ARRAY_SIZE; i++) {
			final int index = i;
			quickSkillButton[i] = new QuickSkillButton(this.quickItemButtonImage);
			quickSkillButton[i].setBounds(230 + i * 60, 20, 50, 50);
			quickSkillButton[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					quickSkillEvent(index);
				}
			});
			add(quickSkillButton[i]);
		}
	}
	
	private void quickSkillEvent(int index) {
		if(!player.isHunt() || !player.isCanUseSkill()) return;
		mainMapleInterface.playerUseSkill(quickSkillButton[index].getSkill().getName());
	}

	private void makeQuickItemSpace() {
		for (int i = 0; i < Adventurer.QUICK_ITEM_ARRAY_SIZE; i++) {
			final int index = i;
			quickItemButton[i] = new QuickItemButton(this.quickItemButtonImage);
			quickItemButton[i].setBounds(750 + i * 60, 20, 50, 50);
			quickItemButton[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					quickItemEvent(index);
				}
			});
			add(quickItemButton[i]);
		}
	}
	
	public void quickItemEvent(int index) {
		if (this.quickItemButton[index].getItem() == null || !player.isCanUsePortion()) {
			return;
		}
		player.getMainAdventurer().usePortion(this.quickItemButton[index].getItem());
		setQuickItemImage();
		if(player.isHunt()) {
			stateBox.updateStateBox();
			player.setCanUsePortion(false);
			mainMapleInterface.nextTurn();
		}
	}

	public void setQuickItemImage() {
		if (player.getMainAdventurer() == null) {
			return;
		}
		for (int i = 0; i < Adventurer.QUICK_ITEM_ARRAY_SIZE; i++) {
			ConsumableItem item = player.getMainAdventurer().getQuickItemByIndex(i);
			if (item != null && item.getNum() != 0) {
				this.quickItemButton[i].setItem(player.getMainAdventurer().getQuickItemByIndex(i));
			} else {
				this.quickItemButton[i].setItem(null);
			}
		}
	}
	
	private void makeQuickItemCancelSpace() {
		for (int i = 0; i < Adventurer.QUICK_ITEM_ARRAY_SIZE; i++) {
			final int keyIndex = i;
			quickItemCancelButton[i] = new MapleButton(this.quickCancelBasicImage, this.quickCancelEnteredImage);
			quickItemCancelButton[i].setBounds(755 + i * 60, 75, 40, 20);
			quickItemCancelButton[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					quickItemCancelEvent(keyIndex);
				}
			});
			add(quickItemCancelButton[i]);
		}
	}
	
	private void makeSkillCancelSpace() {
		for (int i = 0; i < Adventurer.QUICK_SKILL_ARRAY_SIZE; i++) {
			final int keyIndex = i;
			quickSkillCancelButton[i] = new MapleButton(this.quickCancelBasicImage, this.quickCancelEnteredImage);
			quickSkillCancelButton[i].setBounds(235 + i * 60, 75, 40, 20);
			quickSkillCancelButton[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					quickSkillCancelEvent(keyIndex);
				}
			});
			add(quickSkillCancelButton[i]);
		}
	}
	
	private void quickItemCancelEvent(int keyIndex) {
		player.getMainAdventurer().removeQuickItem(keyIndex);
		setQuickItemImage();
	}
	
	private void quickSkillCancelEvent(int keyIndex) {
		player.getMainAdventurer().removeQuickSkill(keyIndex);
		setQuickItemImage();
	}
	
	private void setQuickSkillImage() {
		if (player.getMainAdventurer() == null) {
			return;
		}
		for (int i = 0; i < Adventurer.QUICK_SKILL_ARRAY_SIZE; i++) {
			Skill skill = player.getMainAdventurer().getQuickSkillByIndex(i);
			if (skill != null) {
				this.quickSkillButton[i].setSkill(player.getMainAdventurer().getQuickSkillByIndex(i));
			} else {
				this.quickSkillButton[i].setSkill(null);
			}
		}
	}
	

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D)g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		g.setColor(Color.YELLOW);
		g.setFont(FontUtils.SMALL_FONT);
		ConsumableItem[] quickItemArray = this.player.getPlayerQuickItem();
		if (quickItemArray != null) {
			for (int i = 0; i < quickItemArray.length; i++) {
				int x = quickItemButton[i].getLocation().x + 5;
				int y = quickItemButton[i].getLocation().y - 5;
				if (quickItemArray[i] != null && quickItemArray[i].getNum() != 0) {
					g.drawString("X" + quickItemArray[i].getNum(), x, y);
				}
			}
		}
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
	

}

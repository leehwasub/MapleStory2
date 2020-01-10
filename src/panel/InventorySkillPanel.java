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
import component.MapleButton;
import component.QuickItemButton;
import component.QuickSkillButton;
import item.ConsumableItem;
import maplestory.Player;
import skill.Skill;
import utils.FontUtils;
import utils.ResourceLoader;

public class InventorySkillPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Player player;
	private QuickSkillButton[] quickSkillButton = new QuickSkillButton[Adventurer.QUICK_SKILL_ARRAY_SIZE];
	private MapleButton[] quickSkillCancelButton = new MapleButton[Adventurer.QUICK_SKILL_ARRAY_SIZE];
	private ImageIcon quickSkillButtonImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickItemButton.png"));
	private ImageIcon quickCancelBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickCancelButtonBasic.png"));
	private ImageIcon quickCancelEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickCancelButtonEntered.png"));
	
	public InventorySkillPanel(Player player) {
		setVisible(false);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		this.player = player;
		makeQuickSkillSpace();
		makeSkillCancelSpace();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D)g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		g.setFont(FontUtils.generalFont);
		g.setColor(Color.yellow);
		g.drawString("스킬포인트", 40, 40);
		g.setColor(Color.WHITE);
		g.drawString(""+player.getMainAdventurer().getSkillPoint(), 140, 40);
		if(player.getMainAdventurer().getCareerLevel() >= 0) {
			g.setFont(FontUtils.MID_FONT);
			g.setColor(Color.YELLOW);
			g.drawString("1차 스킬", 220, 45);
			g.setFont(FontUtils.generalFont);
			g.setColor(Color.CYAN);
			g.drawString("hp 증가", 320, 45);
			g.drawString("아이언 바디", 320, 145);
			g.drawString("파워 스트라이크", 320, 245);
			g.setColor(Color.WHITE);
			//g.drawString(player.getHpIncreasingSkillPoint() +"/10", 320, 282);
			//g.drawString(player.getIronBodySkillPoint() +"/20", 320, 382);
		}
	}
	
	private void makeQuickSkillSpace() {
		for (int i = 0; i < Adventurer.QUICK_ITEM_ARRAY_SIZE; i++) {
			quickSkillButton[i] = new QuickSkillButton(quickSkillButtonImage);
			quickSkillButton[i].setBounds(55 + i * 60, 330, 50, 50);
			add(this.quickSkillButton[i]);
		}
	}
	
	public void setQuickSkillImage() {
		for (int i = 0; i < Adventurer.QUICK_ITEM_ARRAY_SIZE; i++) {
			Skill skill = this.player.getPlayerQuickSkillByIndex(i);
			if (skill != null) {
				this.quickSkillButton[i].setSkill(player.getPlayerQuickSkillByIndex(i));
			} else {
				this.quickSkillButton[i].setSkill(null);
			}
		}
	}
	
	private void makeSkillCancelSpace() {
		for (int i = 0; i < Adventurer.QUICK_SKILL_ARRAY_SIZE; i++) {
			final int keyIndex = i;
			quickSkillCancelButton[i] = new MapleButton(this.quickCancelBasicImage, this.quickCancelEnteredImage);
			quickSkillCancelButton[i].setBounds(60 + i * 60, 385, 40, 20);
			quickSkillCancelButton[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					quickSkillCancelEvent(keyIndex);
				}
			});
			add(quickSkillCancelButton[i]);
		}
	}
	
	private void quickSkillCancelEvent(int keyIndex) {
		player.getMainAdventurer().removeQuickSkill(keyIndex);
		setQuickSkillImage();
	}


	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
	
}

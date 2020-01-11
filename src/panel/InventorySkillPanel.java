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

import character.Adventurer;
import component.MapleButton;
import component.QuickSkillButton;
import item.SkillButton;
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
	private ImageIcon stateUpButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "stateUpButtonBasic.png"));
	private ImageIcon stateUpButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "stateUpButtonEntered.png"));
	private MapleButton[] stateUpButton = new MapleButton[4];
	
	private SkillButton[] oneLevelSkillButton = new SkillButton[3];
	private SkillButton[] twoLevelSkillButton = new SkillButton[5];
	private SkillButton[] threeLevelSkillButton = new SkillButton[5];
	
	private SkillTooltipPanel skillTooltip = new SkillTooltipPanel();
	
	private boolean[] skillIsLoaded = {false, false, false};
	
	public InventorySkillPanel(Player player) {
		setVisible(false);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		this.player = player;
		skillTooltip.setBounds(0, 0, 1100, 420);
		add(skillTooltip);
		makeQuickSkillSpace();
		makeSkillCancelSpace();
		skillLoad();
	}
	
	public void skillLoad() {
		if(!skillIsLoaded[0] && player.getMainAdventurer().getCareerLevel() >= 1) {
			loadOneLevelSkill();
			skillIsLoaded[0] = true;
		} else if(!skillIsLoaded[1] && player.getMainAdventurer().getCareerLevel() >= 2) {
			loadTwoLevelSkill();
			skillIsLoaded[1] = true;
		} else if(!skillIsLoaded[2] && player.getMainAdventurer().getCareerLevel() >= 3) {
			loadThreeLevelSkill();
			skillIsLoaded[2] = true;
		}
	}
	
	private void loadOneLevelSkill() {
		ArrayList<Skill> oneSkillList = player.getMainAdventurer().getSkillList(1);
		for(int i = 0; i < oneLevelSkillButton.length; i++) {
			oneLevelSkillButton[i] = new SkillButton();
			oneLevelSkillButton[i].setBounds(240, 70+(65*i), 50, 50);
			oneLevelSkillButton[i].setSkill(oneSkillList.get(i));
			oneLevelSkillButton[i].setSkillToolTip(skillTooltip);
			add(oneLevelSkillButton[i]);
		}
	}
	
	
	private void loadTwoLevelSkill() {
		
	}
	
	
	private void loadThreeLevelSkill() {
		
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
		} if(player.getMainAdventurer().getCareerLevel() >= 0) {
			g.setFont(FontUtils.MID_FONT);
			g.setColor(Color.YELLOW);
			g.drawString("2차 스킬", 520, 45);
		} if(player.getMainAdventurer().getCareerLevel() >= 0) {
			g.setFont(FontUtils.MID_FONT);
			g.setColor(Color.YELLOW);
			g.drawString("3차 스킬", 820, 45);
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

package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import character.Adventurer;
import component.MapleButton;
import component.QuickSkillButton;
import dialog.SkillKeySelectDialog;
import item.SkillButton;
import maplestory.MainMapleInterface;
import maplestory.Player;
import skill.ActiveSkill;
import skill.PassiveSkill;
import skill.Skill;
import utils.DialogUtils;
import utils.FontUtils;
import utils.ResourceLoader;

public class InventorySkillPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Player player;
	private MainMapleInterface mainMapleInterface;
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
	
	private SkillButton[][] skillButton = new SkillButton[3][];
	private MapleButton[][] skillUpButton = new MapleButton[3][];
	
	private SkillTooltipPanel skillTooltip = new SkillTooltipPanel();
	
	private boolean[] skillIsLoaded = {false, false, false};
	
	public InventorySkillPanel(Player player, MainMapleInterface mainMapleInterface) {
		setVisible(false);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		this.player = player;
		this.mainMapleInterface = mainMapleInterface;
		skillTooltip.setBounds(0, 0, 1100, 420);
		add(skillTooltip);
		makeQuickSkillSpace();
		makeSkillCancelSpace();
		skillLoad();
		setQuickSkillImage();
	}
	
	public void skillLoad() {
		for(int i = 0; i < 3; i++) {
			if(!skillIsLoaded[i] && player.getMainAdventurer().getCareerLevel() >= (i+1)) {
				loadSkill(i);
				skillIsLoaded[i] = true;
			}
		}
	}
	
	private void loadSkill(int level) {
		ArrayList<Skill> skillList = player.getMainAdventurer().getSkillList(level+1);
		if(level == 0) {
			skillButton[level] = new SkillButton[3];
			skillUpButton[level] = new MapleButton[3];
		} else {
			skillButton[level] = new SkillButton[5];
			skillUpButton[level] = new MapleButton[5];
		}
		for(int i = 0; i < skillButton[level].length; i++) {
			final int index = i;
			skillButton[level][i] = new SkillButton();
			skillButton[level][i].setBounds(240 + (300 * level), 70 + (65 * i), 50, 50);
			skillButton[level][i].setSkill(skillList.get(i));
			skillButton[level][i].setSkillToolTip(skillTooltip);
			skillButton[level][i].addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(e.getModifiers() == InputEvent.BUTTON1_MASK) {
						inventorySkillEvent(level, index);
					}
				}
			});
			add(skillButton[level][i]);
		}
		for(int i = 0; i < skillUpButton[level].length; i++) {
			final int index = i;
			skillUpButton[level][i] = new MapleButton(stateUpButtonBasicImage, stateUpButtonEnteredImage);
			skillUpButton[level][i].setBounds(310 + (300 * level), 85 + (65 * i), 20, 20);
			skillUpButton[level][i].addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(player.getMainAdventurer().getSkillPoint() >= 1) {
						if(!skillButton[level][index].getSkill().isCanUpgrade(player.getMainAdventurer())) {
							DialogUtils.showWarningDialog(skillButton[level][index].getSkill().requiredSkillInfor());
							return;
						}
						boolean isUp = skillButton[level][index].addSkillPoint();
						if(isUp) {
							if(skillButton[level][index].getSkill() instanceof PassiveSkill) {
								((PassiveSkill)skillButton[level][index].getSkill()).skillUpEffect(player.getMainAdventurer());
								player.calState();
							}
							player.getMainAdventurer().subSkillPoint();
						}
					}
				}
			});
			add(skillUpButton[level][i]);
		}
	}
	
	public void inventorySkillEvent(int level, int index) {
		if(!(skillButton[level][index].getSkill() instanceof ActiveSkill) || skillButton[level][index].getSkillPoint() == 0) return;
		int keyIndex = getKeySelectWithDialog();
		if (keyIndex == -1) {
			return;
		}
		this.player.registQuickSkill(level + 1, index, keyIndex);
		setQuickSkillImage();
		mainMapleInterface.setQuickSkillImage();
	}

	public int getKeySelectWithDialog() {
		SkillKeySelectDialog dialog = new SkillKeySelectDialog();
		dialog.setVisible(true);
		int getIndex = dialog.getReturnIndex();
		dialog.dispose();
		return getIndex;
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
		
		for(int i = 0; i < 3; i++) {
			if(player.getMainAdventurer().getCareerLevel() >= (i+1)) {
				g.setFont(FontUtils.MID_FONT);
				g.setColor(Color.YELLOW);
				g.drawString((i+1)+"차 스킬", 240 + (i * 300), 45);
				if(skillIsLoaded[i]) {
					for(int j = 0; j < skillButton[i].length; j++) {
						Skill skill = skillButton[i][j].getSkill();
						g.setFont(FontUtils.generalFont);
						g.setColor(Color.WHITE);
						g.drawString(skill.getPoint() + " / " + skill.getMaxPoint(), 350 + (i * 300), 101 + (65 * j));
					}
				}
			}
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
		mainMapleInterface.setQuickSkillImage();
	}


	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
	
}

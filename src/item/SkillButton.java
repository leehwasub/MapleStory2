package item;

import java.awt.Cursor;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dialog.SkillDetailDialog;
import map.Point;
import panel.SkillTooltipPanel;
import skill.Skill;
import utils.MusicUtils;
import utils.ResourceLoader;

public class SkillButton extends JButton {
	private static final long serialVersionUID = 1L;
	private static final ImageIcon BUTTON_BASIC_IMAGE = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryItemSpaceButton.png"));
	private ImageIcon buttonImage;
	private Skill skill;
	private SkillTooltipPanel skillToolTip;
	private boolean isEntered;

	public SkillButton(Skill skill, ImageIcon buttonImage) {
		super(new ImageIcon(skill.getImage()));
		this.skill = skill;
		buttonImage = new ImageIcon(skill.getImage());
		buttonInit();
	}

	public SkillButton() {
		super(BUTTON_BASIC_IMAGE);
		this.buttonImage = BUTTON_BASIC_IMAGE;
		buttonInit();
	}

	public SkillButton(ImageIcon buttonImage, boolean visible) {
		super(buttonImage);
		this.buttonImage = buttonImage;
		buttonInit();
		if (visible) {
			setVisible(true);
		} else if (!visible) {
			setVisible(false);
		}
	}

	public SkillButton(ImageIcon buttonImage) {
		super(buttonImage);
		this.buttonImage = buttonImage;
		buttonInit();
	}

	private void buttonInit() {
		setBorderPainted(false);
		setFocusPainted(false);
		setFocusable(false);
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				isEntered = true;
			}

			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				setIcon(SkillButton.this.buttonImage);
				isEntered = false;
				if(skillToolTip != null) {
					skillToolTip.setVisible(false);
				}
			}

			public void mousePressed(MouseEvent e) {
				MusicUtils.startEffectSound("ButtonPressed");
				if(e.getModifiers() == InputEvent.BUTTON3_MASK) {
					SkillDetailDialog skillDetailDialog = new SkillDetailDialog(skill);
					skillDetailDialog.setVisible(true);
				}
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(skillToolTip != null) {
					skillToolTip.setPoint(new Point(getX() + e.getX(), getY() + e.getY()));
					skillToolTip.setVisible(true);
					skillToolTip.setSkill(skill);
				}
			}
		});
	}
	
	public SkillTooltipPanel getSkillToolTip() {
		return skillToolTip;
	}

	public void setSkillToolTip(SkillTooltipPanel skillToolTip) {
		this.skillToolTip = skillToolTip;
	}

	public Skill getSkill() {
		return this.skill;
	}
	
	public boolean addSkillPoint() {
		return skill.addSkillPoint();
	}
	
	public int getSkillPoint() {
		return skill.getPoint();
	}
	
	public int getSkillMaxPoint() {
		return skill.getMaxPoint();
	}

	public boolean isEntered() {
		return isEntered;
	}

	public void setEntered(boolean isEntered) {
		this.isEntered = isEntered;
	}

	public void setSkill(Skill skill) {
		if (skill != null) {
			this.skill = skill;
			this.buttonImage = new ImageIcon(skill.getImage());
			setIcon(new ImageIcon(skill.getImage()));
		} else {
			this.skill = null;
			this.buttonImage = BUTTON_BASIC_IMAGE;
			setIcon(BUTTON_BASIC_IMAGE);
		}
	}
}

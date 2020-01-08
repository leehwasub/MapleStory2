package component;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import skill.Skill;
import utils.MusicUtils;
import utils.ResourceLoader;

public class QuickSkillButton extends JButton {
	private static final long serialVersionUID = 1L;
	private static final ImageIcon BUTTON_BASIC_IMAGE = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickItemButton.png"));
	private ImageIcon buttonImage;
	private Skill skill;
	private boolean isEntered;

	public QuickSkillButton(Skill skill, ImageIcon buttonImage) {
		super(new ImageIcon(skill.getImage()));
		this.skill = skill;
		buttonImage = new ImageIcon(skill.getImage());
		buttonInit();
	}

	public QuickSkillButton() {
		super(BUTTON_BASIC_IMAGE);
		this.buttonImage = BUTTON_BASIC_IMAGE;
		buttonInit();
	}

	public QuickSkillButton(ImageIcon buttonImage, boolean visible) {
		super(buttonImage);
		this.buttonImage = buttonImage;
		buttonInit();
		if (visible) {
			setVisible(true);
		} else if (!visible) {
			setVisible(false);
		}
	}

	public QuickSkillButton(ImageIcon buttonImage) {
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
				QuickSkillButton.this.setCursor(new Cursor(12));
				QuickSkillButton.this.isEntered = true;
			}

			public void mouseExited(MouseEvent e) {
				QuickSkillButton.this.setCursor(new Cursor(0));
				QuickSkillButton.this.setIcon(QuickSkillButton.this.buttonImage);
				QuickSkillButton.this.isEntered = false;
			}

			public void mousePressed(MouseEvent e) {
				MusicUtils.startEffectSound("ButtonPressed");
			}
		});
	}

	public boolean drawInfor(Graphics2D g) {
		if ((this.skill != null) && (this.isEntered)) {
			return true;
		}
		return false;
	}

	public Skill getItem() {
		return this.skill;
	}

	public void setItem(Skill skill) {
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

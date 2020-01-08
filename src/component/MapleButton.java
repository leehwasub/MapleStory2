package component;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import utils.MusicUtils;

public class MapleButton extends JButton {
	private static final long serialVersionUID = 1L;
	private ImageIcon buttonBasicImage;
	private ImageIcon buttonEnteredImage;
	private boolean isSelectedInGroup;

	public MapleButton(ImageIcon basicImage, ImageIcon enteredImage) {
		super(basicImage);
		buttonInit(basicImage, enteredImage);
	}

	private void buttonInit(ImageIcon basicImage, ImageIcon enteredImage) {
		this.buttonBasicImage = basicImage;
		this.buttonEnteredImage = enteredImage;
		setBorderPainted(false);
		setFocusPainted(false);
		setFocusable(false);
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				MapleButton.this.setCursor(new Cursor(12));
				MapleButton.this.setIcon(MapleButton.this.buttonEnteredImage);
				MusicUtils.startEffectSound("ButtonEntered");
			}

			public void mouseExited(MouseEvent e) {
				MapleButton.this.setCursor(new Cursor(0));
				if (!MapleButton.this.isSelectedInGroup) {
					MapleButton.this.setIcon(MapleButton.this.buttonBasicImage);
				}
			}

			public void mousePressed(MouseEvent e) {
				MusicUtils.startEffectSound("ButtonPressed");
			}
		});
	}

	public ImageIcon getButtonBasicImage() {
		return this.buttonBasicImage;
	}

	public ImageIcon getButtonEnteredImage() {
		return this.buttonEnteredImage;
	}

	public void setButtonBasicImage(ImageIcon buttonBasicImage) {
		this.buttonBasicImage = buttonBasicImage;
	}

	public void setButtonEnteredImage(ImageIcon buttonEnteredImage) {
		this.buttonEnteredImage = buttonEnteredImage;
	}

	public boolean isSelectedInGroup() {
		return this.isSelectedInGroup;
	}

	public void setSelectedInGroup(boolean isSelectedInGroup) {
		this.isSelectedInGroup = isSelectedInGroup;
	}

	public MapleButton(ImageIcon basicImage, ImageIcon enteredImage, boolean visible) {
		super(basicImage);
		buttonInit(basicImage, enteredImage);
		if (visible) {
			setVisible(true);
		} else if (!visible) {
			setVisible(false);
		}
	}
}

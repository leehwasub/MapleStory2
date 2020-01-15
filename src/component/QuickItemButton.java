package component;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import item.ConsumableItem;
import utils.MusicUtils;
import utils.ResourceLoader;

public class QuickItemButton extends JButton {
	private static final long serialVersionUID = 1L;
	private static final ImageIcon BUTTON_BASIC_IMAGE = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickItemButton.png"));
	private ImageIcon buttonImage;
	private ConsumableItem item;

	public QuickItemButton(ConsumableItem item, ImageIcon buttonImage) {
		super(new ImageIcon(item.getImage()));
		this.item = item;
		buttonImage = new ImageIcon(item.getImage());
		buttonInit();
	}

	public QuickItemButton() {
		super(BUTTON_BASIC_IMAGE);
		this.buttonImage = BUTTON_BASIC_IMAGE;
		buttonInit();
	}

	public QuickItemButton(ImageIcon buttonImage, boolean visible) {
		super(buttonImage);
		this.buttonImage = buttonImage;
		buttonInit();
		if (visible) {
			setVisible(true);
		} else if (!visible) {
			setVisible(false);
		}
	}

	public QuickItemButton(ImageIcon buttonImage) {
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
				setCursor(new Cursor(12));
			}

			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(0));
				setIcon(QuickItemButton.this.buttonImage);
			}

			public void mousePressed(MouseEvent e) {
				MusicUtils.startEffectSound("ButtonPressed");
			}
		});
	}
	public ConsumableItem getItem() {
		return this.item;
	}

	public void setItem(ConsumableItem item) {
		if (item != null) {
			this.item = item;
			this.buttonImage = new ImageIcon(item.getImage());
			setIcon(new ImageIcon(item.getImage()));
		} else {
			this.item = null;
			this.buttonImage = BUTTON_BASIC_IMAGE;
			setIcon(BUTTON_BASIC_IMAGE);
		}
	}
}
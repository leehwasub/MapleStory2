package item;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import utils.MusicUtils;
import utils.ResourceLoader;

public class ItemButton extends JButton {
	private static final long serialVersionUID = 1L;
	private static final ImageIcon BUTTON_BASIC_IMAGE = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryItemSpaceButton.png"));
	private ImageIcon buttonImage;
	private Item item;
	private boolean isEntered;

	public ItemButton(Item item, ImageIcon buttonImage) {
		super(new ImageIcon(item.getImage()));
		this.item = item;
		buttonImage = new ImageIcon(item.getImage());
		buttonInit();
	}

	public ItemButton() {
		super(BUTTON_BASIC_IMAGE);
		this.buttonImage = BUTTON_BASIC_IMAGE;
		buttonInit();
	}

	public ItemButton(ImageIcon buttonImage, boolean visible) {
		super(buttonImage);
		this.buttonImage = buttonImage;
		buttonInit();
		if (visible) {
			setVisible(true);
		} else if (!visible) {
			setVisible(false);
		}
	}

	public ItemButton(ImageIcon buttonImage) {
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
				ItemButton.this.setCursor(new Cursor(12));
				ItemButton.this.isEntered = true;
			}

			public void mouseExited(MouseEvent e) {
				ItemButton.this.setCursor(new Cursor(0));
				ItemButton.this.setIcon(ItemButton.this.buttonImage);
				ItemButton.this.isEntered = false;
			}

			public void mousePressed(MouseEvent e) {
				MusicUtils.startEffectSound("ButtonPressed");
			}
		});
	}

	public boolean drawInfor(Graphics2D g) {
		if ((this.item != null) && (this.isEntered)) {
			this.item.drawInfor(g, new map.Point(getLocation().x + 55, getLocation().y));
			return true;
		}
		return false;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
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

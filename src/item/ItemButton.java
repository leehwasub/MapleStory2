package item;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import map.Point;
import panel.ItemTooltipPanel;
import utils.MusicUtils;
import utils.ResourceLoader;

public class ItemButton extends JButton {
	private static final long serialVersionUID = 1L;
	private static final ImageIcon BUTTON_BASIC_IMAGE = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryItemSpaceButton.png"));
	private ImageIcon buttonImage;
	private Item item;
	private ItemTooltipPanel itemToolTip;

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
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				setIcon(ItemButton.this.buttonImage);
				if(itemToolTip != null) {
					itemToolTip.setVisible(false);
				}
			}

			public void mousePressed(MouseEvent e) {
				MusicUtils.startEffectSound("ButtonPressed");
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(itemToolTip != null) {
					itemToolTip.setPoint(new Point(getX() + e.getX(), getY() + e.getY()));
					itemToolTip.setVisible(true);
					itemToolTip.setItem(item);
				}
			}
		});
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

	public ItemTooltipPanel getItemToolTip() {
		return itemToolTip;
	}

	public void setItemToolTip(ItemTooltipPanel itemToolTip) {
		this.itemToolTip = itemToolTip;
	}

	
}

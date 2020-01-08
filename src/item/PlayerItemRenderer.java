package item;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import utils.FontUtils;

public class PlayerItemRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object> {
	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		Item item = (Item) value;
		list.setFont(FontUtils.SMALL_FONT);
		setText("<html>" + item.getName() + "<br><font color=#0080FF>" + item.getCost() / 10
				+ " 메소 </font><font color=navy>(X" + item.getNum() + ")</font></html>");

		setIcon(new ImageIcon(item.getImage()));
		setIconTextGap(10);
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setEnabled(true);
		setFont(list.getFont());
		return this;
	}

	public static BufferedImage convertToBufferedImage(Image image) {
		BufferedImage newImage = new BufferedImage(image.getWidth(null), image.getHeight(null), 2);
		Graphics2D g = newImage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return newImage;
	}
}
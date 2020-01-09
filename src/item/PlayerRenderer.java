package item;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import maplestory.Player;
import quest.Quest;
import utils.FontUtils;

public class PlayerRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object> {
	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		Player player = (Player) value;
		list.setFont(FontUtils.SMALL_FONT);
		if(player != null) {
			Quest q = player.getQuest();
			String st = "";
			if(q != null) {
				st = (q.getChapter() == 0 ? "Tutorial" : q.getChapter()) + " - " + q.getQuestId() + " : " + q.getTitle();
			}
			setText("<html><font color=#0080FF>" + player.getMainAdventurer().getName() + "<font><br>"
					+ "<font color=orange>" + player.getMainAdventurer().getCareer() + "</font><br>"
					+ "<font color=gray>" + player.get_curMap().getIsland() +"-" + player.get_curMap().getName() +"</font><br>"
					+ "<font color=navy>" + st +"</font></html>");
			setIcon(new ImageIcon(player.getMainAdventurer().getImage()));
		} else {
			setText("<html><font color=gray>데이터가 존재하지 않습니다.</font></html>");
			setIcon(null);
		}
		
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
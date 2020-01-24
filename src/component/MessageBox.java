package component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import utils.ColorUtils;
import utils.FontUtils;

public class MessageBox {
	
	public static final int PADDING_WIDTH = 20;
	public static final int MARGIN_WIDTH = 5;
	
	private ArrayList<MessageBoxComponent> messageBoxList = new ArrayList<MessageBoxComponent>();
	private int x;
	private int y;
	private int borderWidth;
	private Color borderColor;
	
	public MessageBox(int x, int y, int borderWidth, Color borderColor) {
		this.x = x;
		this.y = y;
		this.borderWidth = borderWidth;
		this.borderColor = borderColor;
	}
	
	public void addMessage(MessageBoxComponent messageBoxComponent) {
		messageBoxList.add(messageBoxComponent);
	}
	
	public void reloadMessageBox(MessageBoxComponent messageBoxComponent) {
		messageBoxList.clear();
		messageBoxList.add(messageBoxComponent);
	}
	
	public void clearMessageBox() {
		messageBoxList.clear();
	}
	
	public int getWidth(Graphics2D g) {
		int ret = 0;
		for(int i = 0; i < messageBoxList.size(); i++) {
			ret = Math.max(ret, g.getFontMetrics().stringWidth(messageBoxList.get(i).getTitle() + " : " + messageBoxList.get(i).getMessage()));
		}
		return ret + (PADDING_WIDTH * 2);
	}
	
	public int getHeight(Graphics2D g) {
		int ret = PADDING_WIDTH;
		for(int i = 0; i < messageBoxList.size(); i++) {
			ret += g.getFontMetrics().getHeight();
			if(i < messageBoxList.size() - 1) {
				ret += MARGIN_WIDTH;
			}
		}
		return ret + PADDING_WIDTH;
	}

	public void drawMessageBox(Graphics2D g) {
		if(messageBoxList.size() == 0) return;
		g.setColor(ColorUtils.BLACK_80);
		g.setFont(FontUtils.SMALL_FONT);
		int width = getWidth(g);
		int height = getHeight(g);
		g.fillRect(x, y, width, height);
		g.setColor(borderColor);
		g.fillRect(x, y, borderWidth, height);
		g.fillRect(x, y, width, borderWidth);
		g.fillRect(x + width - borderWidth, y, borderWidth, height);
		g.fillRect(x, y + height - borderWidth, width, borderWidth);
		for(int i = 0; i < messageBoxList.size(); i++) {
			MessageBoxComponent component = messageBoxList.get(i);
			g.setColor(component.getTitleColor());
			g.drawString(component.getTitle() + " : ", x + PADDING_WIDTH, y + g.getFontMetrics().getAscent() + PADDING_WIDTH + (i * (g.getFontMetrics().getHeight() + MARGIN_WIDTH)));
			g.setColor(component.getMessageColor());
			g.drawString(component.getMessage(), x + PADDING_WIDTH + g.getFontMetrics().stringWidth(component.getTitle() + " : ")
					, y + g.getFontMetrics().getAscent() + PADDING_WIDTH + (i * (g.getFontMetrics().getHeight() + MARGIN_WIDTH)));
		}
	}
	
}

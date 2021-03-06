package maplestory;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Queue;

import utils.FontUtils;

public class MessageList {
	private Queue<Message> messageQueue = new LinkedList<Message>();

	public void pushMessage(Message message) {
		this.messageQueue.clear();
		this.messageQueue.add(message);
	}

	public void clearMessage() {
		this.messageQueue.clear();
	}

	public void draw(Graphics2D g) {
		if (messageQueue != null && !messageQueue.isEmpty()) {
			if(messageQueue.peek() != null && !messageQueue.peek().isAlive() && messageQueue.peek().isVolatility()) {
				messageQueue.poll();
			}
		}
		if (messageQueue != null && !messageQueue.isEmpty()) {
			g.setFont(FontUtils.generalFont);
			Message messagePeek = messageQueue.peek();
			if(messagePeek != null) {
				g.setColor(messagePeek.getColor());
			}
			int preIndex = 0;
			int line = 0;
			String message = "";
			if(messagePeek != null) {
				message = messagePeek.getMessage();
			}
			for (int i = 0; i < message.length(); i++) {
				FontMetrics fm = g.getFontMetrics();
				int width = fm.stringWidth(message.substring(preIndex, i));
				if (width > 1100) {
					g.drawString(message.substring(preIndex, i), 25, 630 + line * 25);
					preIndex = i;
					line++;
				}
			}
			g.drawString(message.substring(preIndex), 25, 630 + line * 25);
		}
	}
}

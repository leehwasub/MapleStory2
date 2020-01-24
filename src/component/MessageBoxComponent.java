package component;

import java.awt.Color;

public class MessageBoxComponent {

	private String title;
	private Color titleColor;
	private String message;
	private Color messageColor;
	
	public MessageBoxComponent(String title, Color titleColor, String message, Color messageColor) {
		this.title = title;
		this.titleColor = titleColor;
		this.message = message;
		this.messageColor = messageColor;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Color getTitleColor() {
		return titleColor;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Color getMessageColor() {
		return messageColor;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setTitleColor(Color titleColor) {
		this.titleColor = titleColor;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setMessageColor(Color messageColor) {
		this.messageColor = messageColor;
	}

	@Override
	public String toString() {
		return "MessageBoxComponent [title=" + title + ", titleColor=" + titleColor + ", message=" + message
				+ ", messageColor=" + messageColor + "]";
	}
	
}

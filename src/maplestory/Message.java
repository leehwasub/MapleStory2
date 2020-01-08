package maplestory;

import java.awt.Color;

public class Message extends Thread {
	private String message;
	private Color color;
	private boolean isVolatility;

	public Message(String message, Color color, boolean isVolatility) {
		this.message = message;
		this.color = color;
		this.isVolatility = isVolatility;
		start();
	}

	public void run() {
		try {
			sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Color getColor() {
		return this.color;
	}

	public boolean isVolatility() {
		return this.isVolatility;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setVolatility(boolean isVolatility) {
		this.isVolatility = isVolatility;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

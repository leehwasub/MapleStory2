package utils;

import java.awt.Color;
import java.awt.Graphics2D;

public class DrawUtils {

	public static void drawRectBox(Graphics2D g, int x, int y, int width, int height, int borderWidth, Color borderColor) {
		g.setColor(ColorUtils.BLACK_80);
		g.fillRect(x, y, width, height);
		g.setColor(borderColor);
		g.fillRect(x, y, borderWidth, height);
		g.fillRect(x, y, width, borderWidth);
		g.fillRect(x + width - borderWidth, y, borderWidth, height);
		g.fillRect(x, y + height - borderWidth, width, borderWidth);
	}
	
}

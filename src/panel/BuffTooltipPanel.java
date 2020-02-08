package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import buff.Buff;
import map.Point;

public class BuffTooltipPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int TOOLTIP_WIDTH = 200;
	public static final int TOOLTIP_HEIGHT = 300;
	private Buff buff;
	private Point point;

	public BuffTooltipPanel() {
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
	}

	public Point getPoint() {
		return this.point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Buff getBuff() {
		return this.buff;
	}

	public void setBuff(Buff buff) {
		this.buff = buff;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		if (this.buff != null) {
			this.buff.draw(g, this.point);
		}
		repaint();
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
}
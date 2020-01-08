package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import maplestory.Player;

public class InventoryQuestPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Player player;

	public InventoryQuestPanel(Player player) {
		this.player = player;
		setVisible(false);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		if (this.player.getQuest() != null) {
			this.player.getQuest().questDraw(g, this.player);
		}
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
}

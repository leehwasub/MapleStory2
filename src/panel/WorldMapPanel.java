package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import maplestory.Player;
import utils.ResourceLoader;

public class WorldMapPanel extends JPanel{
	
	private Image worldImage;
	private static final long serialVersionUID = 1L;
	private boolean isView = false;
	private Player player;
	
	public WorldMapPanel(Player player) {
		setBackground(new Color(0, 0, 0, 0));
		setVisible(false);
		this.player = player;
	}
	
	public boolean toggleWorldMapPanel() {
		isView = !isView;
		if(isView) {
			setVisible(true);
			setWorldImage();
		} else {
			setVisible(false);
		}
		repaint();
		return isView;
	}
	
	public void setWorldImage() {
		String island = player.get_curMap().getIsland();
		switch (island) {
		case "메이플아일랜드":
			worldImage = ResourceLoader.getImage("componentImage", "mapleIslandMapImage.png");
			break;
		case "빅토리아아일랜드":
			worldImage = ResourceLoader.getImage("componentImage", "vitoriaIslandMapImage.png");
			break;
		case "엘나스산맥":
			worldImage = ResourceLoader.getImage("componentImage", "ossyriaMapImage.png");
			break;
		case "니할사막":
			worldImage = ResourceLoader.getImage("componentImage", "nihalDesertMapImage.png");
			break;
		case "미나르숲":
			worldImage = ResourceLoader.getImage("componentImage", "minarForestMapImage.png");
			break;
		case "시간의신전":
			worldImage = ResourceLoader.getImage("componentImage", "templeOfTimeMapImage.png");
			break;
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D)g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		if(isView) {
			g.drawImage(worldImage, 0, 0, null);
		}
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}

}

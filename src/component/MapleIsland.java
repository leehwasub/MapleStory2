package component;

import java.awt.Graphics2D;
import java.awt.Image;

import maplestory.Player;
import utils.ResourceLoader;

public class MapleIsland {
	private Image islandMapImage;
	private boolean isActive;

	public void draw(Graphics2D g) {
		if (this.isActive) {
			g.drawImage(this.islandMapImage, 30, 70, null);
		}
	}

	public void setImage(Player player) {
		String island = player.get_curMap().getIsland();
		switch (island) {
		case "메이플아일랜드":
			this.islandMapImage = ResourceLoader.getImage("componentImage", "mapleIslandMapImage.png");
			break;
		case "빅토리아아일랜드":
			this.islandMapImage = ResourceLoader.getImage("componentImage", "vitoriaIslandMapImage.png");
			break;
		case "오시리아":
			this.islandMapImage = ResourceLoader.getImage("componentImage", "ossyriaMapImage.png");
			break;
		case "니할사막":
			this.islandMapImage = ResourceLoader.getImage("componentImage", "nihalDesertMapImage.png");
			break;
		case "미나르숲":
			this.islandMapImage = ResourceLoader.getImage("componentImage", "minarForestMapImage.png");
			break;
		case "시간의신전":
			this.islandMapImage = ResourceLoader.getImage("componentImage", "templeOfTimeMapImage.png");
			break;
		}
		System.out.println(island + "초기화!!");
	}

	public boolean isActive() {
		return this.isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean toggleMapleIsland() {
		if (this.isActive) {
			this.isActive = false;
		} else {
			this.isActive = true;
		}
		return this.isActive;
	}
}

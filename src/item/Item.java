package item;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;

import map.Point;
import utils.ResourceLoader;

public abstract class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	protected static final Image ITEM_INFOR_PANEL_IMAGE = ResourceLoader.getImage("componentImage",
			"itemInforPanelImage.png");
	protected String name;
	protected int cost;
	protected transient Image image;
	protected String imageUrl;
	protected int num;
	protected FontMetrics fm;

	public Item(String name, int cost, String imageUrl, int num) {
		this.name = name;
		this.cost = cost;
		this.imageUrl = imageUrl;
		setImageWithInstanceForInit();
		this.num = num;
	}

	public void setImageWithInstanceForInit() {
		if ((this instanceof MaterialItem)) {
			this.image = ResourceLoader.getImage("materialItemImage", this.imageUrl + "ItemImage.png");
		} else if ((this instanceof ConsumableItem)) {
			this.image = ResourceLoader.getImage("consumableItemImage", this.imageUrl + "ItemImage.png");
		}
	}

	public abstract void drawInfor(Graphics2D paramGraphics2D, Point paramPoint);

	public String getName() {
		return this.name;
	}

	public int getCost() {
		return this.cost;
	}

	public Image getImage() {
		return this.image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String toGetInfor() {
		return this.name + " " + this.num + "개 획득!";
	}

	public String toString() {
		return "Item [name=" + this.name + ", cost=" + this.cost + ", image=" + this.image + "]";
	}
}

package buff;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import attack.Property;
import character.Character;
import character.Strength;
import utils.ResourceLoader;

public abstract class Buff {
	
	private Image image;
	private String name;
	private Property property;
	private int last;
	private String infor;
	
	public Buff(String imageUri, String name, Property property, int last, String infor) {
		this.image =  ResourceLoader.getImage("buffImage", imageUri + "BuffImage.png");
		this.name = name;
		this.property = property;
		this.last = last;
		this.infor = infor;
	}

	public abstract void draw(Graphics2D g);
	public abstract void effect(Character character);

	public String getName() {
		return name;
	}

	public Property getProperty() {
		return property;
	}

	public int getLast() {
		return last;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getInfor() {
		return infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

}

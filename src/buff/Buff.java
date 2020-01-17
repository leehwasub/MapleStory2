package buff;

import java.awt.Graphics2D;
import java.awt.Image;

import character.Character;
import utils.ResourceLoader;

public abstract class Buff {
	
	private Image image;
	private String name;
	private int last;
	private String infor;
	
	public Buff(String imageUri, String name, int last, String infor) {
		this.image =  ResourceLoader.getImage("buffImage", imageUri + "BuffImage.png");
		this.name = name;
		this.last = last;
		this.infor = infor;
	}

	public abstract void draw(Graphics2D g);
	public abstract void effect(Character character);
	public abstract boolean isDebuff();

	public String getName() {
		return name;
	}
	
	public int getLast() {
		return last;
	}
	
	public boolean isEnd() {
		return (last == 0);
	}
	
	public void oneTurnLast() {
		last--;
	}

	public void setName(String name) {
		this.name = name;
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

package skill;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import attack.Attack;
import component.StateBox;

public abstract class Skill {
	private String name;
	private int point;
	private int maxPoint;
	private Image image;
	private boolean isContainAttack;
	private String infor;

	public Skill(String name, int point, Image image, boolean isContainAttack) {
		this.name = name;
		this.point = point;
		this.image = image;
		this.isContainAttack = isContainAttack;
	}

	public void drawInfor(Graphics2D g) {
		
	}

	public abstract Attack skillUse(StateBox paramStateBox, ArrayList<StateBox> paramArrayList);

	public String getName() {
		return this.name;
	}

	public int getPoint() {
		return this.point;
	}

	public Image getImage() {
		return this.image;
	}

	public boolean isContainAttack() {
		return this.isContainAttack;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setContainAttack(boolean isContainAttack) {
		this.isContainAttack = isContainAttack;
	}
}

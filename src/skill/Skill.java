package skill;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import attack.Attack;
import component.StateBox;
import map.Point;
import utils.ResourceLoader;

/**
 * 
 * @author Leehwasub
 *
 */
public abstract class Skill {
	
	protected Image image;
	protected String name;
	protected int point;
	protected int maxPoint;
	protected String infor;

	/**
	 * 
	 * @param image 스킬 이미지
	 * @param name 스킬 이름
	 * @param maxPoint 최대 포인트
	 * @param infor 스킬 설명
	 */
	public Skill(String imageUrl, String name, int maxPoint, String infor) {
		this.image = ResourceLoader.getImage("skillImage", imageUrl + "skillImage.png");
		this.name = name;
		this.maxPoint = maxPoint;
		this.infor = infor;
	}

	public void drawInfor(Graphics2D g, Point point) {
		
	}

	public abstract int getEffect(int point);

	public String getName() {
		return this.name;
	}

	public int getPoint() {
		return this.point;
	}

	public Image getImage() {
		return this.image;
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

	public int getMaxPoint() {
		return maxPoint;
	}

	public String getInfor() {
		return infor;
	}

	public void setMaxPoint(int maxPoint) {
		this.maxPoint = maxPoint;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

}

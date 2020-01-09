package skill;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import attack.Attack;
import component.StateBox;

/**
 * 
 * @author Leehwasub
 *
 */
public abstract class Skill {
	
	private Image image;
	private String name;
	private int point;
	private int maxPoint;
	private String infor;

	/**
	 * 
	 * @param image 스킬 이미지
	 * @param name 스킬 이름
	 * @param maxPoint 최대 포인트
	 * @param infor 스킬 설명
	 */
	public Skill(Image image, String name, int maxPoint, String infor) {
		this.image = image;
		this.name = name;
		this.maxPoint = maxPoint;
		this.infor = infor;
	}

	public void drawInfor(Graphics2D g) {
		
	}

	public abstract Attack skillUse(StateBox attacker, StateBox opponent);
	public abstract int getNeedMp(int point);
	public abstract int getEffect(int point);
	public abstract int getLast(int point);

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

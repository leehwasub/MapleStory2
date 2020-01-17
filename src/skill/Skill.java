package skill;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;

import character.Adventurer;
import map.Point;
import utils.ColorUtils;
import utils.FontUtils;
import utils.ResourceLoader;

/**
 * 
 * @author Leehwasub
 *
 */
public abstract class Skill implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected transient Image image;
	private String imageUrl;
	protected String name;
	protected int point;
	protected int maxPoint;
	protected String infor;
	
	private FontMetrics fm;

	/**
	 * 
	 * @param image 스킬 이미지
	 * @param name 스킬 이름
	 * @param maxPoint 최대 포인트
	 * @param infor 스킬 설명
	 */
	public Skill(String imageUrl, String name, int maxPoint, String infor) {
		this.imageUrl = imageUrl;
		if(this.imageUrl != null) {
			setSkillImageForInit();
		}
		this.name = name;
		this.maxPoint = maxPoint;
		this.infor = infor;
	}
	
	public void setSkillImageForInit() {
		this.image = ResourceLoader.getImage("skillImage", this.imageUrl + "SkillImage.png");
	}

	public void drawInfor(Graphics2D g, Point p) {
		fm = g.getFontMetrics();
		int totalLine = getLine(g);
		g.setColor(Color.BLACK);
		g.fillRect(p.getX(), p.getY(), 200, 160 + totalLine * 20);
		g.setFont(FontUtils.SMALL_FONT);
		fm = g.getFontMetrics(FontUtils.SMALL_FONT);
		g.setColor(Color.WHITE);
		int width = fm.stringWidth(getName());
		g.drawString(getName(), p.getX() + (200 - width) / 2, p.getY() + 25);
		g.drawImage(getImage(), p.getX() + 20, p.getY() + 45, null);
		g.setColor(Color.YELLOW);
		g.drawString("분류", p.getX() + 80, p.getY() + 70);
		g.setColor(Color.WHITE);
		String skillType = "";
		if(this instanceof PassiveSkill) {
			skillType = "패시브";
		} else {
			skillType = "액티브";
		}
		g.drawString(skillType, p.getX() + 120, p.getY() + 70);
		int preIndex = 0;
		int line = 0;
		int width2 = 0;
		for (int i = 0; i < this.infor.length(); i++) {
			FontMetrics fm = g.getFontMetrics();
			width2 = fm.stringWidth(this.infor.substring(preIndex, i));
			if (width2 > 150) {
				g.drawString(this.infor.substring(preIndex, i), p.getX() + (200 - width2) / 2, p.getY() + 120 + line * 20);
				preIndex = i;
				line++;
			}
		}
		width2 = fm.stringWidth(this.infor.substring(preIndex));
		g.drawString(this.infor.substring(preIndex), p.getX() + (200 - width2) / 2, p.getY() + 120 + line * 20);
		g.setColor(ColorUtils.SEA);
		g.setFont(FontUtils.SMALL_FONT);
	}
	
	private int getLine(Graphics2D g) {
		int preIndex = 0;
		int line = 0;
		int width2 = 0;
		for (int i = 0; i < this.infor.length(); i++) {
			FontMetrics fm = g.getFontMetrics();
			width2 = fm.stringWidth(this.infor.substring(preIndex, i));
			if (width2 > 150) {
				preIndex = i;
				line++;
			}
		}
		return ++line;
	}

	public abstract String getEffectDetail(int point);
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
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean addSkillPoint() {
		if(this.point < this.maxPoint) {
			this.point += 1;
			return true;
		}
		return false;
	}
	
	public String requiredSkillInfor() {
		return "";
	}
	
	public boolean isCanUpgrade(Adventurer adventurer) {
		return true;
	}

	@Override
	public String toString() {
		return "Skill [imageUrl=" + imageUrl + ", name=" + name + ", point=" + point + ", maxPoint=" + maxPoint
				+ ", infor=" + infor + "]";
	}

}

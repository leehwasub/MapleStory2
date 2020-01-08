package character;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import attack.Damage;
import buff.Buff;
import utils.ResourceLoader;

public class Character {
	protected String name;
	protected transient Image image;
	protected String imageUrl;
	protected int curHp;
	protected int curMp;
	protected int minPhysicalDamage;
	protected int maxPhysicalDamage;
	protected int minMagicDamage;
	protected int maxMagicDamage;
	protected Strength strength = new Strength();
	protected ArrayList<Buff> _buff = new ArrayList<Buff>();
	protected boolean isDead;

	public Character(String name, String imageUrl, Strength strength) {
		this.name = name;
		this.imageUrl = imageUrl;
		setImageWithInstanceForInit();
		this.strength = strength;
		this.curHp = strength.getMaxHp();
		this.curMp = strength.getMaxMp();
	}

	public void setImageWithInstanceForInit() {
		if ((this instanceof Adventurer)) {
			this.image = ResourceLoader.getImage("characterImage", this.imageUrl + "Image.png");
		} else if ((this instanceof Monster)) {
			this.image = ResourceLoader.getImage("monsterImage", this.imageUrl + "MonsterImage.png");
		}
	}

	public int hit(Damage damage) {
		Strength opponentStr = damage.getAttacker().getStrength();
		int successRate = opponentStr.getAccuracyRate() - this.strength.getEvasionRate() + opponentStr.getLevel()
				- this.strength.getLevel() + 90;
		int d = 0;
		boolean isMiss = false;
		int calMiss = (int) (Math.random() * 100.0D) + 1;
		if (calMiss > successRate) {
			isMiss = true;
		}
		if (!isMiss) {
			System.out.println(damage + " " + this.curHp);
			d = Math.max(0, damage.getPhysicalDamage() - this.strength.getPhysicalDefense());
			d += Math.max(1, damage.getMagicDamage() - this.strength.getMagicDamage());
			d = calResistenceDamage(d, damage);
			this.curHp -= Math.max(1, d);
		}
		if (this.curHp <= 0) {
			this.isDead = true;
		}
		return d;
	}

	public int calResistenceDamage(int d, Damage damage) {
		Resistance resistance = this.strength.getResistance();
		int resist = 100;
		switch (damage.getProperty()) {
		case PROPERTY_DARK:
			resist = resistance.getFire();
			break;
		case PROPERTY_FIRE:
			resist = resistance.getIce();
			break;
		case PROPERTY_ICE:
			resist = resistance.getPosion();
			break;
		case PROPERTY_NOTHING:
			resist = resistance.getThunder();
			break;
		case PROPERTY_POSION:
			resist = resistance.getDark();
			break;
		case PROPERTY_THUNDER:
			resist = resistance.getHoly();
			break;
		}
		if (resist < 100) {
			double plus = (100.0D - resist) / 200.0D;
			double tmp = d + d * plus;
			d = (int) tmp;
		} else if (resist > 100) {
			double minus = (resist - 100.0F) / 200.0F;
			double tmp = d - d * minus;
			d = (int) tmp;
		}
		return d;
	}

	public int calNormalDamge(double rate) {
		double min = getMinPhysicalDamage() * rate;
		double max = getMaxPhysicalDamage() * rate;
		return (int) (Math.random() * ((int) max - (int) min)) + (int) min;
	}

	public int calMagicDamge(double rate) {
		double min = getMinMagicDamage() * rate;
		double max = getMaxMagicDamage() * rate;
		return (int) (Math.random() * ((int) max - (int) min)) + (int) min;
	}

	public void healHp(int heal) {
		this.curHp = Math.min(this.curHp + heal, this.strength.getMaxHp());
	}

	public void healMp(int heal) {
		this.curMp = Math.min(this.curMp + heal, this.strength.getMaxMp());
	}

	public void spendMp(int mp) {
		this.curMp -= mp;
	}

	public int getMaxHp() {
		return this.strength.getMaxHp();
	}

	public int getMaxMp() {
		return this.strength.getMaxMp();
	}

	public String getName() {
		return this.name;
	}

	public Image getImage() {
		return this.image;
	}

	public int getCurHp() {
		return this.curHp;
	}

	public int getCurMp() {
		return this.curMp;
	}

	public int getMinPhysicalDamage() {
		return this.minPhysicalDamage;
	}

	public int getMaxPhysicalDamage() {
		return this.maxPhysicalDamage;
	}

	public int getMinMagicDamage() {
		return this.minMagicDamage;
	}

	public int getMaxMagicDamage() {
		return this.maxMagicDamage;
	}

	public Strength getStrength() {
		return this.strength;
	}

	public ArrayList<Buff> getBuff() {
		return this._buff;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImage(String image) {
		this.image = new ImageIcon(ResourceLoader.getImage("characterImage", image + "Image.png")).getImage();
	}

	public void setCurHp(int curHp) {
		this.curHp = curHp;
	}

	public void setCurMp(int curMp) {
		this.curMp = curMp;
	}

	public void setMinPhysicalDamage(int minPhysicalDamage) {
		this.minPhysicalDamage = minPhysicalDamage;
	}

	public void setMaxPhysicalDamage(int maxPhysicalDamage) {
		this.maxPhysicalDamage = maxPhysicalDamage;
	}

	public void setMinMagicDamage(int minMagicDamage) {
		this.minMagicDamage = minMagicDamage;
	}

	public void setMaxMagicDamage(int maxMagicDamage) {
		this.maxMagicDamage = maxMagicDamage;
	}

	public void setStrength(Strength strength) {
		this.strength = strength;
	}

	public void setBuff(ArrayList<Buff> buff) {
		this._buff = buff;
	}

	public boolean isDead() {
		return this.isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

	public String toString() {
		return

		"Character [name=" + this.name + ", image=" + this.image + ", curHp=" + this.curHp + ", curMp=" + this.curMp
				+ ", minPhysicalDamage=" + this.minPhysicalDamage + ", maxPhysicalDamage=" + this.maxPhysicalDamage
				+ ", minMagicDamage=" + this.minMagicDamage + ", maxMagicDamage=" + this.maxMagicDamage + ", strength="
				+ this.strength + ", _buff=" + this._buff + "]";
	}
}

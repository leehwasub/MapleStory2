package character;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import attack.AttackInfor;
import attack.Hit;
import attack.Property;
import buff.AbnormalBuff;
import buff.Buff;
import buff.SpecialBuff;
import buff.StrengthBuff;
import buff.StrengthBuffType;
import buff.StrengthRateBuff;
import utils.ResourceLoader;

public abstract class Character implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
	protected ArrayList<Buff> buffList = new ArrayList<Buff>();
	protected boolean isDead;
	protected int ignoreDamageRate;
	
	public Character() {
		
	}
	
	public Character(String name, String imageUrl, Strength strength) {
		this.name = name;
		this.imageUrl = imageUrl;
		setImageWithInstanceForInit();
		this.strength = strength;
		this.curHp = strength.getMaxHp();
		this.curMp = strength.getMaxMp();
	}
	
	public abstract void calState();

	public void setImageWithInstanceForInit() {
		if ((this instanceof Adventurer)) {
			this.image = ResourceLoader.getImage("characterImage", this.imageUrl + "Image.png");
		} else if ((this instanceof Monster)) {
			this.image = ResourceLoader.getImage("monsterImage", this.imageUrl + "MonsterImage.png");
		}
	}

	public Hit hit(AttackInfor attackInfor) {
		Strength opponentStr = attackInfor.getAttacker().getStrength();
		int successRate = opponentStr.getAccuracyRate() - this.strength.getEvasionRate() + opponentStr.getLevel()
				- this.strength.getLevel() + 90;
		int d = 0;
		boolean isMiss = false;
		boolean isCritical = false;
		int calMiss = (int) (Math.random() * 100.0d) + 1;
		if (calMiss > successRate) {
			isMiss = true;
		}
		if (!isMiss) {
			int getPhysicalDamage = 0;
			int getMagicDamage = 0;
			
			if(this instanceof Adventurer) {
				getPhysicalDamage = Math.max(attackInfor.getPhysicalDamage() - this.strength.getPhysicalDefense(), 0);
				getMagicDamage = Math.max(attackInfor.getMagicDamage() - this.strength.getMagicDefense(), 0);
			} else if(this instanceof Monster) {
				getPhysicalDamage = attackInfor.getPhysicalDamage() * (100 - strength.getPhysicalDefenseRate()) / 100;
				getMagicDamage = attackInfor.getMagicDamage() * (100 - strength.getMagicDefenseRate()) / 100;
			}
			getPhysicalDamage = calResistenceDamage(getPhysicalDamage, attackInfor.getProperty());
			getMagicDamage = calResistenceDamage(getMagicDamage, attackInfor.getProperty());
			

			int calCritical = (int)(Math.random() * 100) + 1;
			
			if(opponentStr.getCriticalRate() >= calCritical) {
				isCritical = true;
				getPhysicalDamage *= 2;
				getMagicDamage *= 2;
			}
			
			double ignoreDamageRateDouble = (double)ignoreDamageRate / 100.0;
			getPhysicalDamage = getPhysicalDamage - (int)((double)getPhysicalDamage * ignoreDamageRateDouble);
			getMagicDamage = getMagicDamage - (int)((double)getMagicDamage * ignoreDamageRateDouble);
			
			
			attackInfor.setPhysicalDamage(getPhysicalDamage);
			attackInfor.setMagicDamage(getMagicDamage);
			
			d += getPhysicalDamage;
			d += getMagicDamage;
			
			d = hitEvent(this, attackInfor);
			d = Math.max(1, d);
			this.curHp -= d;
		}
		if (this.curHp <= 0) {
			this.isDead = true;
		}
		return new Hit(d, attackInfor.getDamageType(), isCritical, isMiss);
	}
	
	public int hitEvent(Character character, AttackInfor attackInfor) {
		return (attackInfor.getPhysicalDamage() + attackInfor.getMagicDamage());
	}
	
	public int calResistenceDamage(int d, Property property) {
		Resistance resistance = this.strength.getResistance();
		int resist = 100;
		switch (property) {
		case PROPERTY_FIRE:
			resist = resistance.getFire();
			break;
		case PROPERTY_ICE:
			resist = resistance.getIce();
			break;
		case PROPERTY_POSION:
			resist = resistance.getPosion();
			break;
		case PROPERTY_THUNDER:
			resist = resistance.getThunder();
			break;
		case PROPERTY_DARK:
			resist = resistance.getDark();
			break;
		case PROPARTY_HOLY:
			resist = resistance.getHoly();
			break;
		default:
			break;
		}
		resist = Math.min(200, resist);
		resist = Math.max(0, resist);
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
	
	public void subCurHp(int damage) {
		curHp = Math.max(curHp - damage, 0);
		if(curHp == 0) isDead = true;
	}

	public void subCurMp(int damage) {
		curMp = Math.max(curMp - damage, 0);
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
	
	public void addBuff(Buff buff) {
		if(isAlreadyBuffed(buff.getName())) {
			removeBuff(buff.getName());
		}
		if(buffList == null) {
			newBuffList();
		}
		if(buff instanceof StrengthBuff && ((StrengthBuff)buff).getBuffType() == StrengthBuffType.PORTION_BUFF) {
			removeOverlapStrengthBuff(buff);
		}
		if(buff instanceof StrengthRateBuff && ((StrengthRateBuff)buff).getBuffType() == StrengthBuffType.PORTION_BUFF) {
			removeOverlapStrengthRateBuff(buff);
		}
		if(!isCanBuffed(buff)) {
			return;
		}
		buffList.add(buff);
	}
	
	public abstract boolean isCanBuffed(Buff buff);
	
	private void removeOverlapStrengthRateBuff(Buff buff) {
		if(buffList == null || buffList.size() == 0) return;
		for(int i = buffList.size() - 1; i >= 0; i--) {
			if(buffList.get(i) instanceof StrengthRateBuff && ((StrengthRateBuff)buffList.get(i)).getBuffType() == ((StrengthRateBuff)buff).getBuffType()) {
				if(buffList.get(i).isOverlapEffect(buff)) {
					buffList.remove(i);
				}
			}
		}
	}

	private void removeOverlapStrengthBuff(Buff buff) {
		if(buffList == null || buffList.size() == 0) return;
		for(int i = buffList.size() - 1; i >= 0; i--) {
			if(buffList.get(i) instanceof StrengthBuff && ((StrengthBuff)buffList.get(i)).getBuffType() == ((StrengthBuff)buff).getBuffType()) {
				if(buffList.get(i).isOverlapEffect(buff)) {
					buffList.remove(i);
				}
			}
		}
	}

	public void newBuffList() {
		buffList = new ArrayList<Buff>();
	}
	
	public void removeOneEffectBuff() {
		if(buffList == null || buffList.size() == 0) return;
		for(int i = buffList.size() - 1; i >= 0; i--) {
			if(!buffList.get(i).isDebuff()) {
				buffList.remove(i);
				return;
			}
		}
	}
	
	public boolean isExistEffectBuff() {
		if(buffList == null || buffList.size() == 0) return false;
		for(int i = 0; i < buffList.size(); i++) {
			if(!buffList.get(i).isDebuff()) {
				return true;
			}
		}
		return false;
	}
	
	public void removeAllBuff() {
		if(buffList == null || buffList.size() == 0) return;
		for(int i = buffList.size() - 1; i >= 0; i--) {
			buffList.remove(i);
		}
	}
	
	public void removeBuff(String buffName) {
		if(buffList == null || buffList.size() == 0) return;
		for(int i = buffList.size() - 1; i >= 0; i--) {
			if(buffList.get(i).getName().equals(buffName)) {
				buffList.remove(i);
			}
		}
	}
	
	public boolean isAlreadyBuffed(String buffName) {
		if(buffList == null || buffList.size() == 0) return false;
		for(int i = 0; i < buffList.size(); i++) {
			if(buffList.get(i).getName().equals(buffName)) {
				return true;
			}
		}
		return false;
	}
	
	public void buffLastOneTurn() {
		if(buffList == null || buffList.size() == 0) return;
		for(int i = buffList.size() - 1; i >= 0; i--) {
			buffList.get(i).oneTurnLast();
			if(buffList.get(i).isEnd()) buffList.remove(i);
		}
	}
	
	public void strengthBuffEffect() {
		if(buffList == null || buffList.size() == 0) return;
		for(int i = 0; i < buffList.size(); i++) {
			if(buffList.get(i) instanceof StrengthBuff || buffList.get(i) instanceof StrengthRateBuff) {
				buffList.get(i).effect(this);
			}
		}
	}
	
	public void getAbnormalBuffDamage() {
		if(buffList == null || buffList.size() == 0) return;
		for(int i = 0; i < buffList.size(); i++) {
			if(buffList.get(i) instanceof AbnormalBuff) {
				buffList.get(i).effect(this);
			}
		}
	}
	
	public boolean isStuned() {
		if(buffList == null || buffList.size() == 0) return false;
		for(int i = 0; i < buffList.size(); i++) {
			if(buffList.get(i) instanceof SpecialBuff && buffList.get(i).getName().equals("스턴")) {
				return true;
			}
		}
		return false;
	}
	
	public void removeAllAbnormalBuff() {
		if(buffList == null || buffList.size() == 0) return;
		for(int i = buffList.size() - 1; i >= 0; i--) {
			if(buffList.get(i) instanceof AbnormalBuff) {
				buffList.remove(i);
			}
		}
	}
	
	public ArrayList<Buff> getBuffList() {
		if(buffList == null) newBuffList();
		return this.buffList;
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
	
	public void addMinPhysicalDamage(int minPhysicalDamage) {
		this.minPhysicalDamage += minPhysicalDamage;
	}

	public void addMaxPhysicalDamage(int maxPhysicalDamage) {
		this.maxPhysicalDamage += maxPhysicalDamage;
	}

	public void addMinMagicDamage(int minMagicDamage) {
		this.minMagicDamage += minMagicDamage;
	}

	public void addMaxMagicDamage(int maxMagicDamage) {
		this.maxMagicDamage += maxMagicDamage;
	}

	public void setStrength(Strength strength) {
		this.strength = strength;
	}

	public void setBuff(ArrayList<Buff> buffList) {
		this.buffList = buffList;
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
		setImageWithInstanceForInit();
	}
	
	public int getIgnoreDamageRate() {
		return ignoreDamageRate;
	}
	
	public void addIgnoreDamageRate(int ignoreDamageRate) {
		this.ignoreDamageRate += ignoreDamageRate;
	}

	public void setIgnoreDamageRate(int ignoreDamageRate) {
		this.ignoreDamageRate = ignoreDamageRate;
	}

	public String toString() {
		return "Character [name=" + this.name + ", image=" + this.image + ", curHp=" + this.curHp + ", curMp=" + this.curMp
				+ ", minPhysicalDamage=" + this.minPhysicalDamage + ", maxPhysicalDamage=" + this.maxPhysicalDamage
				+ ", minMagicDamage=" + this.minMagicDamage + ", maxMagicDamage=" + this.maxMagicDamage + ", strength="
				+ this.strength + ", buffList=" + this.buffList + "]";
	}
}

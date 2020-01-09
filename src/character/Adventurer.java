package character;

import java.io.Serializable;
import java.util.ArrayList;

import item.ConsumableItem;
import item.EquipmentItem;
import skill.Skill;
import utils.ExpUtils;
import utils.MusicUtils;
import utils.NewbieStateUtils;

public class Adventurer extends Character implements Serializable {
	private static final long serialVersionUID = 1L;
	private EquipmentItem[] wearEquipment = new EquipmentItem[8];
	private Skill[] quickSkill = new Skill[4];
	private ConsumableItem[] quickItem = new ConsumableItem[4];
	private ArrayList<Skill> skillList = new ArrayList<Skill>();
	private Status status;
	private int proficiency;
	private int skillPoint;
	private int statePoint;
	private String sex;
	private String career;
	private int exp;
	private int[] Exp = ExpUtils.getNeedExp();

	public Adventurer(String name, String imageUrl, Strength strength, Status status, String career) {
		super(name, imageUrl, strength);
		this.status = status;
		this.career = career;
	}

	public void calState() {
		this.strength.setPhysicalDefense(0);
		this.strength.setMagicDefense(this.status.Int);
		this.strength.setPhysicalDamage(0);
		this.strength.setMagicDamage(0);
		this.strength.setMaxHp(NewbieStateUtils.getMaxHpByIndex(this.strength.getLevel()) * 10);
		this.strength.setMaxMp(NewbieStateUtils.getMaxMpByIndex(this.strength.getLevel()));

		this.strength.setAccuracyRate(this.status.dex / 2);
		this.strength.setEvasionRate(this.status.luk / 2);
		for (int i = 0; i < 8; i++) {
			if (this.wearEquipment[i] != null) {
				this.strength.addMaxHp(this.wearEquipment[i].getStrength().getMaxHp());
				this.strength.addMaxMp(this.wearEquipment[i].getStrength().getMaxMp());
				this.strength.addPhysicalDamage(this.wearEquipment[i].getStrength().getPhysicalDamage());
				this.strength.addMagicDamage(this.wearEquipment[i].getStrength().getMagicDamage());
				this.strength.addPhysicalDefense(this.wearEquipment[i].getStrength().getPhysicalDefense());
				this.strength.addMagicDefense(this.wearEquipment[i].getStrength().getMagicDefense());
				this.strength.addAccuracyRate(this.wearEquipment[i].getStrength().getAccuracyRate());
				this.strength.addEvasionRate(this.wearEquipment[i].getStrength().getEvasionRate());
			}
		}
		this.maxPhysicalDamage = (this.strength.getPhysicalDamage() * this.status.str / 10);
		this.maxPhysicalDamage *= 1;
		this.minPhysicalDamage = (this.maxPhysicalDamage * this.proficiency / 10 / 10);

		this.minPhysicalDamage = Math.min(this.minPhysicalDamage, this.maxPhysicalDamage);
	}

	public void addExp(int exp) {
		this.exp += exp;
		while (this.exp >= this.Exp[getStrength().getLevel()]) {
			MusicUtils.startEffectSound("levelUp");
			this.exp -= this.Exp[getStrength().getLevel()];
			getStrength().setLevel(getStrength().getLevel() + 1);
			calState();
			this.curHp = getMaxHp();
			this.curMp = getMaxMp();
			this.statePoint += 5;
		}
	}

	public void usePortion(ConsumableItem item) {
		item.use(this);
	}

	public void removeEmptyQuickItem() {
		for (int i = 0; i < 4; i++) {
			if ((this.quickItem[i] != null) && (this.quickItem[i].getNum() == 0)) {
				this.quickItem[i] = null;
			}
		}
	}

	public boolean removeQuickItem(int keyIndex) {
		if (getQuickItemByIndex(keyIndex) == null) {
			return false;
		}
		setQuickItemByIndex(keyIndex, null);
		calState();
		return true;
	}

	public Status getStatus() {
		return this.status;
	}

	public int getProficiency() {
		return this.proficiency;
	}

	public int getSkillPoint() {
		return this.skillPoint;
	}

	public int getStatePoint() {
		return this.statePoint;
	}

	public void spendStatePoint() {
		if (this.statePoint == 0) {
			return;
		}
		this.statePoint -= 1;
	}

	public String getSex() {
		return this.sex;
	}

	public String getCareer() {
		return this.career;
	}

	public int getExp() {
		return this.exp;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setProficiency(int proficiency) {
		this.proficiency = proficiency;
	}

	public void setSkillPoint(int skillPoint) {
		this.skillPoint = skillPoint;
	}

	public void setStatePoint(int statePoint) {
		this.statePoint = statePoint;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getNeedExp() {
		return this.Exp[this.strength.getLevel()];
	}

	public EquipmentItem[] getWearEquipment() {
		return this.wearEquipment;
	}

	public EquipmentItem getWearEquipmentByIndex(int i) {
		return this.wearEquipment[i];
	}

	public void setWearEquipmentByIndex(int i, EquipmentItem item) {
		this.wearEquipment[i] = item;
	}

	public Skill[] getQuickSkill() {
		return this.quickSkill;
	}

	public ConsumableItem[] getQuickItem() {
		return this.quickItem;
	}

	public void setQuickSkillByIndex(int i, Skill quickSkill) {
		this.quickSkill[i] = quickSkill;
	}

	public void setQuickItemByIndex(int i, ConsumableItem quickItem) {
		this.quickItem[i] = quickItem;
	}

	public Skill getQuickSkillByIndex(int i) {
		return this.quickSkill[i];
	}

	public ConsumableItem getQuickItemByIndex(int i) {
		return this.quickItem[i];
	}

	public void fullHeal() {
		this.curHp = this.strength.getMaxHp();
		this.curMp = this.strength.getMaxMp();
	}

	public ArrayList<Skill> getSkillList() {
		return skillList;
	}
	
	public void addSkill(Skill skill) {
		this.skillList.add(skill);
	}

	public void setSkillList(ArrayList<Skill> skillList) {
		this.skillList = skillList;
	}
	
}
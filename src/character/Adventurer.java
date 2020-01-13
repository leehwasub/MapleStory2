package character;

import java.io.Serializable;
import java.util.ArrayList;

import item.BuffItem;
import item.ConsumableItem;
import item.EquipmentItem;
import item.HealItem;
import maplestory.Main;
import skill.PassiveSkill;
import skill.Skill;
import utils.DialogUtils;
import utils.ExpUtils;
import utils.MusicUtils;
import utils.NewbieStateUtils;
import utils.WarriorStateUtils;

public class Adventurer extends Character implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int QUICK_ITEM_ARRAY_SIZE = 5;
	public static final int QUICK_SKILL_ARRAY_SIZE = 5;
	private EquipmentItem[] wearEquipment = new EquipmentItem[8];
	private Skill[] quickSkill = new Skill[QUICK_SKILL_ARRAY_SIZE];
	private ConsumableItem[] quickItem = new ConsumableItem[QUICK_ITEM_ARRAY_SIZE];
	private ArrayList<Skill> oneLevelSkillList = new ArrayList<Skill>();
	private ArrayList<Skill> twoLevelSkillList = new ArrayList<Skill>();
	private ArrayList<Skill> threeLevelSkillList = new ArrayList<Skill>();
	private Status status;
	private int proficiency;
	private int skillPoint;
	private int statePoint;
	private String sex;
	private String career;
	private int careerLevel;
	private int exp;
	private int[] Exp = ExpUtils.getNeedExp();

	public Adventurer(String name, String imageUrl, Strength strength, Status status, String career) {
		super(name, imageUrl, strength);
		this.status = status;
		this.career = career;
	}

	public void calState() {
		proficiency = 20;
		this.strength.setPhysicalDefense(0);
		this.strength.setMagicDefense(0);
		this.strength.setPhysicalDamage(0);
		this.strength.setMagicDamage(0);
		
		if(careerLevel == 0) {
			strength.setMaxHp(NewbieStateUtils.getMaxHpByIndex(strength.getLevel()));
			strength.setMaxMp(NewbieStateUtils.getMaxMpByIndex(strength.getLevel()));
		} else {
			strength.setMaxHp(WarriorStateUtils.getMaxHpByIndex(strength.getLevel()));
			strength.setMaxMp(WarriorStateUtils.getMaxMpByIndex(strength.getLevel()));
		}
		
		calPassiveSkillState();

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
		
		strengthBuffEffect();
		
		this.maxPhysicalDamage = (this.strength.getPhysicalDamage() * this.status.str / 10);
		if(Main.DAMAGE_TEST_MODE) {
			this.maxPhysicalDamage *= 10;
		}
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
			if(this.getStrength().getLevel() >= 10) this.skillPoint += 3;
		}
	}
	
	public void calPassiveSkillState() {
		for(int i = 0; i < oneLevelSkillList.size(); i++) {
			if(oneLevelSkillList.get(i) instanceof PassiveSkill) {
				((PassiveSkill)oneLevelSkillList.get(i)).skillUpEffect(this);
			}
		}
		for(int i = 0; i < twoLevelSkillList.size(); i++) {
			if(twoLevelSkillList.get(i) instanceof PassiveSkill) {
				((PassiveSkill)twoLevelSkillList.get(i)).skillUpEffect(this);
			}
	
		}
		for(int i = 0; i < threeLevelSkillList.size(); i++) {
			if(threeLevelSkillList.get(i) instanceof PassiveSkill) {
				((PassiveSkill)threeLevelSkillList.get(i)).skillUpEffect(this);
			}
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
	
	public boolean removeQuickSkill(int keyIndex) {
		if (getQuickSkillByIndex(keyIndex) == null) {
			return false;
		}
		setQuickSkillByIndex(keyIndex, null);
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
	
	public void subSkillPoint() {
		this.skillPoint -= 1;
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

	public int getCareerLevel() {
		return careerLevel;
	}

	public void setCareerLevel(int careerLevel) {
		this.careerLevel = careerLevel;
	}

	public void fullHeal() {
		this.curHp = this.strength.getMaxHp();
		this.curMp = this.strength.getMaxMp();
	}
	
	public int getAdventurerLevel() {
		return strength.getLevel();
	}

	/**
	 * 
	 * @param level 몇차전칙 스킬 목록을 리턴할 것인지
	 * @return 스킬 목록
	 */
	public ArrayList<Skill> getSkillList(int level) {
		ArrayList<Skill> ret = null;
		switch(level) {
		case 1:
			ret = oneLevelSkillList;
			break;
		case 2:
			ret = twoLevelSkillList;
			break;
		case 3:
			ret = threeLevelSkillList;
			break;
		}
		return ret;
	}
	
	
	public void addSkill(int level, Skill skill) {
		switch(level) {
		case 1:
			oneLevelSkillList.add(skill);
			break;
		case 2:
			twoLevelSkillList.add(skill);
			break;
		case 3:
			threeLevelSkillList.add(skill);
			break;
		}
	}
	
	public Skill getSkillWithLevelIndex(int level, int index) {
		switch(level) {
		case 1:
			return oneLevelSkillList.get(index);
		case 2:
			return twoLevelSkillList.get(index);
		case 3:
			return threeLevelSkillList.get(index);
		}
		return null;
	}

	public Skill getSkillWithName(String skillName) {
		for(int i = 0; i < oneLevelSkillList.size(); i++) {
			if(oneLevelSkillList.get(i).getName().equals(skillName)) {
				return oneLevelSkillList.get(i);
			}
		}
		for(int i = 0; i < twoLevelSkillList.size(); i++) {
			if(twoLevelSkillList.get(i).getName().equals(skillName)) {
				return twoLevelSkillList.get(i);
			}
		}
		for(int i = 0; i < threeLevelSkillList.size(); i++) {
			if(threeLevelSkillList.get(i).getName().equals(skillName)) {
				return threeLevelSkillList.get(i);
			}
		}
		return null;
	}

	public void setAllSkillImageForInit() {
		for(int i = 0; i < oneLevelSkillList.size(); i++) {
			oneLevelSkillList.get(i).setSkillImageForInit();
		}
		for(int i = 0; i < twoLevelSkillList.size(); i++) {
			twoLevelSkillList.get(i).setSkillImageForInit();
		}
		for(int i = 0; i < threeLevelSkillList.size(); i++) {
			threeLevelSkillList.get(i).setSkillImageForInit();
		}
	}

	
}
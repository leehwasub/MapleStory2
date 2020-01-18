package character;

import java.io.Serializable;
import java.util.ArrayList;

import hunt.EmptyHuntEvent;
import hunt.HuntEvent;
import item.ConsumableItem;
import item.EquipmentItem;
import maplestory.Main;
import skill.ActiveSkill;
import skill.PassiveSkill;
import skill.Skill;
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
	private ArrayList<ArrayList<Skill>> skillList = new ArrayList<ArrayList<Skill>>();
	private Status status;
	private int proficiency;
	private int skillPoint;
	private int statePoint;
	private String sex;
	private String career;
	private int careerLevel;
	private int exp;
	private int[] Exp = ExpUtils.getNeedExp();
	private HuntEvent huntEvent;
	
	private Skill usedSkill;

	public Adventurer(String name, String imageUrl, Strength strength, Status status, String career) {
		super(name, imageUrl, strength);
		this.status = status;
		this.career = career;
		this.huntEvent = new EmptyHuntEvent();
		for(int i = 0; i < 3; i++) {
			skillList.add(new ArrayList<Skill>());
		}
	}

	public void calState() {
		proficiency = 20;
		strength.setPhysicalDefense(0);
		strength.setMagicDefense(0);
		strength.setPhysicalDamage(0);
		strength.setMagicDamage(0);
		strength.setCriticalRate(0);
		ignoreDamageRate = 0;
		
		if(careerLevel == 0) {
			strength.setMaxHp(NewbieStateUtils.getMaxHpByIndex(strength.getLevel()));
			strength.setMaxMp(NewbieStateUtils.getMaxMpByIndex(strength.getLevel()));
		} else {
			strength.setMaxHp(WarriorStateUtils.getMaxHpByIndex(strength.getLevel()));
			strength.setMaxMp(WarriorStateUtils.getMaxMpByIndex(strength.getLevel()));
		}

		strength.setAccuracyRate(this.status.dex / 2);
		strength.setEvasionRate(this.status.luk / 2);
		
		calPassiveSkillState();
		
		for (int i = 0; i < 8; i++) {
			if (wearEquipment[i] != null) {
				strength.addMaxHp(this.wearEquipment[i].getStrength().getMaxHp());
				strength.addMaxMp(this.wearEquipment[i].getStrength().getMaxMp());
				strength.addPhysicalDamage(this.wearEquipment[i].getStrength().getPhysicalDamage());
				strength.addMagicDamage(this.wearEquipment[i].getStrength().getMagicDamage());
				strength.addPhysicalDefense(this.wearEquipment[i].getStrength().getPhysicalDefense());
				strength.addMagicDefense(this.wearEquipment[i].getStrength().getMagicDefense());
				strength.addAccuracyRate(this.wearEquipment[i].getStrength().getAccuracyRate());
				strength.addEvasionRate(this.wearEquipment[i].getStrength().getEvasionRate());
			}
		}
		
		strengthBuffEffect();
		
		maxPhysicalDamage = (this.strength.getPhysicalDamage() * this.status.str / 10);
		if(Main.DAMAGE_TEST_MODE) {
			maxPhysicalDamage *= 10;
		}
		minPhysicalDamage = (maxPhysicalDamage * proficiency / 10 / 10);

		minPhysicalDamage = Math.min(minPhysicalDamage, maxPhysicalDamage);
		
		afterCalState();
	}
	

	private void afterCalState() {
		afterCalStateSkillEffect();
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
		for(int i = 0; i < skillList.size(); i++) {
			for(int j = 0; j < skillList.get(i).size(); j++) {
				if(skillList.get(i).get(j) instanceof PassiveSkill) {
					((PassiveSkill)skillList.get(i).get(j)).calStateEffect(this);
				}
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
	
	public void addSkillPoint(int point) {
		skillPoint += point;
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
	
	public void addProficiency(int proficiency) {
		this.proficiency += proficiency;
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
	
	public Skill getUsedSkill() {
		return usedSkill;
	}

	public void setUsedSkill(Skill usedSkill) {
		this.usedSkill = usedSkill;
	}

	public int getAdventurerLevel() {
		return strength.getLevel();
	}

	public HuntEvent getHuntEvent() {
		return huntEvent;
	}

	public void setHuntEvent(HuntEvent huntEvent) {
		this.huntEvent = huntEvent;
	}

	/**
	 * 
	 * @param level 몇차전칙 스킬 목록을 리턴할 것인지
	 * @return 스킬 목록
	 */
	public ArrayList<Skill> getSkillList(int level) {
		--level;
		return skillList.get(level);
	}
	
	/**
	 * 
	 * @param level 몇차 전직 인지
	 * @param skill 추가할 스킬 본체
	 */
	public void addSkill(int level, Skill skill) {
		--level;
		skillList.get(level).add(skill);
	}
	
	public Skill getSkillWithLevelIndex(int level, int index) {
		--level;
		return skillList.get(level).get(index);
	}

	public Skill getSkillWithName(String skillName) {
		for(int i = 0; i < skillList.size(); i++) {
			for(int j = 0; j < skillList.get(i).size(); j++) {
				if(skillList.get(i).get(j).getName().equals(skillName)) {
					return skillList.get(i).get(j);
				}
			}
		}
		return null;
	}

	public void setAllSkillImageForInit() {
		for(int i = 0; i < skillList.size(); i++) {
			for(int j = 0; j < skillList.get(i).size(); j++) {
				skillList.get(i).get(j).setSkillImageForInit();
			}
		}
	}
	
	private void afterCalStateSkillEffect() {
		for(int i = 0; i < skillList.size(); i++) {
			for(int j = 0; j < skillList.get(i).size(); j++) {
				skillList.get(i).get(j).afterCalStateEffect(this);
			}
		}
	}
	
	public void setAllSkillFullCoolTime() {
		for(int i = 0; i < skillList.size(); i++) {
			for(int j = 0; j < skillList.get(i).size(); j++) {
				if(skillList.get(i).get(j) instanceof ActiveSkill) {
					((ActiveSkill)skillList.get(i).get(j)).setFullCoolTime();
				}
			}
		}
	}
	
	public void resetAllSkillCoolTime() {
		for(int i = 0; i < skillList.size(); i++) {
			for(int j = 0; j < skillList.get(i).size(); j++) {
				if(skillList.get(i).get(j) instanceof ActiveSkill) {
					((ActiveSkill)skillList.get(i).get(j)).resetCoolTime();
				}
			}
		}
	}
	
	public void subAllSkillCoolTime() {
		for(int i = 0; i < skillList.size(); i++) {
			for(int j = 0; j < skillList.get(i).size(); j++) {
				if(skillList.get(i).get(j) instanceof ActiveSkill) {
					((ActiveSkill)skillList.get(i).get(j)).subCoolTime();
				}
			}
		}
	}

	
}
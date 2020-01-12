package skill;

import attack.AttackType;
import attack.Property;

public class MonsterSkill {

	private String attackName;
	private Property property;
	private int skillPoint;
	private AttackType attackType;
	
	public MonsterSkill(String attackName, Property property, int skillPoint, AttackType attackType) {
		this.attackName = attackName;
		this.property = property;
		this.skillPoint = skillPoint;
		this.attackType = attackType;
	}
	
	public String getAttackName() {
		return attackName;
	}
	
	public Property getProperty() {
		return property;
	}
	
	public int getSkillPoint() {
		return skillPoint;
	}
	
	public AttackType getAttackType() {
		return attackType;
	}
	
	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}
	
	public void setProperty(Property property) {
		this.property = property;
	}
	
	public void setSkillPoint(int skillPoint) {
		this.skillPoint = skillPoint;
	}
	
	public void setAttackType(AttackType attackType) {
		this.attackType = attackType;
	}

	
	@Override
	public String toString() {
		return "MonsterSkill [attackName=" + attackName + ", property=" + property + ", skillPoint=" + skillPoint
				+ ", attackType=" + attackType + "]";
	}
	
}

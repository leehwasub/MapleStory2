package skill;

import attack.AttackType;
import attack.Property;
import character.Adventurer;
import component.StateBox;
import hunt.Hunt;
import playerAttack.PlayerAttack;

public abstract class ActiveSkill extends Skill {

	private static final long serialVersionUID = 1L;
	
	protected AttackType attackType;
	protected Property property;
	protected int coolTime;
	
	protected int curCoolTime;

	public ActiveSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor);
		this.attackType = attackType;
		this.property = property;
	}
	
	public ActiveSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property, int coolTime) {
		super(imageUrl, name, maxPoint, infor);
		this.attackType = attackType;
		this.property = property;
		this.coolTime = coolTime;
	}
	
	
	protected final void getElementalCombo(StateBox attacker) {
		Adventurer adventurer = (Adventurer)attacker.getCharacter();
		ElementalChargeSkill elementalCharge = (ElementalChargeSkill)adventurer.getSkillWithName("엘리멘탈차지");
		if(adventurer.getUsedSkill() == null ||elementalCharge == null || 
				elementalCharge.getPoint() == 0 || elementalCharge.isHaveMaxChargeNum()) return;
		
		if(adventurer.getUsedSkill() instanceof FlameChargeSkill && this instanceof BlizzardChargeSkill) {
			elementalCharge.addChargeNum();
		}
		else if(adventurer.getUsedSkill() instanceof BlizzardChargeSkill && this instanceof FlameChargeSkill) {
			elementalCharge.addChargeNum();
		}
	}
	
	protected final void getComboAttack(StateBox attacker) {
		Adventurer adventurer = (Adventurer)attacker.getCharacter();
		ComboAttackSkill comboAttack = (ComboAttackSkill)adventurer.getSkillWithName("콤보어택");
		if(comboAttack == null || comboAttack.getPoint() == 0 || comboAttack.isHaveMaxComboNum()) return;
		
		int rate = comboAttack.getEffect(comboAttack.point);
		int randomRate = (int)(Math.random() * 99) + 1;
 		if(randomRate <= rate) {
 			comboAttack.addComboNum();
 		}
	}
	
	public int getCoolTime() {
		return coolTime;
	}

	public void setCoolTime(int coolTime) {
		this.coolTime = coolTime;
	}

	public AttackType getAttackType() {
		return attackType;
	}

	public Property getProperty() {
		return property;
	}

	public void setAttackType(AttackType attackType) {
		this.attackType = attackType;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "ActiveSkill [attackType=" + attackType + ", property=" + property + "]";
	}
	
	public void resetCoolTime() {
		curCoolTime = coolTime;
	}
	
	public void subCoolTime() {
		if(curCoolTime >= 1) {
			curCoolTime--;
		}
	}

	public boolean isCanUseSkill() {
		return (curCoolTime == 0);
	}
	
	public abstract int getNeedMp(int point);
	public abstract int getLast(int point);
	public abstract PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent);
	
}

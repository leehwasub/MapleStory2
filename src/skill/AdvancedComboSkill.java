package skill;

import character.Adventurer;
import item.EquipmentItem;
import item.WeaponItem;
import item.WeaponType;

public class AdvancedComboSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public AdvancedComboSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}
	

	@Override
	public String requiredSkillInfor() {
		return "선행스킬 : 콤보어택 마스터";
	}
	
	@Override
	public boolean isCanUpgrade(Adventurer adventurer) {
		PassiveSkill advancedCombo = (PassiveSkill)adventurer.getSkillWithName("콤보어택");
		if(advancedCombo == null || advancedCombo.getPoint() < 10) return false;
		return true;
	}
	
	@Override
	public void skillUpEffect(Adventurer adventurer) {
		ComboAttackSkill comboAttackSkill = (ComboAttackSkill)adventurer.getSkillWithName("콤보어택");
		if(comboAttackSkill != null && comboAttackSkill.getPoint() >= 1) {
			comboAttackSkill.setMaxComboNum(getEffect(point));
		}
	}

	@Override
	public int getEffect(int point) {
		return 6 + (point / 5);
	}
	
	public int getDoubleGetEffect(int point) {
		return 20 + point;
	}

	public int getProficiencyEffect(int point) {
		return 15 + ((point + 1) / 2);
	}

	@Override
	public String getEffectDetail(int point) {
		return "콤보어택 최대 " + getEffect(point) + "개 충전 가능, " + getDoubleGetEffect(point)+"% 확률로 콤보어택 2개 충전 [패시브 효과 : 검숙련도 "+getProficiencyEffect(point)+"% 추가 증가]";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		WeaponItem weaponItem = (WeaponItem)adventurer.getWearEquipmentByIndex(EquipmentItem.EQUIPMENT_TYPE_WAEPON);
		if(weaponItem != null && weaponItem.getWeaponType() == WeaponType.SWORD && point >= 1) {
			adventurer.addProficiency(getProficiencyEffect(point));
		}
	}

}

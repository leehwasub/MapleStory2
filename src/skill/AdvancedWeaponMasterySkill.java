package skill;

import character.Adventurer;
import item.EquipmentItem;
import item.WeaponItem;
import item.WeaponType;

public class AdvancedWeaponMasterySkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public AdvancedWeaponMasterySkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 16 + (point / 2);
	}
	
	public int getPhysicalDamageEffect(int point) {
		return point;
	}
	
	public int getCriticalDamageEffect(int point) {
		return 3 + (point / 5);
	}

	@Override
	public String getEffectDetail(int point) {
		return "창 무기 숙련도 +"+ getEffect(point) + ", 창 무기 착용시 물리공격력 +" + getPhysicalDamageEffect(point) + ", 크리티컬 데미지 +" + getCriticalDamageEffect(point) + "%";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		WeaponItem weaponItem = (WeaponItem)adventurer.getWearEquipmentByIndex(EquipmentItem.EQUIPMENT_TYPE_WAEPON);
		if(weaponItem != null && weaponItem.getWeaponType() == WeaponType.SPEAR) {
			adventurer.getStrength().addPhysicalDamage(getPhysicalDamageEffect(point));
			adventurer.addCriticalExtraDamageRate(getCriticalDamageEffect(point));
			adventurer.addProficiency(getEffect(point));
		}
	}

}

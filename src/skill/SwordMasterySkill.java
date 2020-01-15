package skill;

import character.Adventurer;
import item.EquipmentItem;
import item.WeaponItem;
import item.WeaponType;

public class SwordMasterySkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public SwordMasterySkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 2 * point;
	}

	@Override
	public String getEffectDetail(int point) {
		return "검 무기 숙련도 +"+ getEffect(point) + ", 검 무기 착용시 적중률 +" + getEffect(point);
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		WeaponItem weaponItem = (WeaponItem)adventurer.getWearEquipmentByIndex(EquipmentItem.EQUIPMENT_TYPE_WAEPON);
		System.out.println(weaponItem);
		if(weaponItem != null && weaponItem.getWeaponType() == WeaponType.SWORD) {
			adventurer.getStrength().addAccuracyRate(getEffect(point));
			adventurer.addProficiency(getEffect(point));
		}
	}

}

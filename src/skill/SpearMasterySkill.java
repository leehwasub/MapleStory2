package skill;

import character.Adventurer;
import item.EquipmentItem;
import item.WeaponItem;
import item.WeaponType;

public class SpearMasterySkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public SpearMasterySkill(String imageUrl, String name, int maxPoint, String infor) {
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
		return "창 무기 숙련도 +"+ getEffect(point) + ", 창 무기 착용시 적중률 +" + getEffect(point);
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		WeaponItem weaponItem = (WeaponItem)adventurer.getWearEquipmentByIndex(EquipmentItem.EQUIPMENT_TYPE_WAEPON);
		if(weaponItem != null && weaponItem.getWeaponType() == WeaponType.SPEAR && point >= 1) {
			adventurer.getStrength().addAccuracyRate(getEffect(point));
			adventurer.addProficiency(getEffect(point));
		}
	}

}

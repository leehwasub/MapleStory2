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
		return "STR +"+ getEffect(point) + "";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		WeaponItem weaponItem = (WeaponItem)adventurer.getWearEquipmentByIndex(EquipmentItem.EQUIPMENT_TYPE_WAEPON);
		if(weaponItem != null && weaponItem.getWeaponType() == WeaponType.SWORD) {
			adventurer.getStrength().addAccuracyRate(getEffect(point));
			adventurer.addProficiency(getEffect(point));
		}
	}

}

package item;

import java.io.Serializable;

import character.SexType;
import character.Strength;

public class WeaponItem extends EquipmentItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private WeaponType weaponType;
	

	public WeaponItem(String name, int cost, String imageUrl, int num, Strength strength, int type, SexType sex,
			boolean isRare, WeaponType weaponType) {
		super(name, cost, imageUrl, num, strength, type, sex, isRare);
		this.weaponType = weaponType;
	}

	public WeaponType getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}

	
}

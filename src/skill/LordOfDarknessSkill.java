package skill;

import character.Adventurer;
import item.EquipmentItem;
import item.WeaponItem;
import item.WeaponType;

public class LordOfDarknessSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public LordOfDarknessSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 6 + 2 * point;
	}
	
	public int getExtraEffect(int point) {
		return 2;
	}

	@Override
	public String getEffectDetail(int point) {
		return "크리티컬 확률 +" + getEffect(point) + "%, 체력이 20% 낮아질 때마다" + getExtraEffect(point) + "% 추가 증가";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		if(point >= 1) {
			int calMaxHp = adventurer.getMaxHp() / 10;
			int calEffect = getEffect(point);
			for(int i = 2; i < 10; i += 2) {
				if(calMaxHp * (10 - i) > adventurer.getCurHp()) {
					calEffect += getExtraEffect(point);
				}
			}
			adventurer.getStrength().addCriticalRate(calEffect);
		}
	}

}

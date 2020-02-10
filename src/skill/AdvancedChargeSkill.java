package skill;

import character.Adventurer;

public class AdvancedChargeSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public AdvancedChargeSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 1 + (point / 10);
	}
	
	public int getDamageRateEffect(int point) {
		return 1 + (point / 5);
	}

	@Override
	public String getEffectDetail(int point) {
		return "엘레멘탈 차지 1개당 물리데미지 +"+ getDamageRateEffect(point) + "%[패시브효과:모든 차지 스킬 타격횟수 +" + getEffect(point) + "]";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		
	}
	
	@Override
	public void afterCalStateEffect(Adventurer adventurer) {
		double increRate = (double)getDamageRateEffect(point) / 100.0;
		ElementalChargeSkill elementalChargeSkill = (ElementalChargeSkill)adventurer.getSkillWithName("엘리멘탈차지");
		AdvancedChargeSkill advancedChargeSkill = (AdvancedChargeSkill)adventurer.getSkillWithName("어드밴스드차지");
		if(elementalChargeSkill != null && elementalChargeSkill.getChargeNum() >= 1
				&& advancedChargeSkill != null && advancedChargeSkill.getPoint() >= 1) {
			increRate = increRate * elementalChargeSkill.getChargeNum();
			adventurer.addMinPhysicalDamage((int)(adventurer.getMinPhysicalDamage() * increRate));
			adventurer.addMaxPhysicalDamage((int)(adventurer.getMaxPhysicalDamage() * increRate));
		}
	}


}

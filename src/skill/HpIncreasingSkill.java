package skill;

import character.Adventurer;

public class HpIncreasingSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public HpIncreasingSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 2*point;
	}

	@Override
	public String getEffectDetail(int point) {
		return "HP "+ getEffect(point) +"% 증가";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		double percent = (double)getEffect(this.point) / 100.0f;
		int increase = (int)(adventurer.getStrength().getMaxHp() * percent);
		adventurer.getStrength().addMaxHp(increase);
	}


}

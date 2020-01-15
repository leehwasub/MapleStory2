package skill;

import character.Adventurer;

public class PhysicalTrainingSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public PhysicalTrainingSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		adventurer.getStatus().addStr(2);
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
		
	}

}

package skill;

import character.Adventurer;

public class ElementalForceSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public ElementalForceSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 84 + point * 4;
	}

	@Override
	public String getEffectDetail(int point) {
		return "영구적으로 플레임 차지, 블리자드 차지, 라이트닝 차지 데미지 +" + getEffect(point) + "% 증가";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		
	}

}

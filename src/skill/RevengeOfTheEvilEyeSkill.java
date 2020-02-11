package skill;

import character.Adventurer;

public class RevengeOfTheEvilEyeSkill extends PassiveSkill{

	private boolean isHit;
	private static final long serialVersionUID = 1L;

	public RevengeOfTheEvilEyeSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	public int getHpRecoverRate(int point) {
		return 4;
	}

	@Override
	public int getEffect(int point) {
		return 550 + point * 12;
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	@Override
	public String getEffectDetail(int point) {
		return "비홀더가 직접시전, 플레이어 피격시 반격 " + getEffect(point) + "% 물리데미지, 체력 " + getHpRecoverRate(point) + "% 회복";
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		
	}
}

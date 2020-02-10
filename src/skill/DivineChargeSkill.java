package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.BlizzardChargeAttack;
import playerAttack.DivineChargeAttack;
import playerAttack.PlayerAttack;

public class DivineChargeSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public DivineChargeSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property, int coolTime) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
		this.coolTime = coolTime;
	}

	@Override
	public int getNeedMp(int point) {
		return 25 + ((point / 8) * 2);
	}

	@Override
	public int getLast(int point) {
		return 2 + (point / 16);
	}
	
	public int getSilenceRate(int point) {
		return point * 2;
	}
	
	public int getExtraEffect(int point) {
		return 106 + (point / 2);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new DivineChargeAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 334 + point * 4;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getEffect(point) + "% 성속성 물리데미지로 3번 공격,  "+ getSilenceRate(point) + "% 확률로 " + getLast(point) + "턴간 적 침묵, 적스킬 사용불가. " 
				+ " 스턴 상태의 적 공격시 " + getExtraEffect(point) + "% 추가데미지(쿨타임 "+coolTime+"턴)";
	}

}

package skill;

import attack.AttackType;
import attack.Property;
import character.Adventurer;
import component.StateBox;
import hunt.Hunt;
import playerAttack.BlizzardChargeAttack;
import playerAttack.LightningChargeAttack;
import playerAttack.PlayerAttack;

public class LightningChargeSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public LightningChargeSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 25 + point;
	}

	@Override
	public int getLast(int point) {
		return 2 + (point / 15);
	}
	
	public int stunRate(int point) {
		return 10 + point;
	}

	public int extraEffect(int point) {
		return 106 + (point / 2);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new LightningChargeAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 190 + point * 3;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getEffect(point) + "% 전기속성 물리데미지로 3번 공격 " +stunRate(point) +"% 확률로 " + getLast(point) + "턴간 스턴"
				+ ", 동상 상태의 적 공격시 " + extraEffect(point) + "% 추가데미지";
	}

}

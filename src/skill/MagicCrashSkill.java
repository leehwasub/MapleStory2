package skill;

import attack.AttackType;
import attack.Property;
import character.Monster;
import character.Strength;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.MagicCrashAttack;
import playerAttack.PlayerAttack;
import playerAttack.ThreatenAttack;

public class MagicCrashSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public MagicCrashSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property, int coolTime) {
		super(imageUrl, name, maxPoint, infor, attackType, property, coolTime);
	}

	@Override
	public int getNeedMp(int point) {
		return 33 - ((point / 2) * 2);
	}

	@Override
	public int getLast(int point) {
		return 3 + (point / 10);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new MagicCrashAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 20 + point * 4;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, "+getEffect(point)+"% 확률로 적에게 "+ getLast(point) +"턴간 모든 버프를 해제하는 버프를 건다.(쿨타임 " +coolTime+"턴)";
	}
	
}

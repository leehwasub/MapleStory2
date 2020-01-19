package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.IntrepidSlashAttack;
import playerAttack.PlayerAttack;

public class IntrepidSlashSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public IntrepidSlashSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 15 + (point / 5);
	}

	@Override
	public int getLast(int point) {
		return 0;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new IntrepidSlashAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 198 + point * 3;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getEffect(point) + "% 물리데미지로 세번공격";
	}
	
}

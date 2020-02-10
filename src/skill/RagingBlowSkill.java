package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.IntrepidSlashAttack;
import playerAttack.PlayerAttack;
import playerAttack.RagingBlowAttack;

public class RagingBlowSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public RagingBlowSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 22 + ((point / 4) * 2);
	}

	@Override
	public int getLast(int point) {
		return 0;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new RagingBlowAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 148 + point * 4;
	}
	
	public int getEnrageEffect(int point) {
		return 17;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getEffect(point) + "% 물리데미지로 5번공격, 마지막 공격은 반드시 크리티컬 데미지(인레이지 발동시 각각"
				+ getEnrageEffect(point) + "% 추가데미지 마지막 2번 공격은 반드시 크리티컬 데미지)";
	}
	
}

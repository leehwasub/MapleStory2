package skill;

import attack.AttackType;
import attack.Property;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.PlayerAttack;
import playerAttack.ShoutAttack;

public class ShoutSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public ShoutSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property, int coolTime) {
		super(imageUrl, name, maxPoint, infor, attackType, property, coolTime);
	}

	@Override
	public int getNeedMp(int point) {
		return 8 + (point / 2);
	}

	@Override
	public int getLast(int point) {
		return 0;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new ShoutAttack(hunt, attacker, opponent, this);
	}
	
	public int needComboAttack() {
		return 1;
	}
	
	public int deBuffRate(int point) {
		return point * 2;
	}
	
	public int deBuffTurn(int point) {
		return 2 + (point / 15);
	}
	
	@Override
	public int getEffect(int point) {
		return 100 + point * 5;
	}
	
	public SkillValid isCanUseSkill(Adventurer adventurer) {
		if(!super.isCanUseSkill(adventurer).isCanUse()) {
			return super.isCanUseSkill(adventurer);
		}
		ComboAttackSkill comboAttackSkill = (ComboAttackSkill)adventurer.getSkillWithName("콤보어택");
		if(comboAttackSkill != null && comboAttackSkill.getPoint() >= 1 && comboAttackSkill.getComboNum() >= 1) {
			return new SkillValid(true, "사용가능");
		}
		return new SkillValid(false, "콤보어택 개수가 부족합니다");
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, 콤보어택 " + needComboAttack() + "개 사용, " + getEffect(point) + "% 물리데미지로 6번공격"
				+ "공격후 " + deBuffRate(point) + "% 확률로 " + deBuffTurn(point) + "턴간 적스턴";
	}
	
}

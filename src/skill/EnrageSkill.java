package skill;

import attack.AttackType;
import attack.Property;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.EnrageAttack;
import playerAttack.IntrepidSlashAttack;
import playerAttack.PlayerAttack;
import playerAttackImage.EnrageUseImage;

public class EnrageSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public EnrageSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 80 - point;
	}

	@Override
	public int getLast(int point) {
		return 8 + (point / 4);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new EnrageAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 10 + ((point+1) / 2);
	}
	
	public int getCriticalDamageEffect(int point) {
		return 10 + ((point+1) / 2);
	}

	public int needComboAttack() {
		return 1;
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
	public void afterCalStateEffect(Adventurer adventurer) {
		if(adventurer.isAlreadyBuffed("인레이지")) {
			adventurer.addCriticalExtraDamageRate(getCriticalDamageEffect(point));
			adventurer.getStrength().addCriticalRate(getEffect(point));
		}
	}
	
	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, 콤보어택 "+ needComboAttack() + "개 사용, "+ getLast(point) + "턴간 크리티컬 데미지 " + getCriticalDamageEffect(point) + "% 증가,"
				+ "크리티컬 확률 +" +getEffect(point)+ "% 증가";
	}
	
}

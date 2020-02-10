package skill;

import attack.AttackType;
import attack.Property;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.IncisingAttack;
import playerAttack.IntrepidSlashAttack;
import playerAttack.PlayerAttack;

public class IncisingSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public IncisingSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 30 + ((point / 8) * 2);
	}

	@Override
	public int getLast(int point) {
		return 0;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new IncisingAttack(hunt, attacker, opponent, this);
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
	public int getEffect(int point) {
		return 366 + point * 7;
	}
	
	public int getEnrageEffect(int point) {
		return 17;
	}
	
	public int getShoutEffect(int point) {
		return 100 + point * 2;
	}
	
	@Override
	public String requiredSkillInfor() {
		return "선행스킬 : 어드밴스드 콤보 마스터";
	}
	
	@Override
	public boolean isCanUpgrade(Adventurer adventurer) {
		PassiveSkill advancedCombo = (PassiveSkill)adventurer.getSkillWithName("어드밴스드콤보");
		if(advancedCombo == null || advancedCombo.getPoint() < 20) return false;
		return true;
	}
	
	public int needComboAttack() {
		return 1;
	}
	
	public int getDebuffRate(int point) {
		return 40 + point * 2;
	}
	
	public int getDebuffDamage(int point) {
		return 75 + point * 3;
	}
	
	public int getDebuffLast(int point) {
		return 3 + point / 6;
	}
	
	public int getDebuffCriticalEffect(int point) {
		return 11 + point / 2;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, 콤보어택 "+ needComboAttack() + "개 사용, " + getEffect(point) + "% 물리데미지로 4번공격 , 맞은적은"
				+ getDebuffRate(point) + "% 확률로 치명적인 상처를 입어 " + getDebuffLast(point) + "턴간 " + getDebuffLast(point) + "% 무속성 물리데미지, "
				+ "추가 크리티컬 데미지" + getDebuffCriticalEffect(point) + "% [패시브 효과 : 샤우트데미지 +"+ getShoutEffect(point) +"%]";
	}
	
}

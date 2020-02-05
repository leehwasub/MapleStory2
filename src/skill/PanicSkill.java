package skill;

import attack.AttackType;
import attack.Property;
import character.Adventurer;
import character.Monster;
import character.Strength;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.PanicAttack;
import playerAttack.PlayerAttack;

public class PanicSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;
	private int decrePhysicalDamage;
	private int decreMagicDamage;
	private int decreAccuracyRate;

	public PanicSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property, int coolTime) {
		super(imageUrl, name, maxPoint, infor, attackType, property, coolTime);
	}

	@Override
	public int getNeedMp(int point) {
		return 10 + (point / 2);
	}

	@Override
	public int getLast(int point) {
		return 5 + (point / 4);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new PanicAttack(hunt, attacker, opponent, this);
	}
	
	public int needComboAttack() {
		return 2;
	}
	
	public int deBuffLast(int point) {
		return 5 + (point / 4);
	}
	
	public int deBuffRate(int point) {
		return Math.min(100, 30 + point * 3);
	}
	
	public int deBuffEffect(int point) {
		return 11 + (point / 2);
	}

	@Override
	public int getEffect(int point) {
		return 1070 + point * 30;
	}
	
	
	public void setPhysicalDamageDecre(Monster monster) {
		double rate = ((double)deBuffEffect(point) / 100.0);
		int midPhysicalDamage = (monster.getOriMaxPhysicalDamage() + monster.getOriMinPhysicalDamage()) / 2;
		int decredMidPhysicalDamage = midPhysicalDamage - (int)(midPhysicalDamage * rate);
		decrePhysicalDamage =  midPhysicalDamage - decredMidPhysicalDamage;
	}
	
	public void setMagicDamageDecre(Monster monster) {
		double rate = ((double)deBuffEffect(point) / 100.0);
		int midMagicDamage = (monster.getOriMaxMagicDamage() + monster.getOriMinMagicDamage()) / 2;
		int decredMidMagicDamage = midMagicDamage - (int)(midMagicDamage * rate);
		decreMagicDamage = midMagicDamage - decredMidMagicDamage;
	}
	
	public void setAccuracyRateDecre(Monster monster) {
		Strength str = monster.getOriStrength();
		double rate = ((double)deBuffEffect(point) / 100.0);
		int decredAccuracyRate = str.getAccuracyRate()  - (int)(str.getAccuracyRate() * rate);
		decreAccuracyRate = str.getAccuracyRate() - decredAccuracyRate;
	}

	public SkillValid isCanUseSkill(Adventurer adventurer) {
		if(!super.isCanUseSkill(adventurer).isCanUse()) {
			return super.isCanUseSkill(adventurer);
		}
		ComboAttackSkill comboAttackSkill = (ComboAttackSkill)adventurer.getSkillWithName("콤보어택");
		if(comboAttackSkill != null && comboAttackSkill.getPoint() >= 1 && comboAttackSkill.getComboNum() >= 2) {
			return new SkillValid(true, "사용가능");
		}
		return new SkillValid(false, "콤보어택 개수가 부족합니다");
	}

	public int getDecrePhysicalDamage() {
		return decrePhysicalDamage;
	}

	public int getDecreMagicDamage() {
		return decreMagicDamage;
	}

	public int getDecreAccuracyRate() {
		return decreAccuracyRate;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, 콤보어택 " + needComboAttack() + "개 사용, " + getEffect(point) + "% 물리데미지로 한번공격"
				+ "후 " + deBuffRate(point) + "% 확률로 적에게 " + deBuffLast(point) + "턴간 데미지를 " + deBuffEffect(point) + "% 감소, 적중률을 " + deBuffEffect(point) + "% 감소시키는"
						+ "디버프를 건다.(쿨타임 " + coolTime + "턴)";
	}
	
}

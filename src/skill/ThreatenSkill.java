package skill;

import attack.AttackType;
import attack.Property;
import character.Monster;
import character.Strength;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.PlayerAttack;
import playerAttack.ThreatenAttack;

public class ThreatenSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;
	private int decrePhysicalDamage;
	private int decreMagicDamage;
	private int decreAccuracyRate;
	private int decrePhysicalDefense;
	private int decreMagicDefense;

	public ThreatenSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property, int coolTime) {
		super(imageUrl, name, maxPoint, infor, attackType, property, coolTime);
	}

	@Override
	public int getNeedMp(int point) {
		return 15 + (point / 6);
	}

	@Override
	public int getLast(int point) {
		return 4 + (point / 5);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new ThreatenAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 10 + point;
	}
	
	public int getRate(int point) {
		return 15 + (point * 3);
	}
	
	
	public void setPhysicalDamageDecre(Monster monster) {
		double rate = ((double)getEffect(point) / 100.0);
		int midPhysicalDamage = (monster.getOriMaxPhysicalDamage() + monster.getOriMinPhysicalDamage()) / 2;
		int decredMidPhysicalDamage = midPhysicalDamage - (int)(midPhysicalDamage * rate);
		decrePhysicalDamage =  midPhysicalDamage - decredMidPhysicalDamage;
	}
	
	public void setMagicDamageDecre(Monster monster) {
		double rate = ((double)getEffect(point) / 100.0);
		int midMagicDamage = (monster.getOriMaxMagicDamage() + monster.getOriMinMagicDamage()) / 2;
		int decredMidMagicDamage = midMagicDamage - (int)(midMagicDamage * rate);
		decreMagicDamage = midMagicDamage - decredMidMagicDamage;
	}
	
	public void setAccuracyRateDecre(Monster monster) {
		Strength str = monster.getOriStrength();
		double rate = ((double)getEffect(point) / 100.0);
		int decredAccuracyRate = str.getAccuracyRate()  - (int)(str.getAccuracyRate() * rate);
		decreAccuracyRate = str.getAccuracyRate() - decredAccuracyRate;
	}
	
	public void setPhysicalDefenseDecre(Monster monster) {
		Strength str = monster.getOriStrength();
		double rate = ((double)getEffect(point) / 100.0);
		int decredPhysicalDefense = str.getPhysicalDefense()  - (int)(str.getPhysicalDefense() * rate);
		decrePhysicalDefense = str.getPhysicalDefense() - decredPhysicalDefense;
	}
	
	public void setMagicDefenseDecre(Monster monster) {
		Strength str = monster.getStrength();
		double rate = ((double)getEffect(point) / 100.0);
		int decredMagicDefense = str.getMagicDefense()  - (int)(str.getMagicDefense() * rate);
		decreMagicDefense = str.getMagicDefense() - decredMagicDefense;
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

	public int getDecrePhysicalDefense() {
		return decrePhysicalDefense;
	}

	public int getDecreMagicDefense() {
		return decreMagicDefense;
	}


	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, "+getRate(point)+"% 확률로 적에게 "+ getLast(point) +"턴간 적중률, 물리마법 공격력, 물리마법 방어력을 "
				+ getEffect(point) + "% 감소시키는 디버프를 건다. (쿨타임 " +coolTime+"턴)";
	}
	
}

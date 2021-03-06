package skill;

import attack.AttackType;
import attack.Property;
import character.Adventurer;
import character.Strength;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.HyperBodyAttack;
import playerAttack.PlayerAttack;
import utils.WarriorStateUtils;

public class HyperBodySkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;
	private int creHp;
	private int creMp;

	public HyperBodySkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 20 + (point / 5);
	}

	@Override
	public int getLast(int point) {
		return 8 + (point / 2);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new HyperBodyAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return point * 6;
	}
	
	public void setHpIncre(Adventurer adventurer) {
		double rate = ((double)getEffect(point) / 100.0);
		this.creHp = (int)(WarriorStateUtils.getMaxHpByIndex(adventurer.getAdventurerLevel()) * rate);
	}
	
	public void setMpIncre(Adventurer adventurer) {
		double rate = ((double)getEffect(point) / 100.0);
		this.creMp = (int)(WarriorStateUtils.getMaxMpByIndex(adventurer.getAdventurerLevel()) * rate);
	}

	public int getCreHp() {
		return creHp;
	}

	public int getCreMp() {
		return creMp;
	}
	
	@Override
	public String requiredSkillInfor() {
		return "선행스킬 : 아이언월 3이상";
	}
	
	@Override
	public boolean isCanUpgrade(Adventurer adventurer) {
		ActiveSkill ironWillSkill = (ActiveSkill)adventurer.getSkillWithName("아이언월");
		if(ironWillSkill == null || ironWillSkill.getPoint() < 3) return false;
		return true;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getLast(point) + "턴간 HP, MP 최대량 " + getEffect(point) + "% 증가";
	}

}

package character;

import java.util.ArrayList;

import attack.Attack;
import attack.AttackFactory;
import attack.AttackType;
import component.StateBox;
import hunt.Hunt;
import maplestory.Player;
import monster.DropItemFactory;
import monsterAttack.MonsterAttack;
import utils.DialogUtils;

public abstract class Monster extends Character {
	
	private static final long serialVersionUID = 1L;
	
	protected ArrayList<MonsterSkillInfor> skillList = new ArrayList<MonsterSkillInfor>();
	protected int exp;
	protected int money;
	protected boolean isBoss;
	
	private Strength calStrength;
	private int calMinPhysicalDamage;
	private int calMaxPhysicalDamage;
	private int calMinMagicDamage;
	private int calMaxMagicDamage;


	public Monster(String name, String imageUrl, Strength strength, int minPhysicalDamage, int maxPhysicalDamage,
			int minMagicDamage, int maxMagicDamage, int exp, int money, boolean isBoss) {
		super(name, imageUrl, strength);
		this.minPhysicalDamage = minPhysicalDamage;
		this.maxPhysicalDamage = maxPhysicalDamage;
		this.minMagicDamage = minMagicDamage;
		this.maxMagicDamage = maxMagicDamage;
		this.exp = exp;
		this.money = money;
		this.isBoss = isBoss;
		
		try {
			this.calStrength = (Strength)strength.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		this.calMinPhysicalDamage = minPhysicalDamage;
		this.calMaxPhysicalDamage = maxPhysicalDamage;
		this.calMinMagicDamage = minMagicDamage;
		this.calMaxMagicDamage = maxMagicDamage;
	}
	
	@Override
	public void calState() {
		this.minPhysicalDamage = calMinPhysicalDamage;
		this.maxPhysicalDamage = calMaxPhysicalDamage;
		this.minMagicDamage = calMinMagicDamage;
		this.maxMagicDamage = calMaxMagicDamage;
		try {
			this.strength = (Strength)calStrength.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		strengthBuffEffect();
	}
	
	public abstract void initSkillList();

	public final MonsterAttack attack(Hunt hunt, StateBox attacker, StateBox opponent) {
		int percent = (int)(Math.random() * 1000);
		for(int i = 0; i < skillList.size(); i++) {
			MonsterSkillInfor infor = skillList.get(i);
			if(infor.getPercentSt() <= percent && percent < infor.getPercentEd() && curHp <= infor.getUnderHpCondition()) {
				MonsterAttack attack = AttackFactory.makeMonsterAttack(hunt, attacker, opponent, infor.getSkillName(), infor.getSkillPoint());
				//if the attack is the buff skill that is already buffed, monster will not use the skill.
				if(attack.getMonsterSkill().getAttackType() == AttackType.MYSELF && isAlreadyBuffed(attack.getMonsterSkill().getAttackName())) continue;
				if(attack.getMonsterSkill().getAttackType() == AttackType.OPPONENT && opponent.getCharacter().isAlreadyBuffed(attack.getMonsterSkill().getAttackName())) continue;
				if(attack.calNeedMp() <= curMp) {
					curMp = curMp - attack.calNeedMp();
					return attack;
				}
			}
		}
		DialogUtils.showErrorDialog("Monster.attack(...) " + name + " 몬스터 공격 선택 실패!");
		return null;
	}

	public String dropItem(Player player) {
		return DropItemFactory.dropItemWithLevel(this, player);
	}

	public int getExp() {
		return this.exp;
	}

	public int getMoney() {
		return this.money;
	}

	public boolean isBoss() {
		return this.isBoss;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setBoss(boolean isBoss) {
		this.isBoss = isBoss;
	}
}
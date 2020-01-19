package character;

import java.util.ArrayList;

import attack.AttackFactory;
import attack.AttackType;
import component.StateBox;
import hunt.HuntComponent.Hunt;
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
	
	private Strength oriStrength;
	private int oriMinPhysicalDamage;
	private int oriMaxPhysicalDamage;
	private int oriMinMagicDamage;
	private int oriMaxMagicDamage;

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
			this.oriStrength = (Strength)strength.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		this.oriMinPhysicalDamage = minPhysicalDamage;
		this.oriMaxPhysicalDamage = maxPhysicalDamage;
		this.oriMinMagicDamage = minMagicDamage;
		this.oriMaxMagicDamage = maxMagicDamage;
	}
	
	@Override
	public void calState() {
		this.minPhysicalDamage = oriMinPhysicalDamage;
		this.maxPhysicalDamage = oriMaxPhysicalDamage;
		this.minMagicDamage = oriMinMagicDamage;
		this.maxMagicDamage = oriMaxMagicDamage;
		try {
			this.strength = (Strength)oriStrength.clone();
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
					attacker.updateStateBox();
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

	public int getOriMinPhysicalDamage() {
		return oriMinPhysicalDamage;
	}

	public int getOriMaxPhysicalDamage() {
		return oriMaxPhysicalDamage;
	}

	public int getOriMinMagicDamage() {
		return oriMinMagicDamage;
	}

	public int getOriMaxMagicDamage() {
		return oriMaxMagicDamage;
	}

	public void setOriMinPhysicalDamage(int oriMinPhysicalDamage) {
		this.oriMinPhysicalDamage = oriMinPhysicalDamage;
	}

	public void setOriMaxPhysicalDamage(int oriMaxPhysicalDamage) {
		this.oriMaxPhysicalDamage = oriMaxPhysicalDamage;
	}

	public void setOriMinMagicDamage(int oriMinMagicDamage) {
		this.oriMinMagicDamage = oriMinMagicDamage;
	}

	public void setOriMaxMagicDamage(int oriMaxMagicDamage) {
		this.oriMaxMagicDamage = oriMaxMagicDamage;
	}

	public Strength getOriStrength() {
		return oriStrength;
	}

	public void setOriStrength(Strength oriStrength) {
		this.oriStrength = oriStrength;
	}
	
}
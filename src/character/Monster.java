package character;

import java.awt.Dialog;
import java.util.ArrayList;

import attack.Attack;
import attack.AttackFactory;
import component.StateBox;
import hunt.Hunt;
import maplestory.Player;
import monster.DropItemFactory;
import utils.DialogUtils;

public abstract class Monster extends Character {
	
	private static final long serialVersionUID = 1L;
	
	protected ArrayList<MonsterSkillInfor> skillList = new ArrayList<MonsterSkillInfor>();
	protected int exp;
	protected int money;
	protected boolean isBoss;

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
	}
	
	@Override
	public void calState() {
		
	}
	
	public abstract void initSkillList();

	public final Attack attack(Hunt hunt, StateBox attacker, StateBox opponent) {
		int percent = (int)(Math.random() * 1001);
		for(int i = 0; i < skillList.size(); i++) {
			MonsterSkillInfor infor = skillList.get(i);
			if(infor.getPercentSt() <= percent && percent <= infor.getPercentEd() && curHp <= infor.getUnderHpCondition()) {
				Attack attack = AttackFactory.makeMonsterAttack(hunt, attacker, opponent, infor.getSkillName(), infor.getSkillPoint());
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
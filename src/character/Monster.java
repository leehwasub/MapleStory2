package character;

import java.util.ArrayList;

import attack.AttackFactory;
import attack.AttackInfor;
import attack.AttackType;
import buff.AbnormalBuff;
import buff.Buff;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import hunt.HuntEvent;
import hunt.MonsterHuntEvent;
import maplestory.Player;
import monster.DropItemFactory;
import monsterAttack.MonsterAttack;
import skill.IncisingSkill;
import utils.CalUtils;
import utils.DialogUtils;
import utils.MusicUtils;

public abstract class Monster extends Character implements Comparable<Monster>{
	
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
	
	private HuntEvent huntEvent;

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
		
		this.huntEvent = new MonsterHuntEvent();
	}
	
	@Override
	public int hitEvent(Character character,  AttackInfor attackInfor) {
		if(isAlreadyBuffed("파워트랜스퍼")) {
			int skillPoint = getMonsterSkillInforWithName("파워트랜스퍼").getSkillPoint();
			int percent = 8 + skillPoint * 2;
			if(CalUtils.calPercent(percent)) {
				attackInfor.setPhysicalDamage(attackInfor.getPhysicalDamage() / 2);
				attackInfor.setMagicDamage(attackInfor.getMagicDamage() / 2);
				MusicUtils.startEffectSound("defence");
			}
		}
		if(isAlreadyBuffed("인사이징") && attackInfor.isCritical()) {
			IncisingSkill incisingSkill = (IncisingSkill)((Adventurer)attackInfor.getAttacker()).getSkillWithName("인사이징");
			double rate = incisingSkill.getDebuffCriticalEffect(incisingSkill.getPoint()) / 100.0;
			attackInfor.addPhysicalDamage((int)(attackInfor.getPhysicalDamage() * rate));
			attackInfor.addMagicDamage((int)(attackInfor.getMagicDamage() * rate));
		}
		return attackInfor.getTotalDamage();
	}
	
	@Override
	public boolean isCanBuffed(Buff buff) {
		if(isAlreadyBuffed("플레임배리어") && buff.getName().equals("화상")) {
			return false;
		}
		if(isAlreadyBuffed("에테리얼폼") && buff instanceof AbnormalBuff) {
			return false;
		}
		return true;
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
		System.out.println("버프 후 : " + this.toString());
	}
	
	public abstract void initSkillList();
	
	public MonsterSkillInfor getMonsterSkillInforWithName(String skillName) {
		for(int i = 0; i < skillList.size(); i++) {
			MonsterSkillInfor infor = skillList.get(i);
			if(infor.getSkillName().equals(skillName)) {
				return infor;
			}
		}
		DialogUtils.showErrorDialog("Monster.getMonsterSkillInforWithName("+skillName+")몬스터 스킬 가져오기 실패!");
		return null;
	}

	public final MonsterAttack attack(Hunt hunt, StateBox attacker, StateBox opponent) {
		int percent = (int)(Math.random() * 1000);
		for(int i = 0; i < skillList.size(); i++) {
			MonsterSkillInfor infor = skillList.get(i);
			if(infor.getPercentSt() <= percent && percent < infor.getPercentEd() && curHp <= infor.getUnderHpCondition()) {
				MonsterAttack attack = AttackFactory.makeMonsterAttack(hunt, attacker, opponent, infor.getSkillName(), infor.getSkillPoint());
				//if the attack is the buff skill that is already buffed, monster will not use the skill.
				if(attack.getMonsterSkill().getAttackType() == AttackType.MYSELF && isAlreadyBuffed(attack.getMonsterSkill().getAttackName())) continue;
				//if a monster is buffed the magic crash, monster couldn't use the buff skill.
				if(attack.getMonsterSkill().getAttackType() == AttackType.MYSELF && isAlreadyBuffed("매직크래쉬")) continue;
				if(attack.getMonsterSkill().getAttackType() == AttackType.OPPONENT && opponent.getCharacter().isAlreadyBuffed(attack.getMonsterSkill().getAttackName())) continue;
				if(infor.isNeedToExistBuff() && !opponent.getCharacter().isExistEffectBuff()) continue;
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

	public HuntEvent getHuntEvent() {
		return huntEvent;
	}

	public void setHuntEvent(HuntEvent huntEvent) {
		this.huntEvent = huntEvent;
	}
	
	public int getMonsterLevel() {
		return this.strength.getLevel();
	}
	
	@Override
	public int compareTo(Monster o) {
		return this.getMonsterLevel() - o.getMonsterLevel();
	}

	@Override
	public String toString() {
		return "Monster [skillList=" + skillList + ", exp=" + exp + ", money=" + money + ", isBoss=" + isBoss
				+ ", strength=" + strength + ", minPhysicalDamage=" + minPhysicalDamage
				+ ", maxPhysicalDamage=" + maxPhysicalDamage + ", minMagicDamage=" + minMagicDamage
				+ ", maxMagicDamage=" + maxMagicDamage + "]";
	}

	
	
}
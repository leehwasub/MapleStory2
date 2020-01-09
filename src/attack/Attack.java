package attack;

import java.awt.Graphics2D;
import java.util.ArrayList;

import attackImage.SkillImage;
import component.StateBox;
import hunt.Hunt;

public abstract class Attack extends Thread {
	protected Hunt hunt;
	protected StateBox attacker;
	protected StateBox opponent;
	protected String attackName;
	protected Property property;
	protected int skillPoint;
	protected AttackType attackType;
	protected int damage;
	protected int needMp;
	protected ArrayList<SkillImage> skillImageList = new ArrayList<SkillImage>();

	public Attack(Hunt hunt, StateBox attacker, StateBox opponent, String attackName, Property property, int skillPoint, 
			AttackType attackType) {
		this.hunt = hunt;
		this.attacker = attacker;
		this.opponent = opponent;
		this.attackName = attackName;
		this.property = property;
		this.skillPoint = skillPoint;
		this.attackType = attackType;
	}

	public void attackMoveDelay() {
		try {
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void afterAttackDelay() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void wakeUpThread() {
		synchronized (this.hunt) {
			this.hunt.notify();
		}
	}

	public void addSkillImage(SkillImage image) {
		skillImageList.add(image);
	}

	public void draw(Graphics2D g) {
		if (this.skillImageList != null) {
			for (int i = this.skillImageList.size() - 1; i >= 0; i--) {
				if (((SkillImage) this.skillImageList.get(i)).isDead()) {
					this.skillImageList.remove(i);
				} else {
					((SkillImage) this.skillImageList.get(i)).draw(g);
				}
			}
		}
	}

	public StateBox getAttacker() {
		return this.attacker;
	}

	public StateBox getOpponent() {
		return this.opponent;
	}


	public void setAttacker(StateBox attacker) {
		this.attacker = attacker;
	}

	public void setOpponent(StateBox opponent) {
		this.opponent = opponent;
	}

	public String getAttackName() {
		return this.attackName;
	}

	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}

	public int getDamage() {
		return this.damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public AttackType getAttackType() {
		return this.attackType;
	}

	public void setAttackType(AttackType attackType) {
		this.attackType = attackType;
	}

	public abstract void run();

	public abstract String attackInfor();

	public abstract int calNeedMp();
}

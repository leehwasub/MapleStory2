package attack;

import java.awt.Graphics2D;
import java.util.ArrayList;

import attackImage.PowerStrikeHitImage;
import attackImage.SkillImage;
import component.StateBox;
import hunt.Hunt;
import skill.Skill;

public abstract class Attack extends Thread {
	protected Hunt hunt;
	protected StateBox attacker;
	protected StateBox opponent;
	protected ArrayList<SkillImage> skillImageList = new ArrayList<SkillImage>();
	
	protected int damage;

	public Attack(Hunt hunt, StateBox attacker, StateBox opponent) {
		this.hunt = hunt;
		this.attacker = attacker;
		this.opponent = opponent;
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
	
	public void sleep(int sleep) {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void addSkillImageThread(SkillImage skillImage) {
		Thread thread = new Thread(()-> {
			addSkillImage(skillImage);
			skillImage.start();
		});
		thread.start();
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

	public abstract void run();
	public abstract String attackInfor();
}

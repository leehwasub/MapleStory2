package attack;

import java.awt.Graphics2D;
import java.util.ArrayList;

import attackImage.SkillImage;
import attackImage.SkillImage.HitListener;
import component.StateBox;
import hunt.HuntComponent.Hunt;

public abstract class Attack extends Thread {
	protected Hunt hunt;
	protected StateBox attacker;
	protected StateBox opponent;
	protected ArrayList<SkillImage> skillImageList = new ArrayList<SkillImage>();
	
	protected int damage;
	
	protected int skillDelay;

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
			Thread.sleep(500L);
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
	

	/**
	 * 총알같이 동시다발적으로 여러개의 이미지가 일정한 간격을 두고 실행 되고 hit이미지나 시전 이미지 또한 선택적으로 등록할 수 있는 메소드
	 * @param readyImage
	 * @param skillImage
	 * @param hitImage
	 * @param midDelay
	 */
	public void addMutlipleMovableSkillImageThread(SkillImage readyImage, ArrayList<SkillImage> skillImage, ArrayList<SkillImage> hitImage, int midDelay, boolean isNowDelay) {
		int delay = skillImage.get(0).getTotalDelay();
		if(readyImage != null) {
			addNoDelaySkillImageThread(readyImage);
		}
		for(int i = 0; i < skillImage.size(); i++) {
			final int index = i;
			Thread thread = new Thread(()-> {
				skillImage.get(index).start();
				addSkillImage(skillImage.get(index));
				if(hitImage != null) {
					skillImage.get(index).setHitListener(new HitListener() {
						@Override
						public void hit() {
							addHitImageThread(hitImage.get(index));
						}
					});
				}
			});
			thread.start();
			sleep(midDelay);
		}
		if(isNowDelay) {
			sleep(delay);
		} else {
			this.skillDelay += delay;
		}
	}
	
	public void addNoDelaySkillImageThread(SkillImage skillImage) {
		Thread thread = new Thread(()-> {
			skillImage.start();
			addSkillImage(skillImage);
		});
		thread.start();
	}
	
	public void addSkillImageThread(SkillImage skillImage, boolean isNowDelay, int delay) {
		Thread thread = new Thread(()-> {
			skillImage.start();
			addSkillImage(skillImage);
		});
		thread.start();
		if(isNowDelay) {
			sleep(delay);
		} else {
			this.skillDelay += delay;
		}
	}
	
	public void addSkillImageThread(SkillImage skillImage, SkillImage hitImage, boolean isNowDelay, int delay) {
		Thread thread = new Thread(()-> {
			skillImage.start();
			addSkillImage(skillImage);
			skillImage.setHitListener(new HitListener() {
				@Override
				public void hit() {
					addHitImageThread(hitImage);
				}
			});
		});
		thread.start();
		if(isNowDelay) {
			sleep(delay);
		} else {
			this.skillDelay += delay;
		}
	}
	
	public void addSkillImageThread(SkillImage skillImage, boolean isNowDelay) {
		int delay = skillImage.getTotalDelay();
		Thread thread = new Thread(()-> {
			skillImage.start();
			addSkillImage(skillImage);
		});
		thread.start();
		if(isNowDelay) {
			sleep(delay);
		} else {
			this.skillDelay += delay;
		}
	}
	
	public void addSkillImageThread(SkillImage skillImage, SkillImage hitImage, boolean isNowDelay) {
		int delay = skillImage.getTotalDelay();
		Thread thread = new Thread(()-> {
			skillImage.start();
			addSkillImage(skillImage);
			skillImage.setHitListener(new HitListener() {
				@Override
				public void hit() {
					addHitImageThread(hitImage);
				}
			});
		});
		thread.start();
		if(isNowDelay) {
			sleep(delay);
		} else {
			this.skillDelay += delay;
		}
	}
	
	public void addHitImageThread(SkillImage hitImage) {
		Thread thread = new Thread(()-> {
			hitImage.start();
			addSkillImage(hitImage);
		});
		thread.start();
	}
	
	protected void afterAttack() {
		sleep(skillDelay + 250);
		this.attacker.attackBackMotion();
		afterAttackDelay();
		wakeUpThread();
	}

	public void addSkillImage(SkillImage image) {
		skillImageList.add(image);
	}

	public void draw(Graphics2D g) {
		if (this.skillImageList != null) {
			for (int i = this.skillImageList.size() - 1; i >= 0; i--) {
				if (skillImageList.get(i) != null && !skillImageList.get(i).isAlive()) {
					if(skillImageList.get(i).getTotalDamage() != 0) {
						this.damage += skillImageList.get(i).getTotalDamage();
					}
					this.skillImageList.remove(i);
				} else if(skillImageList.get(i) != null) {
					skillImageList.get(i).draw(g);
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
	protected abstract ArrayList<AttackInfor> makeAttackInfor();
	
}

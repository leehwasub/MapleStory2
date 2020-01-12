package attackImage;

import component.StateBox;
import hunt.Hunt;
import map.Point;
import utils.MusicUtils;

public class FlashAttackMovingImage extends MovableSkillImage {
	public FlashAttackMovingImage(Hunt hunt, StateBox attacker, StateBox opponent) {
		super("monsterSkillImage/flash", hunt, attacker, opponent, 120, 3000);
	}

	public void run() {
		moveObject();
		MusicUtils.startEffectSound("flashSkill");
		this.opponent.updateStateBox();
		while(nowTime < takeTime - 1) {
			for (int i = 0; i < this.imageList.size(); i++) {
				this.index = i;
				System.out.println(this.index);
				try {
					Thread.sleep(this.delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		this.isDead = true;
	}
	
}
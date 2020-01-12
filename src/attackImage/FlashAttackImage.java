package attackImage;

import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class FlashAttackImage extends SkillImage {
	public FlashAttackImage(Hunt hunt, StateBox attacker, StateBox opponent) {
		super("monsterSkillImage/flash", hunt, attacker, opponent, 120);
	}

	public void run() {
		MusicUtils.startEffectSound("flashSkill");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.isDead = true;
	}
}
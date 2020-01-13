package attackImage;

import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class SwordUseImage extends SkillImage {
	public SwordUseImage(Hunt hunt, StateBox attacker, StateBox opponent) {
		super("monsterSkillImage/swordUse", hunt, attacker, opponent, 120);
	}

	public void run() {
		attacker.updateStateBox();
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
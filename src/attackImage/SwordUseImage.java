package attackImage;

import attack.AttackInfor;
import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class SwordUseImage extends SkillImage {
	public SwordUseImage(Hunt hunt, StateBox attacker, StateBox opponent, AttackInfor attackInfor) {
		super("monsterSkillImage/swordUse", hunt, attacker, opponent, attackInfor, 120);
	}

	public void run() {
		MusicUtils.startEffectSound("attack");
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
	}
}
package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.Hit;
import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class FlashAttackImage extends SkillImage {
	public FlashAttackImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/flash", hunt, attacker, opponent, attackInfor, 120);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("flashSkill");
		hit();
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
package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class BrandishHitAttackImage extends SkillImage {
	public BrandishHitAttackImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/brandishHit", hunt, attacker, opponent, attackInfor, 120, 0);
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
	}
}
package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class BlizzardChargeUseAttackImage extends SkillImage {
	public BlizzardChargeUseAttackImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/blizzardChargeUse", hunt, attacker, opponent, attackInfor, 90);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("blizzardChargeUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			if(i == 3 || i == 4 || i == 5) {
				hit();
			}
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
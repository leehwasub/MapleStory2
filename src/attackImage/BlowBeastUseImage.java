package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class BlowBeastUseImage extends SkillImage {
	public BlowBeastUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/blowBeastUse", hunt, attacker, opponent, attackInfor, 120, 0, -120);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("blowBeastUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			if(i == 0) {
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
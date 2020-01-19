package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class EvilEyeShockUseImage extends SkillImage {
	public EvilEyeShockUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/evilEyeShockUse", hunt, attacker, opponent, attackInfor, 120, 0, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("evilEyeShockUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 6 || i == 7) {
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
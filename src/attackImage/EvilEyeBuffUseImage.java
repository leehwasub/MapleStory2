package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class EvilEyeBuffUseImage extends SkillImage {
	public EvilEyeBuffUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/evilEyeBuffUse", hunt, attacker, opponent, attackInfor, -50, -50);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("evilEyeBuffUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
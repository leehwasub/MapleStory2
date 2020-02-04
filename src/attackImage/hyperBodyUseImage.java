package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class hyperBodyUseImage extends SkillImage {
	public hyperBodyUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/hyperBodyUse", hunt, attacker, opponent, attackInfor, 0, -30);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("hyperBodyUse");
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
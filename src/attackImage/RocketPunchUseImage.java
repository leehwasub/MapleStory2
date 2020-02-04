package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class RocketPunchUseImage extends SkillImage {
	public RocketPunchUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/rocketPunchUse", hunt, attacker, opponent, attackInfor, -30, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("rocketPunchUse");
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
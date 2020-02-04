package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class PiercingDriveUseImage extends SkillImage {
	public PiercingDriveUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/piercingDriveUse", hunt, attacker, opponent, attackInfor, 200, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("piercingDriveUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 1 || i == 2) {
				hit();
			}
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
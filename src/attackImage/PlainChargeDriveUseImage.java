package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class PlainChargeDriveUseImage extends SkillImage {
	public PlainChargeDriveUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/plainChargeDriveUse", hunt, attacker, opponent, attackInfor, -100, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("plainChargeDriveUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 1) hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
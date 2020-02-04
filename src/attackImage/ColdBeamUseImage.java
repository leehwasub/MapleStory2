package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class ColdBeamUseImage extends SkillImage {
	public ColdBeamUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/coldBeamUse", hunt, attacker, opponent, attackInfor, 0, -50);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("coldBeamUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 5 || i == 6 || i == 7) hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
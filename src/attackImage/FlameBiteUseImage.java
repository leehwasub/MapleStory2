package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class FlameBiteUseImage extends SkillImage {
	public FlameBiteUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/flameBiteUse", hunt, attacker, opponent, attackInfor, -240, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("flameBiteUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 4 || i == 5 || i == 6) hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
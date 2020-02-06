package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class BlazingExtinctionUseImage extends SkillImage {
	public BlazingExtinctionUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/blazingExtinctionUse", hunt, attacker, opponent, attackInfor, 20, -20);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("blazingExtinctionUse");
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
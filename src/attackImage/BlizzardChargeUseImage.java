package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class BlizzardChargeUseImage extends SkillImage {
	public BlizzardChargeUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/blizzardChargeUse", hunt, attacker, opponent, attackInfor, 200, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("blizzardChargeUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 3 || i == 4 || i == 5) {
				hit();
			}
			if(opponent.getCharacter().isAlreadyBuffed("화상") && i == 6) {
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
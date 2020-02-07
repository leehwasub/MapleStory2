package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class BlizzardUseImage extends SkillImage {
	public BlizzardUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor, int modifyX, int modifyY) {
		super("monsterSkillImage/BlizzardUse", hunt, attacker, opponent, attackInfor, modifyX, modifyY);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("BlizzardUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 15) hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
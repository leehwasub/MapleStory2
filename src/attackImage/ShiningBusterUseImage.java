package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class ShiningBusterUseImage extends SkillImage {
	public ShiningBusterUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/shiningBusterUse", hunt, attacker, opponent, attackInfor, 90, -160, -10);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("shiningBusterUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 3 || i == 4 || i == 5)hit();
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
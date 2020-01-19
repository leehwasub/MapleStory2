package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class LaManchaSpearUse3Image extends SkillImage {
	public LaManchaSpearUse3Image(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/laManchaSpearUse3", hunt, attacker, opponent, attackInfor, 90, 200, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("laManchaSpearUse3");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 4) hit();
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
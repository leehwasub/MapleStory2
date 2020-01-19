package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class LaManchaSpearUse1Image extends SkillImage {
	public LaManchaSpearUse1Image(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/laManchaSpearUse1", hunt, attacker, opponent, attackInfor, 60, 200, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("laManchaSpearUse1");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
package playerAttackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.SkillImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class IncisingUseImage extends SkillImage {
	public IncisingUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/incisingUse", hunt, attacker, opponent, attackInfor, 100, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("incisingUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 6 || i == 7 || i == 8 || i == 9) {
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
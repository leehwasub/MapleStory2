package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class WindCircleUseImage extends SkillImage {
	public WindCircleUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/windCircleUse", hunt, attacker, opponent, attackInfor, -200, 0);
	}

	public void run() {
		MusicUtils.startEffectSound("windCircleUse");
		attacker.updateStateBox();
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 5 || i == 6 || i == 7 || i == 8) hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class MassiveSplashUseImage extends SkillImage {
	public MassiveSplashUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/massiveSplashUse", hunt, attacker, opponent, attackInfor, -250, 0);
	}

	public void run() {
		MusicUtils.startEffectSound("massiveSplashUse");
		attacker.updateStateBox();
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 2 || i == 3 || i == 4 || i == 5) hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
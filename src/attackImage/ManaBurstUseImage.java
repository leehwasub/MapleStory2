package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class ManaBurstUseImage extends SkillImage {
	public ManaBurstUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/manaBurstUse", hunt, attacker, opponent, attackInfor, -200, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("manaBurstUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 6 || i == 7 || i == 8) hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
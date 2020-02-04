package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class DevilScytheUseImage extends SkillImage {
	public DevilScytheUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/devilScytheUse", hunt, attacker, opponent, attackInfor, 100, -30);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("devilScytheUse");
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
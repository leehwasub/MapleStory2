package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class PoisonMistUseImage extends SkillImage {
	public PoisonMistUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/poisonMistUse", hunt, attacker, opponent, attackInfor, 90, -225, -50);
	}

	public void run() {
		MusicUtils.startEffectSound("poisonMistUse");
		attacker.updateStateBox();
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 10 || i == 11) hit();
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
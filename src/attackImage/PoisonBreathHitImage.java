package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class PoisonBreathHitImage extends SkillImage {
	public PoisonBreathHitImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/poisonBreathHit", hunt, attacker, opponent, attackInfor, 0, 0);
	}

	public void run() {
		MusicUtils.startEffectSound("poisonBreathHit");
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
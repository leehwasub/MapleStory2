package playerAttackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.SkillImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class RevengeOfTheEvilEyeHitImage extends SkillImage {
	public RevengeOfTheEvilEyeHitImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/revengeOfTheEvilEyeHit", hunt, attacker, opponent, attackInfor, 0, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("revengeOfTheEvilEyeHit");
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
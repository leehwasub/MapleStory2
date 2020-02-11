package playerAttackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.SkillImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class RevengeOfTheEvilEyeUseImage extends SkillImage {
	
	public RevengeOfTheEvilEyeUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/revengeOfTheEvilEyeUse", hunt, attacker, opponent, attackInfor, 50, -50);
	}

	public void run() {
		attacker.updateStateBox();
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 6) {
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
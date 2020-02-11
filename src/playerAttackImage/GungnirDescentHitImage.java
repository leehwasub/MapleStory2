package playerAttackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.SkillImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class GungnirDescentHitImage extends SkillImage {
	public GungnirDescentHitImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/gungnirDescentHit", hunt, attacker, opponent, attackInfor, 0, -150);
	}

	public void run() {
		attacker.updateStateBox();
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 5) MusicUtils.startEffectSound("gungnirDescentHit");
			if(i >= 5 && i <= 10)hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
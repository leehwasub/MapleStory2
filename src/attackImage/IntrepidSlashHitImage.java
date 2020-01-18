package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class IntrepidSlashHitImage extends SkillImage {
	public IntrepidSlashHitImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/intrepidSlashHit", hunt, attacker, opponent, attackInfor, 90, 0, 0);
	}

	public void run() {
		attacker.updateStateBox();
		//MusicUtils.startEffectSound("intrepidSlashHit");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class IntrepidSlashUseImage extends SkillImage {
	public IntrepidSlashUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/intrepidSlashUse", hunt, attacker, opponent, attackInfor, 100, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("intrepidSlashUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 4 || i == 7 || i == 9) {
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
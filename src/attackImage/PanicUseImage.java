package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class PanicUseImage extends SkillImage {
	public PanicUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/panicUse", hunt, attacker, opponent, attackInfor, 120, 100, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("panicUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			if(i == 2) {
				hit();
			}
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
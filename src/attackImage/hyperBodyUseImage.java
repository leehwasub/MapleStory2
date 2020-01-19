package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class hyperBodyUseImage extends SkillImage {
	public hyperBodyUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/hyperBodyUse", hunt, attacker, opponent, attackInfor, 90, 0, -30);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("hyperBodyUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
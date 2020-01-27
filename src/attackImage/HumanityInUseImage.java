package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class HumanityInUseImage extends SkillImage {
	public HumanityInUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/humanityInUse", hunt, attacker, opponent, attackInfor, 90, -50, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("humanityInUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			if(i == 4 || i == 5) hit();
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
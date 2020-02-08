package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class ArmageddonUse2Image extends SkillImage {
	public ArmageddonUse2Image(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/armageddonUse2", hunt, attacker, opponent, attackInfor, 0, 0);
	}

	public void run() {
		attacker.updateStateBox();
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 29 || i == 30 || i == 31) hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
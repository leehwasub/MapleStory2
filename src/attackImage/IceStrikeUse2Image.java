package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class IceStrikeUse2Image extends SkillImage {
	public IceStrikeUse2Image(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/iceStrikeUse2", hunt, attacker, opponent, attackInfor, 0, -70);
	}

	public void run() {
		attacker.updateStateBox();
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 5 || i == 6 || i == 7 || i == 8)hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class BatSweamMovableImage extends MovableSkillImage {

	boolean isHit[] = new boolean[2];

	public BatSweamMovableImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/batSweamBall", hunt, attacker, opponent, attackInfor, 300);
	}

	public void run() {
		moveObject();
		while (nowTime < takeTime - 1) {
			for (int i = 0; i < this.imageList.size() && nowTime < takeTime - 1; i++) {
				this.index = i;
				for(int j = 0; j < 2; j++) {
					if (!isHit[j] && nowTime >= 120 + 120 * j) {
						isHit[j] = true;
						hit();
					}
				}
				try {
					Thread.sleep(delayList.get(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		hit();
		hit();
	}

}
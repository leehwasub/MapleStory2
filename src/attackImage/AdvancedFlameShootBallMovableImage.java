package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;

public class AdvancedFlameShootBallMovableImage extends MovableSkillImage {
	public AdvancedFlameShootBallMovableImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/advancedFlameShootBall", hunt, attacker, opponent, attackInfor, 700);
	}

	public void run() {
		moveObject();
		while(nowTime < takeTime - 1) {
			for (int i = 0; i < this.imageList.size() && nowTime < takeTime - 1; i++) {
				this.index = i;
				try {
					Thread.sleep(delayList.get(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		hit();
	}
	
}
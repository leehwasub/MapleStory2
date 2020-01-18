package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.Hunt;

public class FlashBallMovableImage extends MovableSkillImage {
	public FlashBallMovableImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/flashBall", hunt, attacker, opponent, attackInfor, 120, 500);
	}

	public void run() {
		moveObject();
		while(nowTime < takeTime - 1) {
			for (int i = 0; i < this.imageList.size() && nowTime < takeTime - 1; i++) {
				this.index = i;
				System.out.println(this.index);
				try {
					Thread.sleep(this.delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		hit();
	}
	
}
package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;

public class PoisonBreathBallMovableImage extends MovableSkillImage {
	public PoisonBreathBallMovableImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/poisonBreathBall", hunt, attacker, opponent, attackInfor, 500);
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
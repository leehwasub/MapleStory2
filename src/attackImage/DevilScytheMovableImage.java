package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class DevilScytheMovableImage extends MovableSkillImage {
	
	boolean isHit[] = new boolean[2];
	
	public DevilScytheMovableImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/devilScytheBall", hunt, attacker, opponent, attackInfor, 500);
	}

	public void run() {
		moveObject();
		while(nowTime < takeTime - 1) {
			for (int i = 0; i < this.imageList.size() && nowTime < takeTime - 1; i++) {
				this.index = i;
				if(!isHit[0] && nowTime >= 300) {
					isHit[0] = true;
					hit();
				} else if(!isHit[1] && nowTime >= 420) {
					isHit[1] = true;
					hit();
				}
				if(i % 3 == 0) {
					MusicUtils.startEffectSound("devilScytheBall");
				}
				try {
					Thread.sleep(delayList.get(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
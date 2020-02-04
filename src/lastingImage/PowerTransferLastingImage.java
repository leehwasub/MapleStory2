package lastingImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class PowerTransferLastingImage extends LastingSkillImage{

	public PowerTransferLastingImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/powerTransferLasting", hunt, attacker, opponent, attackInfor);
	}
	
	public void run() {
		setChangedPoint();
		while(isCanLast) {
			for (int i = 0; i < this.imageList.size() && isCanLast; i++) {
				this.index = i;
				point.setXY(attacker.getX(), attacker.getY());
				try {
					Thread.sleep(delayList.get(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public boolean isCanLast() {
		isCanLast = attacker.getCharacter().isAlreadyBuffed("파워트랜스퍼");
		return isCanLast;
	}

}

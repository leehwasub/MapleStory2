package lastingImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class FlameBarrierLastingImage extends LastingSkillImage{

	public FlameBarrierLastingImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/flameBarrierLasting", hunt, attacker, opponent, attackInfor);
	}
	
	public void run() {
		setChangedPoint();
		while(isCanLast) {
			MusicUtils.startEffectSound("flameBarrierLasting");
			for (int i = 0; i < this.imageList.size() && isCanLast; i++) {
				this.index = i;
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
		isCanLast = attacker.getCharacter().isAlreadyBuffed("플레임배리어");
		return isCanLast;
	}

}

package lastingImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class DivineShieldLastingImage extends LastingSkillImage{

	public DivineShieldLastingImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/divineShieldLasting", hunt, attacker, opponent, attackInfor, 0, 30);
	}
	
	public void run() {
		setChangedPoint();
		while(isCanLast) {
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
		isCanLast = attacker.getCharacter().isAlreadyBuffed("블레싱아머");
		return isCanLast;
	}

}

package lastingImage;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.SkillImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;

public abstract class LastingSkillImage extends SkillImage{
	
	protected boolean isCanLast;
	
	public LastingSkillImage(String root, Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super(root, hunt, attacker, opponent, attackInfor, 0, 0);
		this.isCanLast = true;
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
	
	public void setChangedPoint() {
		Thread thread = new Thread(){
			public void run() {
				while(isCanLast) {
					point.setXY(attacker.getX(), attacker.getY());
				}
			}
		};
		thread.start();
	}
	
	public abstract boolean isCanLast();

}

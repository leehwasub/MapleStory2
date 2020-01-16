package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import character.Monster;
import component.StateBox;
import hunt.Hunt;
import map.Point;

public class MovableSkillImage extends SkillImage{

	protected Point targetPoint;
	protected ArrayList<Point> movingPoint = new ArrayList<Point>();
	protected int takeTime;
	protected int nowTime;
	
	public MovableSkillImage(String root, Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor, int delay, int takeTime) {
		super(root, hunt, attacker, opponent, attackInfor, delay, 0);
		this.opponent = opponent;
		this.takeTime = takeTime;
		this.totalDelay = takeTime;
		this.targetPoint = opponent.getPoint();
		if(opponent.getCharacter() instanceof Monster) {
			targetPoint.setX(targetPoint.getX() + 65 - imageList.get(0).getWidth(null)/2);
			targetPoint.setY(targetPoint.getY() + 65 - imageList.get(0).getHeight(null)/2);
		} else {
			targetPoint.setX(targetPoint.getX() + 300 - imageList.get(0).getWidth(null)/2);
			targetPoint.setY(targetPoint.getY() + 65 - imageList.get(0).getHeight(null)/2);
		}
		double intervalX = ((double)targetPoint.getX() - (double)point.getX()) / (double)takeTime;
		double intervalY = ((double)targetPoint.getY() - (double)point.getY()) / (double)takeTime;
		for(int i = 0; i < takeTime; i++) {
			movingPoint.add(new Point((int)(point.getX() + (i*intervalX)), (int)(point.getY() + (i*intervalY))));
		}
	}
	
	public void run() {
		while(nowTime < takeTime) {
			for (int i = 0; i < this.imageList.size(); i++) {
				this.index = i;
				System.out.println(this.index);
				try {
					sleep(this.delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void moveObject() {
		Thread thread = new Thread() {
			public void run() {
				while(nowTime < takeTime - 1) {
					point.setX(movingPoint.get(nowTime).getX());
					point.setY(movingPoint.get(nowTime).getY());
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					nowTime++;
				}
			}
		};
		thread.start();
	}

	public Point getTargetPoint() {
		return targetPoint;
	}

	public ArrayList<Point> getMovingPoint() {
		return movingPoint;
	}

	public void setTargetPoint(Point targetPoint) {
		this.targetPoint = targetPoint;
	}

	public void setMovingPoint(ArrayList<Point> movingPoint) {
		this.movingPoint = movingPoint;
	}

	public int getTakeTime() {
		return takeTime;
	}

	public int getNowTime() {
		return nowTime;
	}

	public void setTakeTime(int takeTime) {
		this.takeTime = takeTime;
	}

	public void setNowTime(int nowTime) {
		this.nowTime = nowTime;
	}


}

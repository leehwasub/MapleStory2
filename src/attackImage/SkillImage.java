package attackImage;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

import component.StateBox;
import hunt.Hunt;
import hunt.ImageFileFrame;
import map.Point;
import utils.FileLoader;
import utils.ResourceLoader;

public abstract class SkillImage extends Thread {
	protected ArrayList<Image> imageList = new ArrayList<Image>();
	protected int index;
	protected int delay;
	protected Point point;
	protected Hunt hunt;
	protected StateBox attacker;
	protected StateBox opponent;
	protected boolean isDead;

	public SkillImage(String root, Hunt hunt, StateBox attacker, StateBox opponent, int delay) {
		this.delay = delay;
		this.attacker = attacker;
		this.opponent = opponent;
		this.hunt = hunt;
		this.point = attacker.getPoint();
		try {
			new FileLoader();
			ArrayList<String> fileNameList = FileLoader.getFileList(root);
			ArrayList<ImageFileFrame> frameList = new ArrayList<ImageFileFrame>();
			for (int i = 0; i < fileNameList.size(); i++) {
				String strFrame = ((String) fileNameList.get(i)).substring(0,
						((String) fileNameList.get(i)).indexOf("."));
				String format = ((String) fileNameList.get(i))
						.substring(((String) fileNameList.get(i)).indexOf(".") + 1);
				frameList.add(new ImageFileFrame(Integer.parseInt(strFrame), format));
			}
			Collections.sort(frameList);
			for (int i = 0; i < frameList.size(); i++) {
				String strFrame = String.valueOf(((ImageFileFrame) frameList.get(i)).getFrame());
				String format = ((ImageFileFrame) frameList.get(i)).getExtension();
				this.imageList.add(new ImageIcon(ResourceLoader.getImage(root, strFrame + "." + format)).getImage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		point.setX(point.getX()+65 - imageList.get(0).getWidth(null)/2);
		point.setY(point.getY()+65 - imageList.get(0).getHeight(null)/2);
		this.isDead = false;
	}

	public void run() {
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			try {
				sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.isDead = true;
	}

	public Image getImage() {
		return (Image) this.imageList.get(this.index);
	}

	public ArrayList<Image> getImageList() {
		return this.imageList;
	}

	public void setImageList(ArrayList<Image> imageList) {
		this.imageList = imageList;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Point getPoint() {
		return this.point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public boolean isDead() {
		return this.isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public StateBox getOpponent() {
		return opponent;
	}

	public void setOpponent(StateBox opponent) {
		this.opponent = opponent;
	}

	public void draw(Graphics2D g) {
		if ((this.imageList != null) && (this.index < this.imageList.size()) && (!this.isDead)) {
			g.drawImage((Image) this.imageList.get(this.index), this.point.getX(), this.point.getY(), null);
		}
	}
}

package item;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import map.Point;
import maplestory.MainMapleInterface;
import maplestory.Player;
import utils.ColorUtils;
import utils.FontUtils;
import utils.MusicUtils;

public class AbnormalRecoveryItem extends ConsumableItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<String> abormalRecoveryList = new ArrayList<String>();

	public AbnormalRecoveryItem(String name, int cost, String imageUrl, int num, int level, String... abormalRecoveryList) {
		super(name, cost, imageUrl, num, level);
		for(int i = 0; i < abormalRecoveryList.length; i++) {
			this.abormalRecoveryList.add(abormalRecoveryList[i]);
		}
	}
	
	public AbnormalRecoveryItem(String name, int cost, String imageUrl, int num, int level, ArrayList<String> abormalRecoveryList) {
		super(name, cost, imageUrl, num, level);
		for(int i = 0; i < abormalRecoveryList.size(); i++) {
			this.abormalRecoveryList.add(abormalRecoveryList.get(i));
		}
	}

	public void use(Player player, MainMapleInterface mainMapleInterface) {
		if (getNum() >= 1) {
			MusicUtils.startEffectSound("portionUse");
			setNum(getNum() - 1);
			for(int i = 0; i < abormalRecoveryList.size(); i++) {
				if(abormalRecoveryList.get(i).equals("전체")) {
					player.getMainAdventurer().removeAllAbnormalBuff();
					break;
				} else {
					player.getMainAdventurer().removeBuff(abormalRecoveryList.get(i));
				}
			}
			player.removeEmptyItem();
			mainMapleInterface.mainStateBarUpdate();
		}
	}
	
	public ArrayList<String> getInfor() {
		ArrayList<String> ret = new ArrayList<String>();
		for(int i = 0; i < abormalRecoveryList.size(); i++) {
			String st = abormalRecoveryList.get(i);
			switch(st) {
			case "전체":
				ret.add("모든 상태이상 회복");
				break;
			case "화상":
				ret.add("화상 상태이상 회복");
				break;
			case "동상":
				ret.add("동상 상태이상 회복");
				break;
			case "중독":
				ret.add("중독 상태이상 회복");
				break;
			case "감전":
				ret.add("감전 상태이상 회복");
				break;
			}
		}
		return ret;
	}
	
	@Override
	public void drawInfor(Graphics2D g, Point p) {
		g.setColor(Color.BLACK);
		g.fillRect(p.getX(), p.getY(), 200, 160 + getInfor().size() * 20);
		g.setFont(FontUtils.SMALL_FONT);
		this.fm = g.getFontMetrics(FontUtils.SMALL_FONT);
		g.setColor(Color.WHITE);
		int width = this.fm.stringWidth(getName());
		g.drawString(this.name, p.getX() + (200 - width) / 2, p.getY() + 25);
		g.drawImage(this.image, p.getX() + 20, p.getY() + 45, null);
		g.setColor(Color.YELLOW);
		g.drawString("분류", p.getX() + 80, p.getY() + 57);
		g.drawString("래벨", p.getX() + 80, p.getY() + 82);
		g.setColor(Color.WHITE);
		g.drawString("소모품", p.getX() + 120, p.getY() + 57);
		g.drawString(this.level+"", p.getX() + 120, p.getY() + 82);
		ArrayList<String> arr = getInfor();
		for (int i = 0; i < arr.size(); i++) {
			int width2 = this.fm.stringWidth((String) arr.get(i));
			g.drawString((String) arr.get(i), p.getX() + (200 - width2) / 2, p.getY() + 120 + i * 20);
		}
		g.setColor(ColorUtils.SEA);
		g.setFont(FontUtils.SMALL_FONT);
		g.drawString(this.cost + " 메소", p.getX() + 20, p.getY() + 160 + (getInfor().size()-1) * 20);
	}

	public ArrayList<String> getAbormalRecoveryList() {
		return abormalRecoveryList;
	}

	public void setAbormalRecoveryList(ArrayList<String> abormalRecoveryList) {
		this.abormalRecoveryList = abormalRecoveryList;
	}

	@Override
	public boolean isNeedQuickReigster() {
		return true;
	}

	@Override
	public boolean isSellable() {
		return true;
	}

}

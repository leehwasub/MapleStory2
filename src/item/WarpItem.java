package item;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.io.Serializable;

import javax.swing.JOptionPane;

import character.Character;
import map.Point;
import maplestory.MainMapleInterface;
import maplestory.MapleInterface;
import maplestory.Player;
import utils.ColorUtils;
import utils.DialogUtils;
import utils.FontUtils;

public class WarpItem extends ConsumableItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String itemInfor;

	public WarpItem(String name, int cost, String imageUrl, int num, int level, String itemInfor) {
		super(name, cost, imageUrl, num, level);
		this.itemInfor = itemInfor;
	}

	@Override
	public void use(Player player, MainMapleInterface mainMapleInterface) {
		if(num >= 1) {
			if(player.isHunt() || !player.isCanSave()) {
				DialogUtils.showWarningDialog("지금은 사용할 수 없습니다.");
				return;
			}
			String nowMapName = player.get_curMap().getName();
			String targetMapName = player.get_curMap().getWarpMapName();
			if(DialogUtils.showConfirmDialog("귀환서를 사용하시겠습니까? " + targetMapName +"(으)로 이동합니다.") == JOptionPane.YES_OPTION) {
				if(nowMapName.equals(targetMapName)) {
					DialogUtils.showWarningDialog("이미 귀환 지점입니다.");
					return;
				}
				setNum(num - 1);
				player.get_curMap().warp(player, targetMapName, mainMapleInterface);
				player.removeEmptyItem();
			}
		}
	}

	@Override
	public boolean isNeedQuickReigster() {
		return false;
	}

	public void drawInfor(Graphics2D g, Point p) {
		int totalLine = getLine(g);
		g.setColor(Color.BLACK);
		g.fillRect(p.getX(), p.getY(), 200, 160 + totalLine * 20);
		g.setFont(FontUtils.SMALL_FONT);
		this.fm = g.getFontMetrics(FontUtils.SMALL_FONT);
		g.setColor(Color.WHITE);
		int width = this.fm.stringWidth(getName());
		g.drawString(getName(), p.getX() + (200 - width) / 2, p.getY() + 25);
		g.drawImage(getImage(), p.getX() + 20, p.getY() + 45, null);
		g.setColor(Color.YELLOW);
		g.drawString("분류", p.getX() + 80, p.getY() + 70);
		g.setColor(Color.WHITE);
		g.drawString("소모품", p.getX() + 120, p.getY() + 70);
		int preIndex = 0;
		int line = 0;
		int width2 = 0;
		for (int i = 0; i < this.itemInfor.length(); i++) {
			FontMetrics fm = g.getFontMetrics();
			width2 = fm.stringWidth(this.itemInfor.substring(preIndex, i));
			if (width2 > 160) {
				g.drawString(this.itemInfor.substring(preIndex, i), p.getX() + (200 - width2) / 2,
						p.getY() + 120 + line * 20);
				preIndex = i;
				line++;
			}
		}
		width2 = fm.stringWidth(this.itemInfor.substring(preIndex));
		g.drawString(this.itemInfor.substring(preIndex), p.getX() + (200 - width2) / 2, p.getY() + 120 + line * 20);
		g.setColor(ColorUtils.SEA);
		g.setFont(FontUtils.SMALL_FONT);
		g.drawString(this.cost + " 메소", p.getX() + 20, p.getY() + 160 + (totalLine-1) * 20);
	}
	
	private int getLine(Graphics2D g) {
		int preIndex = 0;
		int line = 0;
		int width2 = 0;
		for (int i = 0; i < this.itemInfor.length(); i++) {
			FontMetrics fm = g.getFontMetrics();
			width2 = fm.stringWidth(this.itemInfor.substring(preIndex, i));
			if (width2 > 160) {
				preIndex = i;
				line++;
			}
		}
		return ++line;
	}

	public String getItemInfor() {
		return itemInfor;
	}

	public void setItemInfor(String itemInfor) {
		this.itemInfor = itemInfor;
	}

}

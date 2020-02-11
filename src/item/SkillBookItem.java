package item;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.io.Serializable;

import javax.swing.JOptionPane;

import org.w3c.dom.NamedNodeMap;

import character.AdventurerFactory;
import map.Point;
import maplestory.MainMapleInterface;
import maplestory.Player;
import utils.ColorUtils;
import utils.DialogUtils;
import utils.FontUtils;

public class SkillBookItem extends ConsumableItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String itemInfor;

	public SkillBookItem(String name, int cost, String imageUrl, int num, int level, String itemInfor) {
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
			if(name.equals("4차스킬북") && player.getMainAdventurer().getCareerLevel() == 2) {
				DialogUtils.showWarningDialog("3차 스킬북을 먼저 사용해야 합니다.");
				return;
			}
			if(DialogUtils.showConfirmDialog("스킬북을 사용하시겠습니까?") == JOptionPane.YES_OPTION) {
				int playerLevel = player.getMainAdventurer().getAdventurerLevel();
				if(player.getMainAdventurer().getSkillPoint() <= (4 + (playerLevel - level) * 4)
						&& player.getMainAdventurer().getAdventurerLevel() <= playerLevel) {
					setNum(num - 1);
					if(name.equals("3차스킬북")) {
						if(player.getMainAdventurer().getCareer().equals("파이터")) {
							AdventurerFactory.upgradeAdventurer("크루세이더", player.getMainAdventurer());
						} else if(player.getMainAdventurer().getCareer().equals("페이지")) {
							AdventurerFactory.upgradeAdventurer("나이트", player.getMainAdventurer());
						}else if(player.getMainAdventurer().getCareer().equals("스피어맨")) {
							AdventurerFactory.upgradeAdventurer("버서커", player.getMainAdventurer());
						}
					} else if(name.equals("4차스킬북")) {
						if(player.getMainAdventurer().getCareer().equals("크루세이더")) {
							AdventurerFactory.upgradeAdventurer("히어로", player.getMainAdventurer());
						} else if(player.getMainAdventurer().getCareer().equals("나이트")) {
							AdventurerFactory.upgradeAdventurer("팔라딘", player.getMainAdventurer());
						}else if(player.getMainAdventurer().getCareer().equals("버서커")) {
							AdventurerFactory.upgradeAdventurer("다크나이트", player.getMainAdventurer());
						}
					}
					player.removeEmptyItem();
					DialogUtils.showInfoDialog("스킬북 사용이 완료되었습니다.");
				} else if(player.getMainAdventurer().getAdventurerLevel() > playerLevel) {
					DialogUtils.showWarningDialog("래벨이 부족합니다.");
				} else {
					DialogUtils.showWarningDialog("래벨" + (level - 1) + "까지의 스킬포인트를 모두 사용해야 합니다.");
				}
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
		g.drawString("분류", p.getX() + 80, p.getY() + 57);
		g.drawString("래벨", p.getX() + 80, p.getY() + 82);
		g.setColor(Color.WHITE);
		g.drawString("스킬북", p.getX() + 120, p.getY() + 57);
		g.drawString(this.level+"", p.getX() + 120, p.getY() + 82);
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

	@Override
	public boolean isSellable() {
		return false;
	}

}

package item;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.io.Serializable;

import javax.swing.JOptionPane;

import map.Point;
import maplestory.MainMapleInterface;
import maplestory.Player;
import skill.Skill;
import utils.ColorUtils;
import utils.DialogUtils;
import utils.FontUtils;

public class MasteryBookItem extends ConsumableItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String skillName;
	private int skillLevel;

	public MasteryBookItem(String name, int cost, String imageUrl, int num, int level, String skillName, int skillLevel) {
		super(name, cost, imageUrl, num, level);
		this.skillName = skillName;
		this.skillLevel = skillLevel;
	}

	@Override
	public void use(Player player, MainMapleInterface mainMapleInterface) {
		if(num >= 1) {
			if(player.isHunt() || !player.isCanSave()) {
				DialogUtils.showWarningDialog("지금은 사용할 수 없습니다.");
				return;
			}
			if(DialogUtils.showConfirmDialog("마스터리북을 사용하시겠습니까?") == JOptionPane.YES_OPTION) {
				int playerLevel = player.getMainAdventurer().getAdventurerLevel();
				if(player.getMainAdventurer().getAdventurerLevel() > playerLevel) {
					DialogUtils.showWarningDialog("래벨이 부족합니다.");
					return;
				}
				Skill skill = player.getMainAdventurer().getSkillWithName(skillName);
				if(skill == null) {
					DialogUtils.showWarningDialog("존재하지 않는 스킬입니다.");
					return;
				} else if(skill.getMaxPoint() == skillLevel) {
					DialogUtils.showWarningDialog("해당스킬은 이미 마스터리북을 사용하였습니다.");
					return;
				}
				skill.setMaxPoint(skillLevel);
				setNum(num - 1);
				player.removeEmptyItem();
				DialogUtils.showInfoDialog("스킬북 사용이 완료되었습니다.");
			}
		}
	}

	@Override
	public boolean isNeedQuickReigster() {
		return false;
	}

	public void drawInfor(Graphics2D g, Point p) {
		String itemInfor = "사용시 " + skillName + "스킬 마스터 래벨 " + skillLevel + "로 확장";
		int totalLine = getLine(g, itemInfor);
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
		g.drawString("마스터리북", p.getX() + 120, p.getY() + 57);
		g.drawString(this.level+"", p.getX() + 120, p.getY() + 82);
		int preIndex = 0;
		int line = 0;
		int width2 = 0;
		for (int i = 0; i < itemInfor.length(); i++) {
			FontMetrics fm = g.getFontMetrics();
			width2 = fm.stringWidth(itemInfor.substring(preIndex, i));
			if (width2 > 160) {
				g.drawString(itemInfor.substring(preIndex, i), p.getX() + (200 - width2) / 2,
						p.getY() + 120 + line * 20);
				preIndex = i;
				line++;
			}
		}
		width2 = fm.stringWidth(itemInfor.substring(preIndex));
		g.drawString(itemInfor.substring(preIndex), p.getX() + (200 - width2) / 2, p.getY() + 120 + line * 20);
		g.setColor(ColorUtils.SEA);
		g.setFont(FontUtils.SMALL_FONT);
	}
	
	private int getLine(Graphics2D g, String itemInfor) {
		int preIndex = 0;
		int line = 0;
		int width2 = 0;
		for (int i = 0; i < itemInfor.length(); i++) {
			FontMetrics fm = g.getFontMetrics();
			width2 = fm.stringWidth(itemInfor.substring(preIndex, i));
			if (width2 > 160) {
				preIndex = i;
				line++;
			}
		}
		return ++line;
	}
	
	public String getSkillName() {
		return skillName;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	@Override
	public boolean isSellable() {
		return false;
	}

}

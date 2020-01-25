package item;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import character.Adventurer;
import character.Character;
import map.Point;
import maplestory.MainMapleInterface;
import maplestory.MapleInterface;
import maplestory.Player;
import utils.ColorUtils;
import utils.FontUtils;
import utils.MusicUtils;

public class HealItem extends ConsumableItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private Heal heal;

	public HealItem(String name, int cost, String imageUrl, int num, Heal heal, int level) {
		super(name, cost, imageUrl, num, level);
		this.heal = heal;
	}

	public Heal getHeal() {
		return this.heal;
	}

	public void setHeal(Heal heal) {
		this.heal = heal;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void use(Player player, MainMapleInterface mainMapleInterface) {
		Adventurer adventurer = player.getMainAdventurer();
		if (getNum() >= 1) {
			MusicUtils.startEffectSound("portionUse");
			setNum(getNum() - 1);
			if (this.heal.getHealHp() != 0) {
				adventurer.healHp(this.heal.getHealHp());
			}
			if (this.heal.getHealMp() != 0) {
				adventurer.healMp(this.heal.getHealMp());
			}
			if (this.heal.getHealPercentHp() != 0) {
				adventurer.healHp(this.heal.getHealPercentHp() / 100 * adventurer.getMaxHp());
			}
			if (this.heal.getHealPercentMp() != 0) {
				adventurer.healMp(this.heal.getHealPercentMp() / 100 * adventurer.getMaxMp());
			}
			mainMapleInterface.mainStateBarUpdate();
			player.removeEmptyItem();
		}
	}

	public void drawInfor(Graphics2D g, Point p) {
		ArrayList<String> arr = heal.getStrengthItemInfor();
		g.setColor(Color.BLACK);
		g.fillRect(p.getX(), p.getY(), 200, 160 + arr.size() * 20);
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
		for (int i = 0; i < arr.size(); i++) {
			int width2 = this.fm.stringWidth((String) arr.get(i));
			g.drawString((String) arr.get(i), p.getX() + (200 - width2) / 2, p.getY() + 120 + i * 20);
		}
		g.setColor(ColorUtils.SEA);
		g.setFont(FontUtils.SMALL_FONT);
		g.drawString(this.cost + " 메소", p.getX() + 20,  p.getY() + 160 + (arr.size()-1) * 20);
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

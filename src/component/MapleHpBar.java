package component;

import java.awt.Color;

import javax.swing.JProgressBar;
import character.Character;

import utils.FontUtils;

public class MapleHpBar extends JProgressBar {
	private static final long serialVersionUID = 1L;
	Character chatacter;

	public MapleHpBar(Character adventurer) {
		progressInit(adventurer);
	}

	public MapleHpBar(Character adventurer, boolean visible) {
		progressInit(adventurer);
		if (visible) {
			setVisible(true);
		} else if (!visible) {
			setVisible(false);
		}
	}

	private void progressInit(Character chatacter) {
		this.chatacter = chatacter;
		setStringPainted(true);
		setMinimum(0);
		setMaximum(this.chatacter.getStrength().getMaxHp());
		setValue(this.chatacter.getCurHp());
		setString(this.chatacter.getCurHp() + "/" + this.chatacter.getStrength().getMaxHp());
		setFont(FontUtils.SMALL_FONT);
		setForeground(Color.RED);
		setFocusable(false);
	}

	public Character getChatacter() {
		return this.chatacter;
	}

	public void setChatacter(Character chatacter) {
		this.chatacter = chatacter;
		progressUpdate();
	}

	public void progressUpdate() {
		if (this.chatacter.getCurHp() <= 0) {
			this.chatacter.setCurHp(0);
		}
		setMinimum(0);
		setMaximum(this.chatacter.getStrength().getMaxHp());
		setValue(this.chatacter.getCurHp());
		setString(this.chatacter.getCurHp() + "/" + this.chatacter.getStrength().getMaxHp());
	}
}

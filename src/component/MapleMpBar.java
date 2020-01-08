package component;

import java.awt.Color;

import javax.swing.JProgressBar;

import utils.FontUtils;
import character.Character;

public class MapleMpBar extends JProgressBar {
	private static final long serialVersionUID = 1L;
	Character character;

	public MapleMpBar(Character adventurer) {
		progressInit(adventurer);
	}

	public MapleMpBar(Character adventurer, boolean visible) {
		progressInit(adventurer);
		if (visible) {
			setVisible(true);
		} else if (!visible) {
			setVisible(false);
		}
	}

	private void progressInit(Character adventurer) {
		this.character = adventurer;
		setStringPainted(true);
		setMinimum(0);
		setMaximum(this.character.getStrength().getMaxMp());
		setValue(this.character.getCurMp());
		setString(this.character.getCurMp() + "/" + this.character.getStrength().getMaxMp());
		setFont(FontUtils.SMALL_FONT);
		setForeground(Color.BLUE);
		setFocusable(false);
	}

	public Character getCharacter() {
		return this.character;
	}

	public void setCharacter(Character character) {
		this.character = character;
		progressUpdate();
	}

	public void progressUpdate() {
		if (this.character.getCurMp() <= 0) {
			this.character.setCurMp(0);
		}
		setMinimum(0);
		setMaximum(this.character.getStrength().getMaxMp());
		setValue(this.character.getCurMp());
		setString(this.character.getCurMp() + "/" + this.character.getStrength().getMaxMp());
	}
}

package component;

import java.awt.Color;

import javax.swing.JProgressBar;

import character.Adventurer;
import utils.FontUtils;

public class MapleExpBar extends JProgressBar {
	private static final long serialVersionUID = 1L;
	Adventurer adventurer;

	public MapleExpBar(Adventurer adventurer) {
		progressInit(adventurer);
	}

	public MapleExpBar(Adventurer adventurer, boolean visible) {
		progressInit(adventurer);
		if (visible) {
			setVisible(true);
		} else if (!visible) {
			setVisible(false);
		}
	}

	public void progressInit(Adventurer adventurer) {
		this.adventurer = adventurer;
		setStringPainted(true);
		setMinimum(0);
		setMaximum(this.adventurer.getNeedExp());
		setValue(this.adventurer.getExp());
		setString(this.adventurer.getExp() + "/" + this.adventurer.getNeedExp());
		setFont(FontUtils.SMALL_FONT);
		setForeground(Color.GREEN);
		setFocusable(false);
	}

	public Adventurer getAdventurer() {
		return this.adventurer;
	}

	public void set_adventurer(Adventurer adventurer) {
		this.adventurer = adventurer;
		progressUpdate();
	}

	public void progressUpdate() {
		setMinimum(0);
		setMaximum(this.adventurer.getNeedExp());
		setValue(this.adventurer.getExp());
		setString(this.adventurer.getExp() + "/" + this.adventurer.getNeedExp());
	}
}

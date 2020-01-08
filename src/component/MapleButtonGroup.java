package component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MapleButtonGroup {
	private ArrayList<MapleButton> buttonList = new ArrayList<MapleButton>();
	private int curSelected;

	public MapleButtonGroup(ArrayList<MapleButton> buttonList) {
		this.buttonList = buttonList;
		for (int i = 0; i < buttonList.size(); i++) {
			final int index = i;
			buttonList.get(i).addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					MapleButtonGroup.this.selectEvent(index);
				}
			});
		}
	}

	protected void selectEvent(int index) {
		this.curSelected = index;
		for (int i = 0; i < this.buttonList.size(); i++) {
			if (this.curSelected == i) {
				this.buttonList.get(i).setSelectedInGroup(true);
			} else {
				this.buttonList.get(i).setIcon(this.buttonList.get(i).getButtonBasicImage());
				this.buttonList.get(i).setSelectedInGroup(false);
			}
		}
	}
}
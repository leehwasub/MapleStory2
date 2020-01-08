package panel;

import java.awt.Color;

import javax.swing.JPanel;

import maplestory.Player;

public class InventorySkillPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public InventorySkillPanel(Player player) {
		setVisible(false);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
	}
}

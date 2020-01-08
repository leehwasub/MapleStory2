package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import component.MapleButton;
import maplestory.Player;
import maplestory.SaveLoad;
import utils.ResourceLoader;

public class InventorySystemPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon inventorySaveButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventorySaveButtonBasic.png"));
	private ImageIcon inventorySaveButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventorySaveButtonEntered.png"));
	private ImageIcon inventoryMainMenuButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryMainMenuButtonBasic.png"));
	private ImageIcon inventoryMainMenuButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "inventoryMainMenuButtonEntered.png"));
	private MapleButton inventorySaveButton = new MapleButton(this.inventorySaveButtonBasicImage,
			this.inventorySaveButtonEnteredImage);
	private MapleButton inventoryMainMenuButton = new MapleButton(this.inventoryMainMenuButtonBasicImage,
			this.inventoryMainMenuButtonEnteredImage);

	public InventorySystemPanel(final Player player) {
		setVisible(false);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));

		this.inventorySaveButton.setBounds(60, 30, 120, 40);
		this.inventorySaveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (player.isCanSave()) {
					SaveLoad.savePlayer(player);
				}
			}
		});
		add(this.inventorySaveButton);
		this.inventoryMainMenuButton.setBounds(60, 90, 120, 40);
		this.inventoryMainMenuButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
			}
		});
		add(this.inventoryMainMenuButton);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}

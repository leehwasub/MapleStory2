package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import component.MapleButton;
import dialog.SaveDialog;
import maplestory.Main;
import maplestory.MainMapleInterface;
import maplestory.Player;
import maplestory.SaveLoad;
import utils.FontUtils;
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
	
	private MainMapleInterface mainMapleInterface;
	private Player player;

	public InventorySystemPanel(Player player, MainMapleInterface mainMapleInterface) {
		setVisible(false);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));

		this.player = player;
		this.mainMapleInterface = mainMapleInterface;
		
		inventorySaveButton.setBounds(60, 30, 120, 40);
		inventorySaveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont", FontUtils.SMALL_FONT);
				if(!player.isCanSave()) {
					JOptionPane.showMessageDialog(null, "지금은 저장할 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				} else {
					SaveDialog saveDialog = new SaveDialog(player);
					saveDialog.setVisible(true);
				}
			}
		});
		add(this.inventorySaveButton);
		
		inventoryMainMenuButton.setBounds(60, 90, 120, 40);
		inventoryMainMenuButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				UIManager.put("OptionPane.messageFont", FontUtils.SMALL_FONT);
				if(!player.isCanSave()) {
					JOptionPane.showMessageDialog(null, "지금은 메인 메뉴로 이동할 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				} else {
					int answer = JOptionPane.showConfirmDialog(null, "메인 메뉴로 이동하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
					if(answer == JOptionPane.YES_OPTION) {
						mainMapleInterface.toMainMenu();
					}
				}
			}
		});
		add(inventoryMainMenuButton);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}

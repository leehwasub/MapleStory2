package dialog;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import character.Adventurer;
import component.MapleButton;
import item.Item;
import item.ItemPool;
import maplestory.Player;
import maplestory.SaveLoad;
import panel.StorePanel;
import renderer.PlayerRenderer;
import utils.FontUtils;
import utils.InputValidUtils;
import utils.ResourceLoader;

public class SaveDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private static final int DIALOG_WIDTH = 500;
	private static final int DIALOG_HEIGHT = 660;
	private ImageIcon backButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "backButtonEntered.png"));
	private MapleButton backButton = new MapleButton(backButtonBasicImage, backButtonEnteredImage);
	DefaultListModel<Player> dm = new DefaultListModel<Player>();
	JList<Player> jList = new JList<Player>();
	private JScrollPane scrollPane;
	private Player player;

	public SaveDialog(Player player) {
		this.player = player;
		setTitle("Save");
		setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setLayout(null);
		
		this.jList.setCellRenderer(new PlayerRenderer());
		this.jList.setModel(dm);
		this.jList.setFixedCellHeight(100);
		this.jList.setBorder(new EmptyBorder(10, 10, 10, 10));

		this.jList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Player player = (Player) jList.getSelectedValue();
				int index = jList.getSelectedIndex();
				UIManager.put("OptionPane.messageFont", FontUtils.SMALL_FONT);
				String message = "";
				if(player != null) {
					message = "데이터가 이미 저장되어 있습니다. 덮어쓰시겠습니까?";
				} else {
					message = "이곳에 데이터를 저장하시겠습니까?";
				}
				int res = JOptionPane.showConfirmDialog(null, message, "확인", JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION) {
					SaveLoad.savePlayer(index, SaveDialog.this.player);
					updatePlayerData();
				}
			}

			public void mouseExited(MouseEvent e) {
				
			}
		});
		this.jList.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				JList<Item> l = (JList) e.getSource();
				ListModel<Item> m = l.getModel();
				if (m.getSize() == 0) {
					return;
				}
				int index = l.locationToIndex(e.getPoint());
				JScrollBar b = scrollPane.getVerticalScrollBar();
			}
		});
		this.jList.setBounds(20, 20, 460, 530);
		add(jList);
		
		this.scrollPane = new JScrollPane(this.jList);
		this.scrollPane.setBounds(20, 20, 460, 530);
		add(scrollPane);
		
		backButton.setBounds(420, 560, 60, 60);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				end();
			}
		});
		add(backButton);
		
		updatePlayerData();
	}
	
	public void updatePlayerData() {
		dm.clear();
		for(int i = 0; i < 5; i++) {
			dm.addElement(SaveLoad.loadPlayer(i));
		}
	}

	public void end() {
		dispose();
	}
	
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
	}
	
}

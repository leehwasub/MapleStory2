package panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import component.MapleButton;
import dialog.SaveDialog;
import item.Item;
import map.MapleMap;
import map.MapleMapList;
import maplestory.MapleInterface;
import maplestory.Player;
import maplestory.SaveLoad;
import npc.NpcList;
import renderer.PlayerRenderer;
import utils.FontUtils;
import utils.MusicUtils;
import utils.ResourceLoader;

public class LoadPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image backgroundImage = ResourceLoader.getImage("backgroundImage", "mainBackgroundImage.png");
	private ImageIcon backButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "backButtonEntered.png"));
	private MapleButton backButton = new MapleButton(backButtonBasicImage, backButtonEnteredImage);

	MapleInterface mapleInterface;
	
	DefaultListModel<Player> dm = new DefaultListModel<Player>();
	JList<Player> jList = new JList<Player>();
	private JScrollPane scrollPane;

	public LoadPanel(final MapleInterface mapleInterface) {
		MusicUtils.changeMusic("main");
		setLayout(null);

		this.mapleInterface = mapleInterface;

		this.jList.setCellRenderer(new PlayerRenderer());
		this.jList.setModel(dm);
		this.jList.setFixedCellHeight(100);
		this.jList.setBorder(new EmptyBorder(10, 10, 10, 10));

		this.jList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Player player = (Player) jList.getSelectedValue();
				UIManager.put("OptionPane.messageFont", FontUtils.SMALL_FONT);
				if(player != null) {
					int res = JOptionPane.showConfirmDialog(null, "데이터를 로드 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
					if(res == JOptionPane.YES_OPTION) {
						MapleMapList.getInstance().loadMap(player);
						NpcList.getInstance().loadNpcData(player);
						mapleInterface.dataLoad(player);
						MapleMap mapleMap = MapleMapList.getInstance().getMap(player.get_curMap().getName());
						mapleMap.setBasePoint(player.get_curMap().getBasePoint());
						player.set_curMap(mapleMap);
					}
				} 
			}

			public void mouseExited(MouseEvent e) {
				
			}
		});
		this.jList.setBounds(410, 75, 460, 530);
		add(jList);
		
		this.scrollPane = new JScrollPane(this.jList);
		this.scrollPane.setBounds(410, 75, 460, 530);
		add(scrollPane);
		
		backButton.setBounds(1200, 620, 60, 60);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mapleInterface.fromLoadPageToStartPage();
			}
		});
		add(backButton);
	}
	
	public void load() {
		loadSavedData();
	}
	
	private void loadSavedData() {
		dm.clear();
		for(int i = 0; i < 5; i++) {
			dm.addElement(SaveLoad.loadPlayer(i));
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		g.drawImage(this.backgroundImage, 0, 0, this);
		repaint();
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
}

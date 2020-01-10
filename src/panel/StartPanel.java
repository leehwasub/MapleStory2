package panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import component.MapleButton;
import editor.EditorFrame;
import maplestory.MapleInterface;
import utils.MusicUtils;
import utils.ResourceLoader;

public class StartPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image backgroundImage = ResourceLoader.getImage("backgroundImage", "mainBackgroundImage.png");
	private Image titleImage = ResourceLoader.getImage("componentImage", "titleImage.png");
	private ImageIcon startButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "gameStartButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "gameStartButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "gameExitButtonBasic.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "gameExitButtonEntered.png"));
	private ImageIcon loadButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "loadButtonBasic.png"));
	private ImageIcon loadButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "loadButtonEntered.png"));
	private MapleButton startButton = new MapleButton(this.startButtonBasicImage, this.startButtonEnteredImage);
	private MapleButton exitButton = new MapleButton(this.exitButtonBasicImage, this.exitButtonEnteredImage);
	private MapleButton loadButton = new MapleButton(this.loadButtonBasicImage, this.loadButtonEnteredImage);
	private static final int BUTTON_WIDTH = 300;
	private static final int BUTTON_HEIGHT = 75;
	private static final int POSITON_X = 490;
	private static final int POSITON_Y = 300;
	private static final int POSITON_INTERVAL = 90;
	MapleInterface mapleInterface;
	
	private JButton editorButton = new JButton("에디터 열기");

	public StartPanel(final MapleInterface mapleInterface) {
		MusicUtils.changeMusic("main");
		setLayout(null);

		this.mapleInterface = mapleInterface;

		this.startButton.setBounds(490, 300, 300, 75);
		this.startButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mapleInterface.startEnd();
			}
		});
		add(this.startButton);

		this.loadButton.setBounds(490, 390, 300, 75);
		this.loadButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mapleInterface.toLoadPage();
			}
		});
		add(this.loadButton);

		this.exitButton.setBounds(490, 480, 300, 75);
		this.exitButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(this.exitButton);
		
		editorButton.setBounds(10, 10, 120, 40);
		editorButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditorFrame frame = new EditorFrame();
				frame.setVisible(true);
			}
		});
		add(editorButton);
	}

	public void reload() {
		MusicUtils.changeMusic("main");
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		g.drawImage(this.backgroundImage, 0, 0, this);
		g.drawImage(this.titleImage, 340, 100, this);
		repaint();
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
}

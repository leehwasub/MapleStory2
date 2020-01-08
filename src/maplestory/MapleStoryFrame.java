package maplestory;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panel.MainPanel;
import panel.PrologPanel;
import panel.StartPanel;

public class MapleStoryFrame extends JFrame implements MapleInterface {
	private static final long serialVersionUID = 1L;
	JPanel startPanel = new StartPanel(this);
	JPanel prologPanel = new PrologPanel(this);
	JPanel mainPanel;
	private Player player;

	MapleStoryFrame() {
		setTitle("MapleStory");
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setVisible(true);
		getContentPane().add(this.startPanel);
	}

	public void reloadPanel() {
		revalidate();
		repaint();
	}

	public void startEnd() {
		getContentPane().remove(this.startPanel);
		getContentPane().add(this.prologPanel);
		reloadPanel();
	}

	public void newStart(Player player) {
		getContentPane().remove(this.prologPanel);
		this.mainPanel = new MainPanel(this, player);
		getContentPane().add(this.mainPanel);
		reloadPanel();
	}
}

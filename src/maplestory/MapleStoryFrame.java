package maplestory;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panel.LoadPanel;
import panel.MainPanel;
import panel.PrologPanel;
import panel.StartPanel;

public class MapleStoryFrame extends JFrame implements MapleInterface {
	private static final long serialVersionUID = 1L;
	private StartPanel startPanel = new StartPanel(this);
	private PrologPanel prologPanel = new PrologPanel(this);
	private LoadPanel loadPanel = new LoadPanel(this);
	private JPanel mainPanel;
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
	
	public void toLoadPage() {
		getContentPane().remove(this.startPanel);
		getContentPane().add(this.loadPanel);
		loadPanel.load();
		reloadPanel();
	}

	@Override
	public void fromLoadPageToStartPage() {
		getContentPane().remove(this.loadPanel);
		getContentPane().add(this.startPanel);
		reloadPanel();
	}

	@Override
	public void dataLoad(Player player) {
		getContentPane().remove(this.loadPanel);
		this.mainPanel = new MainPanel(this, player);
		getContentPane().add(this.mainPanel);
		reloadPanel();
	}
	
}

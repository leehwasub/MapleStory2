package maplestory;

import javax.swing.JFrame;
import javax.swing.JPanel;

import map.MapleMapList;
import npc.NpcList;
import panel.LoadPanel;
import panel.MainPanel;
import panel.PrologPanel;
import panel.StartPanel;
import utils.MusicUtils;

public class MapleStoryFrame extends JFrame implements MapleInterface {
	private static final long serialVersionUID = 1L;
	private StartPanel startPanel = new StartPanel(this);
	private PrologPanel prologPanel;
	private LoadPanel loadPanel = new LoadPanel(this);
	private JPanel mainPanel;

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
		prologPanel = null;
		prologPanel = new PrologPanel(this);
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
		getContentPane().remove(startPanel);
		getContentPane().add(loadPanel);
		loadPanel.load();
		reloadPanel();
	}

	@Override
	public void fromLoadPageToStartPage() {
		getContentPane().remove(loadPanel);
		getContentPane().add(startPanel);
		reloadPanel();
	}

	@Override
	public void dataLoad(Player player) {
		getContentPane().remove(loadPanel);
		this.mainPanel = new MainPanel(this, player);
		getContentPane().add(mainPanel);
		reloadPanel();
	}

	@Override
	public void toMainMenu() {
		MusicUtils.changeMusic("main");
		getContentPane().remove(mainPanel);
		mainPanel = null;
		getContentPane().add(startPanel);
		reloadPanel();
		MapleMapList.getInstance().reload();
		NpcList.getInstance().reload();
	}
	
}

package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import character.AdventurerFactory;
import component.MapleButton;
import item.ItemPool;
import map.MapleMapList;
import maplestory.MapleInterface;
import maplestory.Player;
import npc.NpcList;
import quest.Quest;
import quest.QuestProceed;
import utils.DialogUtils;
import utils.FileLoader;
import utils.FontUtils;
import utils.InputValidUtils;
import utils.ResourceLoader;

public class PrologPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image backgroundImage = ResourceLoader.getImage("backgroundImage", "mainBackgroundImage.png");
	private ImageIcon nextButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "nextButtonBasic.png"));
	private ImageIcon nextButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "nextButtonEntered.png"));
	private ImageIcon manSelectButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "manSelectButtonBasic.png"));
	private ImageIcon manSelectButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "manSelectButtonEntered.png"));
	private ImageIcon womanSelectButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "womanSelectButtonBasic.png"));
	private ImageIcon womanSelectButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "womanSelectButtonEntered.png"));
	private ImageIcon nameButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "getNameButtonBasic.png"));
	private ImageIcon nameButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "getNameButtonEntered.png"));
	private MapleButton nextButton = new MapleButton(this.nextButtonBasicImage, this.nextButtonEnteredImage, false);
	private MapleButton manSelectButton = new MapleButton(this.manSelectButtonBasicImage,
			this.manSelectButtonEnteredImage, false);
	private MapleButton womanSelectButton = new MapleButton(this.womanSelectButtonBasicImage,
			this.womanSelectButtonEnteredImage, false);
	private MapleButton nameButton = new MapleButton(this.nameButtonBasicImage, this.nameButtonEnteredImage);
	private JTextField nameField = new JTextField();
	
	private static final int SEX_SELECT_BUTTON_WIDTH = 150;
	private static final int SEX_SELECT_BUTTON_HEIGHT = 50;
	private static final int SEX_SELECT_BUTTON_POSITON_X = 490;
	private static final int SEX_SELECT_BUTTON_POSITON_Y = 330;
	private static final int SEX_SELECT_BUTTON_INTERVAL = 160;
	private static final int NEXT_BUTTON_WIDTH = 60;
	private static final int NEXT_BUTTON_HEIGHT = 60;
	private static final int NEXT_BUTTON_POSITON_X = 1200;
	private static final int NEXT_BUTTON_POSITON_Y = 620;
	private static final int TEXT_POSITION_X = 640;
	private static final int TEXT_POSITION_Y = 280;
	private static final int FIELD_POSITION_X = 480;
	private static final int FIELD_POSITION_Y = 330;
	
	MapleInterface mapleInterface;
	private ArrayList<String> text = new ArrayList<String>();
	private int textProcess = 0;
	private Player player;
	private String mainAdventurerName;

	public PrologPanel(MapleInterface mapleInterface) {
		setLayout(null);

		this.mapleInterface = mapleInterface;
		try {
			initText();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		this.nameField.setBounds(480, 330, 250, 30);
		add(this.nameField);

		this.nextButton.setBounds(1200, 620, 60, 60);
		this.nextButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				PrologPanel.this.updateText();
			}
		});
		add(this.nextButton);

		this.manSelectButton.setBounds(490, 330, 150, 50);
		add(this.manSelectButton);
		this.manSelectButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				PrologPanel.this.sexSelectEvent("남자");
			}
		});
		this.womanSelectButton.setBounds(650, 330, 150, 50);
		add(this.womanSelectButton);
		this.womanSelectButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				PrologPanel.this.sexSelectEvent("여자");
			}
		});
		this.nameButton.setBounds(750, 330, 90, 30);
		add(this.nameButton);
		this.nameButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String name = PrologPanel.this.nameField.getText();
				if (InputValidUtils.isValidName(name)) {
					PrologPanel.this.mainAdventurerName = name;
					PrologPanel.this.updateText();
					PrologPanel.this.nameButton.setVisible(false);
					PrologPanel.this.nameField.setVisible(false);
					PrologPanel.this.manSelectButton.setVisible(true);
					PrologPanel.this.womanSelectButton.setVisible(true);
				} else {
					DialogUtils.showWarningDialog("이름은 3글자이상 12글자 이하, 특수문자는 포함될 수 없습니다.");
				}
			}
		});
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == 39) && (PrologPanel.this.nextButton.isVisible())) {
					PrologPanel.this.updateText();
				}
			}
		});
		setFocusable(true);
		requestFocus();
	}

	public void sexSelectEvent(String sex) {
		//makeWarrior(sex);
		makeNewAdventurer(sex);
		updateText();
		this.nextButton.setVisible(true);
		this.manSelectButton.setVisible(false);
		this.womanSelectButton.setVisible(false);
	}
	
	public void makeWarrior(String sex) {
		if (sex.equals("남자")) {
			player = new Player(mainAdventurerName, "남자1차모험가");
			player.getWearEquipment("마스터서전트(남)");
			player.getWearEquipment("마스터서전트치마(남)");
		} else if (sex.equals("여자")) {
			player = new Player(mainAdventurerName, "여자1차모험가");
			player.getWearEquipment("샤크(여)");
			player.getWearEquipment("샤크치마(여)");
		}
		player.addItem(ItemPool.getItem("새우튀김", 500));
		player.addItem(ItemPool.getItem("파란포션", 500));
		Quest quest = Quest.makeQuest(0, 1, "TEST").setRewardExp(100)
				.addMessage("TEST");
		player.setQuest(quest);
		player.getWearEquipment("일룬");
		player.set_curMap(MapleMapList.getInstance().getMap("페리온"));
		player.getInventory().setMoney(1000000);
		AdventurerFactory.upgradeAdventurer("검사", player.getMainAdventurer());
		NpcList.getInstance().setNpcProcess("주먹펴고일어서", 12);
		NpcList.getInstance().getNpcWithName("주먹펴고일어서").setQuestNum(1);
	}

	public void makeNewAdventurer(String sex) {
		if (sex.equals("남자")) {
			this.player = new Player(mainAdventurerName, "남자초보모험가");
			this.player.getWearEquipment("하얀반팔면티(남)");
			this.player.getWearEquipment("파란청반바지(남)");
		} else if (sex.equals("여자")) {
			this.player = new Player(mainAdventurerName, "여자초보모험가");
			this.player.getWearEquipment("노란반팔면티(여)");
			this.player.getWearEquipment("빨간미니스커트(여)");
		}
		this.player.getWearEquipment("고무장화");
		this.player.getWearEquipment("검");
		this.player.getMainAdventurer().setSex(sex);
		Quest quest = Quest.makeQuest(0, 1, "메이플 아일랜드")
				.addMessage("메이플 아일랜드에 도착했다. 일단 슈가라는 NPC에게 가보도록 하자.")
				.setPlayerQuestProceed(QuestProceed.PROLOGUE).setRewardExp(8).addRewardItem("초보모험가의빨간포션", 10)
				.addRewardItem("초보모험가의파란포션", 10).addRewardNpcQuestProceed("마이", 1);
		this.player.setQuest(quest);
	}

	public void updateText() {
		if (this.textProcess + 1 < this.text.size()) {
			this.textProcess += 1;
			repaint();
		} else {
			this.mapleInterface.newStart(this.player);
		}
	}

	public void initText() throws Exception {
		InputStream in = new FileLoader().getFileStream("text", "start.txt");
		BufferedReader bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		String line;
		while ((line = bf.readLine()) != null) {
			this.text.add(line);
		}
		bf.close();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D) g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		g.drawImage(this.backgroundImage, 0, 0, this);
		g.setFont(FontUtils.guideMessageFont);
		g.setColor(Color.BLACK);
		g.drawString((String) this.text.get(this.textProcess),
				640 - ((String) this.text.get(this.textProcess)).length() * 10, 280);
	}

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
}

package editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditorPanel extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	
	private JButton startButton = new JButton("시작");
	private JButton saveButton = new JButton("저장");
	private int stateNum = 0;
	private int typeNum = 0;
	
	private String[] state = new String[7];
	private String[] typeString = new String[6];
	private JTextField nameField = new JTextField();
	private JTextField yField = new JTextField();
	private JTextField xField = new JTextField();
	
	private JTextField backgroundField = new JTextField();
	private JTextField musicField = new JTextField();
	private JTextField warpField = new JTextField();
	private JTextField tileField = new JTextField();

	private JButton[][] mapButton;
	
	public static final int MAP_EMPTY_STATE = 0;
	public static final int MAP_WALL_STATE = 1;
	public static final int MAP_NPC_STATE = 2;
	public static final int MAP_PORTAL_STATE = 3;
	public static final int MAP_STORE_STATE = 4;
	public static final int MAP_HEAL_STATE = 5;
	public static final int MAP_GUARD_STATE = 6;
	
	public static final int MAP_VILLAGE_TYPE = 0;
	public static final int MAP_HUNTING_TYPE = 1;
	public static final int MAP_BOSS_TYPE = 2;
	public static final int MAP_SAILING_TYPE = 3;
	public static final int MAP_HARBOR_TYPE = 4;
	public static final int MAP_DUNGEON_TYPE = 5;
	
	private Color typeColor[] = new Color[8];
	
	private JComboBox<String> combo, typeCombo;
	
	EditorPanel(){
		setLayout(null);
		state[0] = "EMPTY_STATE";
		state[1] = "WALL_STATE";
		state[2] = "NPC_STATE";
		state[3] = "PORTAL_STATE";
		state[4] = "STORE_STATE";
		state[5] = "HEAL_STATE";
		state[6] = "GUARD_STATE";
		
		typeString[0] = "MAP_VILLAGE_TYPE";
		typeString[1] = "MAP_HUNTING_TYPE";
		typeString[2] = "MAP_BOSS_TYPE";
		typeString[3] = "MAP_SAILING_TYPE";
		typeString[4] = "MAP_HARBOR_TYPE";
		typeString[5] = "MAP_DUNGEON_TYPE";
		
		combo = new JComboBox<String>(state);
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = combo.getSelectedIndex();
				stateNum = index;
			}
		});
		combo.setBounds(50, 50, 120, 50);
		add(combo);
		typeColor[0] = Color.WHITE;
		typeColor[1] = Color.BLACK;
		typeColor[2] = Color.RED;
		typeColor[3] = Color.BLUE;
		typeColor[4] = Color.MAGENTA;
		typeColor[5] = Color.YELLOW;
		typeColor[6] = Color.CYAN;
		JLabel xLabel = new JLabel("X좌표");
		xLabel.setBounds(200, 50, 80, 50);
		add(xLabel);
		xField.setBounds(250, 50, 80, 50);
		add(xField);
		JLabel yLabel = new JLabel("Y좌표");
		yLabel.setBounds(350, 50, 80, 50);
		add(yLabel);
		yField.setBounds(400, 50, 80, 50);
		add(yField);
		JLabel nameLabel = new JLabel("맵이름");
		nameLabel.setBounds(500, 50, 80, 50);
		add(nameLabel);
		nameField.setBounds(550, 50, 80, 50);
		add(nameField);
		
		JLabel backgroundLabel = new JLabel("배경사진");
		backgroundLabel.setBounds(650, 50, 80, 50);
		add(backgroundLabel);
		backgroundField.setBounds(720, 50, 80, 50);
		add(backgroundField);
		
		
		JLabel musicLabel = new JLabel("음악");
		musicLabel.setBounds(820, 50, 80, 50);
		add(musicLabel);
		musicField.setBounds(870, 50, 80, 50);
		add(musicField);
		
		JLabel warpLabel = new JLabel("워프지점");
		warpLabel.setBounds(970, 50, 80, 50);
		add(warpLabel);
		warpField.setBounds(1040, 50, 80, 50);
		add(warpField);
		
		JLabel tileLabel = new JLabel("타일");
		tileLabel.setBounds(1170, 50, 80, 50);
		add(tileLabel);
		tileField.setBounds(1210, 50, 80, 50);
		add(tileField);
		
		typeCombo = new JComboBox<String>(typeString);
		typeCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = typeCombo.getSelectedIndex();
				typeNum = index;
			}
		});
		typeCombo.setBounds(1450, 50, 200, 50);
		add(typeCombo);
		
		add(nameField);
		startButton.setBounds(1700, 50, 80, 50);
		add(startButton);
		saveButton.setBounds(1800, 50, 80, 50);
		add(saveButton);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(mapButton != null) {
					for(int i = 0; i < mapButton.length; i++) {
						for(int j = 0; j < mapButton[i].length; j++) {
							remove(mapButton[i][j]);
							mapButton[i][j].revalidate();
							repaint();
						}
					}
				}
				int x = Integer.parseInt(xField.getText());
				int y = Integer.parseInt(yField.getText());
				mapButton = new JButton[x][y];
				setButton(x, y);
				repaint();
			}
		});
		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				FileWriter file = null;
				try {
					file = new FileWriter("res/mapText/" + nameField.getText() + ".txt");
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				try {
					BufferedWriter bw = new BufferedWriter(file);
					if(mapButton != null) {
						String[] nameString = nameField.getText().split("-");
						bw.write(mapButton.length + " " + mapButton[0].length + " " + nameString[0] + " " + nameString[1] + " " + backgroundField.getText() + " " + musicField.getText() + " " + typeNum + " " + warpField.getText() + " " + tileField.getText() + "\n");
						for(int i = 0; i < mapButton.length; i++) {
							for(int j = 0; j < mapButton[i].length; j++) {
								if(!mapButton[i][j].getText().equals("0")) {
									bw.write(i + " " + j + " " + mapButton[i][j].getText());
									bw.newLine();
									bw.flush();
								}
							}
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	public void setButton(int x, int y) {
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				mapButton[i][j] = new JButton("0");
				mapButton[i][j].setBounds(50 + j * 15, 150 + i * 15, 15, 15);
				mapButton[i][j].addMouseListener(this);
				mapButton[i][j].setBackground(Color.WHITE);
				add(mapButton[i][j]);
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D)g);
		g.drawString("type : " + stateNum, 1000, 1000);
	}
	
	public void screenDraw(Graphics2D g) {
		rendering(g);
	}
	

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object source = e.getSource();
		if(mapButton != null) {
			for(int i = 0; i < mapButton.length; i++) {
				for(int j = 0; j < mapButton[i].length; j++) {
					if(mapButton[i][j] == source) {
						mapButton[i][j].setText(stateNum+"");
						mapButton[i][j].setBackground(typeColor[stateNum]);
						repaint();
					}
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}

package dialog;


import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import component.MapleButton;
import utils.FontUtils;
import utils.ResourceLoader;

public class JobSelectDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private static final int DIALOG_WIDTH = 800;
	private static final int DIALOG_HEIGHT = 390;
	private ImageIcon fighterButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "fighterButtonBasic.png"));
	private ImageIcon fighterButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "fighterButtonEntered.png"));
	private ImageIcon pageButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "pageButtonBasic.png"));
	private ImageIcon pageButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "pageButtonEntered.png"));
	private ImageIcon spearManButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "spearManButtonBasic.png"));
	private ImageIcon spearManButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "spearManButtonEntered.png"));
	private FontMetrics fm;
	private MapleButton[] button = new MapleButton[3];
	private ImageIcon[] basicIcon = { fighterButtonBasicImage, pageButtonBasicImage, spearManButtonBasicImage};
	private ImageIcon[] enteredIcon = { fighterButtonEnteredImage, pageButtonEnteredImage, spearManButtonEnteredImage};
	private JTextArea[] jobIntroduction = new JTextArea[3];
	private String[] introduction = new String[3];
	private String[] jobName = {"파이터", "페이지", "스피어맨"};
	private int returnIndex = -1;

	public JobSelectDialog() {
		setTitle("job select");
		setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setLayout(null);
		this.fm = getFontMetrics(FontUtils.generalFont);
		int width = this.fm.stringWidth("직업을 선택해주세요");
		int height = this.fm.getHeight();
		JLabel label = new JLabel("직업을 선택해주세요");
		label.setFont(FontUtils.generalFont);
		label.setBounds((DIALOG_WIDTH - width) / 2, 20, width, height);
		getContentPane().add(label);
		for (int i = 0; i < 3; i++) {
			final int index = i;
			this.button[i] = new MapleButton(this.basicIcon[i], this.enteredIcon[i]);
			this.button[i].setBounds(80 + 260 * i, 70, 120, 40);
			this.button[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					returnIndex = index;
					end();
				}
			});
			getContentPane().add(this.button[i]);
		}
		initText();
		for(int i = 0; i < 3; i++) {
			jobIntroduction[i] = new JTextArea();
			jobIntroduction[i].setBounds(40 + 260 * i, 130, 200, 200);
			jobIntroduction[i].setFont(FontUtils.SMALL_FONT);
			jobIntroduction[i].setText(makeStringForTextArea(i));
			jobIntroduction[i].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			jobIntroduction[i].setEditable(false);
			add(jobIntroduction[i]);
		}
	}
	
	public String makeStringForTextArea(int index) {
		int preIndex = 0;
		int width = 0;
		String infor = introduction[index];
		ArrayList<String> stringList = new ArrayList<String>();
		for (int i = 0; i < infor.length(); i++) {
			FontMetrics fm = jobIntroduction[index].getFontMetrics(FontUtils.SMALL_FONT);
			width = fm.stringWidth(infor.substring(preIndex, i));
			if (width > 175) {
				stringList.add(infor.substring(preIndex, i));
				preIndex = i;
			}
		}
		stringList.add(infor.substring(preIndex));
		StringBuffer bf = new StringBuffer();
		for(int i = 0; i < stringList.size(); i++) {
			if(i != 0) bf.append("\n");
			bf.append(stringList.get(i));
		}
		return bf.toString();
	}
	
	public void initText() {
		introduction[0] = "전사 최고의 딜러를 표방하는 근접 캐릭터답게, 매서운 공격력으로 상대를 제압한다. 특성화 스킬로 콤보 카운트를 쌓는 콤보 어택이 있으며, "
				+ "카운트를 많이 쌓을수록 공격력이 강해지지만, 스킬에 따라 카운트를 스킬 비용으로 소비해야만 하는 경우도 있다.";
		introduction[1] = "절대 방어의 수호 기사를 담당하며 몬스터의 공격으로부터 자신과 아군을 방어하며 보조를 하는 전사의 모습을 하고 있다. "
				+ "특성화 스킬 시스템으로는 여러가지 속성을 사용하며 차지를 누적하는 엘리멘탈 차지가 있다.";
		introduction[2] = "공격형인 파이터 계열과 방어형인 페이지 계열과는 달리 이쪽은 버프형 직업으로, 상징적이라고 할 수 있는 하이퍼 바디와 아이언 월이 이를 대변해준다.";
	}
	
	public String getSelectedJobName() {
		if(returnIndex == -1) return null;
		return jobName[returnIndex];
	}

	public void end() {
		dispose();
	}

	public int getReturnIndex() {
		return this.returnIndex;
	}

	public void setReturnIndex(int returnIndex) {
		this.returnIndex = returnIndex;
	}

	public void paintComponents(Graphics g) {
		super.paintComponents(g);
	}
}

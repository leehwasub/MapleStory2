package dialog;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import character.Adventurer;
import component.MapleButton;
import utils.FontUtils;
import utils.ResourceLoader;

public class SkillKeySelectDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private static final int DIALOG_WIDTH = 480;
	private static final int DIALOG_HEIGHT = 200;
	private ImageIcon quickINSButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickINSButtonBasic.png"));
	private ImageIcon quickINSButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickINSButtonEntered.png"));
	private ImageIcon quickHOMButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickHOMButtonBasic.png"));
	private ImageIcon quickHOMButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickHOMButtonEntered.png"));
	private ImageIcon quickPUButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickPUButtonBasic.png"));
	private ImageIcon quickPUButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickPUButtonEntered.png"));
	private ImageIcon quickDELButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickDELButtonBasic.png"));
	private ImageIcon quickDELButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickDELButtonEntered.png"));
	private ImageIcon quickENDButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickENDButtonBasic.png"));
	private ImageIcon quickENDButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickENDButtonEntered.png"));
	private ImageIcon quickPDButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickPDButtonBasic.png"));
	private ImageIcon quickPDButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickPDButtonEntered.png"));
	private FontMetrics fm;
	private MapleButton[] button = new MapleButton[Adventurer.QUICK_SKILL_ARRAY_SIZE];
	private ImageIcon[] basicIcon = { quickINSButtonBasicImage, quickHOMButtonBasicImage,
			quickPUButtonBasicImage, quickDELButtonBasicImage,  quickENDButtonBasicImage, quickPDButtonBasicImage};
	private ImageIcon[] enteredIcon = { quickINSButtonEnteredImage, quickHOMButtonEnteredImage,
			quickPUButtonEnteredImage, quickDELButtonEnteredImage,  quickENDButtonEnteredImage, quickPDButtonEnteredImage};
	private int returnIndex = -1;

	public SkillKeySelectDialog() {
		setTitle("key select");
		setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setLayout(null);
		this.fm = getFontMetrics(FontUtils.generalFont);
		int width = this.fm.stringWidth("키를 선택해주세요.");
		int height = this.fm.getHeight();
		JLabel label = new JLabel("키를 선택해주세요.");
		label.setFont(FontUtils.generalFont);
		label.setBounds((DIALOG_WIDTH - width) / 2, 10, width, height);
		getContentPane().add(label);
		for (int i = 0; i < Adventurer.QUICK_SKILL_ARRAY_SIZE; i++) {
			final int index = i;
			this.button[i] = new MapleButton(this.basicIcon[i], this.enteredIcon[i]);
			this.button[i].setBounds(40 + 70 * i, 60, 50, 50);
			this.button[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					returnIndex = index;
					end();
				}
			});
			getContentPane().add(this.button[i]);
		}
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

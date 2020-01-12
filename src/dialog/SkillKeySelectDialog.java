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
	private static final int DIALOG_WIDTH = 420;
	private static final int DIALOG_HEIGHT = 200;
	private ImageIcon quickZButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickZButtonBasic.png"));
	private ImageIcon quickZButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickZButtonEntered.png"));
	private ImageIcon quickXButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickXButtonBasic.png"));
	private ImageIcon quickXButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickXButtonEntered.png"));
	private ImageIcon quickCButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickCButtonBasic.png"));
	private ImageIcon quickCButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickCButtonEntered.png"));
	private ImageIcon quickVButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickVButtonBasic.png"));
	private ImageIcon quickVButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickVButtonEntered.png"));
	private ImageIcon quickBButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickBButtonBasic.png"));
	private ImageIcon quickBButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickBButtonEntered.png"));
	private FontMetrics fm;
	private MapleButton[] button = new MapleButton[Adventurer.QUICK_SKILL_ARRAY_SIZE];
	private ImageIcon[] basicIcon = { quickZButtonBasicImage, quickXButtonBasicImage,
			quickCButtonBasicImage, quickVButtonBasicImage,  quickBButtonBasicImage};
	private ImageIcon[] enteredIcon = { quickZButtonEnteredImage, quickXButtonEnteredImage,
			quickCButtonEnteredImage, quickVButtonEnteredImage,  quickBButtonEnteredImage};
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
		label.setBounds((420 - width) / 2, 10, width, height);
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

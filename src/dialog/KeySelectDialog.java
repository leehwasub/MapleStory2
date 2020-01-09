package dialog;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import character.Adventurer;
import component.MapleButton;
import utils.FontUtils;
import utils.ResourceLoader;

public class KeySelectDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private static final int DIALOG_WIDTH = 350;
	private static final int DIALOG_HEIGHT = 200;
	private ImageIcon quickQButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickQButtonBasic.png"));
	private ImageIcon quickQButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickQButtonEntered.png"));
	private ImageIcon quickWButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickWButtonBasic.png"));
	private ImageIcon quickWButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickWButtonEntered.png"));
	private ImageIcon quickEButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickEButtonBasic.png"));
	private ImageIcon quickEButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickEButtonEntered.png"));
	private ImageIcon quickRButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickRButtonBasic.png"));
	private ImageIcon quickRButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "quickRButtonEntered.png"));
	private int calWidth;
	private FontMetrics fm;
	private ArrayList<Adventurer> adventurers = new ArrayList<>();
	private MapleButton[] button = new MapleButton[4];
	private ImageIcon[] basicIcon = { this.quickQButtonBasicImage, this.quickWButtonBasicImage,
			this.quickEButtonBasicImage, this.quickRButtonBasicImage };
	private ImageIcon[] enteredIcon = { this.quickQButtonEnteredImage, this.quickWButtonEnteredImage,
			this.quickEButtonEnteredImage, this.quickRButtonEnteredImage };
	private int returnIndex = -1;

	public KeySelectDialog() {
		setTitle("key select");
		setSize(350, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setLayout(null);
		this.fm = getFontMetrics(FontUtils.generalFont);
		int width = this.fm.stringWidth("키를 선택해주세요.");
		int height = this.fm.getHeight();
		JLabel label = new JLabel("키를 선택해주세요.");
		label.setFont(FontUtils.generalFont);
		label.setBounds((350 - width) / 2, 10, width, height);
		getContentPane().add(label);
		for (int i = 0; i < 4; i++) {
			final int index = i;
			this.button[i] = new MapleButton(this.basicIcon[i], this.enteredIcon[i]);
			this.button[i].setBounds(40 + 70 * i, 60, 50, 50);
			this.button[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					KeySelectDialog.this.returnIndex = index;
					KeySelectDialog.this.end();
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

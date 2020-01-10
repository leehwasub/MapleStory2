package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import maplestory.Player;
import utils.FontUtils;

public class InventorySkillPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Player player;

	public InventorySkillPanel(Player player) {
		setVisible(false);
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		this.player = player;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		screenDraw((Graphics2D)g);
	}

	public void screenDraw(Graphics2D g) {
		rendering(g);
		g.setFont(FontUtils.generalFont);
		g.setColor(Color.yellow);
		g.drawString("스킬포인트", 40, 40);
		g.setColor(Color.WHITE);
		g.drawString(""+player.getMainAdventurer().getSkillPoint(), 140, 40);
		if(player.getMainAdventurer().getCareerLevel() >= 0) {
			g.setFont(FontUtils.MID_FONT);
			g.setColor(Color.YELLOW);
			g.drawString("1차 스킬", 220, 45);
			g.setFont(FontUtils.generalFont);
			g.setColor(Color.CYAN);
			g.drawString("hp 증가", 320, 45);
			g.drawString("아이언 바디", 320, 145);
			g.drawString("파워 스트라이크", 320, 245);
			g.setColor(Color.WHITE);
			//g.drawString(player.getHpIncreasingSkillPoint() +"/10", 320, 282);
			//g.drawString(player.getIronBodySkillPoint() +"/20", 320, 382);
		}
	}
	

	private void rendering(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
	
}

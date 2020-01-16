package dialog;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import component.MapleButton;
import skill.Skill;
import utils.FontUtils;
import utils.ResourceLoader;

import renderer.*;

public class SkillDetailDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private static final int DIALOG_WIDTH = 500;
	private static final int DIALOG_HEIGHT = 660;
	private ImageIcon backButtonBasicImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(
			ResourceLoader.getImage("componentImage", "backButtonEntered.png"));
	private MapleButton backButton = new MapleButton(backButtonBasicImage, backButtonEnteredImage);
	JTable jTable;
	private JScrollPane scrollPane;
	private Skill skill;
	private DefaultTableModel model;
	private Vector<String> columnName;

	public SkillDetailDialog(Skill skill) {
		this.skill = skill;
		setTitle("skill detail");
		setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setLayout(null);
		
		for(int i = 0; i < skill.getMaxPoint(); i++) {
			
		}
		columnName = new Vector<String>();
		columnName.add("Point");
		columnName.add("Detail");
		
		model = new DefaultTableModel(columnName, 0);
		
		jTable = new JTable(model);
		jTable.setDefaultRenderer(Object.class, new MultiLineCellRenderer());
		//jTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		jTable.setFont(FontUtils.VERY_SMALL_FONT);
		jTable.setEnabled(false);
		this.jTable.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.jTable.setBounds(20, 20, 460, 530);
		jTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		jTable.getColumnModel().getColumn(1).setPreferredWidth(400);
		jTable.setRowHeight(20);
		add(jTable);
		
		this.scrollPane = new JScrollPane(this.jTable);
		this.scrollPane.setBounds(20, 20, 460, 530);
		add(scrollPane);
		
		backButton.setBounds(420, 560, 60, 60);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				end();
			}
		});
		add(backButton);
		
		addSkillData();
	}
	
	public int getLine(String detail) {
		int preIndex = 0;
		int width = 0;
		int line = 1;
		for (int i = 0; i < detail.length(); i++) {
			FontMetrics fm = jTable.getFontMetrics(FontUtils.SMALL_FONT);
			width = fm.stringWidth(detail.substring(preIndex, i));
			if (width > 400) {
				preIndex = i;
				line++;
			}
		}
		return line;
	}
	
	public void addSkillData() {
		for(int i = 0; i < skill.getMaxPoint(); i++) {
			Vector<String> rowData = new Vector<String>();
			rowData.add((i+1)+"");
			int line = getLine(skill.getEffectDetail(i+1));
			rowData.add(skill.getEffectDetail(i+1));
			model.addRow(rowData);
			jTable.setRowHeight(i, (line * jTable.getFontMetrics(FontUtils.SMALL_FONT).getHeight()));
		}
	}

	public void end() {
		dispose();
	}
	
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
	}
	
}

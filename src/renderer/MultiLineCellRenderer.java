package renderer;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

import utils.ColorUtils;

public class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
	 
	private static final long serialVersionUID = 1L;
	
	private int curPoint;

	public MultiLineCellRenderer(int curPoint) {
		this.curPoint = curPoint;
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
        setEditable(false); //this line doesn't seem to be doing anything
    }
 
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        }
        else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        
        if(curPoint == row + 1) {
        	setForeground(ColorUtils.SEA);
        }
        setFont(table.getFont());
        if (hasFocus) {
            setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
            if (table.isCellEditable(row, column)) {
                setForeground(UIManager.getColor("Table.focusCellForeground"));
                setBackground(UIManager.getColor("Table.focusCellBackground"));
            }
        }
        else {
            setBorder(new EmptyBorder(1, 2, 1, 2));
        }
        setText((value == null) ? "" : value.toString());
        setEditable(false); //this line doesn't seem to be doing anything
        return this;
    }
}
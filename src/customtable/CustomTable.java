package customtable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author KRISNA
 */
public class CustomTable extends JTable {

//    private CustomTableHeader header;
//    private CustomTableCell cell;
    public CustomTable() {
//        header = new CustomTableHeader();
//        cell = new CustomTableCell();
        getTableHeader().setDefaultRenderer(new CustomTableHeader());
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, new CustomTableCell());
        setRowHeight(30);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new customTable.ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(82, 82, 82));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(255, 255, 255));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2));
    }

    private class CustomTableHeader extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            com.setBackground(new Color(82, 82, 82));
            com.setForeground(new Color(255, 255, 255));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            return com;
        }

    }

    private class CustomTableCell extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isCellSelected(row, column)) {
                if (row % 2 == 0) {
                    com.setBackground(new Color(224, 52, 52));
                } else {
                    com.setBackground(new Color(224, 52, 52));
                }
            } else {
                if (row % 2 == 0) {
                    com.setBackground(new Color(244, 244, 244));
                } else {
                    com.setBackground(new Color(255, 255, 255));
                }
            }
            com.setForeground(new Color(0, 0, 0));
            setBorder(new EmptyBorder(0, 5, 0, 5));
//            if (alignment.containsKey(column)) {
//                setHorizontalAlignment(alignment.get(column));
//            } else {
//                setHorizontalAlignment(JLabel.LEFT);
//            }
            return com;
        }

    }
}

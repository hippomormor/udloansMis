package udloansmis;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author hippomormor
 */
public class CustomCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value == null || value.toString().equals("")) {
            return c;
        }
        if (column == 5 && value.toString().equals("0") )
            c.setForeground(Color.orange);
        else if (column == 5 && Integer.parseInt(value.toString()) < 0)
            c.setForeground(Color.red);   
        else
            c.setForeground(Color.black);
        return c;

    }
}

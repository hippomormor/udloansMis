
package udloansmis;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Christian Genter
 */
public class UdloansMis_CellRenderer extends DefaultTableCellRenderer {

    private final Color evenColor = Color.WHITE;
    private final Color oddColor = new Color(242, 242, 242);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Set even row to white & odd row to grey
        if (row % 2 == 0)
            c.setBackground(evenColor);
        else
            c.setBackground(oddColor);
        
        // If table is not empty..
        if (!(value == null || value.toString().equals(""))) {
            
            // Set colors dependent on delivery-date value
            if (column == 5 && value.toString().equals("0"))
                c.setBackground(new Color(250, 218, 100));
            else if (column == 5 && Integer.parseInt(value.toString()) < 0) 
                c.setBackground(new Color(244, 128, 110));      
            else if (column == 5)
                c.setBackground(new Color(184, 222, 133));
            return c;
        }

        return c;

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TurisGym;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author turis
 */
public class MembershipStatusRenderer extends DefaultTableCellRenderer {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        try {
            String endDateStr = table.getModel().getValueAt(row, 3).toString(); // Assuming end date is in column index 3
            Date endDate = formatter.parse(endDateStr);
            Date currentDate = new Date();
            if (endDate.before(currentDate)) {
                setBackground(Color.RED); // Past end date
            } else {
                setBackground(Color.GREEN); // Active membership
            }
        } catch (Exception e) {
            setBackground(Color.WHITE); // Default background color on parsing error
        }

        return this;
    }
}

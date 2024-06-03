/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TurisGym;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author turis
 */
class DateStatusRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Default styling
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Only change background if not selected, to maintain selection visibility
        if (!isSelected) {
            Date endDate = null;
            try {
                endDate = (Date) table.getModel().getValueAt(row, 3); // Ensure this is the right column index for EndPeriod
            } catch (Exception e) {
                System.err.println("Error parsing date: " + e.getMessage());
            }
            
            Date today = new Date();
            if (endDate != null && endDate.before(today)) {
                c.setBackground(Color.RED); // Training has ended
            } else if (endDate != null && !endDate.before(today)) {
                c.setBackground(Color.GREEN); // Training is active
            }
        } else {
            c.setBackground(table.getSelectionBackground()); // Keeps the selection highlight visible
        }

        return c;
    }
}
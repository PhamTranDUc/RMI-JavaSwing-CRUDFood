/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Image;

/**
 *
 * @author phamduc
 */
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class ImageRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Image) {
            // Nếu giá trị trong ô là hình ảnh, hiển thị hình ảnh
            ImageIcon icon = new ImageIcon((Image) value);
            setIcon(icon);
            setText("");
        } else {
            // Nếu không phải hình ảnh, hiển thị giá trị như bình thường
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
        return this;
    }
}
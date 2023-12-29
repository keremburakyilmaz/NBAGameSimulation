package Entities.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
        label.setBorder(new EmptyBorder(10, 10, 5, 10));
        label.setFont(new Font("Ariel", Font.BOLD, 16));
        label.setOpaque(true);
        label.setBackground(list.getBackground());
        label.setForeground(list.getForeground());
        return label;
    }
}

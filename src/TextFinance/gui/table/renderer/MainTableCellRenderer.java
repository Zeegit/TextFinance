package TextFinance.gui.table.renderer;

import TextFinance.model.Account;
import TextFinance.model.Currency;
import TextFinance.saveload.SaveData;
import TextFinance.settings.Format;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MainTableCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setBorder(noFocusBorder);
        setHorizontalAlignment(SwingConstants.CENTER);
        return this;
    }
    
}

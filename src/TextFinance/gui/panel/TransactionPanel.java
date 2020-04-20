package TextFinance.gui.panel;

import TextFinance.gui.MainFrame;
import TextFinance.gui.dialog.TransactionAddEditDialog;
import TextFinance.gui.handler.FunctionsHandler;
import TextFinance.gui.table.TransactionTableData;
import TextFinance.gui.toolbar.FunctionsToolBar;
import TextFinance.settings.Style;

import javax.swing.*;

public class TransactionPanel extends RightPanel {
    
    public TransactionPanel(MainFrame frame) {
        super(frame, new TransactionTableData(new FunctionsHandler(frame, new TransactionAddEditDialog(frame))),
                "TRANSACTIONS", Style.ICON_PANEL_TRANSACTIONS,
                new JPanel[] {new FunctionsToolBar(new FunctionsHandler(frame, new TransactionAddEditDialog(frame))), new FilterPanel(frame)});
    }
    
}

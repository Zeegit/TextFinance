package TextFinance.gui.panel;

import TextFinance.gui.MainFrame;
import TextFinance.gui.dialog.TransactionAddEditDialog;
import TextFinance.gui.handler.FunctionsHandler;
import TextFinance.gui.table.TransactionTableData;
import TextFinance.settings.Settings;
import TextFinance.settings.Style;

public class OverviewPanel extends RightPanel {
    
    public OverviewPanel(MainFrame frame) {
        super(frame,
                new TransactionTableData(new FunctionsHandler(frame, new TransactionAddEditDialog(frame)), Settings.COUNT_OVERVIEW_ROWS),
                "LAST_TRANSACTIONS", Style.ICON_PANEL_OVERVIEW);
    }
    
}

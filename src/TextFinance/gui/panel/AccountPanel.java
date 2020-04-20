package TextFinance.gui.panel;

import TextFinance.gui.MainFrame;
import TextFinance.gui.dialog.AccountAddEditDialog;
import TextFinance.gui.handler.FunctionsHandler;
import TextFinance.gui.table.AccountTableData;
import TextFinance.gui.toolbar.FunctionsToolBar;
import TextFinance.settings.Style;

public class AccountPanel extends RightPanel {
    
    public AccountPanel(MainFrame frame) {
        super(frame, new AccountTableData(new FunctionsHandler(frame, new AccountAddEditDialog(frame))),
                "ACCOUNTS", Style.ICON_PANEL_ACCOUNTS,
                new FunctionsToolBar(new FunctionsHandler(frame, new AccountAddEditDialog(frame))));
    }
    
}

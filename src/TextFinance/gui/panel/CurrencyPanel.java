package TextFinance.gui.panel;

import TextFinance.gui.MainFrame;
import TextFinance.gui.dialog.CurrencyAddEditDialog;
import TextFinance.gui.handler.FunctionsHandler;
import TextFinance.gui.table.CurrencyTableData;
import TextFinance.gui.toolbar.FunctionsToolBar;
import TextFinance.settings.Style;

public class CurrencyPanel extends RightPanel {
    
    public CurrencyPanel(MainFrame frame) {
        super(frame, new CurrencyTableData(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))),
                "CURRENCIES", Style.ICON_PANEL_CURRENCIES,
                new FunctionsToolBar(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))));
    }
    
}

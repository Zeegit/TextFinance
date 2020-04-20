package TextFinance.gui.panel;


import TextFinance.gui.MainFrame;
import TextFinance.gui.dialog.TransferAddEditDialog;
import TextFinance.gui.handler.FunctionsHandler;
import TextFinance.gui.table.TransferTableData;
import TextFinance.gui.toolbar.FunctionsToolBar;
import TextFinance.settings.Style;

import javax.swing.*;

public class TransferPanel extends RightPanel {

    public TransferPanel(MainFrame frame) {
        super(frame, new TransferTableData(new FunctionsHandler(frame, new TransferAddEditDialog(frame))),
                "TRANSFERS", Style.ICON_PANEL_TRANSFERS,
                new JPanel[] {new FunctionsToolBar(new FunctionsHandler(frame, new TransferAddEditDialog(frame))), new FilterPanel(frame)});
    }

}

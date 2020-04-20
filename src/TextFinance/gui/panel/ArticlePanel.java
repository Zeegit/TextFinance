package TextFinance.gui.panel;

import TextFinance.gui.MainFrame;
import TextFinance.gui.dialog.ArticleAddEditDialog;
import TextFinance.gui.handler.FunctionsHandler;
import TextFinance.gui.table.ArticleTableData;
import TextFinance.gui.toolbar.FunctionsToolBar;
import TextFinance.settings.Style;

public class ArticlePanel extends RightPanel {
    
    public ArticlePanel(MainFrame frame) {
        super(frame, new ArticleTableData(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))),
                "ARTICLES", Style.ICON_PANEL_ARTICLES,
                new FunctionsToolBar(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))));
    }
    
}

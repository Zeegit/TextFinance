package TextFinance.gui.table;


import TextFinance.gui.handler.FunctionsHandler;
import TextFinance.gui.table.model.ArticleTableModel;
import TextFinance.settings.Style;

import javax.swing.*;

public class ArticleTableData extends TableData {
    
    private static final String[] columns = new String[]{"TITLE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE};
    
    public ArticleTableData(FunctionsHandler handler) {
        super(new ArticleTableModel(columns), handler, columns, icons);
    }
    
}

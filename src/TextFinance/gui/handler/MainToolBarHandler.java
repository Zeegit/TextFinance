package TextFinance.gui.handler;

import TextFinance.gui.MainFrame;
import TextFinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MainToolBarHandler extends MenuViewHandler {
    
    public MainToolBarHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case HandlerCode.TOOLBAR_OVERVIEW: {
                showOverviewPanel();
                break;
            }
            case HandlerCode.TOOLBAR_ACCOUNTS: {
                showAccountPanel();
                break;
            }
            case HandlerCode.TOOLBAR_ARTICLES: {
                showArticlePanel();
                break;
            }
            case HandlerCode.TOOLBAR_TRANSACTIONS: {
                showTransactionPanel();
                break;
            }
            case HandlerCode.TOOLBAR_TRANSFERS: {
                showTransferPanel();
                break;
            }
            case HandlerCode.TOOLBAR_CURRENCIES: {
                showCurrencyPanel();
                break;
            }
            case HandlerCode.TOOLBAR_STATISTICS: {
                showStatisticsPanel();
            }
            
        }
        super.actionPerformed(ae);
    }
    
}

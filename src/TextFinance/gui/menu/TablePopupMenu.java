package TextFinance.gui.menu;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import TextFinance.gui.Refresh;
import TextFinance.gui.handler.FunctionsHandler;
import TextFinance.settings.HandlerCode;
import TextFinance.settings.Style;
import TextFinance.settings.Text;

public class TablePopupMenu extends JPopupMenu implements Refresh {

    private final FunctionsHandler handler;
    
    public TablePopupMenu(FunctionsHandler handler) {
        super();
        this.handler = handler;
        init();
    }
    
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void init() {
        JMenuItem editItem = new JMenuItem(Text.get("EDIT"));
        JMenuItem deleteItem = new JMenuItem(Text.get("DELETE"));

        editItem.setActionCommand(HandlerCode.EDIT);
        deleteItem.setActionCommand(HandlerCode.DELETE);

        editItem.addActionListener(handler);
        deleteItem.addActionListener(handler);

        editItem.setIcon(Style.ICON_MENU_POPUP_EDIT);
        deleteItem.setIcon(Style.ICON_MENU_POPUP_DELETE);

        add(editItem);
        add(deleteItem);
    }
}

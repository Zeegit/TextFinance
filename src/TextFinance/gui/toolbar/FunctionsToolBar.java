package TextFinance.gui.toolbar;

import TextFinance.gui.EnableEditDelete;
import TextFinance.gui.handler.Handler;
import TextFinance.gui.menu.MainButton;
import TextFinance.settings.HandlerCode;
import TextFinance.settings.Style;
import TextFinance.settings.Text;

public final class FunctionsToolBar extends AbstractToolBar implements EnableEditDelete {

    private MainButton editButton;
    private MainButton deleteButton;

    public FunctionsToolBar(Handler handler) {
        super(Style.BORDER_FUNCTIONS_TOOLBAR, handler);
        init();
    }

    @Override
    protected void init() {
        addButton(Text.get("ADD"), Style.ICON_ADD, HandlerCode.ADD, false);
        editButton = addButton(Text.get("EDIT"), Style.ICON_EDIT, HandlerCode.EDIT, false);
        deleteButton = addButton(Text.get("DELETE"), Style.ICON_DELETE, HandlerCode.DELETE, false);
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        editButton.setEnabled(enable);
        deleteButton.setEnabled(enable);
    }

}


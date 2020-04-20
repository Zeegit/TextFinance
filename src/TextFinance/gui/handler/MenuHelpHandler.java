package TextFinance.gui.handler;

import TextFinance.gui.MainFrame;
import TextFinance.gui.dialog.AboutDialog;
import TextFinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MenuHelpHandler extends Handler {
    
    public MenuHelpHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case HandlerCode.MENU_HELP_ABOUT: {
                new AboutDialog().setVisible(true);
            }
        }
        super.actionPerformed(ae);
    }
    
}

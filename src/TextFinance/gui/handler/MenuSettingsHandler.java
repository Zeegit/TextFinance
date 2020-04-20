package TextFinance.gui.handler;

import TextFinance.gui.MainFrame;
import TextFinance.settings.HandlerCode;
import TextFinance.settings.Settings;
import TextFinance.settings.Text;

import java.awt.event.ActionEvent;

public class MenuSettingsHandler extends Handler {
    
    public MenuSettingsHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case HandlerCode.MENU_SETTINGS_LANGUAGE_RUSSIAN: {
                //Settings.setLanguage("ru");
                break;
            }
            case HandlerCode.MENU_SETTINGS_LANGUAGE_ENGLISH: {
                //Settings.setLanguage("en");
            }
        }
        Text.init();
        frame.getMenu().refresh();
        super.actionPerformed(ae);
    }
    
}

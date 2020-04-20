package TextFinance.gui.handler;

import TextFinance.exception.ModelException;
import TextFinance.gui.MainFrame;
import TextFinance.gui.dialog.AddEditDialog;
import TextFinance.gui.dialog.ConfirmDialog;
import TextFinance.gui.dialog.ErrorDialog;
import TextFinance.saveload.SaveData;
import TextFinance.settings.HandlerCode;

import javax.swing.*;
import java.awt.event.*;

public class MainWindowHandler extends WindowAdapter {
    
    @Override
    public void windowClosing(WindowEvent we) {
        if (SaveData.getInstance().isSaved()) System.exit(0);
        else {
            int result = ConfirmDialog.show((MainFrame) we.getWindow(), "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");
            if (result == JOptionPane.YES_OPTION) System.exit(0);
        }
    }
    
}


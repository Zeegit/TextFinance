package TextFinance.gui.dialog;

import TextFinance.gui.MainFrame;
import TextFinance.settings.Text;

import javax.swing.*;

public class ErrorDialog {
    public static void show(MainFrame frame, String text) {
        JOptionPane.showMessageDialog(frame, Text.get(text), Text.get("ERROR"), JOptionPane.ERROR_MESSAGE);
    }

}

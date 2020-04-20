package TextFinance.gui.handler;

import TextFinance.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Handler implements ActionListener {

    protected final MainFrame frame;

    public Handler(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.refresh();
    }
}

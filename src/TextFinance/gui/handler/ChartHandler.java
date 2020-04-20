package TextFinance.gui.handler;

import TextFinance.gui.MainFrame;
import TextFinance.gui.panel.StatisticsPanel;
import TextFinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class ChartHandler extends Handler {
    
    public ChartHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case HandlerCode.TYPE: {
                ((StatisticsPanel) frame.getRightPanel()).nextType();
            }
        }
        super.actionPerformed(ae);
    }
    
}

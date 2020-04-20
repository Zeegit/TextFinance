package TextFinance.gui.panel;

import TextFinance.gui.MainFrame;
import TextFinance.gui.handler.ChartHandler;
import TextFinance.gui.menu.MainButton;
import TextFinance.settings.HandlerCode;
import TextFinance.settings.Text;

public final class StatisticsTypePanel extends AbstractPanel {

    private final String title;

    public StatisticsTypePanel(MainFrame frame, String title) {
        super(frame);
        this.title = Text.get(title);
        init();
    }

    @Override
    protected void init() {
        MainButton type = new MainButton(title, new ChartHandler(frame), HandlerCode.TYPE);
        add(type);
    }
    
}

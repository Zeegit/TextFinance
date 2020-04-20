package TextFinance.gui;

import TextFinance.gui.dialog.AccountAddEditDialog;
import TextFinance.gui.handler.MainToolBarHandler;
import TextFinance.gui.handler.MainWindowHandler;
import TextFinance.gui.menu.MainMenu;
import TextFinance.gui.panel.*;
import TextFinance.gui.toolbar.FunctionsToolBar;
import TextFinance.gui.toolbar.MainToolBar;
import TextFinance.settings.Style;
import TextFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public final class MainFrame extends JFrame implements Refresh {

    private final GridBagConstraints constraints;
    private final MainMenu mb;
    private final LeftPanel leftPanel;
    private RightPanel rightPanel;
    private final MainToolBar tb;

    public MainFrame() {
        super(Text.get("PROGRAMM_NAME"));

        setResizable(false);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        mb = new MainMenu(this);
        setJMenuBar(mb);

        setLayout(new GridBagLayout());

        constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        tb = new MainToolBar(new MainToolBarHandler(this));
        add(tb, constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;

        leftPanel = new LeftPanel(this);
        add(leftPanel, constraints);

        setRightPanel(new OverviewPanel(this));

        pack();
        setLocationRelativeTo(null);

        addWindowListener(new MainWindowHandler());
    }

    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        tb.refresh();
        leftPanel.refresh();
        rightPanel.refresh();
        pack();
    }

    public MainMenu getMenu() {
        return mb;
    }

    public void setRightPanel(RightPanel panel) {
        if (rightPanel != null) remove(rightPanel);
        constraints.gridy = 1;
        constraints.gridx = 1;
        rightPanel = panel;
        panel.setBorder(Style.BORDER_PANEL);
        add(rightPanel, constraints);
        pack();
    }

    public RightPanel getRightPanel() {
        return rightPanel;
    }
}
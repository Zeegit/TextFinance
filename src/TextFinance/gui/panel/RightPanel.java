package TextFinance.gui.panel;

import TextFinance.gui.EnableEditDelete;
import TextFinance.gui.MainFrame;
import TextFinance.gui.Refresh;
import TextFinance.gui.table.TableData;
import TextFinance.gui.toolbar.AbstractToolBar;
import TextFinance.model.Statistics;
import TextFinance.saveload.SaveData;
import TextFinance.settings.Style;
import TextFinance.settings.Text;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

abstract public class RightPanel extends AbstractPanel {
    
    protected TableData td;
    
    private String title;
    private ImageIcon icon;
    private JPanel[] panels;
    
    public RightPanel(MainFrame frame, TableData td, String title, ImageIcon icon, JPanel[] panels) {
        super(frame);
        this.td = td;
        this.title = title;
        this.icon = icon;
        this.panels = panels;
        init();
    }
    
    public RightPanel(MainFrame frame, TableData td, String title, ImageIcon icon, AbstractToolBar tb) {
        this(frame, td, title, icon, new JPanel[]{tb});
    }
    
    public RightPanel(MainFrame frame, TableData td, String title, ImageIcon icon) {
        this(frame, td, title, icon, new JPanel[]{});
    }
    
    protected void setPanels(JPanel[] panels) {
        this.panels = panels;
    }
    
    @Override
    public void refresh() {
        super.refresh();
        if (td != null) td.refresh();
        for (JPanel panel : panels) {
            if (panel instanceof Refresh) ((Refresh) panel).refresh();
        }
    }
    
    private void enableEditDelete() {
        for (JPanel panel : panels) {
            if (panel instanceof EnableEditDelete) ((EnableEditDelete) panel).setEnableEditDelete(false);
        }
        frame.getMenu().setEnableEditDelete(false);
        
        if (td != null) {
            if (td.getSelectedRow() != -1) {
                for (JPanel panel : panels) {
                    if (panel instanceof EnableEditDelete) ((EnableEditDelete) panel).setEnableEditDelete(true);
                }
                frame.getMenu().setEnableEditDelete(true);
            }
        }
    }
    
    @Override
    protected final void init() {
        enableEditDelete();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel header = new JLabel(Text.get(title));
        header.setFont(Style.FONT_LABEL_HEADER);
        header.setIcon(icon);
        header.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        add(header);
        
        if (panels.length == 0) add(Box.createVerticalStrut(Style.PADDING_PANEL_EMPTY));
        
        for (JPanel panel : panels) {
            add(panel);
            add(Box.createVerticalStrut(Style.PADDING_PANEL));
        }
        
        if (td != null) {
            JScrollPane scroll = new JScrollPane(td);
            add(scroll);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            ListSelectionModel selectionModel = td.getSelectionModel();
            selectionModel.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    enableEditDelete();
                }
            });
        }
        
    }

    public TableData getTableData() {
        return td;
    }
    
}

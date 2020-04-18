package TextFinance.model;

import TextFinance.saveload.SaveData;

abstract public class Common {
    public String getValueForComboBox() {
        return null;
    }
    public void postAdd(SaveData sd) {}
    public void postEdit(SaveData sd) {}
    public void postDelete(SaveData sd) {}
}

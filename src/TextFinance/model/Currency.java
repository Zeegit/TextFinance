package TextFinance.model;

public class Currency {
    private String title;
    private String code;
    private double rate;
    private boolean isOn;
    private boolean isBase;

    public Currency() {
    }

    public Currency(String title, String code, double rate, boolean isOn, boolean isBase) {
        this.title = title;
        this.code = code;
        this.rate = rate;
        this.isOn = isOn;
        this.isBase = isBase;
    }
}

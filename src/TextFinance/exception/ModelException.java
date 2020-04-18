package TextFinance.exception;

import TextFinance.settings.Text;

public class ModelException extends Exception {
    public static final int TITLE_EMPTY = 1;
    public static final int CODE_EMPTY = 2;
    public static final int RATE_INCORRECT = 3;
    public static final int CURRENCY_EMPTY = 4;
    public static final int ACCOUNT_EMPTY = 5;
    public static final int ARTICLE_EMPTY = 6;
    public static final int AMOUNT_FORMAT = 7;
    public static final int IS_EXISTS = 8;

    private final int code;

    public ModelException(int code) {
        this.code = code;
    }

    public String getMessage() {
        switch (code) {
            case TITLE_EMPTY:
                return Text.get("ERROR_TITLE_EMPTY");
        }
        return "";
    }
}

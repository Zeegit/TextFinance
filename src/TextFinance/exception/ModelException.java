package pf.exception;

import pf.settings.Test;

public class ModelException extends Exception {
    public static final int TITLE_EMPTY = 1;

    private final int code;

    public ModelException(int code) {
        this.code = code;
    }

    public String getMessage () {
        switch (code) {
            case TITLE_EMPTY:
                return Test.get("ERROR_TITLE_EMPTY");
        }
        return "";
    }
}

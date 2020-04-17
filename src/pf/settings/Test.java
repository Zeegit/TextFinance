package pf.settings;

import java.util.HashMap;

final public class Test {
    private static final HashMap<String, String> data = new HashMap<>();

    public static String get(String key) {
        return data.get(key);
    }

    public static String[] getMonths() {
        String[] months = new String[12];
        months[0] =  data.get("JAN");
        return months;
    }

    public static void init() {
        data.put("PROGRAM_NAME", "Бух");
        data.put("MENU_FILE", "Файл");

        data.put("JAN", "Январь");

        data.put("ERROR_TITLE_EMPTY", "Вы ен ввели название!");
    }

}

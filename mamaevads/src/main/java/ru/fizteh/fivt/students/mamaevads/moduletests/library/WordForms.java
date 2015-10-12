package ru.fizteh.fivt.students.mamaevads.moduletests.library;

public class WordForms {
    public static final String[] HOUR_FORMS = {"час", "часа", "часов"};
    public static final String[] MINUTES_FORMS = {"минуту", "минуты", "минут"};
    public static final String[] DAYS_FORMS = {"день", "дня", "дней"};
    public static final String[] RE_FORMS = {"ретвит", "ретвита", "ретвитов"};

    public static final int ONE = 1;
    public static final int TEN = 10;
    public static final int TWO_TEN = 20;
    public static final int TEN_ONE = 11;
    public static final int TWO = 2;
    public static final int TEN_TEN = 100;
    public static final int TWO_TWO = 4;

    static String getForm(long number, String[] words) {
        if (number == ONE || (number > TWO_TEN && number % TEN == ONE && number % TEN_TEN != TEN_ONE)) {
            return words[0];
        } else if ((number % TEN_TEN < TEN || number % TEN_TEN > TWO_TEN)
                && number % TEN >= TWO && number % TEN <= TWO_TWO) {
            return words[1];
        } else {
            return words[2];
        }
    }
}

package ru.fizteh.fivt.students.mamaevads.supertests;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

//dontreadme
//tweet.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(
// LocalDateTime curDate = LocalDateTime.now();

public class TimeHandler {
    public static final int TWO_MINUTES = 120;

    static String getType(LocalDateTime myDayTime, LocalDateTime nowDayTime) {
        LocalDateTime tweetDate = myDayTime;
        LocalDateTime curDate = nowDayTime;
        if (ChronoUnit.SECONDS.between(tweetDate, curDate) < TWO_MINUTES) {
            return "только что";
        } else if (ChronoUnit.HOURS.between(tweetDate, curDate) == 0) {
            long between = ChronoUnit.MINUTES.between(tweetDate, curDate);
            return between + " " + WordForms.getForm(between, WordForms.MINUTES_FORMS) + " назад";
        } else if (ChronoUnit.DAYS.between(tweetDate, curDate) <= 1) {
            if (tweetDate.getDayOfMonth() == nowDayTime.getDayOfMonth()) {
                long between = ChronoUnit.HOURS.between(tweetDate, curDate);
                return between + " " + WordForms.getForm(between, WordForms.HOUR_FORMS) + " назад";
            } else {
                return "вчера";
            }
        } else {
            long between = ChronoUnit.DAYS.between(tweetDate, curDate);
            return between + " " + WordForms.getForm(between, WordForms.DAYS_FORMS) + " назад";
        }
    }
}



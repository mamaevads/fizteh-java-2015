package ru.fizteh.fivt.students.mamaevads.moduletests.library;
import twitter4j.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class MakeMassage {

    static String getName(Status st) {
        return "@" + st.getUser().getName() + " : ";
    }
    static String getRetweets(Status st) {
        int retweet = st.getRetweetCount();
        if (retweet == 0) {
            return "";
        } else {
            return "(" + retweet + WordForms.getForm(retweet, WordForms.RE_FORMS) + ")";
        }
    }
    static String getMessage(Status st) {
        String text = st.getText();
        if (st.isRetweet()) {
            text = " ретвитнул " + st.getRetweetedStatus().getUser().getScreenName() + " : ";
        }
        return text;
    }

    static String getTime(Status st) {
        LocalDateTime tweetDate = st.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime curDate = LocalDateTime.now();
        return TimeHandler.getType(tweetDate, curDate);
    }

    static String info(Status st) throws LostInformationException {
        String message = getTime(st) + " " + getName(st) + getMessage(st) + " " + getRetweets(st) + "\n";
        message += "-----------------------------------------------------------------------------------";
        return message;
    }
}

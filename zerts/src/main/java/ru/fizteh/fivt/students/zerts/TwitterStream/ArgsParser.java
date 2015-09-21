package ru.fizteh.fivt.students.zerts.TwitterStream;
    import com.beust.jcommander.Parameter;

public class ArgsParser {
    //public int argMode = new int(0);
    @Parameter(names = {"-s", "--stream"}, description = "stream output")
    private boolean streamMode;
    @Parameter(names = {"-q", "--query"}, description = "query output")
    private String query;
    @Parameter(names = {"-p", "--place"}, description = "place output")
    private String place;
    @Parameter(names = "--hideRetweets", description = "no retweets output")
    private boolean noRetweetMode;
    @Parameter(names = {"-l", "--limit"}, description = "limited output")
    private int numberOfTweets;
    @Parameter(names = {"-h", "--help"}, description = "help output")
    private boolean helpMode;

    public final boolean isStreamMode() {
        return streamMode;
    }
    public final String getQuery() {
        return query;
    }
    public final String getPlace() {
        return place;
    }
    public final boolean isNoRetweetMode() {
        return noRetweetMode;
    }
    public final int getNumberOfTweets() {
        return numberOfTweets;
    }
    public final boolean isHelpMode() {
        return helpMode;
    }
}

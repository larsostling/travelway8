package app.travelway.jayway.com.travelwayadmin.domain;

/**
 * Created by mattias on 2015-10-02.
 */
public class EventInfo {

    public final String title;
    public final String info;
    public final String time;
    public final boolean isParticipating;


    public EventInfo(String title, String info, String time, boolean isParticipating) {
        this.title = title;
        this.info = info;
        this.time = time;
        this.isParticipating = isParticipating;
    }
}

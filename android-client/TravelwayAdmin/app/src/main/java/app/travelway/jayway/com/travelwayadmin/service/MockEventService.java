package app.travelway.jayway.com.travelwayadmin.service;

import android.os.SystemClock;

/**
 * Created by mattias on 2015-10-02.
 */
public class MockEventService implements EventService{
    @Override
    public void updateParticipation(boolean participate) {
        SystemClock.sleep(1000);
    }
}

package app.travelway.jayway.com.travelwayadmin;

/**
 * Created by mattias on 2015-10-02.
 */;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new EventListFragment();
            case 1:
                // Games fragment activity
                return new TravelwayMapFragment();
            case 2:
                // Movies fragment activity
                return new InformationFragment();
            case 3:
                // Movies fragment activity
                return new WebFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 4;
    }

}

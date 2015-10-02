package app.travelway.jayway.com.travelwayadmin.domain;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.AbsListView;

/**
 * Created by mattias on 2015-10-02.
 */
public class Utils {

    public static View getSpaceViewWithSizeInDp(Context context, int sizeInDp){
        View space = new View(context);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(1, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, context.getResources().getDisplayMetrics()));
        space.setLayoutParams(params);
        return space;
    }
}

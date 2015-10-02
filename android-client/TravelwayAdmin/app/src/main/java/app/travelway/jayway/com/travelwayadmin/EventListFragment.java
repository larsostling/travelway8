package app.travelway.jayway.com.travelwayadmin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.travelway.jayway.com.travelwayadmin.domain.EventInfo;

/**
 * Created by mattias on 2015-10-02.
 */
public class EventListFragment extends Fragment {

    ListView eventListView;

    List<EventInfo> eventList;

    EventAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_event_list, container, false);

        eventListView = (ListView) rootView.findViewById(R.id.event_list_view);

        adapter = new EventAdapter();

        initData();

        setupViews();

        return rootView;
    }

    private void setupViews() {
        eventListView.setAdapter(adapter);
    }

    private void initData() {
        eventList = new ArrayList<>();
        eventList.add(new EventInfo("Food at the Restaurant", "Lets grab a nice bite at the famous place", "12:45"));
        eventList.add(new EventInfo("See a Tapir", "The Zoo", "16:20"));
        eventList.add(new EventInfo("Picasso", "Da Museum Fantastico", "17:00"));
        eventList.add(new EventInfo("Barcrawl", "Get drunk", "20:00"));
        eventList.add(new EventInfo("Food at McDonalds", "Fastfood at it's worst", "21:30"));
    }

    private class EventAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return eventList.size();
        }

        @Override
        public Object getItem(int position) {
            return eventList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            ViewHolder holder = null;

            if(convertView == null) {
                view = getActivity().getLayoutInflater().inflate(R.layout.event_list_item, null);
                holder = new ViewHolder();
                holder.title = (TextView) view.findViewById(R.id.event_title);
                holder.info = (TextView) view.findViewById(R.id.event_info);
                holder.time = (TextView) view.findViewById(R.id.event_time);
                view.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
                view = convertView;
            }

            holder.title.setText(eventList.get(position).title);
            holder.info.setText(eventList.get(position).info);
            holder.time.setText(eventList.get(position).time);

            return view;
        }
    }

    public static class ViewHolder{
        public TextView title;
        public TextView info;
        public TextView time;
    }
}


package app.travelway.jayway.com.travelwayadmin;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.travelway.jayway.com.travelwayadmin.domain.EventInfo;
import app.travelway.jayway.com.travelwayadmin.domain.Utils;

/**
 * Created by mattias on 2015-10-02.
 */
public class EventListFragment extends Fragment {

    ListView eventListView;

    List<EventInfo> eventList;

    EventAdapter adapter;

    int selectedPosition;

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
        eventListView.addFooterView(Utils.getSpaceViewWithSizeInDp(getActivity(), 20));
        eventListView.addHeaderView(Utils.getSpaceViewWithSizeInDp(getActivity(), 20));
        eventListView.setAdapter(adapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initData() {
        eventList = new ArrayList<>();
        eventList.add(new EventInfo("Food at the Restaurant", "Lets grab a nice bite at the famous place", "12:45", false));
        eventList.add(new EventInfo("See a Tapir", "The Zoo", "16:20", true));
        eventList.add(new EventInfo("Picasso", "Da Museum Fantastico", "17:00", false));
        eventList.add(new EventInfo("Barcrawl", "Get drunk", "20:00", false));
        eventList.add(new EventInfo("Food at McDonalds", "Fastfood at it's worst", "21:30", true));
    }

    private class EventAdapter extends BaseAdapter {

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
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view;
            ViewHolder holder = null;

            if (convertView == null) {
                view = getActivity().getLayoutInflater().inflate(R.layout.event_list_item, null);
                holder = new ViewHolder();
                holder.title = (TextView) view.findViewById(R.id.event_title);
                holder.info = (TextView) view.findViewById(R.id.event_info);
                holder.time = (TextView) view.findViewById(R.id.event_time);
                holder.participantsLayout = (LinearLayout) view.findViewById(R.id.event_info_participate_layout);
                holder.participateIndicator = (TextView) view.findViewById(R.id.event_item_active_indicator);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
                view = convertView;
            }

            //+1 since we use header view
            holder.participantsLayout.setVisibility(position + 1 == selectedPosition ? View.VISIBLE : View.GONE);

            holder.title.setText(eventList.get(position).title);
            holder.info.setText(eventList.get(position).info);
            holder.time.setText(eventList.get(position).time);

            holder.participateIndicator.setBackgroundColor(eventList.get(position).isParticipating ? getResources().getColor(R.color.event_active_on) : getResources().getColor(R.color.event_active_off));
            holder.participateIndicator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Updating...", Toast.LENGTH_SHORT).show();
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SystemClock.sleep(1000);
                            EventInfo eventInfo = eventList.get(position);
                            eventList.set(position, new EventInfo(eventInfo.title, eventInfo.info, eventInfo.time, !eventList.get(position).isParticipating));

                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.notifyDataSetChanged();
                                }
                            });

                        }
                    });
                    t.start();
                }
            });

            return view;
        }
    }

    public static class ViewHolder {
        public TextView title;
        public TextView info;
        public TextView time;
        public LinearLayout participantsLayout;
        public TextView participateIndicator;

    }
}


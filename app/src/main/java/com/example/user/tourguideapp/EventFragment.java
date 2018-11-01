package com.example.user.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by user on 10/25/2018.
 */

public class EventFragment extends Fragment {

    ArrayList<Event> events;

    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event, container, false);

        // create the adapter
        EventAdapter eventAdapter = new EventAdapter(getActivity(), events);

        //get the listview
        ListView eventListView = rootView.findViewById(R.id.event_list);

        //set the listview to the adapter
        eventListView.setAdapter(eventAdapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return rootView;
    }

    void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}

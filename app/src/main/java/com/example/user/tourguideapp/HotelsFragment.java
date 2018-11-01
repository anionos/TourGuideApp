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
 * Created by user on 11/1/2018.
 */

public class HotelsFragment extends Fragment {
    ArrayList<Hotel> hotels;

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hotel, container, false);

        // create the adapter
        HotelAdapter hotelAdapter = new HotelAdapter(getActivity(), hotels);

        //get the listview
        ListView hotelListView = rootView.findViewById(R.id.hotel_list);

        //set the listview to the adapter
        hotelListView.setAdapter(hotelAdapter);

        hotelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return rootView;
    }

    void setHotels(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }
}

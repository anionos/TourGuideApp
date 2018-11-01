package com.example.user.tourguideapp;

import android.os.Bundle;
import android.os.Parcelable;
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

public class RestaurantFragment extends Fragment {


    ArrayList<Restaurants> restaurants;

    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_restaurant, container, false);

        // Create a list of events
        // create the adapter
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(getActivity(), restaurants);

        //get the listview
        ListView restaurantListView = rootView.findViewById(R.id.restaurant_list);

        //set the listview to the adapter
        restaurantListView.setAdapter(restaurantAdapter);

        restaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return rootView;
    }

    void setRestaurants(ArrayList<Restaurants> restaurants) {
        this.restaurants = restaurants;
    }

}

package com.example.user.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by user on 10/25/2018.
 */

public class AttractionsFragment extends Fragment {

    ArrayList<Attractions> attractions;

    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_museum, container, false);

        // create the adapter
        AttractionsAdapter attractionsAdapter = new AttractionsAdapter(getActivity(), attractions);

        //get the GridView
        GridView attractionGrid = rootView.findViewById(R.id.museum_grid);

        //set the listview to the adapter
        attractionGrid.setAdapter(attractionsAdapter);

        attractionGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return rootView;
    }

    void setAttractions(ArrayList<Attractions> attractions) {
        this.attractions = attractions;
    }
}

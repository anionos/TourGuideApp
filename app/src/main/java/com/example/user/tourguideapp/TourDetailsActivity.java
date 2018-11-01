package com.example.user.tourguideapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.parceler.Parcels;

import java.util.ArrayList;

public class TourDetailsActivity extends AppCompatActivity {

    public String tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_details);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);



        Intent intent = getIntent();

        ArrayList<Event> events = Parcels.unwrap(intent.getParcelableExtra("events"));
        ArrayList<Restaurants> restaurants = Parcels.unwrap(intent.getParcelableExtra("restaurants"));
        ArrayList<Attractions> attractions = Parcels.unwrap(intent.getParcelableExtra("attractions"));


        // Create an adapter that knows which fragment should be shown on each page
        TourAdapter adapter = new TourAdapter(this, getSupportFragmentManager(), events, restaurants, attractions);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);



    }
}

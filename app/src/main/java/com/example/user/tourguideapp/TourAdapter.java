package com.example.user.tourguideapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by user on 10/25/2018.
 */

public class TourAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;
    ArrayList<Event> events;
    ArrayList<Restaurants> restaurants;
    ArrayList<Attractions> attractions;

    public TourAdapter(Context context, FragmentManager fm, ArrayList<Event> events, ArrayList<Restaurants> restaurants, ArrayList<Attractions> attractions) {
        super(fm);
        mContext = context;
        this.events = events;
        this.restaurants = restaurants;
        this.attractions = attractions;

    }
    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            EventFragment eventFragment = new EventFragment();
            eventFragment.setEvents(events);

            return eventFragment;
        } else if (position == 1) {
            AttractionsFragment attractionsFragment = new AttractionsFragment();
            attractionsFragment.setAttractions(attractions);
            return attractionsFragment;
        } else {
            RestaurantFragment restaurantFragment = new RestaurantFragment();
            restaurantFragment.setRestaurants(restaurants);
            return restaurantFragment;
        }
    }
    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.event);
        } else if (position == 1) {
            return mContext.getString(R.string.attractions);
        } else {
            return mContext.getString(R.string.restaurant);
        }
    }

}

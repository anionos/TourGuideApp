package com.example.user.tourguideapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/2/2018.
 */

public class ItemFragment extends Fragment {
    private static final String POSITON = "position";
    private static final String SCALE = "scale";
    private static final String DRAWABLE_RESOURE = "resource";

    private int screenWidth;
    private int screenHeight;

    private int[] imageArray = new int[]{R.drawable.cally,
            R.drawable.abuja,
            R.drawable.lagos,
            R.drawable.abiaa, R.drawable.abeokuta};

    private String[] textArray = new String[]{getString(R.string.calabar), getString(R.string.abuja),
            getString(R.string.lagos), getString(R.string.abia), getString(R.string.abeokuta)};

    public static Fragment newInstance(MainActivity context, int pos, float scale) {
        Bundle b = new Bundle();
        b.putInt(POSITON, pos);
        b.putFloat(SCALE, scale);

        return Fragment.instantiate(context, ItemFragment.class.getName(), b);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWidthAndHeight();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        final int postion = this.getArguments().getInt(POSITON);
        float scale = this.getArguments().getFloat(SCALE);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams((screenWidth / 2 + screenWidth / 6), (screenHeight / 2 + screenHeight / 8));
        LinearLayout.LayoutParams layoutParamsLL = new LinearLayout.LayoutParams((screenWidth / 2 + screenWidth / 6), (screenHeight / 2 + screenHeight / 8));
        FrameLayout.LayoutParams layoutParamsFL = new FrameLayout.LayoutParams((screenWidth / 2 + screenWidth / 6), (screenHeight / 2 + screenHeight / 8));

        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_image, container, false);

        TextView textView = (TextView) linearLayout.findViewById(R.id.text);
        CarouselLinearLayout root = (CarouselLinearLayout) linearLayout.findViewById(R.id.root_container);
        CardView cardView = root.findViewById(R.id.parent);
        ConstraintLayout constraintLayout = cardView.findViewById(R.id.constraint_layout);
        ImageView imageView = constraintLayout.findViewById(R.id.pagerImg);

        textView.setText(textArray[postion]);

        imageView.setLayoutParams(layoutParams);
        constraintLayout.setLayoutParams(layoutParamsFL);
        cardView.setLayoutParams(layoutParamsLL);
        imageView.setImageResource(imageArray[postion]);

        //handling click event
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textArray[postion].equals(getString(R.string.calabar))) {
                    startTourDetailsActivity(getEventsInCalabar(), getAttractionsInCalabar(), getRestaurantInCalabar(),getHotelsInCalabar());
                } else if (textArray[postion].equals(getString(R.string.abuja))) {
                    startTourDetailsActivity(getEventsInAbuja(), getAttractionsInAbuja(), getRestaurantInAbuja(),getHotelsInAbuja());
                } else if (textArray[postion].equals(getString(R.string.lagos))) {
                    startTourDetailsActivity(getEventsInLagos(), getAttractionsInLagos(), getRestaurantInLagos(),getHotelsInLagos());
                } else if (textArray[postion].equals(getString(R.string.abia))) {
                    startTourDetailsActivity(getEventsInAbia(), getAttractionsInAbia(), getRestaurantInAbia(),getHotelsInAbia());
                } else {
                    startTourDetailsActivity(getEventsInAbeokuta(), getAttractionsInAbeokuta(), getRestaurantInAbeokuta(),getHotelsInAbeokuta());
                }
            }
        });

        root.setScaleBoth(scale);

        return linearLayout;
    }

    public void startTourDetailsActivity(ArrayList<Event> events, ArrayList<Attractions> attractions, ArrayList<Restaurants> restaurants, ArrayList<Hotel> hotels) {
        Intent intent = new Intent(getActivity(), TourDetailsActivity.class);
        //this adds extra data to the intent of the next activity
        intent.putExtra(getString(R.string.event), Parcels.wrap(events));
        intent.putExtra(getString(R.string.attractions), Parcels.wrap(attractions));
        intent.putExtra(getString(R.string.restaurant), Parcels.wrap(restaurants));
        intent.putExtra(getString(R.string.hotels), Parcels.wrap(hotels));
        startActivity(intent);
    }

    /**
     * Get device screen width and height
     */
    private void getWidthAndHeight() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeight = displaymetrics.heightPixels;
        screenWidth = displaymetrics.widthPixels;
    }

    public ArrayList<Event> getEventsInCalabar() {

        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.cal_date), R.drawable.cal_festival, getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.trade_day), getString(R.string.trade_date), R.drawable.cal_trade,
                getString(R.string.trade_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.cal_date), R.drawable.cal_festival,
                getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_market), getString(R.string.market_date), R.drawable.cal_markrt, getString(R.string.market_desc)));

        return events;
    }

    public ArrayList<Attractions> getAttractionsInCalabar() {
        // Create a list of events
        final ArrayList<Attractions> attractions = new ArrayList<Attractions>();
        attractions.add(new Attractions(getString(R.string.duke_garden), R.drawable.cally, R.drawable.fourpoints));
        attractions.add(new Attractions(getString(R.string.obudu_mountain), R.drawable.obudu, R.drawable.fourpoints));
        attractions.add(new Attractions(getString(R.string.cal_festival), R.drawable.cal_festival, R.drawable.fourpoints));
        attractions.add(new Attractions(getString(R.string.tinapa), R.drawable.tin, R.drawable.fourpoints));
        attractions.add(new Attractions(getString(R.string.mighty_hands), R.drawable.cally, R.drawable.fourpoints));
        attractions.add(new Attractions(getString(R.string.snake_garden), R.drawable.obudu, R.drawable.fourpoints));

        return attractions;
    }

    public ArrayList<Restaurants> getRestaurantInCalabar() {
        // Create a list of events
        final ArrayList<Restaurants> restaurants = new ArrayList<Restaurants>();
        restaurants.add(new Restaurants(R.drawable.cal_festival, getString(R.string.serve_yourself)));
        restaurants.add(new Restaurants(R.drawable.cally, getString(R.string.Delicioius)));
        restaurants.add(new Restaurants(R.drawable.tin, getString(R.string.spicy)));
        restaurants.add(new Restaurants(R.drawable.obudu, getString(R.string.mama_touch)));
        restaurants.add(new Restaurants(R.drawable.cal_markrt, getString(R.string.supreme_meal)));

        return restaurants;
    }

    public ArrayList<Hotel> getHotelsInCalabar() {
        // Create a list of events
        final ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.cal_date), R.drawable.stadium, getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival),  getString(R.string.trade_date), R.drawable.elibrary,
                getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival),  getString(R.string.trade_date), R.drawable.fourpoints,
                getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival),  getString(R.string.trade_date), R.drawable.trops, getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival),  getString(R.string.trade_date),R.drawable.elibrary, getString(R.string.cal_description)));

        return hotels;
    }

    public ArrayList<Event> getEventsInAbuja() {

        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.stadium, getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary,
                getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.fourpoints,
                getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.trops, getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary, getString(R.string.cal_description)));

        return events;
    }

    public ArrayList<Attractions> getAttractionsInAbuja() {
        // Create a list of events
        final ArrayList<Attractions> attractions = new ArrayList<Attractions>();
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.stadium, R.drawable.stadium));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.elibrary, R.drawable.elibrary));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.fourpoints, R.drawable.fourpoints));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.trops, R.drawable.trops));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.elibrary, R.drawable.stadium));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.stadium, R.drawable.fourpoints));

        return attractions;
    }

    public ArrayList<Restaurants> getRestaurantInAbuja() {
        // Create a list of events
        final ArrayList<Restaurants> restaurants = new ArrayList<Restaurants>();
        restaurants.add(new Restaurants(R.drawable.stadium,  getString(R.string.trade_date)));
        restaurants.add(new Restaurants(R.drawable.elibrary,  getString(R.string.trade_date)));
        restaurants.add(new Restaurants(R.drawable.fourpoints,  getString(R.string.trade_date)));
        restaurants.add(new Restaurants(R.drawable.trops,  getString(R.string.trade_date)));
        restaurants.add(new Restaurants(R.drawable.elibrary,  getString(R.string.trade_date)));
        restaurants.add(new Restaurants(R.drawable.stadium,  getString(R.string.trade_date)));

        return restaurants;
    }

    public ArrayList<Hotel> getHotelsInAbuja() {
        // Create a list of events
        final ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.stadium, getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary,
                getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.fourpoints,
                getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.trops, getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary, getString(R.string.cal_description)));

        return hotels;
    }

    public ArrayList<Event> getEventsInLagos() {

        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.stadium, getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary,
                getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.fourpoints,
                getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.trops, getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary, getString(R.string.cal_description)));

        return events;
    }

    public ArrayList<Attractions> getAttractionsInLagos() {
        // Create a list of events
        final ArrayList<Attractions> attractions = new ArrayList<Attractions>();
        attractions.add(new Attractions(getString(R.string.cal_festival), R.drawable.stadium, R.drawable.stadium));
        attractions.add(new Attractions(getString(R.string.cal_festival), R.drawable.elibrary, R.drawable.elibrary));
        attractions.add(new Attractions(getString(R.string.cal_festival), R.drawable.fourpoints, R.drawable.fourpoints));
        attractions.add(new Attractions(getString(R.string.cal_festival), R.drawable.trops, R.drawable.trops));
        attractions.add(new Attractions(getString(R.string.cal_festival), R.drawable.elibrary, R.drawable.stadium));
        attractions.add(new Attractions(getString(R.string.cal_festival), R.drawable.stadium, R.drawable.fourpoints));

        return attractions;
    }

    public ArrayList<Restaurants> getRestaurantInLagos() {
        // Create a list of events
        final ArrayList<Restaurants> restaurants = new ArrayList<Restaurants>();
        restaurants.add(new Restaurants(R.drawable.stadium, getString(R.string.cal_festival)));
        restaurants.add(new Restaurants(R.drawable.elibrary, getString(R.string.cal_festival)));
        restaurants.add(new Restaurants(R.drawable.fourpoints, getString(R.string.cal_festival)));
        restaurants.add(new Restaurants(R.drawable.trops, getString(R.string.cal_festival)));
        restaurants.add(new Restaurants(R.drawable.elibrary, getString(R.string.cal_festival)));
        restaurants.add(new Restaurants(R.drawable.stadium, getString(R.string.cal_festival)));

        return restaurants;
    }

    public ArrayList<Hotel> getHotelsInLagos() {
        // Create a list of events
        final ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.stadium, getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary,
                getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.fourpoints,
                getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.trops, getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary, getString(R.string.cal_description)));

        return hotels;
    }

    public ArrayList<Event> getEventsInAbia() {

        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.stadium, getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary,
                getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.fourpoints,
                getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.trops, getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary, getString(R.string.cal_description)));

        return events;
    }

    public ArrayList<Attractions> getAttractionsInAbia() {
        // Create a list of events
        final ArrayList<Attractions> attractions = new ArrayList<Attractions>();
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.stadium, R.drawable.stadium));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.elibrary, R.drawable.elibrary));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.fourpoints, R.drawable.fourpoints));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.trops, R.drawable.trops));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.elibrary, R.drawable.stadium));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.stadium, R.drawable.fourpoints));

        return attractions;
    }

    public ArrayList<Restaurants> getRestaurantInAbia() {
        // Create a list of events
        final ArrayList<Restaurants> restaurants = new ArrayList<Restaurants>();
        restaurants.add(new Restaurants(R.drawable.stadium, getString(R.string.cal_festival)));
        restaurants.add(new Restaurants(R.drawable.elibrary, getString(R.string.cal_festival)));
        restaurants.add(new Restaurants(R.drawable.fourpoints, getString(R.string.cal_festival)));
        restaurants.add(new Restaurants(R.drawable.trops, getString(R.string.cal_festival)));
        restaurants.add(new Restaurants(R.drawable.elibrary, getString(R.string.cal_festival)));
        restaurants.add(new Restaurants(R.drawable.stadium, getString(R.string.cal_festival)));

        return restaurants;
    }

    public ArrayList<Hotel> getHotelsInAbia() {
        // Create a list of events
        final ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.stadium, getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary,
                getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.fourpoints,
                getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.trops, getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary, getString(R.string.cal_description)));

        return hotels;
    }

    public ArrayList<Event> getEventsInAbeokuta() {

        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event(getString(R.string.cal_festival),getString(R.string.trade_date), R.drawable.stadium, getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary,
                getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.fourpoints,
                getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.trops, getString(R.string.cal_description)));
        events.add(new Event(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary, getString(R.string.cal_description)));

        return events;
    }

    public ArrayList<Attractions> getAttractionsInAbeokuta() {
        // Create a list of events
        final ArrayList<Attractions> attractions = new ArrayList<Attractions>();
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.stadium, R.drawable.stadium));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.elibrary, R.drawable.elibrary));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.fourpoints, R.drawable.fourpoints));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.trops, R.drawable.trops));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.elibrary, R.drawable.stadium));
        attractions.add(new Attractions( getString(R.string.trade_date), R.drawable.stadium, R.drawable.fourpoints));

        return attractions;
    }

    public ArrayList<Restaurants> getRestaurantInAbeokuta() {
        // Create a list of events
        final ArrayList<Restaurants> restaurants = new ArrayList<Restaurants>();
        restaurants.add(new Restaurants(R.drawable.stadium,  getString(R.string.trade_date)));
        restaurants.add(new Restaurants(R.drawable.elibrary,  getString(R.string.trade_date)));
        restaurants.add(new Restaurants(R.drawable.fourpoints,  getString(R.string.trade_date)));
        restaurants.add(new Restaurants(R.drawable.trops,  getString(R.string.trade_date)));
        restaurants.add(new Restaurants(R.drawable.elibrary,  getString(R.string.trade_date)));
        restaurants.add(new Restaurants(R.drawable.stadium,  getString(R.string.trade_date)));

        return restaurants;
    }

    public ArrayList<Hotel> getHotelsInAbeokuta() {
        // Create a list of events
        final ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel(getString(R.string.cal_festival),getString(R.string.trade_date), R.drawable.stadium, getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary,
                getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.fourpoints,
                getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.trops, getString(R.string.cal_description)));
        hotels.add(new Hotel(getString(R.string.cal_festival), getString(R.string.trade_date), R.drawable.elibrary, getString(R.string.cal_description)));

        return hotels;
    }
}

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

    private String[] textArray = new String[]{"Calabar", "Abuja",
            "Lagos", "Abia", "Abeokuta"};

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
                if (textArray[postion].equals("Calabar")) {
                    startTourDetailsActivity(getEventsInCalabar(), getAttractionsInCalabar(), getRestaurantInCalabar(),getHotelsInCalabar());
                } else if (textArray[postion].equals("Abuja")) {
                    startTourDetailsActivity(getEventsInAbuja(), getAttractionsInAbuja(), getRestaurantInAbuja(),getHotelsInAbuja());
                } else if (textArray[postion].equals("Lagos")) {
                    startTourDetailsActivity(getEventsInLagos(), getAttractionsInLagos(), getRestaurantInLagos(),getHotelsInLagos());
                } else if (textArray[postion].equals("Abia")) {
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
        intent.putExtra("events", Parcels.wrap(events));
        intent.putExtra("attractions", Parcels.wrap(attractions));
        intent.putExtra("restaurants", Parcels.wrap(restaurants));
        intent.putExtra("hotels", Parcels.wrap(hotels));
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
        events.add(new Event("Calabar Festival", "December 31", R.drawable.cal_festival, "This Event is awesome "));
        events.add(new Event("Trade Fair", "December 15", R.drawable.cal_trade,
                "Come lets Trade and Associate"));
        events.add(new Event("Calabar Day", "October 27", R.drawable.cal_festival,
                "Celabrating our culture"));
        events.add(new Event("Calabar Market", "September 13", R.drawable.cal_markrt, "Mingle and associate"));

        return events;
    }

    public ArrayList<Attractions> getAttractionsInCalabar() {
        // Create a list of events
        final ArrayList<Attractions> attractions = new ArrayList<Attractions>();
        attractions.add(new Attractions("Donald duke Garden", R.drawable.cally, R.drawable.fourpoints));
        attractions.add(new Attractions("Obudu Mountain Resort", R.drawable.obudu, R.drawable.fourpoints));
        attractions.add(new Attractions("Calabar Carnival", R.drawable.cal_festival, R.drawable.fourpoints));
        attractions.add(new Attractions("Tinapa", R.drawable.tin, R.drawable.fourpoints));
        attractions.add(new Attractions("Mighty Hands", R.drawable.cally, R.drawable.fourpoints));
        attractions.add(new Attractions("Snake Garden", R.drawable.obudu, R.drawable.fourpoints));

        return attractions;
    }

    public ArrayList<Restaurants> getRestaurantInCalabar() {
        // Create a list of events
        final ArrayList<Restaurants> restaurants = new ArrayList<Restaurants>();
        restaurants.add(new Restaurants(R.drawable.cal_festival, "serve Yourself"));
        restaurants.add(new Restaurants(R.drawable.cally, "Delicious"));
        restaurants.add(new Restaurants(R.drawable.tin, "Spicy"));
        restaurants.add(new Restaurants(R.drawable.obudu, "Mama's Touch"));
        restaurants.add(new Restaurants(R.drawable.cal_markrt, "Supreme Meal"));

        return restaurants;
    }

    public ArrayList<Hotel> getHotelsInCalabar() {
        // Create a list of events
        final ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel("Calabar Festival", "December, 2018", R.drawable.stadium, "This Eveny is awesome"));
        hotels.add(new Hotel("mustard yellow", "chiwiiṭә", R.drawable.elibrary,
                "great place to be"));
        hotels.add(new Hotel("dusty yellow", "ṭopiisә", R.drawable.fourpoints,
                "mighty fellowship"));
        hotels.add(new Hotel("green", "chokokki", R.drawable.trops, "great event with Emem"));
        hotels.add(new Hotel("brown", "ṭakaakki", R.drawable.elibrary, "great and mighty God"));

        return hotels;
    }

    public ArrayList<Event> getEventsInAbuja() {

        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event("Calabar Festival", "December, 2018", R.drawable.stadium, "This Eveny is awesome"));
        events.add(new Event("mustard yellow", "chiwiiṭә", R.drawable.elibrary,
                "great place to be"));
        events.add(new Event("dusty yellow", "ṭopiisә", R.drawable.fourpoints,
                "mighty fellowship"));
        events.add(new Event("green", "chokokki", R.drawable.trops, "great event with Emem"));
        events.add(new Event("brown", "ṭakaakki", R.drawable.elibrary, "great and mighty God"));

        return events;
    }

    public ArrayList<Attractions> getAttractionsInAbuja() {
        // Create a list of events
        final ArrayList<Attractions> attractions = new ArrayList<Attractions>();
        attractions.add(new Attractions("Calabar Festival", R.drawable.stadium, R.drawable.stadium));
        attractions.add(new Attractions("mustard yellow", R.drawable.elibrary, R.drawable.elibrary));
        attractions.add(new Attractions("dusty yellow", R.drawable.fourpoints, R.drawable.fourpoints));
        attractions.add(new Attractions("chokokki", R.drawable.trops, R.drawable.trops));
        attractions.add(new Attractions("ṭakaakki", R.drawable.elibrary, R.drawable.stadium));
        attractions.add(new Attractions("ṭopoppi", R.drawable.stadium, R.drawable.fourpoints));

        return attractions;
    }

    public ArrayList<Restaurants> getRestaurantInAbuja() {
        // Create a list of events
        final ArrayList<Restaurants> restaurants = new ArrayList<Restaurants>();
        restaurants.add(new Restaurants(R.drawable.stadium, "Filter"));
        restaurants.add(new Restaurants(R.drawable.elibrary, "great place to be"));
        restaurants.add(new Restaurants(R.drawable.fourpoints, "mighty fellowship"));
        restaurants.add(new Restaurants(R.drawable.trops, "great event with Emem"));
        restaurants.add(new Restaurants(R.drawable.elibrary, "great and mighty God"));
        restaurants.add(new Restaurants(R.drawable.stadium, "good lord vincent is..."));

        return restaurants;
    }

    public ArrayList<Hotel> getHotelsInAbuja() {
        // Create a list of events
        final ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel("Calabar Festival", "December, 2018", R.drawable.stadium, "This Eveny is awesome"));
        hotels.add(new Hotel("mustard yellow", "chiwiiṭә", R.drawable.elibrary,
                "great place to be"));
        hotels.add(new Hotel("dusty yellow", "ṭopiisә", R.drawable.fourpoints,
                "mighty fellowship"));
        hotels.add(new Hotel("green", "chokokki", R.drawable.trops, "great event with Emem"));
        hotels.add(new Hotel("brown", "ṭakaakki", R.drawable.elibrary, "great and mighty God"));

        return hotels;
    }

    public ArrayList<Event> getEventsInLagos() {

        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event("Calabar Festival", "December, 2018", R.drawable.stadium, "This Eveny is awesome"));
        events.add(new Event("mustard yellow", "chiwiiṭә", R.drawable.elibrary,
                "great place to be"));
        events.add(new Event("dusty yellow", "ṭopiisә", R.drawable.fourpoints,
                "mighty fellowship"));
        events.add(new Event("green", "chokokki", R.drawable.trops, "great event with Emem"));
        events.add(new Event("brown", "ṭakaakki", R.drawable.elibrary, "great and mighty God"));

        return events;
    }

    public ArrayList<Attractions> getAttractionsInLagos() {
        // Create a list of events
        final ArrayList<Attractions> attractions = new ArrayList<Attractions>();
        attractions.add(new Attractions("Calabar Festival", R.drawable.stadium, R.drawable.stadium));
        attractions.add(new Attractions("mustard yellow", R.drawable.elibrary, R.drawable.elibrary));
        attractions.add(new Attractions("dusty yellow", R.drawable.fourpoints, R.drawable.fourpoints));
        attractions.add(new Attractions("chokokki", R.drawable.trops, R.drawable.trops));
        attractions.add(new Attractions("ṭakaakki", R.drawable.elibrary, R.drawable.stadium));
        attractions.add(new Attractions("ṭopoppi", R.drawable.stadium, R.drawable.fourpoints));

        return attractions;
    }

    public ArrayList<Restaurants> getRestaurantInLagos() {
        // Create a list of events
        final ArrayList<Restaurants> restaurants = new ArrayList<Restaurants>();
        restaurants.add(new Restaurants(R.drawable.stadium, "Filter"));
        restaurants.add(new Restaurants(R.drawable.elibrary, "great place to be"));
        restaurants.add(new Restaurants(R.drawable.fourpoints, "mighty fellowship"));
        restaurants.add(new Restaurants(R.drawable.trops, "great event with Emem"));
        restaurants.add(new Restaurants(R.drawable.elibrary, "great and mighty God"));
        restaurants.add(new Restaurants(R.drawable.stadium, "good lord vincent is..."));

        return restaurants;
    }

    public ArrayList<Hotel> getHotelsInLagos() {
        // Create a list of events
        final ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel("Calabar Festival", "December, 2018", R.drawable.stadium, "This Eveny is awesome"));
        hotels.add(new Hotel("mustard yellow", "chiwiiṭә", R.drawable.elibrary,
                "great place to be"));
        hotels.add(new Hotel("dusty yellow", "ṭopiisә", R.drawable.fourpoints,
                "mighty fellowship"));
        hotels.add(new Hotel("green", "chokokki", R.drawable.trops, "great event with Emem"));
        hotels.add(new Hotel("brown", "ṭakaakki", R.drawable.elibrary, "great and mighty God"));

        return hotels;
    }

    public ArrayList<Event> getEventsInAbia() {

        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event("Calabar Festival", "December, 2018", R.drawable.stadium, "This Eveny is awesome"));
        events.add(new Event("mustard yellow", "chiwiiṭә", R.drawable.elibrary,
                "great place to be"));
        events.add(new Event("dusty yellow", "ṭopiisә", R.drawable.fourpoints,
                "mighty fellowship"));
        events.add(new Event("green", "chokokki", R.drawable.trops, "great event with Emem"));
        events.add(new Event("brown", "ṭakaakki", R.drawable.elibrary, "great and mighty God"));

        return events;
    }

    public ArrayList<Attractions> getAttractionsInAbia() {
        // Create a list of events
        final ArrayList<Attractions> attractions = new ArrayList<Attractions>();
        attractions.add(new Attractions("Calabar Festival", R.drawable.stadium, R.drawable.stadium));
        attractions.add(new Attractions("mustard yellow", R.drawable.elibrary, R.drawable.elibrary));
        attractions.add(new Attractions("dusty yellow", R.drawable.fourpoints, R.drawable.fourpoints));
        attractions.add(new Attractions("chokokki", R.drawable.trops, R.drawable.trops));
        attractions.add(new Attractions("ṭakaakki", R.drawable.elibrary, R.drawable.stadium));
        attractions.add(new Attractions("ṭopoppi", R.drawable.stadium, R.drawable.fourpoints));

        return attractions;
    }

    public ArrayList<Restaurants> getRestaurantInAbia() {
        // Create a list of events
        final ArrayList<Restaurants> restaurants = new ArrayList<Restaurants>();
        restaurants.add(new Restaurants(R.drawable.stadium, "Filter"));
        restaurants.add(new Restaurants(R.drawable.elibrary, "great place to be"));
        restaurants.add(new Restaurants(R.drawable.fourpoints, "mighty fellowship"));
        restaurants.add(new Restaurants(R.drawable.trops, "great event with Emem"));
        restaurants.add(new Restaurants(R.drawable.elibrary, "great and mighty God"));
        restaurants.add(new Restaurants(R.drawable.stadium, "good lord vincent is..."));

        return restaurants;
    }

    public ArrayList<Hotel> getHotelsInAbia() {
        // Create a list of events
        final ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel("Calabar Festival", "December, 2018", R.drawable.stadium, "This Eveny is awesome"));
        hotels.add(new Hotel("mustard yellow", "chiwiiṭә", R.drawable.elibrary,
                "great place to be"));
        hotels.add(new Hotel("dusty yellow", "ṭopiisә", R.drawable.fourpoints,
                "mighty fellowship"));
        hotels.add(new Hotel("green", "chokokki", R.drawable.trops, "great event with Emem"));
        hotels.add(new Hotel("brown", "ṭakaakki", R.drawable.elibrary, "great and mighty God"));

        return hotels;
    }

    public ArrayList<Event> getEventsInAbeokuta() {

        // Create a list of events
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event("Calabar Festival", "December, 2018", R.drawable.stadium, "This Eveny is awesome"));
        events.add(new Event("mustard yellow", "chiwiiṭә", R.drawable.elibrary,
                "great place to be"));
        events.add(new Event("dusty yellow", "ṭopiisә", R.drawable.fourpoints,
                "mighty fellowship"));
        events.add(new Event("green", "chokokki", R.drawable.trops, "great event with Emem"));
        events.add(new Event("brown", "ṭakaakki", R.drawable.elibrary, "great and mighty God"));

        return events;
    }

    public ArrayList<Attractions> getAttractionsInAbeokuta() {
        // Create a list of events
        final ArrayList<Attractions> attractions = new ArrayList<Attractions>();
        attractions.add(new Attractions("Calabar Festival", R.drawable.stadium, R.drawable.stadium));
        attractions.add(new Attractions("mustard yellow", R.drawable.elibrary, R.drawable.elibrary));
        attractions.add(new Attractions("dusty yellow", R.drawable.fourpoints, R.drawable.fourpoints));
        attractions.add(new Attractions("chokokki", R.drawable.trops, R.drawable.trops));
        attractions.add(new Attractions("ṭakaakki", R.drawable.elibrary, R.drawable.stadium));
        attractions.add(new Attractions("ṭopoppi", R.drawable.stadium, R.drawable.fourpoints));

        return attractions;
    }

    public ArrayList<Restaurants> getRestaurantInAbeokuta() {
        // Create a list of events
        final ArrayList<Restaurants> restaurants = new ArrayList<Restaurants>();
        restaurants.add(new Restaurants(R.drawable.stadium, "Filter"));
        restaurants.add(new Restaurants(R.drawable.elibrary, "great place to be"));
        restaurants.add(new Restaurants(R.drawable.fourpoints, "mighty fellowship"));
        restaurants.add(new Restaurants(R.drawable.trops, "great event with Emem"));
        restaurants.add(new Restaurants(R.drawable.elibrary, "great and mighty God"));
        restaurants.add(new Restaurants(R.drawable.stadium, "good lord vincent is..."));

        return restaurants;
    }

    public ArrayList<Hotel> getHotelsInAbeokuta() {
        // Create a list of events
        final ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel("Calabar Festival", "December, 2018", R.drawable.stadium, "This Eveny is awesome"));
        hotels.add(new Hotel("mustard yellow", "chiwiiṭә", R.drawable.elibrary,
                "great place to be"));
        hotels.add(new Hotel("dusty yellow", "ṭopiisә", R.drawable.fourpoints,
                "mighty fellowship"));
        hotels.add(new Hotel("green", "chokokki", R.drawable.trops, "great event with Emem"));
        hotels.add(new Hotel("brown", "ṭakaakki", R.drawable.elibrary, "great and mighty God"));

        return hotels;
    }
}

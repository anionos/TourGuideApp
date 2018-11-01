package com.example.user.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by user on 10/30/2018.
 */

public class RestaurantAdapter extends ArrayAdapter<Restaurants> {

    public RestaurantAdapter(Context context, ArrayList<Restaurants> restaurants) {
        super(context, 0, restaurants);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View restaurantListItem = convertView;
        if (restaurantListItem == null) {
            restaurantListItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.restaurant_list_item, parent, false);

            Restaurants currentRestaurant = getItem(position);
            // Find the TextView in the list_item.xml layout with the ID version_name
            // Find the TextView in the list_item.xml layout with the ID version_number
            TextView card1 = restaurantListItem.findViewById(R.id.textView10);
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView
            card1.setText(currentRestaurant.getmName());
            ImageView imageView = restaurantListItem.findViewById(R.id.staduim_img);
            imageView.setImageResource(currentRestaurant.getmImageResource());

        }
        return restaurantListItem;
    }
}

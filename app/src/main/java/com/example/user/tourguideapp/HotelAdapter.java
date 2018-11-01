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
 * Created by user on 11/1/2018.
 */

public class HotelAdapter extends ArrayAdapter<Hotel> {

    public HotelAdapter(Context context, ArrayList<Hotel> hotels) {
        super(context, 0, hotels);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View hotelListItem = convertView;
        if (hotelListItem == null) {
            hotelListItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.hotel_list_item, parent, false);

            Hotel currentPlace = getItem(position);
            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView profileTextView = hotelListItem.findViewById(R.id.textView9);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            profileTextView.setText(currentPlace.getmName());
            // Find the TextView in the list_item.xml layout with the ID version_number
            TextView dateTextView = hotelListItem.findViewById(R.id.textView12);
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView
            dateTextView.setText(currentPlace.getmDate());
            TextView detailedTextView = hotelListItem.findViewById(R.id.textView13);
            detailedTextView.setText(currentPlace.getmDescription());
            ImageView imageView = hotelListItem.findViewById(R.id.staduim_img);
            imageView.setImageResource(currentPlace.getmImageResource());

            CircleImageView profileImg = hotelListItem.findViewById(R.id.profile_image);
            profileImg.setImageResource(currentPlace.getmImageResource());

        }
        return hotelListItem;
    }
}

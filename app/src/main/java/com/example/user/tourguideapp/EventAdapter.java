package com.example.user.tourguideapp;

import android.app.usage.UsageEvents;
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
 * Created by user on 10/27/2018.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    public EventAdapter(Context context, ArrayList<Event> events) {
        super(context, 0, events);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View eventListItem = convertView;
        if (eventListItem == null) {
            eventListItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.event_list_item, parent, false);

            Event currentPlace = getItem(position);
            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView profileTextView = eventListItem.findViewById(R.id.textView9);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            profileTextView.setText(currentPlace.getmName());
            // Find the TextView in the list_item.xml layout with the ID version_number
            TextView dateTextView = eventListItem.findViewById(R.id.textView12);
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView
            dateTextView.setText(currentPlace.getmDate());
            TextView detailedTextView = eventListItem.findViewById(R.id.textView13);
            detailedTextView.setText(currentPlace.getmDescription());
            ImageView imageView = eventListItem.findViewById(R.id.staduim_img);
            imageView.setImageResource(currentPlace.getmImageResource());

            CircleImageView profileImg = eventListItem.findViewById(R.id.profile_image);
            profileImg.setImageResource(currentPlace.getmImageResource());

        }
        return eventListItem;
    }
}
package com.example.user.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by user on 10/29/2018.
 */

public class AttractionsAdapter extends BaseAdapter {

    private Context mContext;
    ArrayList<Attractions> attractions;

    public AttractionsAdapter(Context c, ArrayList<Attractions> attractions) {
        mContext = c;
        this.attractions = attractions;
    }

    public int getCount() {
        return attractions.size();
    }

    public Object getItem(int position) {
        return attractions.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View attractionsListItem = convertView;
        if (attractionsListItem == null) {
            attractionsListItem = LayoutInflater.from(mContext).inflate(
                    R.layout.museum_list_item, parent, false);

            Attractions currentAttraction = (Attractions) getItem(position);
            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView attractionName = attractionsListItem.findViewById(R.id.textView_museum_name);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            attractionName.setText(currentAttraction.getmName());
            ImageView imageView1 = attractionsListItem.findViewById(R.id.museum_img1);
            imageView1.setImageResource(currentAttraction.getmImageResource1());

            ImageView imageView2 = attractionsListItem.findViewById(R.id.museum_img2);
            imageView2.setImageResource(currentAttraction.getmImageResource2());

        }
        return attractionsListItem;
    }
}

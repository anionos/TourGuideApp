package com.example.user.tourguideapp;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by user on 10/30/2018.
 */
@Parcel
public class Restaurants {

    private int mImageResource;

    private String mName;

    @ParcelConstructor
    public Restaurants() {
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Restaurants(int mImageResource, String mName) {
        this.mImageResource = mImageResource;
        this.mName = mName;
    }
}

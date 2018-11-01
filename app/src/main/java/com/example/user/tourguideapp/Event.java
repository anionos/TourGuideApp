package com.example.user.tourguideapp;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by user on 10/29/2018.
 */
@Parcel
public class Event {

    private String mName;

    private String mDate;

    private int mImageResource;

    private String mDescription;

    public String getmName() {
        return mName;
    }

    public Event(String mName, String mDate, int mImageResource, String mDescription) {
        this.mName = mName;
        this.mDate = mDate;
        this.mImageResource = mImageResource;
        this.mDescription = mDescription;
    }
    @ParcelConstructor
    public Event() {
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}

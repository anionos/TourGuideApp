package com.example.user.tourguideapp;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by user on 10/30/2018.
 */
@Parcel
public class Attractions {

    private String mName;

    private int mImageResource1;

    private int mImageResource2;

    public Attractions(String mName, int mImageResource1, int mImageResource2) {
        this.mName = mName;
        this.mImageResource1 = mImageResource1;
        this.mImageResource2 = mImageResource2;
    }
@ParcelConstructor
    public Attractions() {
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmImageResource1() {
        return mImageResource1;
    }

    public void setmImageResource1(int mImageResource1) {
        this.mImageResource1 = mImageResource1;
    }

    public int getmImageResource2() {
        return mImageResource2;
    }

    public void setmImageResource2(int mImageResource2) {
        this.mImageResource2 = mImageResource2;
    }
}

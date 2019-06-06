package com.example.jitendra.medisafe.MoreActivitys;

public class Appointment_Item {
    private String mCountryName;
    private int mFlagImage;

    public Appointment_Item(String countryName, int flagImage) {
        mCountryName = countryName;
        mFlagImage = flagImage;
    }

    public String getCountryName() {
        return mCountryName;
    }

    public int getFlagImage() {
        return mFlagImage;
    }
}

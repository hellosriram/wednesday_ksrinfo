package com.ksr.ksrinfo;

public class offerInfo {

    // string variable for
    // storing employee name.
    private String stallName;

    // string variable for storing
    // employee contact number
    private String stallEmail;

    // string variable for storing
    // employee address.
    private String stallOffer;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public offerInfo() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public String getStallEmail() {
        return stallEmail;
    }

    public void setStallEmail(String stallEmail) {
        this.stallEmail = stallEmail;
    }

    public String getStallOffer() {
        return stallOffer;
    }

    public void setStallOffer(String stallOffer) {
        this.stallOffer = stallOffer;
    }
}

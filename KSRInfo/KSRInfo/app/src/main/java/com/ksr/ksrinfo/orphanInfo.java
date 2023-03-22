package com.ksr.ksrinfo;

public class orphanInfo {

    // string variable for
    // storing employee name.
    private String orphanName;

    // string variable for storing
    // employee contact number
    private String orphanEmail;

    // string variable for storing
    // employee address.
    private String orphanAddress;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public orphanInfo() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getOrphanName() {
        return orphanName;
    }

    public void setOrphanName(String orphanName) {
        this.orphanName = orphanName;
    }

    public String getOrphanEmail() {
        return orphanEmail;
    }

    public void setOrphanEmail(String orphanEmail) {
        this.orphanEmail = orphanEmail;
    }

    public String getOrphanAddress() {
        return orphanAddress;
    }

    public void setOrphanAddress(String orphanAddress) {
        this.orphanAddress = orphanAddress;
    }
}

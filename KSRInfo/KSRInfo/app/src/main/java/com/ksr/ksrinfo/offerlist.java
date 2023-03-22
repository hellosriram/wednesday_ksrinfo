package com.ksr.ksrinfo;

import android.content.Intent;
import android.media.Image;


public class offerlist
{
    String name,address,phone,photo;
    offerlist()
    {

    }
    public offerlist(String name, String address, String phone, String photo) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.photo  = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

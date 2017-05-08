package com.warmit.stoeff.warmitclient.model;

import com.google.gson.annotations.SerializedName;

public class Ip {

    @SerializedName("ip")
    private String ip;

    public Ip(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

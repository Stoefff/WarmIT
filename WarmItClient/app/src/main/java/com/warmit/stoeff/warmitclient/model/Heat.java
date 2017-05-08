package com.warmit.stoeff.warmitclient.model;

import com.google.gson.annotations.SerializedName;

public class Heat {

    @SerializedName("heat")
    private int value;

    public Heat(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

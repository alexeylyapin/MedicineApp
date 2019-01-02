package com.lyapinalex.android.medicineapp.net.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Measure {


    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("iso")
    @Expose
    private String iso;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
}

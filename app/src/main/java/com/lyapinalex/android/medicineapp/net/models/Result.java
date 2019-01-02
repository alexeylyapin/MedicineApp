package com.lyapinalex.android.medicineapp.net.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("composition")
    @Expose
    private Composition composition;
    @SerializedName("packaging")
    @Expose
    private Packaging packaging;
    @SerializedName("trade_label")
    @Expose
    private TradeLabel tradeLabel;
    @SerializedName("manufacturer")
    @Expose
    private Manufacturer manufacturer;
    @SerializedName("code")
    @Expose
    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public TradeLabel getTradeLabel() {
        return tradeLabel;
    }

    public void setTradeLabel(TradeLabel tradeLabel) {
        this.tradeLabel = tradeLabel;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

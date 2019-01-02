package com.lyapinalex.android.medicineapp.net.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Packaging {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("composition")
    @Expose
    private Composition_ composition;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("in_bulk")
    @Expose
    private Boolean inBulk;
    @SerializedName("minimal_quantity")
    @Expose
    private String minimalQuantity;
    @SerializedName("package_quantity")
    @Expose
    private String packageQuantity;
    @SerializedName("variant")
    @Expose
    private Object variant;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Composition_ getComposition() {
        return composition;
    }

    public void setComposition(Composition_ composition) {
        this.composition = composition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getInBulk() {
        return inBulk;
    }

    public void setInBulk(Boolean inBulk) {
        this.inBulk = inBulk;
    }

    public String getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(String minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }

    public String getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(String packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public Object getVariant() {
        return variant;
    }

    public void setVariant(Object variant) {
        this.variant = variant;
    }
}

package com.lyapinalex.android.medicineapp.net.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Composition_ {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("atc")
    @Expose
    private List<String> atc = null;
    @SerializedName("inn")
    @Expose
    private Inn_ inn;
    @SerializedName("pharm_form")
    @Expose
    private PharmForm_ pharmForm;
    @SerializedName("dosage")
    @Expose
    private Double dosage;
    @SerializedName("measure")
    @Expose
    private Measure_ measure;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAtc() {
        return atc;
    }

    public void setAtc(List<String> atc) {
        this.atc = atc;
    }

    public Inn_ getInn() {
        return inn;
    }

    public void setInn(Inn_ inn) {
        this.inn = inn;
    }

    public PharmForm_ getPharmForm() {
        return pharmForm;
    }

    public void setPharmForm(PharmForm_ pharmForm) {
        this.pharmForm = pharmForm;
    }

    public Double getDosage() {
        return dosage;
    }

    public void setDosage(Double dosage) {
        this.dosage = dosage;
    }

    public Measure_ getMeasure() {
        return measure;
    }

    public void setMeasure(Measure_ measure) {
        this.measure = measure;
    }
}


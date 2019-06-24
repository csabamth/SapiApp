package com.example.csaba.sapiapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vizsga {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tantargyId")
    @Expose
    private Integer tantargyId;
    @SerializedName("szakId")
    @Expose
    private Integer szakId;
    @SerializedName("evfolyamId")
    @Expose
    private Integer evfolyamId;
    @SerializedName("tanarId")
    @Expose
    private Integer tanarId;
    @SerializedName("vizsgadatum")
    @Expose
    private String vizsgadatum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTantargyId() {
        return tantargyId;
    }

    public void setTantargyId(Integer tantargyId) {
        this.tantargyId = tantargyId;
    }

    public Integer getSzakId() {
        return szakId;
    }

    public void setSzakId(Integer szakId) {
        this.szakId = szakId;
    }

    public Integer getEvfolyamId() {
        return evfolyamId;
    }

    public void setEvfolyamId(Integer evfolyamId) {
        this.evfolyamId = evfolyamId;
    }

    public Integer getTanarId() {
        return tanarId;
    }

    public void setTanarId(Integer tanarId) {
        this.tanarId = tanarId;
    }

    public String getVizsgadatum() {
        return vizsgadatum;
    }

    public void setVizsgadatum(String vizsgadatum) {
        this.vizsgadatum = vizsgadatum;
    }

    @Override
    public String toString() {
        return "Vizsga: tantargyId=" + tantargyId +
                ", szakId=" + szakId +
                ", evfolyamId=" + evfolyamId +
                ", tanarId=" + tanarId +
                ", vizsgadatum='" + vizsgadatum + '\n'
                ;
    }
}

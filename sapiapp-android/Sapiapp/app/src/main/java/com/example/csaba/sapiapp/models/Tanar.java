package com.example.csaba.sapiapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tanar {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("vezeteknev")
    @Expose
    private String vezeteknev;
    @SerializedName("keresztnev")
    @Expose
    private String keresztnev;
    @SerializedName("funkcio")
    @Expose
    private String funkcio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getFunkcio() {
        return funkcio;
    }

    public void setFunkcio(String funkcio) {
        this.funkcio = funkcio;
    }
}

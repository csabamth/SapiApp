package com.example.csaba.sapiapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Esemeny implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cim")
    @Expose
    private String cim;
    @SerializedName("leiras")
    @Expose
    private String leiras;
    @SerializedName("img_url")
    @Expose
    private String img_url;
    @SerializedName("esemeny_datum")
    @Expose
    private String esemeny_datum;

    public Integer getId() {
        return id;
    }

    public String getCim() {
        return cim;
    }

    public String getLeiras() {
        return leiras;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getEsemeny_datum() {
        return esemeny_datum;
    }
}

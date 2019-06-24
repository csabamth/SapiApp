package com.example.csaba.sapiapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {
    @SerializedName("hetfo_leves")
    @Expose
    private String hetfo_leves;
    @SerializedName("hetfo_fofogas")
    @Expose
    private String hetfo_fofogas;
    @SerializedName("kedd_leves")
    @Expose
    private String kedd_leves;
    @SerializedName("kedd_fofogas")
    @Expose
    private String kedd_fofogas;
    @SerializedName("szerda_leves")
    @Expose
    private String szerda_leves;
    @SerializedName("szerda_fofogas")
    @Expose
    private String szerda_fofogas;
    @SerializedName("csutortok_leves")
    @Expose
    private String csutortok_leves;
    @SerializedName("csutortok_fofogas")
    @Expose
    private String csutortok_fofogas;
    @SerializedName("pentek_leves")
    @Expose
    private String pentek_leves;
    @SerializedName("pentek_fofogas")
    @Expose
    private String pentek_fofogas;
    @SerializedName("mettol")
    @Expose
    private String mettol;
    @SerializedName("meddig")
    @Expose
    private String meddig;

    public String getHetfo_leves() {
        return hetfo_leves;
    }

    public String getHetfo_fofogas() {
        return hetfo_fofogas;
    }

    public String getKedd_leves() {
        return kedd_leves;
    }

    public String getKedd_fofogas() {
        return kedd_fofogas;
    }

    public String getSzerda_leves() {
        return szerda_leves;
    }

    public String getSzerda_fofogas() {
        return szerda_fofogas;
    }

    public String getCsutortok_leves() {
        return csutortok_leves;
    }

    public String getCsutortok_fofogas() {
        return csutortok_fofogas;
    }

    public String getPentek_leves() {
        return pentek_leves;
    }

    public String getPentek_fofogas() {
        return pentek_fofogas;
    }

    public String getMettol() {
        return mettol;
    }

    public String getMeddig() {
        return meddig;
    }
}


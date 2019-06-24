package com.example.csaba.sapiapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Szak {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("megnevezes")
    @Expose
    private String megnevezes;
    @SerializedName("rovidites")
    @Expose
    private String rovidites;
    @SerializedName("idotartamEvben")
    @Expose
    private Integer idotartamEvben;
    @SerializedName("tipus")
    @Expose
    private String tipus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public String getRovidites() {
        return rovidites;
    }

    public void setRovidites(String rovidites) {
        this.rovidites = rovidites;
    }

    public Integer getIdotartamEvben() {
        return idotartamEvben;
    }

    public void setIdotartamEvben(Integer idotartamEvben) {
        this.idotartamEvben = idotartamEvben;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    @Override
    public String toString() {
        return this.megnevezes;
    }
}

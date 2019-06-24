package com.example.csaba.sapiapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tantargy {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("megnevezes")
    @Expose
    private String megnevezes;

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

    @Override
    public String toString() {
        return this.megnevezes;
    }
}

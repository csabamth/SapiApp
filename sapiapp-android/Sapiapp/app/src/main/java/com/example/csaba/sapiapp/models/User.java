package com.example.csaba.sapiapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("szakId")
    @Expose
    private int szakId;
    @SerializedName("evfolyamId")
    @Expose
    private int evfolyamId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSzakId() {
        return szakId;
    }

    public void setSzakId(int szakId) {
        this.szakId = szakId;
    }

    public int getEvfolyamId() {
        return evfolyamId;
    }

    public void setEvfolyamId(int evfolyamId) {
        this.evfolyamId = evfolyamId;
    }
}

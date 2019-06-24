package com.example.csaba.sapiapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoutResult {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;


    public LogoutResult(Boolean error, String message) {
        this.error = error;
        this.message = message;

    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }


}

package com.example.csaba.sapiapp.API;

import com.example.csaba.sapiapp.models.Esemeny;
import com.example.csaba.sapiapp.models.Evfolyam;
import com.example.csaba.sapiapp.models.LogoutResult;
import com.example.csaba.sapiapp.models.Menu;
import com.example.csaba.sapiapp.models.RegisterResult;
import com.example.csaba.sapiapp.models.Result;
import com.example.csaba.sapiapp.models.Szak;
import com.example.csaba.sapiapp.models.Tanar;
import com.example.csaba.sapiapp.models.Tantargy;
import com.example.csaba.sapiapp.models.User;
import com.example.csaba.sapiapp.models.Vizsga;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

    //The login call
    @FormUrlEncoded
    @POST("androidlogin")
    Call<Result> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    //The register call
    @FormUrlEncoded
    @POST("register")
    Call<RegisterResult> createUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("szakId") int szakId,
            @Field("evfolyamId") int evfolyamId,
            @Field("password") String password

    );

    //logout
    @POST("logout")
    Call<LogoutResult> logoutUser(@Header("Authorization") String token);

    //useradatok lekerese
    @GET("users")
    Call<List<User>> getUsers(@Header("Authorization") String token);

    @GET("user/{id}")
    Call<User> getUserWithId(@Header("Authorization") String token);

    //szakok lekerese
    @GET("szakok")
    Call<List<Szak>> getSzakok();

    @GET("szakok/{id}")
    Call<Szak> getSzakWithID(@Path("id") int id);


    //evfolyamok lekerese
    @GET("evfolyamok")
    Call<List<Evfolyam>> getEvfolyamok();

    @GET("evfolyamok/{id}")
    Call<Evfolyam> getEvfolyamWithID(@Path("id") int id);

    //vizsgak lekerese
    @GET("vizsgak")
    Call<List<Vizsga>> getVizsgak(@Header("Authorization") String token);

    //tantargyak lekerese
    @GET("tantargyak")
    Call<List<Tantargy>> getTantargyak(@Header("Authorization") String token);

    @GET("tantargy/{id}")
    Call<Tantargy> getTantargyWithID(@Path("id") int id, @Header("Authorization") String token);

    //tanarok lekerese
    @GET("tanarok")
    Call<List<Tanar>> getTanarok(@Header("Authorization") String token);

    @GET("tanar/{id}")
    Call<Tanar> getTanarWithID(@Path("id") int id, @Header("Authorization") String token);

    //tantargyak lekerese
    @GET("aktualismenu")
    Call<Menu> getAktualisMenu(@Header("Authorization") String token);

    //tantargyak lekerese
    @GET("esemenyek")
    Call<List<Esemeny>> getEsemenyek(@Header("Authorization") String token);

    @GET("tantargy/{id}")
    Call<Esemeny> getEsemenyWithID(@Path("id") int id, @Header("Authorization") String token);


}

package com.example.csaba.sapiapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.csaba.sapiapp.API.APIService;
import com.example.csaba.sapiapp.API.RetrofitClient;
import com.example.csaba.sapiapp.R;
import com.example.csaba.sapiapp.models.Evfolyam;
import com.example.csaba.sapiapp.models.Szak;
import com.example.csaba.sapiapp.models.Tanar;
import com.example.csaba.sapiapp.models.Tantargy;
import com.example.csaba.sapiapp.models.Vizsga;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VizsgaAdapter extends RecyclerView.Adapter<VizsgaAdapter.VizsgaViewHolder> {
    final APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);
    private ArrayList<Vizsga> vlist;
    private String vtoken;

    public VizsgaAdapter(ArrayList<Vizsga> vizsgalist, String token) {
        vlist = vizsgalist;
        vtoken = token;

    }

    @NonNull
    @Override
    public VizsgaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_exam_item, parent, false);
        VizsgaViewHolder vvh = new VizsgaViewHolder(v);
        return vvh;
    }

    @Override
    public void onBindViewHolder(@NonNull final VizsgaViewHolder holder, int position) {
        Vizsga currentItem = vlist.get(position);
        holder.text_datum.setText(currentItem.getVizsgadatum());
        Call<Szak> call = service.getSzakWithID(currentItem.getSzakId());
        call.enqueue(new Callback<Szak>() {
            @Override
            public void onResponse(Call<Szak> call, Response<Szak> response) {
                holder.text_szak.setText(response.body().getMegnevezes());
            }

            @Override
            public void onFailure(Call<Szak> call, Throwable t) {

            }
        });
        Call<Evfolyam> call2 = service.getEvfolyamWithID(currentItem.getEvfolyamId());
        call2.enqueue(new Callback<Evfolyam>() {
            @Override
            public void onResponse(Call<Evfolyam> call, Response<Evfolyam> response) {
                holder.text_evfolyam.setText(response.body().getMegnevezes());
            }

            @Override
            public void onFailure(Call<Evfolyam> call, Throwable t) {

            }
        });

        Call<Tantargy> call3 = service.getTantargyWithID(currentItem.getTantargyId(), "Bearer " + vtoken);
        call3.enqueue(new Callback<Tantargy>() {
            @Override
            public void onResponse(Call<Tantargy> call, Response<Tantargy> response) {
                holder.text_targynev.setText(response.body().getMegnevezes());
            }

            @Override
            public void onFailure(Call<Tantargy> call, Throwable t) {

            }
        });

        Call<Tanar> call4 = service.getTanarWithID(currentItem.getTanarId(), "Bearer " + vtoken);
        call4.enqueue(new Callback<Tanar>() {
            @Override
            public void onResponse(Call<Tanar> call, Response<Tanar> response) {
                holder.text_tanarnev.setText(response.body().getVezeteknev() + " " + response.body().getKeresztnev());
            }

            @Override
            public void onFailure(Call<Tanar> call, Throwable t) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return vlist.size();
    }

    public static class VizsgaViewHolder extends RecyclerView.ViewHolder {
        public TextView text_datum, text_targynev, text_tanarnev, text_evfolyam, text_szak;

        public VizsgaViewHolder(View itemView) {
            super(itemView);
            text_datum = itemView.findViewById(R.id.text_datum);
            text_targynev = itemView.findViewById(R.id.text_targynev);
            text_tanarnev = itemView.findViewById(R.id.text_tanarnev);
            text_evfolyam = itemView.findViewById(R.id.text_evfolyam);
            text_szak = itemView.findViewById(R.id.text_szak);

        }
    }

}

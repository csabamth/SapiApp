package com.example.csaba.sapiapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.csaba.sapiapp.API.APIService;
import com.example.csaba.sapiapp.API.RetrofitClient;
import com.example.csaba.sapiapp.R;
import com.example.csaba.sapiapp.activities.HomePageActivity;
import com.example.csaba.sapiapp.models.Esemeny;
import com.example.csaba.sapiapp.models.Evfolyam;
import com.example.csaba.sapiapp.models.Szak;
import com.example.csaba.sapiapp.models.User;
import com.example.csaba.sapiapp.models.Vizsga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomePageFragment extends Fragment {
    final APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);
    TextView nameholder, szakholder, evfolyamholder, szaktipusholder, vizsgaalertholder, esemenyholder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_homepage, container, false);
        Bundle bundle = this.getArguments();
        final User user = (User) bundle.getSerializable("user");
        final String token = bundle.getString("token");
        nameholder = v.findViewById(R.id.nameholder);
        szakholder = v.findViewById(R.id.szakholder);
        evfolyamholder = v.findViewById(R.id.evfolyaholder);
        szaktipusholder = v.findViewById(R.id.szaktipusholder);
        vizsgaalertholder = v.findViewById(R.id.vizsgaalertholder);
        esemenyholder = v.findViewById(R.id.esemenyholder);
        nameholder.setText(user.getName());
        ((HomePageActivity) getActivity())
                .setActionBarTitle("Profil");
        Call<Szak> setSzak = service.getSzakWithID(user.getSzakId());
        setSzak.enqueue(new Callback<Szak>() {
            @Override
            public void onResponse(Call<Szak> call, Response<Szak> response) {
                szakholder.setText(response.body().getMegnevezes());
                if (response.body().getTipus().equals("BsC"))
                    szaktipusholder.setText("BsC");
                else if (response.body().getTipus().equals("MsC"))
                    szaktipusholder.setText("MsC");
            }

            @Override
            public void onFailure(Call<Szak> call, Throwable t) {

            }
        });


        Call<Evfolyam> setEvfolyam = service.getEvfolyamWithID(user.getEvfolyamId());
        setEvfolyam.enqueue(new Callback<Evfolyam>() {
            @Override
            public void onResponse(Call<Evfolyam> call, Response<Evfolyam> response) {
                evfolyamholder.setText(response.body().getMegnevezes() + ". évfolyam");
            }

            @Override
            public void onFailure(Call<Evfolyam> call, Throwable t) {

            }
        });

        Call<List<Vizsga>> vizsgacall = service.getVizsgak("Bearer " + token);
        vizsgacall.enqueue(new Callback<List<Vizsga>>() {
            @Override
            public void onResponse(Call<List<Vizsga>> call, Response<List<Vizsga>> response) {
                ArrayList<Vizsga> sortedVizsga = new ArrayList<>();
                for (Vizsga vizsga : response.body()) {
                    if (user.getEvfolyamId() == vizsga.getEvfolyamId() && user.getSzakId() == vizsga.getSzakId())
                        sortedVizsga.add(vizsga);
                }
                int listsize = sortedVizsga.size();
                if (listsize == 0)
                    vizsgaalertholder.setText("Nincs vizsgád a közeljövőben!");
                else
                    vizsgaalertholder.setText(listsize + " vizsgád lesz a közeljövőben!");
            }

            @Override
            public void onFailure(Call<List<Vizsga>> call, Throwable t) {

            }
        });

        Call<List<Esemeny>> eCall = service.getEsemenyek("Bearer " + token);
        eCall.enqueue(new Callback<List<Esemeny>>() {
            @Override
            public void onResponse(Call<List<Esemeny>> call, Response<List<Esemeny>> response) {
                ArrayList<Esemeny> esemenylista;
                ArrayList<Esemeny> sortedesemenylista = new ArrayList<>();
                final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                esemenylista = (ArrayList<Esemeny>) response.body();
                for (Esemeny esemeny : esemenylista) {
                    try {
                        Date currentTime = Calendar.getInstance().getTime();
                        if (dateFormat.parse(esemeny.getEsemeny_datum()).before(currentTime)) {
                        } else
                            sortedesemenylista.add(esemeny);
                    } catch (ParseException e) {
                        throw new IllegalArgumentException(e);
                    }

                }
                int listsize = sortedesemenylista.size();
                if (listsize == 0)
                    esemenyholder.setText("Nincs új esemény a közeljövőben!");
                else
                    esemenyholder.setText(listsize + " eseményed lesz a közeljövőben!");

            }

            @Override
            public void onFailure(Call<List<Esemeny>> call, Throwable t) {

            }
        });
        return v;
    }
}

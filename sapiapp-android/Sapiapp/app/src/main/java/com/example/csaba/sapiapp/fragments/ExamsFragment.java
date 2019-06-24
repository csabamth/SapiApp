package com.example.csaba.sapiapp.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.csaba.sapiapp.API.APIService;
import com.example.csaba.sapiapp.API.RetrofitClient;
import com.example.csaba.sapiapp.R;
import com.example.csaba.sapiapp.activities.HomePageActivity;
import com.example.csaba.sapiapp.adapters.VizsgaAdapter;
import com.example.csaba.sapiapp.models.User;
import com.example.csaba.sapiapp.models.Vizsga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ExamsFragment extends Fragment {
    final APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);
    private RecyclerView vRecyclerView;
    private RecyclerView.Adapter vRecyclerViewAdapter;
    private RecyclerView.LayoutManager vRecyclerViewLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exams, container, false);
        Bundle bundle = this.getArguments();
        final User user = (User) bundle.getSerializable("user");
        final String token = bundle.getString("token");
        vRecyclerView = v.findViewById(R.id.vizsgaRecycler);

        vRecyclerViewLayoutManager = new LinearLayoutManager(getContext());
        vRecyclerView.setLayoutManager(vRecyclerViewLayoutManager);
        vRecyclerView.setHasFixedSize(true);

        ((HomePageActivity) getActivity())
                .setActionBarTitle("Vizsgák");

        Call<List<Vizsga>> vizsgacall = service.getVizsgak("Bearer " + token);
        vizsgacall.enqueue(new Callback<List<Vizsga>>() {
            @Override
            public void onResponse(Call<List<Vizsga>> call, Response<List<Vizsga>> response) {
                ArrayList<Vizsga> sortedVizsga = new ArrayList<>();
                final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                for (Vizsga vizsga : response.body()) {
                    if (user.getEvfolyamId() == vizsga.getEvfolyamId() && user.getSzakId() == vizsga.getSzakId())
                        try {
                            Date currentTime = Calendar.getInstance().getTime();
                            if (dateFormat.parse(vizsga.getVizsgadatum()).before(currentTime)) {
                            } else
                                sortedVizsga.add(vizsga);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }

                }
                Collections.sort(sortedVizsga, new Comparator<Vizsga>() {

                    @Override
                    public int compare(Vizsga vizsga, Vizsga t1) {
                        try {
                            return dateFormat.parse(vizsga.getVizsgadatum()).compareTo(dateFormat.parse(t1.getVizsgadatum()));
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                });
                int listsize = sortedVizsga.size();
                if (listsize == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Jó hír! Nincs vizsgád a közeljövőben!")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    getActivity().onBackPressed();
                                }
                            });
                    builder.show();
                } else {
                    vRecyclerViewAdapter = new VizsgaAdapter(sortedVizsga, token);
                    vRecyclerView.setAdapter(vRecyclerViewAdapter);
                }


            }

            @Override
            public void onFailure(Call<List<Vizsga>> call, Throwable t) {

            }
        });
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}

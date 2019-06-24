package com.example.csaba.sapiapp.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
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
import com.example.csaba.sapiapp.adapters.EventAdapter;
import com.example.csaba.sapiapp.models.Esemeny;
import com.example.csaba.sapiapp.models.User;

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


public class EventsFragment extends Fragment {
    final APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);
    private RecyclerView eRecyclerView;
    private EventAdapter eRecyclerViewAdapter;
    private RecyclerView.LayoutManager eRecyclerViewLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_events, container, false);

        Bundle bundle = this.getArguments();
        final User user = (User) bundle.getSerializable("user");
        final String token = bundle.getString("token");
        eRecyclerView = v.findViewById(R.id.eventRecycler);

        eRecyclerViewLayoutManager = new LinearLayoutManager(getContext());
        eRecyclerView.setLayoutManager(eRecyclerViewLayoutManager);
        eRecyclerView.setHasFixedSize(true);


        ((HomePageActivity) getActivity())
                .setActionBarTitle("Események");

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

                Collections.sort(sortedesemenylista, new Comparator<Esemeny>() {

                    @Override
                    public int compare(Esemeny esemeny1, Esemeny esemeny2) {
                        try {
                            return dateFormat.parse(esemeny1.getEsemeny_datum()).compareTo(dateFormat.parse(esemeny2.getEsemeny_datum()));
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                });
                int listsize = sortedesemenylista.size();
                if (listsize == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Nincs új esemény a közeljövőben!")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    getActivity().onBackPressed();
                                }
                            });
                    builder.show();
                } else {
                    eRecyclerViewAdapter = new EventAdapter(getContext(), sortedesemenylista, token);
                    eRecyclerView.setAdapter(eRecyclerViewAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Esemeny>> call, Throwable t) {

            }
        });
        return v;
    }
}

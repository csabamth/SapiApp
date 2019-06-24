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
import com.example.csaba.sapiapp.models.Menu;
import com.example.csaba.sapiapp.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuFragment extends Fragment {
    final APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);
    TextView mettol, meddig, hetfo_leves, hetfo_foetel, kedd_leves, kedd_foetel, szerda_leves, szerda_foetel, csutortok_leves,
            csutortok_foetel, pentek_leves, pentek_foetel;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        Bundle bundle = this.getArguments();
        final User user = (User) bundle.getSerializable("user");
        final String token = bundle.getString("token");
        final TextView mettol = v.findViewById(R.id.text_mettol);
        final TextView meddig = v.findViewById(R.id.text_meddig);
        final TextView hetfo_leves = v.findViewById(R.id.hetfo_leves);
        final TextView hetfo_foetel = v.findViewById(R.id.hetfo_foetel);
        final TextView kedd_leves = v.findViewById(R.id.kedd_leves);
        final TextView kedd_foetel = v.findViewById(R.id.kedd_foetel);
        final TextView szerda_leves = v.findViewById(R.id.szerda_leves);
        final TextView szerda_foetel = v.findViewById(R.id.szerda_foetel);
        final TextView csutortok_leves = v.findViewById(R.id.csutortok_leves);
        final TextView csutortok_foetel = v.findViewById(R.id.csutortok_foetel);
        final TextView pentek_leves = v.findViewById(R.id.pentek_leves);
        final TextView pentek_foetel = v.findViewById(R.id.pentek_foetel);
        ((HomePageActivity) getActivity())
                .setActionBarTitle("Heti menü");
        Call<Menu> menuCall = service.getAktualisMenu("Bearer " + token);
        menuCall.enqueue(new Callback<Menu>() {
            @Override
            public void onResponse(Call<Menu> call, Response<Menu> response) {
                mettol.setText(response.body().getMettol());
                meddig.setText(response.body().getMeddig());
                hetfo_leves.setText(response.body().getHetfo_leves());
                hetfo_foetel.setText(response.body().getHetfo_fofogas());
                kedd_leves.setText(response.body().getKedd_leves());
                kedd_foetel.setText(response.body().getKedd_fofogas());
                szerda_leves.setText(response.body().getSzerda_leves());
                szerda_foetel.setText(response.body().getSzerda_fofogas());
                csutortok_leves.setText(response.body().getCsutortok_leves());
                csutortok_foetel.setText(response.body().getCsutortok_fofogas());
                pentek_leves.setText(response.body().getPentek_leves());
                pentek_foetel.setText(response.body().getPentek_fofogas());
            }

            @Override
            public void onFailure(Call<Menu> call, Throwable t) {

            }
        });
        return v;

    }
}

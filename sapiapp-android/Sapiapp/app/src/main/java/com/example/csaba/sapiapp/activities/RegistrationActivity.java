package com.example.csaba.sapiapp.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csaba.sapiapp.API.APIService;
import com.example.csaba.sapiapp.API.RetrofitClient;
import com.example.csaba.sapiapp.R;
import com.example.csaba.sapiapp.models.Evfolyam;
import com.example.csaba.sapiapp.models.RegisterResult;
import com.example.csaba.sapiapp.models.Szak;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private static String pokember;
    private Button buttonSignUp;
    private EditText editTextName, editTextEmail, editTextPassword;
    private String selectedSzak;
    private String selectedEvfolyam;
    private APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);
    private TextView szakhidden, evfolyamhidden, textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        szakhidden = findViewById(R.id.szakhidden);
        evfolyamhidden = findViewById(R.id.evfolyamhidden);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignUp.setOnClickListener(this);

        //get the spinner from the xml.
        final Spinner dropdown = findViewById(R.id.szakSpinner);
        final Spinner dropdown2 = findViewById(R.id.evfolyamSpinner);


        //set listeners
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), "Item selected.", Toast.LENGTH_SHORT).show();

                selectedSzak = dropdown.getSelectedItem().toString();
                Call<List<Szak>> lista = service.getSzakok();
                lista.enqueue(new Callback<List<Szak>>() {
                    @Override
                    public void onResponse(Call<List<Szak>> call, Response<List<Szak>> response) {
                        for (Szak szak : response.body()) {
                            if (szak.getMegnevezes().equals(selectedSzak))
                                szakhidden.setText(szak.getId().toString());

                        }

                    }

                    @Override
                    public void onFailure(Call<List<Szak>> call, Throwable t) {

                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(parent.getContext(), "Nothing selected.", Toast.LENGTH_SHORT).show();
            }
        });

        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedEvfolyam = dropdown2.getSelectedItem().toString();
                Call<List<Evfolyam>> lista2 = service.getEvfolyamok();
                lista2.enqueue(new Callback<List<Evfolyam>>() {
                    @Override
                    public void onResponse(Call<List<Evfolyam>> call, Response<List<Evfolyam>> response) {
                        for (Evfolyam evfolyam : response.body()) {
                            if (evfolyam.getMegnevezes().equals(selectedEvfolyam))
                                evfolyamhidden.setText(evfolyam.getId().toString());
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Evfolyam>> call, Throwable t) {

                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Call<List<Szak>> lista = service.getSzakok();
        lista.enqueue(new Callback<List<Szak>>() {
            @Override
            public void onResponse(Call<List<Szak>> call, Response<List<Szak>> response) {
                ArrayList<String> szaknevek = new ArrayList<>();
                for (Szak szak : response.body())
                    szaknevek.add(szak.getMegnevezes());
                final ArrayAdapter adapter = new ArrayAdapter<>(RegistrationActivity.this, android.R.layout.simple_spinner_dropdown_item, szaknevek);
                dropdown.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Szak>> call, Throwable t) {

            }
        });

        Call<List<Evfolyam>> lista2 = service.getEvfolyamok();
        lista2.enqueue(new Callback<List<Evfolyam>>() {
            @Override
            public void onResponse(Call<List<Evfolyam>> call, Response<List<Evfolyam>> response) {
                ArrayList<String> evfolyamnevek = new ArrayList<>();
                for (Evfolyam evfolyam : response.body())
                    evfolyamnevek.add(evfolyam.getMegnevezes());
                final ArrayAdapter adapter = new ArrayAdapter<>(RegistrationActivity.this, android.R.layout.simple_spinner_dropdown_item, evfolyamnevek);
                dropdown2.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Evfolyam>> call, Throwable t) {
            }
        });


    }


    @Override
    public void onClick(View view) {

        Call<List<Szak>> lista = service.getSzakok();
        lista.enqueue(new Callback<List<Szak>>() {
            @Override
            public void onResponse(Call<List<Szak>> call, Response<List<Szak>> response) {
                for (Szak szak : response.body()) {
                    if (szak.getMegnevezes().equals(selectedSzak))
                        szakhidden.setText(selectedSzak);
                    break;
                }
            }

            @Override
            public void onFailure(Call<List<Szak>> call, Throwable t) {

            }
        });

        Call<List<Evfolyam>> lista2 = service.getEvfolyamok();
        lista2.enqueue(new Callback<List<Evfolyam>>() {
            @Override
            public void onResponse(Call<List<Evfolyam>> call, Response<List<Evfolyam>> response) {
                for (Evfolyam evfolyam : response.body()) {
                    if (evfolyam.getMegnevezes().equals(selectedEvfolyam))
                        szakhidden.setText("" + evfolyam.getId());
                    break;
                }

            }

            @Override
            public void onFailure(Call<List<Evfolyam>> call, Throwable t) {

            }
        });
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Regisztráció folyamatban...");
        progressDialog.show();
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        int Szakid = Integer.parseInt(szakhidden.getText().toString().trim());
        int Evfolyamid = Integer.parseInt(evfolyamhidden.getText().toString().trim());

        Call<RegisterResult> call = service.createUser(name, email, Szakid, Evfolyamid, password);
        call.enqueue(new Callback<RegisterResult>() {
            @Override
            public void onResponse(Call<RegisterResult> call, Response<RegisterResult> response) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), response.body().getMessage(),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<RegisterResult> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}

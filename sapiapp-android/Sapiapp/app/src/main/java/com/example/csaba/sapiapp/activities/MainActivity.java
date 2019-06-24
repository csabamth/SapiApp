package com.example.csaba.sapiapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.csaba.sapiapp.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonSignIn, buttonSignUp;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonSignIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == buttonSignIn) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (view == buttonSignUp) {
            startActivity(new Intent(this, RegistrationActivity.class));

        }
    }
}

package com.example.csaba.sapiapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csaba.sapiapp.API.APIService;
import com.example.csaba.sapiapp.API.RetrofitClient;
import com.example.csaba.sapiapp.R;
import com.example.csaba.sapiapp.fragments.EventsFragment;
import com.example.csaba.sapiapp.fragments.ExamsFragment;
import com.example.csaba.sapiapp.fragments.HomePageFragment;
import com.example.csaba.sapiapp.fragments.MenuFragment;
import com.example.csaba.sapiapp.models.LogoutResult;
import com.example.csaba.sapiapp.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomePageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    final APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);
    private RecyclerView vRecyclerView;
    private RecyclerView.Adapter vRecyclerViewAdapter;
    private RecyclerView.LayoutManager vRecyclerViewLayoutManager;
    private Bundle extrastopass;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        TextView userName = header.findViewById(R.id.textView2);
        Intent i = getIntent();
        extrastopass = i.getExtras();
        final User user = (User) i.getSerializableExtra("user");
        token = i.getStringExtra("token");
        userName.setText(user.getName());
        HomePageFragment fragmentdefault = new HomePageFragment();
        fragmentdefault.setArguments(extrastopass);
        android.support.v4.app.FragmentTransaction fragmentTransactiondefault = getSupportFragmentManager().beginTransaction();
        fragmentTransactiondefault.replace(R.id.fragmentContainer, fragmentdefault);
        fragmentTransactiondefault.addToBackStack(null);
        fragmentTransactiondefault.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.signout:
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Kijelentkezés");
                progressDialog.show();
                Call<LogoutResult> logoutcall = service.logoutUser("Bearer " + token);
                logoutcall.enqueue(new Callback<LogoutResult>() {
                    @Override
                    public void onResponse(Call<LogoutResult> call, Response<LogoutResult> response) {
                        progressDialog.dismiss();
                        if (!response.body().getError()) {
                            final Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                            finishAffinity();
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LogoutResult> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Kijelentkezés nem sikerült.", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case R.id.quit:
                finish();
                break;
        }

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_item_homepage:

                HomePageFragment fragment = new HomePageFragment();
                fragment.setArguments(extrastopass);
                android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.fragmentContainer, fragment);
                fragmentTransaction3.addToBackStack(null);
                fragmentTransaction3.commit();

                break;
            case R.id.menu_item_events:

                EventsFragment fragment3 = new EventsFragment();
                fragment3.setArguments(extrastopass);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, fragment3);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.menu_item_exams:

                ExamsFragment fragment2 = new ExamsFragment();
                fragment2.setArguments(extrastopass);
                android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.fragmentContainer, fragment2);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
                break;
            case R.id.menu_item_menu:

                MenuFragment fragment4 = new MenuFragment();
                fragment4.setArguments(extrastopass);
                android.support.v4.app.FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction4.replace(R.id.fragmentContainer, fragment4);
                fragmentTransaction4.addToBackStack(null);
                fragmentTransaction4.commit();
                break;


        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


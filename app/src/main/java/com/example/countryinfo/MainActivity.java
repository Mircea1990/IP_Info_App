package com.example.countryinfo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId())
            {
                case R.id.home:
                {
                    Toast toast = Toast.makeText(MainActivity.this, "Home page", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    View view = toast.getView();
                    view.setBackgroundColor(Color.GREEN);
                    toast.show();
                    Intent mainMenu = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(mainMenu);
                    break;
                }
                case R.id.contact:
                {
                    Toast toast = Toast.makeText(MainActivity.this, "Contact page", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    View view = toast.getView();
                    view.setBackgroundColor(Color.GREEN);
                    toast.show();
                    Intent contactMe = new Intent(MainActivity.this,ContactMe.class);
                    startActivity(contactMe);
                    break;
                }
                case R.id.maps:
                {
                    Toast toast = Toast.makeText(MainActivity.this, "Please wait...", Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    view.setBackgroundColor(Color.GREEN);
                    toast.show();
                    Intent maps = new Intent(MainActivity.this,GoogleMaps.class);
                    startActivity(maps);
                    break;
                }
                case R.id.CountryByIp:
                {
                    Toast toast = Toast.makeText(MainActivity.this, "Please wait...", Toast.LENGTH_LONG);
                    View view =toast.getView();
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    view.setBackgroundColor(Color.GREEN);
                    toast.show();
                    Intent ip = new Intent(MainActivity.this,IpSearch.class);
                    startActivity(ip);
                    break;
                }
                case R.id.about:
                {
                    Toast toast = Toast.makeText(MainActivity.this, "About me page", Toast.LENGTH_SHORT);
                    View view =toast.getView();
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    view.setBackgroundColor(Color.GREEN);
                    toast.show();
                    Intent aboutMe = new Intent(MainActivity.this,AboutMe.class);
                    startActivity(aboutMe);
                    break;
                }
                case R.id.register:
                {
                    Toast toast = Toast.makeText(MainActivity.this, "Register page", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    View view = toast.getView();
                    view.setBackgroundColor(Color.GREEN);
                    toast.show();
                    Intent registration = new Intent(MainActivity.this,RegistrationForm.class);
                    startActivity(registration);
                    break;
                }
                case R.id.shareBT:
                {
                    Intent myIntent = new Intent(Intent.ACTION_SEND);
                    myIntent.setType("text/plain");
                    String shareBody = "Choose an option to share";
                    String shareSub = "Your subject";
                    myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                    myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(myIntent, "Share using"));
                    break;
                }
                case R.id.rate_me:
                {
                    Toast toast = Toast.makeText(MainActivity.this, "Rate me page", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    View view = toast.getView();
                    view.setBackgroundColor(Color.GREEN);
                    toast.show();
                    Intent rate = new Intent(MainActivity.this,RateActivity.class);
                    startActivity(rate);
                    break;
                }

            }
            return false;
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
package com.example.countryinfo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AboutMe extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        backButton = findViewById(R.id.aboutMeButtonAbout);
        backButton.setOnClickListener(v -> {
            Intent back = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(back);
        });
    }
}
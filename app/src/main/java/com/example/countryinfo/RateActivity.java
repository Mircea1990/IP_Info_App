package com.example.countryinfo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RateActivity extends AppCompatActivity {

    RatingBar rt;
    Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_activity);

        //binding MainActivity.java with activity_main.xml file
        rt = findViewById(R.id.ratingBar);

        //finding the specific RatingBar with its unique ID
        LayerDrawable stars=(LayerDrawable)rt.getProgressDrawable();

        //Use for changing the color of RatingBar
        stars.getDrawable(2).setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);

        backButton = findViewById(R.id.aboutMeButtonRate);
        backButton.setOnClickListener(v -> {
            Intent back = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(back);
        });
    }

    public void Call(View v)
    {
        // This function is called when button is clicked.
        // Display ratings, which is required to be converted into string first.
        TextView t = findViewById(R.id.textView2);
        t.setText("You Rated :"+String.valueOf(rt.getRating()));
    }
}
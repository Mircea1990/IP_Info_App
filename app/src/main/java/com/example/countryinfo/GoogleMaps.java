package com.example.countryinfo;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class GoogleMaps extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap googleMap;
    SearchView searchView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        Objects.requireNonNull(mapFragment).getMapAsync(this);

        backButton = findViewById(R.id.aboutMeButtonGoogle);
        backButton.setOnClickListener(v -> {
            Intent back = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(back);
        });

        searchView = findViewById(R.id.idSearchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = searchView.getQuery().toString();

                List<Address> addressList = null;

                if (location != null || location.equals("")) {

                    Geocoder geocoder = new Geocoder(GoogleMaps.this);
                    try {

                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    assert addressList != null;
                    Address address = addressList.get(0);


                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());


                    googleMap.addMarker(new MarkerOptions().position(latLng).title(location));


                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 4));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap Map) {
        googleMap = Map;
    }
}
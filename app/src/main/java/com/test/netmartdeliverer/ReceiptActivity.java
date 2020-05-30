package com.test.netmartdeliverer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ReceiptActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap ReceiptMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        TextView notifyTitle = findViewById(R.id.notifyTitle);
        TextView notifyDelivery = findViewById(R.id.notifyDeliveryTime);
        TextView sendingDate = findViewById(R.id.sendingDate);
        TextView sendingTime = findViewById(R.id.sendingTime);
        TextView notifyTotalPrice = findViewById(R.id.notifyTotalPrice);
        TextView total = findViewById(R.id.total);
        TextView subTotal = findViewById(R.id.subTotal);
        TextView tax = findViewById(R.id.tax);


        //get the map for the place
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_container);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        ReceiptMap = googleMap;
        //add the marker
        LatLng TutorialsPoint = new LatLng(21, 57);
        ReceiptMap.addMarker(new
                MarkerOptions().position(TutorialsPoint).title("Receipt Map"));
    }
}

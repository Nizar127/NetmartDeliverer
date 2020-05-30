package com.test.netmartdeliverer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PickUpActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "PickUpActivity";
    private GoogleMap mMap;
    String TestButton = "This Works";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);
        Log.d(TAG, "PickupActivity: Started");

        TextView pickup = findViewById(R.id.pickuplocation);
        TextView dropoff = findViewById(R.id.dropOfflocation);
        TextView regionalArea = findViewById(R.id.regionalArea);
        TextView notifyUser = findViewById(R.id.notifyClient);
        Switch availability = findViewById(R.id.simpleSwitch);
        LinearLayout callClient = findViewById(R.id.callClient);
        LinearLayout chatMessage = findViewById(R.id.chatClient);
        Button acceptButton = findViewById(R.id.acceptItem);

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),TestButton,Toast.LENGTH_LONG).show();
            }
        });

        //get items from the activity orderlist
        Bundle extras = getIntent().getExtras();
//        if(extras != null){
//            pickup();
//        }

        //get the map for the place
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_container);
        mapFragment.getMapAsync(this);



}

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //add the marker
        LatLng TutorialsPoint = new LatLng(21, 57);
        mMap.addMarker(new
                MarkerOptions().position(TutorialsPoint).title("Delivery System"));
    }
}

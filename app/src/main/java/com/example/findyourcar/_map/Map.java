package com.example.findyourcar._map;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import com.example.findyourcar.dataBase.GpsDataBase;
import com.example.findyourcar.ListViewDialog;
import com.example.findyourcar.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Map extends AppCompatActivity implements OnMapReadyCallback{
    private GoogleMap googleMap;

    private List<MarkerOptions> listMarkers = new ArrayList<>();
    private ClusterManager<MarkerClusterItem> clusterManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

            mapFragment.getMapAsync(this);

    }



    private void addMarkers(){

                SQLiteOpenHelper helper = new GpsDataBase(getApplicationContext(), "GPS3", null, 1);
                SQLiteDatabase database = helper.getReadableDatabase();
                Cursor cursor = database.query("GPS", new String[]{"NAME","X_DILER_CENTER_GPS","Y_DILER_CENTER_GPS","DILER_CENTER_DRAWABLE"}, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    do {
                        LatLng sydney = new LatLng(cursor.getDouble(1),cursor.getDouble(2));
                        MarkerOptions markerOptions = new MarkerOptions()
                                .position(sydney)
                                .title(cursor.getString(0))
                                .icon(BitmapDescriptorFactory.fromResource(cursor.getInt(3)));
                        Log.e("***",Integer.toString(cursor.getInt(3)));
                        //  .icon(bitmapFactory.fR.drawable.img)
                        listMarkers.add(markerOptions);

                    } while (cursor.moveToNext());
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(listMarkers.get(0).getPosition(), 13.0f));
                }


            }




    private void setupClusterManager() {
        setRenderer();
        addClusterItems();
        setClusterManagerClickListener();
        googleMap.setOnCameraIdleListener(clusterManager);
        googleMap.setOnMarkerClickListener(clusterManager);
        if (listMarkers.size() != 1 ) clusterManager.cluster();

    }

    private void setRenderer() {
        MarkerClusterRenderer<MarkerClusterItem> clusterRenderer = new MarkerClusterRenderer<>(this, googleMap, clusterManager);
        clusterManager.setRenderer(clusterRenderer);
    }

    private void setClusterManagerClickListener() {
        clusterManager.setOnClusterClickListener(cluster -> {
            Collection<MarkerClusterItem> listItems = cluster.getItems();
            List<String> listNames = new ArrayList<>();
            for (MarkerClusterItem item : listItems){
                listNames.add(item.getTitle());
            }
            googleMap.animateCamera(CameraUpdateFactory.newLatLng(cluster.getPosition()), new GoogleMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    ListViewDialog listViewDialog = new ListViewDialog(getApplicationContext(), listNames);
                    listViewDialog.showDialog();
                }
                @Override
                public void onCancel() { }
            });
            return true;
        });
    }

    private void addClusterItems() {
        for(MarkerOptions markerOptions : listMarkers){
            MarkerClusterItem clusterItem = new MarkerClusterItem(markerOptions.getPosition(), markerOptions.getTitle());
            clusterManager.addItem(clusterItem);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        clusterManager = new ClusterManager<>(this, googleMap);
        addMarkers();
        setupClusterManager();
    }






}
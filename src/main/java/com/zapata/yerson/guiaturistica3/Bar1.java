package com.zapata.yerson.guiaturistica3;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 *LatLng onca = new LatLng(4.8167706, -75.6977624);
 mMap.moveCamera(CameraUpdateFactory.newLatLng(onca));
 mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
 mMap.addMarker(new MarkerOptions().position(onca).title("Onca Bar").snippet("Cafe Bar"));
 */
public class Bar1 extends Fragment  {
    private GoogleMap map;
    private MapView mapView;


    public Bar1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment   //this.getFragmentManager()
        View v =inflater.inflate(R.layout.fragment_bar1, container, false);
        mapView = (MapView) v.findViewById(R.id.mapBar1);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(true);
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        map.setMyLocationEnabled(true);

        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        MapsInitializer.initialize(this.getActivity());

        // Updates the location and zoom of the MapView
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(4.8167706, -75.6977624), 15);
        map.addMarker(new MarkerOptions().position(new LatLng(4.8167706, -75.6977624)).title("Onca Bar").snippet("Cafe Bar"));
        map.animateCamera(cameraUpdate);

        return v;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}
/*
public class Bar1 extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;


    public Bar1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment   //this.getFragmentManager()
        View v =inflater.inflate(R.layout.fragment_bar1, container, false);
       // SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.mapBar1);
        //mapFragment.getMapAsync(this);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getChildFragmentManager().beginTransaction().add(R.id.mapBar1,mapFragment);
        mapFragment.getMapAsync(this);

            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapBar1)).getMap();
        LatLng onca = new LatLng(4.8167706, -75.6977624);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(onca));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        mMap.addMarker(new MarkerOptions().position(onca).title("Onca Bar").snippet("Cafe Bar"));

    return v;
    }

    public void onMapReady(GoogleMap googleMap){

    }
    public void onDestroyView() {
        super.onDestroyView();
        Fragment fragment = this.getChildFragmentManager().findFragmentById(R.id.mapBar1);

try{
        if (fragment != null)
            getFragmentManager().beginTransaction().remove(fragment).commit();
}catch  (Exception e){

        }
    }

    @Override
    public void onDestroy() {

        SupportMapFragment f = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.mapBar1);

        super.onDestroy();
    }
    @Override
    public void onPause() {
        super.onPause();
        Fragment fragment = this.getChildFragmentManager().findFragmentById(R.id.mapBar1);

        try{
            if (fragment != null)
                getFragmentManager().beginTransaction().remove(fragment).commit();
        }catch  (Exception e){

        }
    }

}

 -------------

             <fragment
                android:id="@+id/mapBar1"
                android:layout_gravity="center"
                android:layout_width="300dp"
                android:layout_height="300dp"
                android:name="com.google.android.gms.maps.SupportMapFragment"/>
*/
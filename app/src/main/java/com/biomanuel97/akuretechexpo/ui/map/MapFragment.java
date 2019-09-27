package com.biomanuel97.akuretechexpo.ui.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.biomanuel97.akuretechexpo.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

import java.util.Map;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private MapViewModel mMapViewModel;
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        mMapViewModel = ViewModelProviders.of(this).get(MapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_map, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
//        mMapViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            mapFragment.getMapAsync(this);
        }

        // R.id.map is a FrameLayout, not a Fragment
        getChildFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();

        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Ajowa Street and move the camera
        LatLng techExpoVenue = new LatLng(7.233281, 5.204161);
        LatLng Shoprite = new LatLng(7.236872, 5.214211);
        mMap.addMarker(new MarkerOptions().position(techExpoVenue).title("AkureTechExpo Venue"));
        mMap.addMarker(new MarkerOptions().position(Shoprite).title("Shoprite"));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(techExpoVenue));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(techExpoVenue.latitude, techExpoVenue.longitude), 18.20f));
        mMap.setMinZoomPreference((float) 10.50);
        mMap.setMaxZoomPreference((float) 20.50);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(techExpoVenue));
    }
}
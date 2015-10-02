package app.travelway.jayway.com.travelwayadmin;

import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by mattias on 2015-10-02.
 */
public class TravelwayMapFragment extends SupportMapFragment {

    private LatLng myLocation;

    private MyGpsListener gpsListener;

    public TravelwayMapFragment() {
        super();
        gpsListener = new MyGpsListener();

    }

//    public static TravelwayMapFragment newInstance(LatLng posicion){
//        TravelwayMapFragment frag = new TravelwayMapFragment();
////        frag.mPosFija = posicion;
//        return frag;
//    }

    @Override
    public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2) {
        View v = super.onCreateView(arg0, arg1, arg2);
        initMap();
        return v;
    }

    private void initMap() {
        UiSettings settings = getMap().getUiSettings();
        settings.setAllGesturesEnabled(true);
        settings.setMyLocationButtonEnabled(true);

        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationManager.addGpsStatusListener(gpsListener);

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10 * 1000, 50, gpsListener);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 10, gpsListener);

//        zoomToMyPos();

//        getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(mPosFija, 16));
//        getMap().addMarker(new MarkerOptions().position(mPosFija));
    }

    private void centerMapOnMyLocation() {

        getMap().setMyLocationEnabled(true);

        Location location = getMap().getMyLocation();

        if (location != null) {
            myLocation = new LatLng(location.getLatitude(),
                    location.getLongitude());
        }
        getMap().animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 10f));
    }

    private void zoomToMyPos(Location location) {

        if (location != null && getMap() != null) {
            getMap().animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(location.getLatitude(), location.getLongitude()), 13));

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(location.getLatitude(), location.getLongitude()))      // Sets the center of the map to location user
                    .zoom(17)                   // Sets the zoom
                    .bearing(0)                // Sets the orientation of the camera to north
                    .tilt(0)                   // Sets the tilt of the camera to 0 degrees
                    .build();                   // Creates a CameraPosition from the builder
            getMap().animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            getMap().clear();
            getMap().addMarker(new MarkerOptions()
                    .position(new LatLng(location.getLatitude(), location.getLongitude()))
                    .title("You are here!"));

        }


    }

    private class MyGpsListener implements GpsStatus.Listener, LocationListener {

        @Override
        public void onGpsStatusChanged(int event) {

        }

        @Override
        public void onLocationChanged(Location location) {
            Log.d("Travelway", "onLocationChanged accuracy: " + location.getAccuracy() + " longitude: " + location.getLongitude() + " latitude: " + location.getLatitude());
            if (location.getAccuracy() < 100) {
                zoomToMyPos(location);
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}

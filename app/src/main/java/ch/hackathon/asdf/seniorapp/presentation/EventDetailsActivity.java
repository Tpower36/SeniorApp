package ch.hackathon.asdf.seniorapp.presentation;

import android.app.AlertDialog;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.personalized.HereContent;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.R;
import ch.hackathon.asdf.seniorapp.services.EventsServices;

public class EventDetailsActivity extends AppCompatActivity {
    Long id;
    Event event;
    GoogleMap gmap;
    Address address;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        id = Long.valueOf(getIntent().getExtras().getString("ID"));
        event = EventsServices.getEventById(this, id);

        if (event == null) {
            TextView err = (TextView) findViewById(R.id.eventNameView);
            err.setText("Aucun événement trouvé à cet emplacement... Veuillez réessayer");
        } else {

            TextView nom = (TextView) findViewById(R.id.eventNameView);
            nom.setText(event.getTitle());


            TextView desc = (TextView) findViewById(R.id.eventDescriptionView);
            if (event.getDescription() == null) {
                desc.setText("Aucune description");
            } else {
                desc.setText(event.getDescription());
            }

            TextView date = (TextView) findViewById(R.id.eventDateView);
            if (event.getEventDate() == null) {
                date.setText("Aucune date");
            } else {
                date.setText(event.getEventDate().toString());
            }
            //A faire : Implémenter le lieu sur la map...


            gmap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

            try {
                //Utilisation d'un GeoCoder pour obtenir les Latitude et Longitude de l'emplacement
                Geocoder geocoder = new Geocoder(this);
                List<Address> addresses = geocoder.getFromLocationName(event.getLocation(), 1);
                address = addresses.get(0);


            } catch (IOException e) {

                e.printStackTrace();
            }

        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void editEvent(View button) {
        Intent intent = new Intent(EventDetailsActivity.this, EventEditActivity.class);
        intent.putExtra("ID", String.valueOf(id));
        startActivity(intent);
    }

    public void deleteEvent(View button) {

        EventsServices.deleteEvent(this, event);
        Intent intent = new Intent(EventDetailsActivity.this, EventsActivity.class);
        startActivity(intent);
    }

    protected boolean isRouteDisplayed() {
        return false;
    }

    protected boolean isLocationDisplayed() {
        return true;
    }



    public void onMapReady(GoogleMap googleMap) {
        gmap.addMarker(new MarkerOptions()
                .position(new LatLng(address.getLatitude(), address.getLongitude()))
                .title("Lieu de rendez-vous"));
    }
}

package ch.hackathon.asdf.seniorapp.presentation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;


import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.R;
import ch.hackathon.asdf.seniorapp.services.EventsServices;

public class EventDetailsActivity extends FragmentActivity
        implements OnMapReadyCallback {
    Long id;
    Event event;
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

            GoogleMap gmap;
            gmap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

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


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        /*client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "EventDetails Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://ch.hackathon.asdf.seniorapp.presentation/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);*/
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        /*Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "EventDetails Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://ch.hackathon.asdf.seniorapp.presentation/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();*/
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}

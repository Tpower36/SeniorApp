package ch.hackathon.asdf.seniorapp.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.R;
import ch.hackathon.asdf.seniorapp.services.EventsServices;

public class EventDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        long id;
        id = 0;
        Event event = null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        event = EventsServices.getEventById(this, Long.valueOf(getIntent().getExtras().getString("ID")));

        if(event == null){
            TextView err = (TextView) findViewById(R.id.eventNameView);
            err.setText("Aucun événement trouvé à cet emplacement... Veuillez réessayer");
        } else {

            TextView nom = (TextView) findViewById(R.id.eventNameView);
            nom.setText(event.getTitle());

            TextView desc = (TextView) findViewById(R.id.eventDescription);
            desc.setText(event.getDescription());

            TextView date = (TextView) findViewById(R.id.eventDate);
            date.setText(event.getEventDate().toString());

            //A faire : Implémenter le lieu sur la map...
        }

    }
}

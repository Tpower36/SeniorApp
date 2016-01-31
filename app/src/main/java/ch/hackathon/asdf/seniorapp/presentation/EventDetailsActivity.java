package ch.hackathon.asdf.seniorapp.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.R;
import ch.hackathon.asdf.seniorapp.services.EventsServices;

public class EventDetailsActivity extends AppCompatActivity {
    Long id;
    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        id= Long.valueOf(getIntent().getExtras().getString("ID"));
        event = EventsServices.getEventById(this,id);

        if(event == null){
            TextView err = (TextView) findViewById(R.id.eventNameView);
            err.setText("Aucun événement trouvé à cet emplacement... Veuillez réessayer");
        } else {

            TextView nom = (TextView) findViewById(R.id.eventNameView);
            nom.setText(event.getTitle());


            TextView desc = (TextView) findViewById(R.id.eventDescriptionView);
            if(event.getDescription() == null){
                desc.setText("Aucune description");
            }else {
                desc.setText(event.getDescription());
            }

            TextView date = (TextView) findViewById(R.id.eventDateView);
            if(event.getEventDate() == null) {
                date.setText("Aucune date");
            }else {
                date.setText(event.getEventDate().toString());
            }
            //A faire : Implémenter le lieu sur la map...
        }

    }

    public void editEvent(View button){
        Intent intent = new Intent(EventDetailsActivity.this, EventEditActivity.class);
        intent.putExtra("ID", String.valueOf(id));
        startActivity(intent);
    }
    public void deleteEvent(View button){

        EventsServices.deleteEvent(this, event);
        Intent intent = new Intent(EventDetailsActivity.this, EventsActivity.class);
        startActivity(intent);
    }
}

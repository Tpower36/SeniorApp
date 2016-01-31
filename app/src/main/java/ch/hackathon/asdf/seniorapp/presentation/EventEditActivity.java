package ch.hackathon.asdf.seniorapp.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.R;
import ch.hackathon.asdf.seniorapp.services.EventsServices;

public class EventEditActivity extends AppCompatActivity {

    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);

        Long id = Long.valueOf(getIntent().getExtras().getString("ID"));

        EditText title = (EditText)findViewById(R.id.editEventTitle);
        EditText description = (EditText)findViewById(R.id.editEventDescription);
        EditText date = (EditText)findViewById(R.id.editEventDate);
        EditText location = (EditText)findViewById(R.id.editEventLocation);

        event = EventsServices.getEventById(this,id);
        title.setText(event.getTitle());
        description.setText(event.getDescription());
        date.setText(event.getEventDate());
        location.setText(event.getLocation());


    }

    public void editEvent(View button){
        final EditText titleField = (EditText) findViewById(R.id.editEventTitle);
        String title = titleField.getText().toString();

        final EditText descriptionField = (EditText) findViewById(R.id.editEventDescription);
        String description = descriptionField.getText().toString();

        final EditText dateField = (EditText) findViewById(R.id.editEventDate);
        String date = dateField.getText().toString();

        final EditText locationField = (EditText) findViewById(R.id.editEventLocation);
        String location = locationField.getText().toString();

        event.setTitle(title);
        event.setEventDate(date);
        if(description != null){
            event.setDescription(description);
        }
        if(location !=null){
            event.setLocation(location);
        }
        EventsServices.editEvent(this, event);

        Intent intent = new Intent(EventEditActivity.this, EventsActivity.class);
        startActivity(intent);
        EventsServices.editEvent(this, event);
    }
}

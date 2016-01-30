package ch.hackathon.asdf.seniorapp.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.R;
import ch.hackathon.asdf.seniorapp.services.EventsServices;

public class AddEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }

    public void addEvent(View button){
        final EditText titleField = (EditText) findViewById(R.id.editTitle);
        String title = titleField.getText().toString();

        final EditText descriptionField = (EditText) findViewById(R.id.editDescription);
        String description = descriptionField.getText().toString();

        final EditText dateField = (EditText) findViewById(R.id.editDate);
        String date = dateField.getText().toString();

        final EditText locationField = (EditText) findViewById(R.id.editLocation);
        String location = locationField.getText().toString();

        Event event = new Event();
        event.setTitle(title);
        event.setEventDate(date);
        if(description != null){
            event.setDescription(description);
        }
        if(location !=null){
            event.setLocation(location);
        }
        EventsServices.addEvent(this, event);

        Intent intent = new Intent(AddEventActivity.this, EventsActivity.class);
        startActivity(intent);
    }
}

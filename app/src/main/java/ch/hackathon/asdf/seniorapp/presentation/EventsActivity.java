package ch.hackathon.asdf.seniorapp.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.R;
import ch.hackathon.asdf.seniorapp.presentation.adapter.EventAdapter;
import ch.hackathon.asdf.seniorapp.services.EventsServices;

public class EventsActivity extends AppCompatActivity {

    private List<Event> eventsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        if(EventsServices.getAllEvents(this)!=null) {
            eventsList = EventsServices.getAllEvents(this);
        }
        else{
            eventsList = new ArrayList<>();
            eventsList.add(new Event(0,"Pas d'événement Trouvé"," ", "", ""));
        }
            EventAdapter adapter = new EventAdapter(this, eventsList);

            ListView eventsListView = (ListView) findViewById(android.R.id.list);
            eventsListView.setAdapter(adapter);
            eventsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    long personId = eventsList.get(position).getId();

                /*
                Intent intent = new Intent(ListPersonneActivity.this, DetailPersonneActivity.class);
                intent.putExtra("ID", String.valueOf(personId));
                startActivity(intent);*/
                }
            });
        }

    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        Event event = null;
        switch (view.getId()) {
            case R.id.add:
                Intent intent = new Intent(EventsActivity.this, AddEventActivity.class);
                startActivity(intent);
                break;
        }

    }


}

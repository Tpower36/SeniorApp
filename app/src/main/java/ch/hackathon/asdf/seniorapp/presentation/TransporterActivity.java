package ch.hackathon.asdf.seniorapp.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.Business.Transporter;
import ch.hackathon.asdf.seniorapp.R;
import ch.hackathon.asdf.seniorapp.presentation.adapter.EventAdapter;
import ch.hackathon.asdf.seniorapp.presentation.adapter.TransporterAdapter;
import ch.hackathon.asdf.seniorapp.services.EventsServices;

public class TransporterActivity extends AppCompatActivity {

    private List<Transporter> transportersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        transportersList = getTransporters();

        TransporterAdapter adapter = new TransporterAdapter(this, transportersList);

        ListView eventsListView = (ListView) findViewById(android.R.id.list);
        eventsListView.setAdapter(adapter);
        eventsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long personId = transportersList.get(position).getId();

            }
        });
    }

    private List<Transporter> getTransporters(){
        List<Transporter> list = new ArrayList<>();
        list.add(new Transporter("AAA Taxi Tyby Sàrl", "079 230 68 00"));
        list.add(new Transporter("Transport pour personnes agées et handicapées","026 663 90 10"));
        list.add(new Transporter("EasyAidService Sàrl", "079 911 24 24"));
        list.add(new Transporter("Passe Partout Glâne", "026 656 10 33"));
        list.add(new Transporter("PassePartout-Sarine", "026 422 56 20"));
        list.add(new Transporter("PassePartout Veveyse", "021 948 11 00"));

        return list;
    }
}


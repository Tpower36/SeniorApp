package ch.hackathon.asdf.seniorapp.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.R;

/**
 * Created by thierry.hubmann on 30.01.2016.
 */
public class EventAdapter extends ArrayAdapter<Event> {

    public EventAdapter(Context context, List<Event> events){
        super(context, 0, events);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Event event = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_item, parent, false);
        }

        TextView tvId = (TextView) convertView.findViewById(R.id.eventId);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.eventTitle);
        TextView tvDescription = (TextView) convertView.findViewById(R.id.eventDescription);

        //C'est a ce moment qu'on assigne les valeurs aux textView
        tvId.setText(String.valueOf(event.getId()));
        tvTitle.setText(event.getTitle());
        tvDescription.setText(event.getDescription());

        return convertView;
    }
}

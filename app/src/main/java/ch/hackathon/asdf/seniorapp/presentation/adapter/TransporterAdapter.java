package ch.hackathon.asdf.seniorapp.presentation.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.Business.Transporter;
import ch.hackathon.asdf.seniorapp.R;

/**
 * Created by thierry.hubmann on 31.01.2016.
 */
public class TransporterAdapter extends ArrayAdapter<Transporter>{

    public TransporterAdapter(Context context, List<Transporter> transporters){
        super(context, 0, transporters);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Transporter transporter = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.transporter_item, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.transporterName);
        TextView tvNumber = (TextView) convertView.findViewById(R.id.transporterNumber);

        //C'est a ce moment qu'on assigne les valeurs aux textView
        Log.i("TEST", transporter.getNumber());

        tvName.setText(transporter.getName());
        tvNumber.setText(transporter.getNumber());

        return convertView;
    }
}

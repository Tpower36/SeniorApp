package ch.hackathon.asdf.seniorapp.presentation.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import ch.hackathon.asdf.seniorapp.R;

public class ContactAdapter extends ArrayAdapter<String> {

    public ContactAdapter(Context context, List<String> contacts) {
        super(context, 0, contacts);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        String contact = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_item, parent, false);
        }

        TextView tvUsername = (TextView) convertView.findViewById(R.id.contactUsername);

        //C'est a ce moment qu'on assigne les valeurs aux textView
        tvUsername.setText(contact);

        return convertView;
    }

}

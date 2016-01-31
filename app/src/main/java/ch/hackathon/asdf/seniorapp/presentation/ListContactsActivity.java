package ch.hackathon.asdf.seniorapp.presentation;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ch.hackathon.asdf.seniorapp.R;
import ch.hackathon.asdf.seniorapp.presentation.adapter.ContactAdapter;
import ch.hackathon.asdf.seniorapp.utils.SkypeContacts;

public class ListContactsActivity extends AppCompatActivity {

    private List<String> contacts;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_contacts_list);

        ContactAdapter adapter = new ContactAdapter(this, contacts);
        ListView contactsListView = (ListView) findViewById(android.R.id.list);
        contactsListView.setAdapter(adapter);
        contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String contact = contacts.get(position);
                Intent sky = new Intent("android.intent.action.VIEW");
                sky.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                sky.setData(Uri.parse("skype:" + contact));
                Log.d("UTILS", "tel:" + contact);
                startActivity(sky);

            }
        });

    }

}

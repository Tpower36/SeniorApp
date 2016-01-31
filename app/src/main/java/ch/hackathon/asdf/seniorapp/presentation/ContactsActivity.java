package ch.hackathon.asdf.seniorapp.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ch.hackathon.asdf.seniorapp.R;
import ch.hackathon.asdf.seniorapp.services.ContactsServices;


public class ContactsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        TextView fav1 = (TextView)findViewById(R.id.favContact1);
        TextView fav2 = (TextView)findViewById(R.id.favContact2);
        TextView fav3 = (TextView)findViewById(R.id.favContact3);


        if (ContactsServices.getContactByRank(this, 1) == null) {
            fav1.setText("Non renseigné");
        } else {
            fav1.setText(ContactsServices.getContactByRank(this, 1).getUsername());
        }

        if (ContactsServices.getContactByRank(this, 2) == null) {
            fav2.setText("Non renseigné");
        } else {
            fav2.setText(ContactsServices.getContactByRank(this, 2).getUsername());
        }

        if (ContactsServices.getContactByRank(this, 3) == null) {
            fav2.setText("Non renseigné");
        } else {
            fav3.setText(ContactsServices.getContactByRank(this, 3).getUsername());
        }
    }

    public void editFavorite(View button){
        Intent intent = new Intent(ContactsActivity.this, ContactEditActivity.class);
        startActivity(intent);
    }

    public void displayContacts(View button){
        Intent intent = new Intent(ContactsActivity.this, ListContactsActivity.class);
        startActivity(intent);
    }

}

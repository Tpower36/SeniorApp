package ch.hackathon.asdf.seniorapp.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import ch.hackathon.asdf.seniorapp.Business.Contact;
import ch.hackathon.asdf.seniorapp.R;
import ch.hackathon.asdf.seniorapp.services.ContactsServices;
import ch.hackathon.asdf.seniorapp.utils.SkypeContacts;

public class ContactEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_edit);
        fillSpinners();
    }

    private void fillSpinners() {
        Spinner spinnerR1 = (Spinner) findViewById(R.id.spinnerRank1);
        Spinner spinnerR2 = (Spinner) findViewById(R.id.spinnerRank2);
        Spinner spinnerR3 = (Spinner) findViewById(R.id.spinnerRank3);

        List contactsList = SkypeContacts.getSkypeContacts(this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, contactsList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerR1.setAdapter(dataAdapter);
        spinnerR1.setSelection(getContactPosition(ContactsServices.getContactByRank(this, 1).getUsername()));

        spinnerR2.setAdapter(dataAdapter);
        spinnerR2.setSelection(getContactPosition(ContactsServices.getContactByRank(this, 2).getUsername()));

        spinnerR3.setAdapter(dataAdapter);
        spinnerR3.setSelection(getContactPosition(ContactsServices.getContactByRank(this, 3).getUsername()));

    }

    public void editTop3(View button) {
        Spinner spinnerR1 = (Spinner) findViewById(R.id.spinnerRank1);
        Spinner spinnerR2 = (Spinner) findViewById(R.id.spinnerRank2);
        Spinner spinnerR3 = (Spinner) findViewById(R.id.spinnerRank3);
        Contact contact1 = new Contact();
        contact1.setId(1);
        contact1.setUsername(String.valueOf(spinnerR1.getSelectedItem()));
        ContactsServices.addToTop(this, contact1, 1);

        Contact contact2 = new Contact();
        contact2.setId(2);
        contact2.setUsername(String.valueOf(spinnerR2.getSelectedItem()));
        ContactsServices.addToTop(this, contact2, 2);


        Contact contact3 = new Contact();
        contact3.setId(1);
        contact3.setUsername(String.valueOf(spinnerR3.getSelectedItem()));
        ContactsServices.addToTop(this, contact3, 3);

        Intent intent = new Intent(ContactEditActivity.this, ContactsActivity.class);
        startActivity(intent);
    }

    /**
     * Méthode retournant la position du contact dans la liste
     *
     * @return la position du contact
     */
    private int getContactPosition(String username) {
        List contactsList = SkypeContacts.getSkypeContacts(this);
        boolean found = false;
        int i = 0;
        while (!found) {
            if (contactsList.get(i).equals(username)) {
                found = true;
            } else {
                i++;
            }
        }
        return i;
    }
}

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

    private void fillSpinners(){
        Spinner spinnerR1=(Spinner)findViewById(R.id.spinnerRank1);
        Spinner spinnerR2=(Spinner)findViewById(R.id.spinnerRank2);
        Spinner spinnerR3=(Spinner)findViewById(R.id.spinnerRank3);

        List contactsList = SkypeContacts.getSkypeContacts(this);
        contactsList.add("Non changé");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, contactsList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerR1.setAdapter(dataAdapter);
        if(ContactsServices.isRankSet(this,1)){
            spinnerR1.setSelection(contactsList.size());
        }
        spinnerR2.setAdapter(dataAdapter);
        if(ContactsServices.isRankSet(this,2)){
            spinnerR2.setSelection(contactsList.size());
        }
        spinnerR3.setAdapter(dataAdapter);
        if(ContactsServices.isRankSet(this,3)){
            spinnerR3.setSelection(contactsList.size());
        }
    }

    public void editTop3(View button){
        Spinner spinnerR1=(Spinner)findViewById(R.id.spinnerRank1);
        Spinner spinnerR2=(Spinner)findViewById(R.id.spinnerRank2);
        Spinner spinnerR3=(Spinner)findViewById(R.id.spinnerRank3);
        if(spinnerR1.getSelectedItem().toString() != null) {
            Contact contact1 = new Contact();
            contact1.setId(1);
            contact1.setUsername(String.valueOf(spinnerR1.getSelectedItem()));
            ContactsServices.addToTop(this, contact1, 1);
        }
        if(spinnerR2.getSelectedItem().toString() != null) {
            Contact contact2 = new Contact();
            contact2.setId(2);
            contact2.setUsername(String.valueOf(spinnerR2.getSelectedItem()));
            ContactsServices.addToTop(this, contact2, 2);
        }
        if(spinnerR3.getSelectedItem().toString() != null) {
            Contact contact3 = new Contact();
            contact3.setId(1);
            contact3.setUsername(String.valueOf(spinnerR3.getSelectedItem()));
            ContactsServices.addToTop(this, contact3, 3);
        }
        Intent intent = new Intent(ContactEditActivity.this, ContactsActivity.class);
        startActivity(intent);
    }
}

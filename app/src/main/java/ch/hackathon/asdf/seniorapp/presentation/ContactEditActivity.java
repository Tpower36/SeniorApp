package ch.hackathon.asdf.seniorapp.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import ch.hackathon.asdf.seniorapp.R;

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
        Spinner spinnerR3=(Spinner)findViewById(R.id.spinnerRank1);
    }
}

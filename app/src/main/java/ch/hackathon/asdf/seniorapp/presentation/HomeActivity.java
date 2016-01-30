package ch.hackathon.asdf.seniorapp.presentation;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import ch.hackathon.asdf.seniorapp.R;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void startEvent(View button){
        Intent intent = new Intent(HomeActivity.this, EventsActivity.class);
        startActivity(intent);
    }


}

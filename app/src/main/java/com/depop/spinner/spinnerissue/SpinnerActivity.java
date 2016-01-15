package com.depop.spinner.spinnerissue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.depop.spinner.myapplication.R;
import com.depop.spinner.spinnerissue.view.LabelledSpinner;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.us_states, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final LabelledSpinner stateSpinner = (LabelledSpinner) findViewById(R.id.state_labelled_spinner);
        stateSpinner.setAdapter(adapter);

        final Spinner normalSpinner = (Spinner) findViewById(R.id.state_normal_spinner);
        normalSpinner.setAdapter(adapter);

        final Spinner classicSpinner = (Spinner) findViewById(R.id.state_classic_spinner);
        classicSpinner.setAdapter(adapter);
    }
}


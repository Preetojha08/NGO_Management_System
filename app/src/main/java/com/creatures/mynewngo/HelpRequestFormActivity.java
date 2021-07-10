package com.creatures.mynewngo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class HelpRequestFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_request_form);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_help_form);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Send Help Request");


    }
}
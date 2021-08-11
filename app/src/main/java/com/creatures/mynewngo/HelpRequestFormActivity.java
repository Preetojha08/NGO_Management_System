package com.creatures.mynewngo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class HelpRequestFormActivity extends AppCompatActivity {

    TextInputEditText tiet_type_of_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_request_form);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_help_form);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Send Help Request");

        tiet_type_of_help=(TextInputEditText)findViewById(R.id.text_input_edit_text_help_form_typeOfHelp);

        Intent intent = getIntent();
        String str = intent.getStringExtra("Help_type");
        Toast.makeText(this, " "+str, Toast.LENGTH_SHORT).show();
        tiet_type_of_help.setText(str);



    }
}
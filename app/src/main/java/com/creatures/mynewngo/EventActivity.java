package com.creatures.mynewngo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    RecyclerView event_recyclerView;
    List<String> e_Titles;
    List<String> e_sub_titles;
    List<Integer> e_images;
    HelperCardRecyclerAdapter event_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_events);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Events");

        event_recyclerView=(RecyclerView)findViewById(R.id.event_recycler_view);

        e_Titles = new ArrayList<>();
        e_sub_titles = new ArrayList<>();
        e_images = new ArrayList<>();

        e_images.add(R.drawable.new_event_1);
        e_images.add(R.drawable.new_event_1);
        e_images.add(R.drawable.new_event_1);
        e_images.add(R.drawable.new_event_1);

        e_Titles.add("Blood Donation");
        e_Titles.add("Food Distribution");
        e_Titles.add("Money Donation");
        e_Titles.add("Health Camp");

        e_sub_titles.add("Blood Donation Camp");
        e_sub_titles.add("Food Distribution Among Peoples");
        e_sub_titles.add("Money Collection Camp");
        e_sub_titles.add("Medical Camp For Health Check Ups");

        event_adapter = new HelperCardRecyclerAdapter(this,e_Titles,e_sub_titles,e_images,10);

        event_recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        event_recyclerView.setAdapter(event_adapter);






    }
}
package com.creatures.mynewngo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HelpActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> titles;
    List<String> sub_titles;
    List<Integer> images;

    HelperCardRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_help);
        setSupportActionBar(toolbar);

        titles = new ArrayList<>();
        sub_titles = new ArrayList<>();
        images = new ArrayList<>();

        recyclerView=(RecyclerView)findViewById(R.id.help_cards_recycler_view);

        titles.add("First Item");
        titles.add("Second Item");
        titles.add("Third Item");
        titles.add("Fourth Item");
        titles.add("Fifth Item");
        titles.add("Sixth Item");

        sub_titles.add("Item 1");
        sub_titles.add("Item 2");
        sub_titles.add("Item 3");
        sub_titles.add("Item 4");
        sub_titles.add("Item 5");
        sub_titles.add("Item 6");

        images.add(R.drawable.info);
        images.add(R.drawable.info);
        images.add(R.drawable.info);
        images.add(R.drawable.info);
        images.add(R.drawable.info);
        images.add(R.drawable.info);

        adapter = new HelperCardRecyclerAdapter(this,titles,sub_titles,images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);


    }
}
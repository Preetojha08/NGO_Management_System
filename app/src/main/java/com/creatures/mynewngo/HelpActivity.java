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

        titles.add("Cancer Treatment");//1
        titles.add("Liver Treatment");//2
        titles.add("Accident & Injury");//3
        titles.add("Heart Issue");//4
        titles.add("Kidney Treatment");//5
        titles.add("Brain Surgery");//6
        titles.add("COVID Treatment");//7
        titles.add("Request for Different Kind of Issue");//8

        sub_titles.add("Maximum Fund Raised \n ₹54 Lakhs");
        sub_titles.add("Maximum Fund Raised \n ₹22 Lakhs");
        sub_titles.add("Maximum Fund Raised \n ₹29 Lakhs");
        sub_titles.add("Maximum Fund Raised \n ₹30 Lakhs");

        sub_titles.add("Maximum Fund Raised \n ₹20 Lakhs");
        sub_titles.add("Maximum Fund Raised \n ₹50 Lakhs");
        sub_titles.add("Maximum Fund Raised \n ₹28 Lakhs");
        sub_titles.add("Any Type of Help");

        images.add(R.drawable.cancer);//1
        images.add(R.drawable.liver);//2
        images.add(R.drawable.knee);//
        images.add(R.drawable.heart);//4
        images.add(R.drawable.kidney);//5
        images.add(R.drawable.brain);//6
        images.add(R.drawable.covid);//7
        images.add(R.drawable.help_card);//8

        adapter = new HelperCardRecyclerAdapter(this,titles,sub_titles,images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);


    }
}
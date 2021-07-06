package com.creatures.mynewngo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class HelpActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> titles;
    List<String> sub_titles;
    List<Integer> images;
    BarChart bar_chart;
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
        titles.add("Different Kind of Help");//8Request for Different Kind of Issue

        sub_titles.add("Maximum Fund Raised \n ₹54 Lakhs");
        sub_titles.add("Maximum Fund Raised \n ₹22 Lakhs");
        sub_titles.add("Maximum Fund Raised \n ₹29 Lakhs");
        sub_titles.add("Maximum Fund Raised \n ₹30 Lakhs");

        sub_titles.add("Maximum Fund Raised \n ₹20 Lakhs");
        sub_titles.add("Maximum Fund Raised \n ₹50 Lakhs");
        sub_titles.add("Maximum Fund Raised \n ₹28 Lakhs");
        sub_titles.add("Request for Any Type of Issue");//Request for Different Kind of Issue

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


        //Bar Graph Chart
        bar_chart=(BarChart)findViewById(R.id.help_bar_chart);

        ArrayList<BarEntry> bar_entry_array_list = new ArrayList<>();

        bar_entry_array_list.add(new BarEntry(2016,430));
        bar_entry_array_list.add(new BarEntry(2017,440));
        bar_entry_array_list.add(new BarEntry(2018,400));
        bar_entry_array_list.add(new BarEntry(2019,300));
        bar_entry_array_list.add(new BarEntry(2020,430));
        bar_entry_array_list.add(new BarEntry(2021,486));

        BarDataSet bar_data_set = new BarDataSet(bar_entry_array_list,"Requests");
        bar_data_set.setColors(ColorTemplate.MATERIAL_COLORS);
        bar_data_set.setValueTextColor(Color.BLACK);
        bar_data_set.setValueTextSize(11f);

        BarData bar_data = new BarData(bar_data_set);

        bar_chart.setFitBars(true);
        bar_chart.setData(bar_data);
        boolean bol=true;
        bar_chart.getDescription().setText("User Help Requests Chart");
        bar_chart.animateY(2000);

    }
}
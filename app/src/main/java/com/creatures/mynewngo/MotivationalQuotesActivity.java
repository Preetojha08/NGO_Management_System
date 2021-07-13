package com.creatures.mynewngo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MotivationalQuotesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Integer> motivational_quotes_images;
    List<String> titles;
    List<String> sub_titles;
    HelperCardRecyclerAdapter motivational_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational_quotes2);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view_motivational_quotes);

        motivational_quotes_images = new ArrayList<>();
        titles = new ArrayList<>();
        sub_titles = new ArrayList<>();

        motivational_quotes_images.add(R.drawable.motive_1);//1
        motivational_quotes_images.add(R.drawable.motive_2);//1
        motivational_quotes_images.add(R.drawable.motive_3);//1
        motivational_quotes_images.add(R.drawable.motive_1);//1
        motivational_quotes_images.add(R.drawable.motive_2);//1
        motivational_quotes_images.add(R.drawable.motive_3);//1
        motivational_quotes_images.add(R.drawable.motive_1);//1
        motivational_quotes_images.add(R.drawable.motive_2);//1
        motivational_quotes_images.add(R.drawable.motive_3);//1
        motivational_quotes_images.add(R.drawable.motive_1);//1
        motivational_quotes_images.add(R.drawable.motive_2);//1
        motivational_quotes_images.add(R.drawable.motive_3);//1


        titles.add("title 1");//1
        titles.add("title 2");//2
        titles.add("title 3");//3
        titles.add("title 4");//4j
        titles.add("title 5");//5
        titles.add("title 6");//6
        titles.add("title 1");//1
        titles.add("title 2");//2
        titles.add("title 3");//3
        titles.add("title 4");//4j
        titles.add("title 5");//5
        titles.add("title 6");//6

        sub_titles.add("Sub Title 1");//1
        sub_titles.add("Sub Title 2");//2
        sub_titles.add("Sub Title 3");//3
        sub_titles.add("Sub Title 4");//4
        sub_titles.add("Sub Title 5");//5
        sub_titles.add("Sub Title 6");//6
        sub_titles.add("Sub Title 1");//1
        sub_titles.add("Sub Title 2");//2
        sub_titles.add("Sub Title 3");//3
        sub_titles.add("Sub Title 4");//4
        sub_titles.add("Sub Title 5");//5
        sub_titles.add("Sub Title 6");//6

        motivational_adapter = new HelperCardRecyclerAdapter(this,titles,sub_titles,motivational_quotes_images,20);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MotivationalQuotesActivity.this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(motivational_adapter);

    }
}
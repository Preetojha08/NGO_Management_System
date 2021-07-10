package com.creatures.mynewngo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class JobPortalActivity extends AppCompatActivity {

    List<String> job_heading;
    List<String> job_description;
    List<Integer> job_images;

    RecyclerView recyclerView;

    HelperCardRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_portal);

        recyclerView=(RecyclerView)findViewById(R.id.job_portal_recycler_view);

        job_heading = new ArrayList<>();
        job_description = new ArrayList<>();
        job_images = new ArrayList<>();

        //Job Heading
        job_heading.add("Office Worker"); //1
        job_heading.add("Programmer"); //2
        job_heading.add("Veterinarian"); //3
        job_heading.add("Street Vendor"); //4
        job_heading.add("Factory Worker"); //5
        job_heading.add("Miner"); //6
        job_heading.add("Teacher"); //7
        job_heading.add("Real Estate Agent"); //8

        //Job Description
        job_description.add("This is Job Description Here"); //1
        job_description.add("This is Job Description Here"); //2
        job_description.add("This is Job Description Here"); //3
        job_description.add("This is Job Description Here"); //4
        job_description.add("This is Job Description Here"); //5
        job_description.add("This is Job Description Here"); //6
        job_description.add("This is Job Description Here"); //7
        job_description.add("This is Job Description Here"); //8

        //Job Images
        job_images.add(R.drawable.info); //1
        job_images.add(R.drawable.info); //2
        job_images.add(R.drawable.info); //3
        job_images.add(R.drawable.info); //4
        job_images.add(R.drawable.info); //5
        job_images.add(R.drawable.info); //6
        job_images.add(R.drawable.info); //7
        job_images.add(R.drawable.info); //8

        adapter = new HelperCardRecyclerAdapter(this,job_heading,job_description,job_images,99);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

    }
}
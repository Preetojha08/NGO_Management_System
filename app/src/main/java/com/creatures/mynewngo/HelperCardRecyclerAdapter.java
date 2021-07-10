package com.creatures.mynewngo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HelperCardRecyclerAdapter extends RecyclerView.Adapter<HelperCardRecyclerAdapter.card_view_holder>{

    List<String> titles;
    List<String> sub_titles;
    List<Integer> images;
    LayoutInflater layoutInflater;
    Context context;

    public HelperCardRecyclerAdapter(Context context, List<String> titles, List<String> sub_titles, List<Integer> images) {
        this.titles = titles;
        this.sub_titles = sub_titles;
        this.images = images;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public card_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.help_cards,parent,false);
        return new card_view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HelperCardRecyclerAdapter.card_view_holder holder, int position) {
        holder.tv_help_card_heading.setText(titles.get(position));
        holder.tv_help_card_subheading.setText(sub_titles.get(position));
        holder.tv_help_card_image_view.setImageResource(images.get(position));
        int a = position;
        a++;
        int finalA = a;
        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,HelpRequestFormActivity.class);


                switch (finalA)
                {
                    case 1:
                        i.putExtra("Help_type","Cancer Treatment");
                        break;
                    case 2:
                        i.putExtra("Help_type","Liver Treatment");
                        break;
                    case 3:
                        i.putExtra("Help_type","Accident & Injury Treatment");
                        break;
                    case 4:
                        i.putExtra("Help_type","Heart Issue or Treatment");
                        break;
                    case 5:
                        i.putExtra("Help_type","Kidney Treatment");
                        break;
                    case 6:
                        i.putExtra("Help_type","Brain Treatment");
                        break;
                    case 7:
                        i.putExtra("Help_type","COVID Treatment");
                        break;
                    case 8:
                        i.putExtra("Help_type","Request for different kind of Help");
                        break;
                }
                context.startActivity(i);


            }
        });

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class card_view_holder extends RecyclerView.ViewHolder
    {
        TextView tv_help_card_heading,tv_help_card_subheading;
        ImageView tv_help_card_image_view;
        CardView card_view;
        public card_view_holder(@NonNull View itemView) {
            super(itemView);

            tv_help_card_heading=(TextView)itemView.findViewById(R.id.help_card_text_view_1);
            tv_help_card_subheading=(TextView)itemView.findViewById(R.id.help_card_text_view_2);
            tv_help_card_image_view=(ImageView)itemView.findViewById(R.id.help_card_image_view);
            card_view=(CardView)itemView.findViewById(R.id.help_card_details);


        }
    }
    
}

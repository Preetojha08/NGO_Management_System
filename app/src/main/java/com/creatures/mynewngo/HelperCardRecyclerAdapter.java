package com.creatures.mynewngo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class HelperCardRecyclerAdapter extends RecyclerView.Adapter<HelperCardRecyclerAdapter.card_view_holder>{

    List<String> titles;
    List<String> sub_titles;
    List<Integer> images;
    LayoutInflater layoutInflater;
    Context context;
    int card_details;


    public HelperCardRecyclerAdapter(Context context, List<Integer> images, int card_details) {
        this.images = images;
        this.card_details = card_details;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public HelperCardRecyclerAdapter(Context context, List<String> titles, List<String> sub_titles, List<Integer> images, int card_details) {
        this.titles = titles;
        this.sub_titles = sub_titles;
        this.images = images;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.card_details = card_details;
    }

    @NonNull
    @Override
    public card_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view_oncreate;
       if (card_details == 0)
       {
           view_oncreate = layoutInflater.inflate(R.layout.help_cards,parent,false);

       }
       else if (card_details == 99)
       {
           view_oncreate = layoutInflater.inflate(R.layout.job_details_card,parent,false);

       }
       else if (card_details == 10)
       {
           view_oncreate = layoutInflater.inflate(R.layout.event_cards,parent,false);
       }
       else if (card_details == 20)
       {
           view_oncreate = layoutInflater.inflate(R.layout.motivational_quotes_card,parent,false);
       }
       else
       {
           view_oncreate = layoutInflater.inflate(R.layout.help_cards,parent,false);
       }
        return new card_view_holder(view_oncreate);
    }

    @Override
    public void onBindViewHolder(@NonNull HelperCardRecyclerAdapter.card_view_holder holder, int position) {

        if (card_details == 0)
        {
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
                            i.putExtra("Help_type","Lungs Treatment");
                            break;
                        case 8:
                            i.putExtra("Help_type","COVID Treatment");
                            break;
                        case 9:
                            i.putExtra("Help_type","Eye Treatment");
                            break;
                        case 10:
                            i.putExtra("Help_type","Request for different kind of Help");
                            break;
                    }
                    context.startActivity(i);
                }
            });
        }

        if (card_details == 20)
        {
            holder.motivational_quotes_imagv.setImageResource(images.get(position));
        }

        if (card_details == 10)
        {
            holder.event_tv_1.setText(titles.get(position));
            holder.event_tv_2.setText(sub_titles.get(position));
            holder.event_iv.setImageResource(images.get(position));
            int a = position;
            a++;
            int finalA = a;
            holder.event_cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Event no: "+finalA, Toast.LENGTH_SHORT).show();
                }
            });

        }

        if (card_details == 99)
        {
            /*holder.tv_help_card_heading.setText(titles.get(position));
            holder.tv_help_card_subheading.setText(sub_titles.get(position));
            holder.tv_help_card_image_view.setImageResource(images.get(position));*/
            holder.tv_job_heading.setText(titles.get(position));
            holder.tv_job_description.setText(sub_titles.get(position));
            holder.job_circleImageView.setImageResource(images.get(position));
            int a = position;
            a++;
            int finalA = a;
            holder.job_details_card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Job CardView no: "+finalA, Toast.LENGTH_SHORT).show();
                }
            });


        }

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class card_view_holder extends RecyclerView.ViewHolder
    {
        TextView tv_help_card_heading,tv_help_card_subheading;
        ImageView tv_help_card_image_view;
        CardView card_view;

        TextView tv_job_heading,tv_job_description;
        CircleImageView job_circleImageView;
        CardView job_details_card_view;

        ImageView motivational_quotes_imagv;
        TextView tv_title_one_mq,tv_sub_title_two_mq;

        TextView event_tv_1,event_tv_2;
        ImageView event_iv,imageView_notification;
        CardView event_cardView;

        public card_view_holder(@NonNull View itemView) {
            super(itemView);

            if (card_details == 0)
            {
                tv_help_card_heading=(TextView)itemView.findViewById(R.id.help_card_text_view_1);
                tv_help_card_subheading=(TextView)itemView.findViewById(R.id.help_card_text_view_2);
                tv_help_card_image_view=(ImageView)itemView.findViewById(R.id.help_card_image_view);
                card_view=(CardView)itemView.findViewById(R.id.help_card_details);
            }

            if (card_details == 99)
            {
                tv_job_heading=(TextView)itemView.findViewById(R.id.text_view_job_heading);
                tv_job_description=(TextView)itemView.findViewById(R.id.text_view_job_description);
                job_circleImageView=(CircleImageView)itemView.findViewById(R.id.job_portal_Job_image_view);
                job_details_card_view=(CardView)itemView.findViewById(R.id.job_details_card_view);
            }

            if (card_details == 20)
            {
                motivational_quotes_imagv=(ImageView)itemView.findViewById(R.id.motivational_quotes_image_view);

            }

            if (card_details == 10)
            {
                event_tv_1=(TextView)itemView.findViewById(R.id.recycler_view_event_name_display);
                event_tv_2=(TextView)itemView.findViewById(R.id.recycler_view_event_description_display);

                imageView_notification=(ImageView)itemView.findViewById(R.id.event_notification_image_view);
                event_iv=(ImageView)itemView.findViewById(R.id.image_view_event_image);
                event_cardView=(CardView)itemView.findViewById(R.id.event_details_card_view);

            }


        }
    }
    
}

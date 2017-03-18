package com.example.admin.schoolappondemand;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 3/17/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Myholder> {

    ArrayList<NewsModel> Al=new ArrayList<>();
    int res;
    Activity obj;


    NewsAdapter(Activity obj, int res, ArrayList<NewsModel> Al)
    {
        this.obj= obj;
        this.res=res;
        this.Al=Al;
    }


    @Override
    public NewsAdapter.Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(obj).inflate(res,parent,false);

      Myholder myholder=new Myholder(view);

        return myholder ;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.Myholder holder, int position) {

        NewsModel n1=Al.get(position);

        holder.iv.setImageResource(n1.getNwimg());
        holder.heading.setText(n1.getNwsheading());
        holder.dt.setText(n1.getNwsdt());
        holder.news.setText(n1.getNws());




    }

    @Override
    public int getItemCount() {
        return Al.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView iv;
        TextView heading,dt,news;
        Button mrdtl;

        public Myholder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.crd_nws);
            iv= (ImageView) itemView.findViewById(R.id.iv_nws_title);
            heading= (TextView) itemView.findViewById(R.id.nws_hdng);
            dt= (TextView) itemView.findViewById(R.id.nws_dt);
            news= (TextView) itemView.findViewById(R.id.nws);
            mrdtl= (Button) itemView.findViewById(R.id.shw_nws);


        }
    }
}

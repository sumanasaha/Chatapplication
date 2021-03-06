package com.example.sumanasaha.chatapplication;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by sumanasaha on 25/01/16.
 */
public class VivzAdapter extends RecyclerView.Adapter<VivzAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    ArrayList<String> data= new ArrayList<>();
    int height,hl,ml;
    String currentTimeString;



    public VivzAdapter(Context context,ArrayList<String> data,int height,int hl,String currentTimeString)
    {
        inflater = LayoutInflater.from(context);
        this.data=data;
        this.height=height;
        this.hl=hl;
        this.ml=ml;
        this.currentTimeString=currentTimeString;
    }

    public VivzAdapter() {
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(data.size()==1)
        {



          int holderheight=holder.container.getHeight();
            TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT); // (width, height)
           // params.topMargin=height-(hl+holderheight);
            int margin= (int) (height*0.5);
            params.topMargin= (int) margin;
            holder.container.setLayoutParams(params);
        }

        if(data.size()!=0) {
            holder.title.setText(data.get(position));
            holder.date.setText(currentTimeString);
          //  holder.icon.setImageResource(current.iconId);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout container;
        LinearLayout bottomsection1;
        TextView title;
        TextView date;
       // ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.listText);
            container = (LinearLayout) itemView.findViewById(R.id.containerlayout);
            date= (TextView) itemView.findViewById(R.id.date);

       //     icon= (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}

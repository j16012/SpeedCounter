package com.example.speedcounter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by J16012 on 2018/01/17.
 * レイアウトのカードのAdapter
 *
 */

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.ViewHolder>{
    private String[] list;
    private Context context;
    private int width,height;

    public CardRecyclerAdapter(Context context,String[] stringArray) {
        super();
        this.list = stringArray;
        this.context = context;

    }
    public CardRecyclerAdapter(Context context,String[] stringArray,int width,int height) {
        super();
        this.list = stringArray;
        this.context = context;
        this.width=width;
        this.height=height;
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    @Override
    public void onBindViewHolder(ViewHolder vh, final int position) {

        vh.textView_main.setText(list[position]);
        ImageGetTask imageGetTask = new ImageGetTask(vh.image);
        String size = String.valueOf(this.width);
        size+="x";
        size+=String.valueOf(this.height);
        String url ="https://maps.googleapis.com/maps/api/streetview?size=600x300&location=34.982143,138.406242&fov=110&pitch=1&key=AIzaSyBwuuctRqMeC3jNiyNFoWTcxqIpx0-sQZQ";
        imageGetTask.execute(url);
        vh.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,list[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public CardRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView_main;
        Button button;
        ImageView image;

        public ViewHolder(View v) {
            super(v);
            textView_main = (TextView)v.findViewById(R.id.textView3);
            button = (Button)v.findViewById(R.id.card_button);
            image = (ImageView)v.findViewById(R.id.card_image);

        }
    }
}
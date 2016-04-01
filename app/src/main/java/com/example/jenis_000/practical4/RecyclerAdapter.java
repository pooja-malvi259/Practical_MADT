package com.example.jenis_000.practical4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jenis_000 on 3/12/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolderM> {
    private ArrayList<DataProvider> arrayList=new ArrayList<DataProvider>();

    public RecyclerAdapter(ArrayList<DataProvider> arrayList){
        this.arrayList=arrayList;
    }
    @Override
    public RecyclerViewHolderM onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerViewHolderM recyclerViewHolderM=new RecyclerViewHolderM(view);

        return recyclerViewHolderM;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolderM holder, int position) {
        DataProvider dataProvider=arrayList.get(position);
        holder.imageView.setImageResource(dataProvider.getImg_res());
        holder.s_name.setText(dataProvider.getS_name());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolderM extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView s_name;

        public RecyclerViewHolderM(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.img);
            s_name=(TextView)itemView.findViewById(R.id.s_name);
        }
    }
}

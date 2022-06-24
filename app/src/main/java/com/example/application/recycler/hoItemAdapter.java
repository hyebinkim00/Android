package com.example.application.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;


import java.util.ArrayList;

public class hoItemAdapter extends RecyclerView.Adapter<hoItemAdapter.ViewHolder> {

    ArrayList<String> list;


     public hoItemAdapter(ArrayList<String> lists){
         list = lists;

    }

    private onClickListener clickListener;

    public interface onClickListener{
         void onCount(String count);
    }

    public void setClickListener(onClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_text);
        }
    }

    @NonNull
    @Override
    public hoItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_list,parent,false);
        hoItemAdapter.ViewHolder vh = new hoItemAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull hoItemAdapter.ViewHolder holder, int position) {
         holder.textView.setText(list.get(position));
       if (list.get(position).equals("Instagram"))
       {
           Log.d("Insta", String.valueOf(position));

       }
         holder.textView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 clickListener.onCount(String.valueOf(list.size()));
             }
         });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}

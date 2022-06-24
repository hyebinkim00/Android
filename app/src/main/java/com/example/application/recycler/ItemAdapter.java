package com.example.application.recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.Model;
import com.example.application.Name;
import com.example.application.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Model.Contents> list;

    public ItemAdapter(ArrayList<Model.Contents> lists){
        list = lists;
    }

    private onClickListener onClickListener;
    
   public interface onClickListener{
        void onItem(String item);
    }

    public void setOnClickListener(onClickListener listener){
       this.onClickListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_list,parent,false);
        View view2 = inflater.inflate(R.layout.item_list2,parent,false);
        ItemAdapter.ViewHolder viewHolder = new ItemAdapter.ViewHolder(view);
        ItemAdapter.ViewHolder2 viewHolder2 = new ItemAdapter.ViewHolder2(view2);

        if (viewType == 0){
            return viewHolder;
        }else {
            return viewHolder2;
        }

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       switch (holder.getItemViewType()){
           case 0 :
               ViewHolder holder1 = (ViewHolder) holder;
               holder1.textView.setText(list.get(position).getId()+list.get(position).getName());
               holder1.textView.setOnClickListener(new View.OnClickListener() {

                   @Override
                   public void onClick(View view) {
                       String ss = list.get(position).getId();
                       String pp = list.get(position).getName();
                       onClickListener.onItem(ss+pp);
                   }
               });
               break;
           case 1:
               ViewHolder2 holder2 = (ViewHolder2) holder;
               holder2.textView.setText(list.get(position).getName());
               break;
       }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }



    /*여러개의 뷰 타입을 사용할때 */
    @Override
    public int getItemViewType(int position) {
        Log.d("po",String.valueOf(position));
        return Integer.parseInt(list.get(position).getId())%2 == 0 ? 0 :1 ;

    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public ViewHolder(@NonNull View view){
            super(view);
            textView = view.findViewById(R.id.item_text);

        }

    }

    static class ViewHolder2 extends RecyclerView.ViewHolder{
        TextView textView;

        public ViewHolder2(@NonNull View view){
            super(view);
            textView = view.findViewById(R.id.text2);

        }

    }

}

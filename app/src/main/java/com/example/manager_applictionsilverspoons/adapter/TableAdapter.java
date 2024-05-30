package com.example.manager_applictionsilverspoons.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.manager_applictionsilverspoons.R;
import com.example.manager_applictionsilverspoons.model.OrderModel;
import com.example.manager_applictionsilverspoons.model.TableModel;

import java.util.ArrayList;

public abstract class TableAdapter extends RecyclerView.Adapter<TableAdapter.TViewHolder>{


    public ArrayList<TableModel> list;

    public Context context;

    public  onClickListener onClickListener;

    public TableAdapter(ArrayList<TableModel> list, Context context, onClickListener
            onClickListener) {
        this.list = list;
        this.context = context;
        this.onClickListener = onClickListener;
    }



    @NonNull
    @Override
    public TViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.raw_table, parent, false);
        TViewHolder viewHolder = new TViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TViewHolder holder, int position) {


        holder.tvtableid.setText(list.get(position).getId());
        holder.tvTableNumber.setText(list.get(position).getTnumber());
        holder.tvPerson.setText(list.get(position).getGuest());
        holder.tvDate.setText(list.get(position).getDate());
        holder.tvTime.setText(list.get(position).getTime());
       holder.table_id.setText("#"+list.get(position).getId());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public abstract void onClick(int position, TableModel tableModel);

    public  class TViewHolder extends RecyclerView.ViewHolder{

        TextView tvtableid,tvTableNumber,tvTime,tvDate,tvPerson,table_id;
        public TViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate=itemView.findViewById(R.id.tvDate);
            tvtableid=itemView.findViewById(R.id.tvtableid);
            tvTableNumber=itemView.findViewById(R.id.tvTableNumber);
            tvTime=itemView.findViewById(R.id.tvTime);
            tvPerson=itemView.findViewById(R.id.tvPerson);
            table_id=itemView.findViewById(R.id.table_id);

        }
    }

    public  interface  onClickListener{

        public void onClick(int position,TableModel  tableModel);
    }
}

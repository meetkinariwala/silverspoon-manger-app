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

import de.hdodenhof.circleimageview.CircleImageView;

public abstract class OrderAdapter extends  RecyclerView.Adapter<OrderAdapter.OrderViewholder>{


    public ArrayList<OrderModel> list;

    public Context context;

    public OrderAdapter.onClickListener onClickListener;

    public OrderAdapter(ArrayList<OrderModel> list, Context context, OrderAdapter.onClickListener
            onClickListener) {
        this.list = list;
        this.context = context;
        this.onClickListener = onClickListener;
    }



    @NonNull
    @Override
    public OrderAdapter.OrderViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.raw_menu, parent, false);
        OrderAdapter.OrderViewholder viewHolder = new OrderViewholder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderViewholder holder, int position) {

       // Glide.with(context).load(list.get(position).getPpic()).into(holder.img_order);
        holder.tvorder_id.setText("#"+list.get(position).getId());
        holder.tv_date.setText(list.get(position).getCreated_at());
        holder.tv_price.setText("Rs."+list.get(position).getTotal_amount());
        holder.userid.setText(list.get(position).getUid());
        holder.tvpay_type.setText(list.get(position).getPayment_type());

        holder.tv_view_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    onClickListener.onClick(position,list.get(position));
            }
        });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public  class OrderViewholder extends RecyclerView.ViewHolder{


        TextView tvorder_id,tv_date,tv_price,userid,tv_view_order,tvpay_type;
        CircleImageView img_order;

        public OrderViewholder(@NonNull View itemView) {
            super(itemView);

            tvorder_id=itemView.findViewById(R.id.tvorder_id);
            tv_date=itemView.findViewById(R.id.tv_date);
            tv_price=itemView.findViewById(R.id.tv_price);
            userid=itemView.findViewById(R.id.userid);
            img_order=itemView.findViewById(R.id.img_order);
            tv_view_order=itemView.findViewById(R.id.tv_view_order);
            tvpay_type=itemView.findViewById(R.id.tvpay_type);


        }
    }

    public  interface  onClickListener{

        public void onClick(int position,OrderModel  orderModel);
    }
}

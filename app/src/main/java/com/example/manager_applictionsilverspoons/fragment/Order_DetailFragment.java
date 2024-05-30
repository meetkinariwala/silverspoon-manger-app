package com.example.manager_applictionsilverspoons.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manager_applictionsilverspoons.HomeActivity;
import com.example.manager_applictionsilverspoons.R;
import com.example.manager_applictionsilverspoons.model.OrderModel;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class Order_DetailFragment extends Fragment {


    TextView tvorder_id,tv_dishname,tvtotal_amount,tv_amount,tvqty,tvsubtotal,tvgst,tv_grandTotal,tv_order_id,tvdate_time,tvpayment_type;

    ImageView btnbackarrow;

    FrameLayout fragment_container;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_oredr__detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OrderModel orderModel= (OrderModel) getArguments().getSerializable("order");



        tvorder_id=view.findViewById(R.id.tvorder_id);
        tv_dishname=view.findViewById(R.id.tv_dishname);
        tvtotal_amount=view.findViewById(R.id.tvtotal_amount);
        tv_amount=view.findViewById(R.id.tv_amount);
        tvqty=view.findViewById(R.id.tvqty);
        tvsubtotal=view.findViewById(R.id.tvsubtotal);
        tv_grandTotal=view.findViewById(R.id.tv_grandTotal);
        tv_order_id=view.findViewById(R.id.tv_order_id);
        tvdate_time=view.findViewById(R.id.tvdate_time);
        tvpayment_type=view.findViewById(R.id.tvpayment_type);
        btnbackarrow=view.findViewById(R.id.btnbackarrow);
        fragment_container=view.findViewById(R.id.fragment_container);

        btnbackarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                // Remove the current fragment
                Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_container); // replace "fragment_container" with the id of your fragment container
                if (currentFragment != null) {
                    fragmentManager.beginTransaction().remove(currentFragment).commit();
                }

                // Open the OrderFragment
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new OrderFragment()) // replace "fragment_container" with the id of your fragment container
                        .addToBackStack(null)
                        .commit();
            }
        });


        if(orderModel!=null){

        tvorder_id.setText(orderModel.getId());
        tv_dishname.setText(orderModel.getPname());
        tv_amount.setText(orderModel.getAmount());
        tvtotal_amount.setText(orderModel.getAmount());
        tvqty.setText(orderModel.getQuantity());
        tvsubtotal.setText(orderModel.getAmount());
        tv_grandTotal.setText(orderModel.getTotal_amount());
            tv_order_id.setText(orderModel.getId());

            if (orderModel.getPayment_type().equals("0.00")) {
                tvpayment_type.setText("Cash");

            } else {

                tvpayment_type.setText("Online");
            }



            tvdate_time.setText(orderModel.getCreated_at());




        }


    }
}
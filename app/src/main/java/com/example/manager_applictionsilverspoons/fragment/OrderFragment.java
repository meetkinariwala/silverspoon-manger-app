package com.example.manager_applictionsilverspoons.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manager_applictionsilverspoons.HomeActivity;
import com.example.manager_applictionsilverspoons.R;
import com.example.manager_applictionsilverspoons.adapter.OrderAdapter;
import com.example.manager_applictionsilverspoons.api.OrderApi;
import com.example.manager_applictionsilverspoons.model.OrderModel;
import com.example.manager_applictionsilverspoons.model.OrderOutputModel;


public class OrderFragment extends Fragment {

    RecyclerView rcyl_Order;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcyl_Order=view.findViewById(R.id.rcyl_Order);

        new OrderApi().order(OrderFragment.this);
    }

    public void  setMenuBooking(OrderOutputModel model){

        OrderAdapter orderAdapter =new OrderAdapter(model.getOrder(), getContext(), new OrderAdapter.onClickListener() {
            @Override
            public void onClick(int position, OrderModel orderModel) {

                Order_DetailFragment orderDetailFragment= new Order_DetailFragment();
                Bundle bundle=new Bundle();
                bundle.putSerializable("order",orderModel);
                orderDetailFragment.setArguments(bundle);
                ((HomeActivity) getActivity()).openFragment(orderDetailFragment);

            }
        }){
        };

        rcyl_Order.setLayoutManager(new LinearLayoutManager(getContext()));
        rcyl_Order.setAdapter(orderAdapter);







    }
}
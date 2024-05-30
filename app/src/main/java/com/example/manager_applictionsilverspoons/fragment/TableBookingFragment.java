package com.example.manager_applictionsilverspoons.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manager_applictionsilverspoons.R;
import com.example.manager_applictionsilverspoons.adapter.TableAdapter;
import com.example.manager_applictionsilverspoons.api.TableApi;
import com.example.manager_applictionsilverspoons.model.TableModel;
import com.example.manager_applictionsilverspoons.model.TableOutputModel;


public class TableBookingFragment extends Fragment {


    RecyclerView rcyl_table;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_booking, container, false);
        return  view;



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcyl_table=view.findViewById(R.id.rcyl_table);

        new TableApi().table(TableBookingFragment.this);
    }

    public void setTableBooking(TableOutputModel model) {


       TableAdapter tableAdapter= new TableAdapter(model.getTable(), getContext(), new TableAdapter.onClickListener() {
           @Override
           public void onClick(int position, TableModel tableModel) {





           }

       }) {
           @Override
           public void onClick(int position, TableModel tableModel) {



           }
       };

        rcyl_table.setLayoutManager(new LinearLayoutManager(getContext()));
        rcyl_table.setAdapter(tableAdapter);

//        rcyl_table.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
//        rcyl_table.setAdapter(tableAdapter);



    }
}